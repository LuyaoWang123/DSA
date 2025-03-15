from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node


class LinkedListInsertBetween(Scene):
    def construct(self):
        title = Text("Doubly Linked List (Insertion between Nodes)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        pre = Node("...")
        node_old = Node("y")
        post = Node("...")

        nodes = VGroup(pre, node_old, post)
        nodes.arrange(RIGHT, buff=3)

        arrow_ab = CustomArrow(
            pre.circle.get_right() + UP * 0.2,
            node_old.circle.get_left() + UP * 0.2,
            buff=0.2
        )
        arrow_ba = CustomArrow(
            node_old.circle.get_left() + DOWN * 0.2, 
            pre.circle.get_right() + DOWN * 0.2, 
            buff=0.2
        )
        arrow_bc = CustomArrow(
            node_old.circle.get_right() + UP * 0.2, 
            post.circle.get_left() + UP * 0.2, 
            buff=0.2
        )
        arrow_cb = CustomArrow(
            post.circle.get_left() + DOWN * 0.2, 
            node_old.circle.get_right() + DOWN * 0.2, 
            buff=0.2
        )

        node_new = Node("x", color=GREEN)
        midpoint_bc = (node_old.get_center() + post.get_center()) / 2
        node_new.move_to(midpoint_bc + UP * 3)

        text_first = Tex("$x \\rightarrow{} next = y\\rightarrow{} next$")
        text_position = ((pre.circle.get_left() + node_old.circle.get_right()) / 2) + UP * 0.5
        text_first.move_to(text_position)

        text_sec = Tex("$x \\rightarrow{} pre = y$")
        text_sec.move_to(text_position)

        text_third = Tex("$y \\rightarrow{} next \\rightarrow{} pre = x$")
        text_third.move_to(text_position)

        text_forth = Tex("$y \\rightarrow{} next = x$")
        text_forth.move_to(text_position )

        arrow_bd = CustomArrow(
            node_old.circle.get_top(),
            node_new.circle.get_bottom() + LEFT * 0.5, 
            buff=0.3
        )
        arrow_db = CustomArrow(
            node_new.circle.get_bottom(), 
            node_old.circle.get_top() + RIGHT * 0.5,
            buff=0.3
        )
        arrow_dc = CustomArrow(
            node_new.circle.get_bottom(),
            post.circle.get_top() + LEFT * 0.5, 
            buff=0.3
        )
        arrow_cd = CustomArrow(
            post.circle.get_top(),
            node_new.circle.get_bottom() + RIGHT * 0.5,
            buff=0.3
        )
        arrow_cd.move_to(arrow_dc.get_center() + RIGHT * 0.5)
        arrow_bd.move_to(arrow_db.get_center() + LEFT * 0.5)

        everything = VGroup(
            nodes, node_new, 
            arrow_ab, arrow_ba, 
            arrow_bc, arrow_cb, 
            arrow_bd, arrow_db, 
            arrow_dc, arrow_cd
        )

        everything.move_to(ORIGIN)

        self.play(FadeIn(nodes))
        self.play(Create(arrow_ab), Create(arrow_ba))
        self.play(Create(arrow_bc), Create(arrow_cb))
        self.wait()

        self.play(FadeIn(node_new))
        self.wait()

        self.play(Create(arrow_dc), Write(text_first))
        self.wait(2)

        self.play(ReplacementTransform(text_first, text_sec))
        self.play(Create(arrow_db))
        self.wait(2)

        self.play(ReplacementTransform(text_sec, text_third))
        self.play(ReplacementTransform(arrow_cb, arrow_cd))
        self.wait(2)

        self.play(ReplacementTransform(text_third, text_forth))
        self.play(ReplacementTransform(arrow_bc, arrow_bd))
        self.wait(2)
