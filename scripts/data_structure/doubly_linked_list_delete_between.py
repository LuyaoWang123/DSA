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
        # Initial nodes set up
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

        # 1st scene: x->pre->next = b
        text1 = Tex("$x$", "$\\rightarrow{}$", "$pre$", "$\\rightarrow{}$", "$next$", "$ = $", "$b$")
        text_position = (pre.get_center() + post.get_center()) / 2 + UP * 2
        text1[0].set_color(WHITE)
        text1[1].set_color(WHITE)
        text1[2].set_color(WHITE)
        text1[3].set_color(WHITE)
        text1[4].set_color(WHITE)
        text1[5].set_color(WHITE)
        text1[6].set_color(WHITE)
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

        self.play(
            text1[0].animate.set_color(YELLOW),
            node_to_delete.circle.animate.set_color(YELLOW)
        )

        dot = Dot(point=arrow_delete_pre.get_start(), color=YELLOW, radius=0.12)
        halo = create_blurry_halo(dot.get_center(), dot_radius=0.12, halo_outer_radius=0.45, layers=8, color=YELLOW)
        halo.add_updater(lambda mob, dt: mob.move_to(dot.get_center()))
        self.play(FadeIn(dot), FadeIn(halo))

        self.play(
            MoveAlongPath(dot, arrow_delete_pre), 
            text1[1:3].animate.set_color(YELLOW),
            run_time=2)
        self.play(
            MoveAlongPath(dot, arrow_pre_delete), 
            text1[3:5].animate.set_color(YELLOW),
            run_time=2)

        dot.add_updater(lambda m: m.move_to(arrow_pre_delete.get_end()))
        curved_arrow = ArcBetweenPoints(
            pre.circle.get_right() + UP * 0.2,
            post.circle.get_left() + UP * 0.2,
            radius=-8,
        )
        curved_arrow.add_tip()

        self.play(
            ReplacementTransform(arrow_pre_delete, curved_arrow), 
            MoveAlongPath(dot, curved_arrow),
            text1[5:7].animate.set_color(YELLOW),
            run_time=2)
        self.wait()

        halo.clear_updaters()
        dot.clear_updaters()

        # 2sc scene: x->next>pre = a
        text2 = Tex("$x$", "$\\rightarrow{}$", "$next$", "$\\rightarrow{}$", "$pre$", " = ", "$a$")
        text2[0].set_color(WHITE)
        text2[1].set_color(WHITE)
        text2[2].set_color(WHITE)
        text2[3].set_color(WHITE)
        text2[4].set_color(WHITE)
        text2[5].set_color(WHITE)
        text2[6].set_color(WHITE)
        text2.move_to(text1.get_center())

        self.play(
            FadeOut(dot),
            FadeOut(halo),
            node_to_delete.circle.animate.set_color(BLUE),
            ReplacementTransform(text1, text2)
        )

        self.play(
            text2[0].animate.set_color(YELLOW),
            node_to_delete.circle.animate.set_color(YELLOW)
        )

        dot1 = Dot(point=arrow_delete_post.get_start(), color=YELLOW, radius=0.12)
        halo1 = create_blurry_halo(dot1.get_center(), dot_radius=0.12, halo_outer_radius=0.45, layers=8, color=YELLOW)
        halo1.add_updater(lambda mob, dt: mob.move_to(dot1.get_center()))
        self.play(FadeIn(dot1), FadeIn(halo1))

        self.play(
            MoveAlongPath(dot1, arrow_delete_post), 
            text2[1:3].animate.set_color(YELLOW),
            run_time=2)
        self.play(
            MoveAlongPath(dot1, arrow_post_delete), 
            text2[3:5].animate.set_color(YELLOW),
            run_time=2)

        dot1.add_updater(lambda m: m.move_to(arrow_post_delete.get_end()))
        curved_arrow2 = ArcBetweenPoints(
            post.circle.get_left() + DOWN * 0.2,
            pre.circle.get_right() + DOWN * 0.2,
            radius=-8,
        )
        curved_arrow2.add_tip()

        self.play(
            ReplacementTransform(arrow_post_delete, curved_arrow2), 
            MoveAlongPath(dot1, curved_arrow2),
            text2[5:7].animate.set_color(YELLOW),
            run_time=2)
        self.wait()

        halo1.clear_updaters()
        dot1.clear_updaters()

        # 3rd scene: x->pre = null
        text3 = Tex("$x$", "$\\rightarrow{}$", "$pre$", "$=$", "$null$")
        text3.move_to(text2.get_center())
        self.play(
            FadeOut(dot1),
            FadeOut(halo1),
            ReplacementTransform(text2, text3)
        )
        self.play(
            FadeOut(arrow_delete_pre)
        )
        self.wait()

        # 4th scene: x->next = null
        text4 = Tex("$x$", "$\\rightarrow{}$", "$next$", "$=$", "$null$")
        text4.move_to(text2.get_center())
        self.play(
            ReplacementTransform(text3, text4)
        )
        self.play(
            FadeOut(arrow_delete_post)
        )
        self.wait()