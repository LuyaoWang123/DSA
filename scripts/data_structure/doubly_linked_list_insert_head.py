from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node
from manim import config


class LinkedListInsertHead(Scene):
    def construct(self):
        # Title
        title = Text("Doubly Linked List (Insertion to Head)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        # Create initial nodes: "head" and "..."
        head = Node("head")
        rest = Node("...")
        initial_nodes = VGroup(head, rest).arrange(
            RIGHT, buff=3).move_to(ORIGIN)
        self.play(FadeIn(initial_nodes))

        # Create solid arrows between head and rest
        arrow_hear_rest = always_redraw(lambda: CustomArrow(
            head.circle.get_right() + UP * 0.2,
            rest.circle.get_left() + UP * 0.2,
            buff=0.2))
        arrow_rest_head = always_redraw(lambda: CustomArrow(
            rest.circle.get_left() + DOWN * 0.2,
            head.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        self.play(Create(arrow_hear_rest), Create(arrow_rest_head))

        # Introduce new node "x" from off-screen left
        node_new = Node("x", color=GREEN)
        node_new.move_to(LEFT * (config.frame_width / 2 + node_new.width))
        self.play(FadeIn(node_new))

        # Rearrange nodes: new node becomes leftmost; center all nodes
        all_nodes = VGroup(node_new, head, rest)
        self.play(all_nodes.animate.arrange(RIGHT, buff=3).move_to(ORIGIN))
        self.wait()

        # Display connection text and create arrow_x_head (from node_new to head)
        text1 = Tex("$x \\rightarrow{} next = head$")
        text1.move_to(head.get_top() + UP * 1.0)
        self.play(VGroup(all_nodes, text1).animate.move_to(ORIGIN))
        arrow_x_head = always_redraw(lambda: CustomArrow(
            node_new.circle.get_right() + UP * 0.2,
            head.circle.get_left() + UP * 0.2,
            buff=0.2))
        self.play(Create(arrow_x_head))
        self.wait()

        # Show conditional text: "if head = null"
        text2 = Tex("if $head = null$")
        text2.move_to(head.get_top() + UP * 1.0)
        self.play(ReplacementTransform(text1, text2))

        # Preserve copies of the solid nodes and arrows for later reversion.
        solid_head_copy = head.copy()
        solid_rest_copy = rest.copy()
        arrow_head_rest_static = always_redraw(lambda: CustomArrow(
            head.circle.get_right() + UP * 0.2,
            rest.circle.get_left() + UP * 0.2,
            buff=0.2))
        arrow_rest_head_static = always_redraw(lambda: CustomArrow(
            rest.circle.get_left() + DOWN * 0.2,
            head.circle.get_right() + DOWN * 0.2,
            buff=0.2))

        # Create dashed versions of head and rest (dash only the circles)
        dashed_head = VGroup(
            DashedVMobject(head.circle.copy(), dashed_ratio=0.2),
            head.text.copy()
        )
        dashed_rest = VGroup(
            DashedVMobject(rest.circle.copy(), dashed_ratio=0.2),
            rest.text.copy()
        )
        # For arrows, create static copies and dash them
        dashed_arrow_hr = DashedVMobject(arrow_head_rest_static, dashed_ratio=0.2)
        dashed_arrow_rh = DashedVMobject(arrow_rest_head_static, dashed_ratio=0.2)

        # Transform solid head/rest into their dashed versions
        self.play(
            ReplacementTransform(head, dashed_head),
            ReplacementTransform(rest, dashed_rest),
            FadeOut(arrow_hear_rest),
            FadeOut(arrow_rest_head)
        )
        self.play(Create(dashed_arrow_hr), Create(dashed_arrow_rh))
        self.wait()

        # Fade out the dashed state and conditional text
        self.play(
            FadeOut(arrow_x_head),
            FadeOut(dashed_head),
            FadeOut(dashed_rest),
            FadeOut(dashed_arrow_hr),
            FadeOut(dashed_arrow_rh),
            FadeOut(text2)
        )

        # Show a temporary state: "head = tail = x" above node_new.
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

        all_nodes = VGroup(node_new, solid_head_copy, solid_rest_copy)
        self.play(all_nodes.animate.arrange(RIGHT, buff=3).move_to(ORIGIN))

        self.play(
            ReplacementTransform(dashed_head, solid_head_copy),
            ReplacementTransform(dashed_rest, solid_rest_copy),
        )
        self.wait()

        text4 = Tex("else ...")
        text4.next_to(solid_head_copy, UP, buff=1.0)
        composite = VGroup(all_nodes, text4)
        self.play(composite.animate.move_to(ORIGIN))
        self.wait()

        solid_arrow_ab = always_redraw(lambda: CustomArrow(
            solid_head_copy.circle.get_right() + UP * 0.2,
            solid_rest_copy.circle.get_left() + UP * 0.2,
            buff=0.2))
        solid_arrow_ba = always_redraw(lambda: CustomArrow(
            solid_rest_copy.circle.get_left() + DOWN * 0.2,
            solid_head_copy.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        solid_new_head = always_redraw(lambda: CustomArrow(
            node_new.circle.get_right() + UP * 0.2,
            solid_head_copy.circle.get_left() + UP * 0.2,
            buff=0.2))
        self.play(Create(solid_arrow_ab), Create(
            solid_arrow_ba), Create(solid_new_head))
        self.wait()

        text5 = Tex("head.pre = x")
        text5.next_to(solid_head_copy, UP, buff=1.0)
        arrow_head_x = always_redraw(lambda: CustomArrow(
            solid_head_copy.circle.get_left() + DOWN * 0.2,
            node_new.circle.get_right() + DOWN * 0.2,
            buff=0.2))
        self.play(ReplacementTransform(text4, text5))
        self.play(Create(arrow_head_x))
        self.wait()

        text6 = Tex("head = x")
        text6.next_to(solid_head_copy, UP, buff=1.0)
        self.play(ReplacementTransform(text5, text6))
        new_head_label = Tex("head", font_size=36)
        new_head_label.move_to(node_new.get_center())
        old_head_label = Tex("...", font_size=36)
        old_head_label.move_to(solid_head_copy.get_center())
        self.play(
            ReplacementTransform(node_old_label, new_head_label),
            ReplacementTransform(solid_head_copy.text, old_head_label)
        )
        self.wait()
