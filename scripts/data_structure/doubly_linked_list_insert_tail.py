from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node
from manim import config


class LinkedListInsertTail(Scene):
    def construct(self):
        # Title
        title = Text("Doubly Linked List (Insertion to Tail)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        # Create initial nodes: "rest" and "..."
        rest = Node("...")
        tail = Node("tail")
        initial_nodes = VGroup(rest, tail).arrange(
            RIGHT, buff=3).move_to(ORIGIN)
        self.play(FadeIn(initial_nodes))

        # Create solid arrows between rest and tail
        arrow_rt = always_redraw(lambda: CustomArrow(
            rest.circle.get_right() + UP * 0.2,
            tail.circle.get_left() + UP * 0.2,
            buff=0.2))
        arrow_tr = always_redraw(lambda: CustomArrow(
            tail.circle.get_left() + DOWN * 0.2,
            rest.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        self.play(Create(arrow_rt), Create(arrow_tr))

        # Introduce new node "x" from off-screen right
        node_new = Node("x", color=GREEN)
        node_new.move_to(RIGHT * (config.frame_width / 2 + node_new.width))
        self.play(FadeIn(node_new))

        # Rearrange nodes: new node becomes leftmost; center all nodes
        all_nodes = VGroup(rest, tail, node_new)
        self.play(all_nodes.animate.arrange(RIGHT, buff=3).move_to(ORIGIN))
        self.wait()

        # Display connection text and create arrow_x_tail (from node_new to rest)
        text1 = Tex("$x \\rightarrow{} pre = tail$")
        text1.move_to(tail.get_top() + UP * 1.0)
        self.play(VGroup(all_nodes, text1).animate.move_to(ORIGIN))
        arrow_x_tail = always_redraw(lambda: CustomArrow(
            node_new.circle.get_left() + DOWN * 0.2,
            tail.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        self.play(Create(arrow_x_tail))
        self.wait()

        # Show conditional text: "if tail = null"
        text2 = Tex("if $tail = null$")
        text2.move_to(tail.get_top() + UP * 1.0)
        self.play(ReplacementTransform(text1, text2))

        # Preserve copies of the solid nodes and arrows for later reversion.
        solid_rest_copy = rest.copy()
        solid_tail_copy = tail.copy()
        arrow_rt_static = always_redraw(lambda: CustomArrow(
            rest.circle.get_right() + UP * 0.2,
            tail.circle.get_left() + UP * 0.2,
            buff=0.2))
        arrow_tr_static = always_redraw(lambda: CustomArrow(
            tail.circle.get_left() + DOWN * 0.2,
            rest.circle.get_right() + DOWN * 0.2,
            buff=0.2))

        # Create dashed versions of rest and tail (dash only the circles)
        dashed_head = VGroup(
            DashedVMobject(rest.circle.copy(), dashed_ratio=0.2),
            rest.text.copy()
        )
        dashed_rest = VGroup(
            DashedVMobject(tail.circle.copy(), dashed_ratio=0.2),
            tail.text.copy()
        )
        # For arrows, create static copies and dash them
        dashed_arrow_rt = DashedVMobject(arrow_rt_static, dashed_ratio=0.2)
        dashed_arrow_tr = DashedVMobject(arrow_tr_static, dashed_ratio=0.2)

        # Transform solid rest/tail into their dashed versions
        self.play(
            ReplacementTransform(rest, dashed_head),
            ReplacementTransform(tail, dashed_rest),
            FadeOut(arrow_rt),
            FadeOut(arrow_tr)
        )
        self.play(Create(dashed_arrow_rt), Create(dashed_arrow_tr))
        self.wait()

        # Fade out the dashed state and conditional text
        self.play(
            FadeOut(arrow_x_tail),
            FadeOut(dashed_head),
            FadeOut(dashed_rest),
            FadeOut(dashed_arrow_rt),
            FadeOut(dashed_arrow_tr),
            FadeOut(text2)
        )

        # Show a temporary state: "rest = tail = x" above node_new.
        text3 = Tex("head = tail = x")
        text3.move_to(node_new.get_top() + UP * 1.0)
        temp_group = VGroup(node_new, text3)
        self.play(temp_group.animate.move_to(ORIGIN))

        # Update node_new's label to a two-line label
        node_new_label = Tex("head \\\\ tail", font_size=26)
        node_new_label.move_to(node_new.text.get_center())
        self.play(ReplacementTransform(node_new.text, node_new_label))
        self.wait()

        # Revert back to the full solid state (bring back initial nodes and their arrows)
        node_old_label = Tex("x")
        node_old_label.move_to(node_new.text.get_center())
        self.play(ReplacementTransform(node_new_label, node_old_label))

        self.play(
            FadeOut(node_new),
            FadeOut(text3),
        )

        all_nodes = VGroup(solid_rest_copy, solid_tail_copy, node_new)
        self.play(all_nodes.animate.arrange(RIGHT, buff=3).move_to(ORIGIN))

        self.play(
            ReplacementTransform(dashed_head, solid_rest_copy),
            ReplacementTransform(dashed_rest, solid_tail_copy),
        )
        self.wait()

        text4 = Tex("else ...")
        text4.next_to(solid_tail_copy, UP, buff=1.0)
        composite = VGroup(all_nodes, text4)
        self.play(composite.animate.move_to(ORIGIN))
        self.wait()

        solid_arrow_rt = always_redraw(lambda: CustomArrow(
            solid_rest_copy.circle.get_right() + UP * 0.2,
            solid_tail_copy.circle.get_left() + UP * 0.2,
            buff=0.2))
        solid_arrow_tr = always_redraw(lambda: CustomArrow(
            solid_tail_copy.circle.get_left() + DOWN * 0.2,
            solid_rest_copy.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        solid_x_tail = always_redraw(lambda: CustomArrow(
            node_new.circle.get_left() + DOWN * 0.2,
            solid_tail_copy.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        self.play(Create(solid_arrow_rt), Create(
            solid_arrow_tr), Create(solid_x_tail))
        self.wait()

        text5 = Tex("$tail \\rightarrow{} next = x$")
        text5.next_to(solid_tail_copy, UP, buff=1.0)
        arrow_tail_x = always_redraw(lambda: CustomArrow(
            solid_tail_copy.circle.get_right() + UP * 0.2,
            node_new.circle.get_left() + UP * 0.2,
            buff=0.2))
        self.play(ReplacementTransform(text4, text5))
        self.play(Create(arrow_tail_x))
        self.wait()

        text6 = Tex("tail = x")
        text6.next_to(solid_tail_copy, UP, buff=1.0)
        self.play(ReplacementTransform(text5, text6))
        new_tail_label = Tex("tail", font_size=36)
        new_tail_label.move_to(node_new.get_center())
        old_tail_label = Tex("...", font_size=36)
        old_tail_label.move_to(solid_tail_copy.get_center())
        self.play(
            ReplacementTransform(node_old_label, new_tail_label),
            ReplacementTransform(solid_tail_copy.text, old_tail_label)
        )
        self.wait()
