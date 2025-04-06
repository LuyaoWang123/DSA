from manim import *
from common.custom_arrow import CustomArrow
from common.node import Node
from common.base_algorithm_scene import BaseAlgorithmScene
from common.code_animator import CodeAnimator

class LinkedListSearch(BaseAlgorithmScene):
    def construct(self):
        self.setup_layout(code_area_ratio=1/3)
        title = Text("Doubly Linked List (Search)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        code_str = '''DoublyNode<U> node = head;
while (node != null && 
       node.data != data) {
    node = node.next;
}
return node;'''
        code = CodeAnimator(scene=self, code_str=code_str)
        code_mobj = code.get_code_mobject()
        code_mobj.move_to(self.code_area.get_center())
        code_mobj.scale_to_fit_width(self.code_area.width)

        self.play(FadeIn(code_mobj))
        self.wait()
