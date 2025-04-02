from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node

class LinkedListSearch(Scene):
    def construct(self):
        title = Text("Doubly Linked List (Search)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        code_str = '''DoublyNode<U> node = head;
while (node != null && node.data != data) {
    node = node.next;
}
return node;'''
        code = self.build_code_block(code_str)
        self.play(Create(code))
        self.wait(2)


    def build_code_block(self, code_str):
        code = Code(
            code_string=code_str,
            tab_width=4,
            background="rectangle",
            language="java",
            formatter_style="friendly_grayscale",
            background_config={
                "fill_color": BLACK,
                "fill_opacity": 0.5,
            },
            paragraph_config={
                "line_spacing": 1.0
            }
        )

        self.add(code)
        return code