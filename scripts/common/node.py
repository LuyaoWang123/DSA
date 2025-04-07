from manim import *
import numpy as np

class Node(VGroup):
    def __init__(self, label, color=BLUE, **kwargs):
        super().__init__(**kwargs)
        self.circle = Circle(color=color).scale(0.6)
        self.text = Text(label).scale(0.6)
        self.text.move_to(self.circle.get_center())
        self.add(self.circle, self.text)