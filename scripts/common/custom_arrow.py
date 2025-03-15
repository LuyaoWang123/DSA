from manim import *
import numpy as np

class CustomArrow(Line):
    def __init__(
        self,
        start: np.ndarray,
        end: np.ndarray,
        tip_length: float = 0.2,
        tip_shape=ArrowTriangleFilledTip,
        buff: float = 0,
        **kwargs
    ):
        super().__init__(start, end, buff=buff, **kwargs)
        self.tip = tip_shape(color=WHITE)
        self.tip.stretch_to_fit_height(tip_length)
        self.tip.move_to(self.get_end())
        self.add_tip(tip=self.tip)

    def put_start_and_end_on(self, start: np.ndarray, end: np.ndarray):
        super().put_start_and_end_on(start, end)
        self.tip.move_to(self.get_end())
        return self