from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node

class LinkedListDeleteHead(Scene):
    def construct(self):
        title = Text("Doubly Linked List (Deletion from Head)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        head = Node("head")
        rest = Node("...")
        nodes = VGroup(
            head,
            rest
        )
        nodes.arrange(RIGHT, buff=3)

        arrow_head_rest = CustomArrow(
            head.circle.get_right() + UP * 0.2,
            rest.circle.get_left() + UP * 0.2,
            buff=0.2
        )
        arrow_rest_head = CustomArrow(
            rest.circle.get_left() + DOWN * 0.2,
            head.circle.get_right() + DOWN * 0.2,
            buff=0.2
        )

        text1 = Tex("if $head\\rightarrow next$ = null")
        text_position = (head.get_center() + rest.get_center()) / 2 + UP * 2
        text1.move_to(text_position)

        group = VGroup(
            nodes,
            arrow_head_rest, arrow_rest_head,
            text1
        )
        group.move_to(ORIGIN)

        self.play(
            FadeIn(nodes)
        )
        self.play(
            Create(arrow_head_rest),
            Create(arrow_rest_head)
        )
        self.wait()
        
        self.play(Write(text1))
        self.wait()

        solid_head_copy = head.copy()
        solid_rest_copy = rest.copy()
        solid_arrow_head_rest = arrow_head_rest.copy()
        solid_arrow_rest_head = arrow_rest_head.copy()
        dashed_rest = VGroup(
            DashedVMobject(rest.circle.copy(), dashed_ratio=0.2),
            rest.text.copy()
        )
        dashed_arrow_head_rest = DashedVMobject(arrow_head_rest, dashed_ratio=0.2)
        dashed_arrow_rest_head = DashedVMobject(arrow_rest_head, dashed_ratio=0.2)

        self.play(
            Transform(rest, dashed_rest),
            Transform(arrow_head_rest, dashed_arrow_head_rest),
            Transform(arrow_rest_head, dashed_arrow_rest_head)
        )
        self.wait()

        self.play(
            FadeOut(arrow_head_rest),
            FadeOut(arrow_rest_head),
            FadeOut(rest)
        )
        self.wait()

        text2 = Tex("head=tail=null")
        text2.move_to(text1.get_center())
        self.play(ReplacementTransform(text1, text2))
        self.wait()
        self.play(
            FadeOut(head)
        )
        self.wait()

        text3 = Tex("else ...")
        text3.move_to(text2.get_center())
        else_solid_group = VGroup(
            text3,
            solid_head_copy,
            solid_rest_copy,
            solid_arrow_head_rest,
            solid_arrow_rest_head,
        )
        else_solid_group.move_to(ORIGIN)
        self.play(
            ReplacementTransform(text2, text3)
        )
        self.play(
            ReplacementTransform(head, solid_head_copy),
            ReplacementTransform(dashed_rest, solid_rest_copy),
            ReplacementTransform(dashed_arrow_head_rest, solid_arrow_head_rest),
            ReplacementTransform(dashed_arrow_rest_head, solid_arrow_rest_head)
        )
        self.wait()
        
        text4 = Tex("$head\\rightarrow{} next \\rightarrow{} pre = null$")
        text4.move_to(text3.get_center())
        self.play(
            ReplacementTransform(text3, text4)
        )
        self.play(
            FadeOut(solid_arrow_rest_head)
        )
        self.wait()

        text5 = Tex("$head = head \\rightarrow{} next$")
        text5.move_to(text4.get_center())
        self.play(
            ReplacementTransform(text4, text5)
        )

        new_label = Tex("head", font_size=36)
        new_label.move_to(solid_rest_copy.text.get_center())
        self.play(
            FadeOut(solid_head_copy.text),
            ReplacementTransform(solid_rest_copy.text, new_label)
        )
        self.wait()