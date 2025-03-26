from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node

class LinkedListDeleteTail(Scene):
    def construct(self):
        title = Text("Doubly Linked List (Deletion from Tail)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        rest = Node("...")
        tail = Node("tail")
        nodes = VGroup(
            rest,
            tail
        )
        nodes.arrange(RIGHT, buff=3)

        arrow_rest_tail = CustomArrow(
            rest.circle.get_right() + UP * 0.2,
            tail.circle.get_left() + UP * 0.2,
            buff=0.2
        )
        arrow_tail_rest = CustomArrow(
            tail.circle.get_left() + DOWN * 0.2,
            rest.circle.get_right() + DOWN * 0.2,
            buff=0.2
        )

        text1 = Tex("if $tail\\rightarrow pre = null$")
        text_position = (rest.get_center() + tail.get_center()) / 2 + UP * 2
        text1.move_to(text_position)

        group = VGroup(
            nodes,
            arrow_tail_rest, arrow_rest_tail,
            text1
        )
        group.move_to(ORIGIN)
        self.play(
            FadeIn(nodes)
        )
        self.play(
            Create(arrow_tail_rest),
            Create(arrow_rest_tail)
        )
        self.wait()
        
        self.play(Write(text1))
        self.wait()

        solid_rest_copy = rest.copy()
        solid_tail_copy = tail.copy()
        solid_arrow_rest_tail = arrow_rest_tail.copy()
        solid_arrow_tail_rest = arrow_tail_rest.copy()
        dashed_rest = VGroup(
            DashedVMobject(rest.circle.copy(), dashed_ratio=0.2),
            rest.text.copy()
        )
        dashed_arrow_rest_tail = DashedVMobject(arrow_rest_tail, dashed_ratio=0.2)
        dashed_arrow_tail_rest = DashedVMobject(arrow_tail_rest, dashed_ratio=0.2)
        self.play(
            Transform(rest, dashed_rest),
            Transform(arrow_rest_tail, dashed_arrow_rest_tail),
            Transform(arrow_tail_rest, dashed_arrow_tail_rest)
        )
        self.wait()

        self.play(
            FadeOut(arrow_rest_tail),
            FadeOut(arrow_tail_rest),
            FadeOut(rest),
        )
        self.wait()

        text2 = Tex("head=tail=null")
        text2.move_to(text1.get_center())
        self.play(ReplacementTransform(text1, text2))
        self.wait()
        self.play(
            FadeOut(tail)
        )
        self.wait()

        text3 = Tex("else ...")
        text3.move_to(text2.get_center())
        else_solid_group = VGroup(
            text3,
            solid_rest_copy,
            solid_tail_copy,
            solid_arrow_rest_tail,
            solid_arrow_tail_rest
        )
        else_solid_group.move_to(ORIGIN)
        self.play(
            ReplacementTransform(text2, text3)
        )
        self.play(
            ReplacementTransform(tail, solid_tail_copy),
            ReplacementTransform(dashed_rest, solid_rest_copy),
            ReplacementTransform(dashed_arrow_rest_tail, solid_arrow_rest_tail),
            ReplacementTransform(dashed_arrow_tail_rest, solid_arrow_tail_rest)
        )
        self.wait()

        text4 = Tex("$tail\\rightarrow pre \\rightarrow next = null$")
        text4.move_to(text3.get_center())
        self.play(
            ReplacementTransform(text3, text4)
        )
        self.wait()
        self.play(
            FadeOut(solid_arrow_rest_tail)
        )
        self.wait()

        text5 = Tex("$tail = tail \\rightarrow pre$")
        text5.move_to(text4.get_center())
        self.play(
            ReplacementTransform(text4, text5)
        )

        new_label = Tex("tail", font_size=36)
        new_label.move_to(solid_rest_copy.text.get_center())
        self.play(
            FadeOut(solid_tail_copy.text),
            ReplacementTransform(solid_rest_copy.text, new_label)
        )
        self.wait()