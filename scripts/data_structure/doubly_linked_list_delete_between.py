from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node

def create_blurry_halo(center, dot_radius=0.12, halo_outer_radius=0.45, layers=5, color=YELLOW):
    if halo_outer_radius is None:
        halo_outer_radius = dot_radius * 2
    halo = VGroup()
    for i in range(layers):
        alpha = i / (layers - 1)
        radius = interpolate(dot_radius, halo_outer_radius, alpha)
        fill_opacity = (1 - alpha) * 0.15
        circle = Circle(radius=radius)
        circle.set_fill(color, opacity=fill_opacity)
        circle.set_stroke(width=0)
        circle.move_to(center)
        halo.add(circle)
    return halo

class LinkedListDeleteBetween(Scene):
    def construct(self):
        title = Text("Doubly Linked List (Deletion between Nodes)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        pre = Node("a")
        node_to_delete = Node("x")
        post = Node("b")

        nodes = VGroup(pre, node_to_delete, post)
        nodes.arrange(RIGHT, buff=3)

        arrow_pre_delete = CustomArrow(
            pre.circle.get_right() + UP * 0.2,
            node_to_delete.circle.get_left() + UP * 0.2,
            buff=0.2
        )
        arrow_delete_pre = CustomArrow(
            node_to_delete.circle.get_left() + DOWN * 0.2,
            pre.circle.get_right() + DOWN * 0.2,
            buff=0.2
        )
        arrow_delete_post = CustomArrow(
            node_to_delete.circle.get_right() + UP * 0.2,
            post.circle.get_left() + UP * 0.2,
            buff=0.2
        )
        arrow_post_delete = CustomArrow(
            post.circle.get_left() + DOWN * 0.2,
            node_to_delete.circle.get_right() + DOWN * 0.2,
            buff=0.2
        )

        text1 = Tex("$x \\rightarrow{} pre \\rightarrow{} next = b$")
        text_position = (pre.get_center() + post.get_center()) / 2 + UP * 2
        text1.move_to(text_position)

        everything = VGroup(
            nodes,
            arrow_delete_pre, arrow_delete_post,
            arrow_pre_delete, arrow_post_delete,
            text1
        )
        everything.move_to(ORIGIN)

        self.play(FadeIn(nodes))
        self.play(Create(arrow_pre_delete), 
                  Create(arrow_delete_pre),
                  Create(arrow_delete_post), 
                  Create(arrow_post_delete))
        self.wait()

        self.play(Write(text1))
        self.wait()

        dot = Dot(point=arrow_delete_pre.get_start(), color=YELLOW, radius=0.12)
        halo = create_blurry_halo(dot.get_center(), dot_radius=0.12, halo_outer_radius=0.45, layers=8, color=YELLOW)
        self.add(dot, halo)

        halo.add_updater(lambda mob, dt: mob.move_to(dot.get_center()))

        self.play(MoveAlongPath(dot, arrow_delete_pre), run_time=2)
        self.play(MoveAlongPath(dot, arrow_pre_delete), run_time=2)
        
        halo.clear_updaters()
