from manim import *


class BaseAlgorithmScene(Scene):
    def setup_layout(self, code_area_ratio=1/2, horizontal_margin=0.5, vertical_margin=0.5):
        scene_width = self.camera.frame_width
        scene_height = self.camera.frame_height
        width = scene_width - 2 * horizontal_margin
        height = scene_height - 4 * vertical_margin
        code_width = width * code_area_ratio
        algo_width = width * (1 - code_area_ratio)

        self.code_area = Rectangle(
            width=code_width, height=height, fill_opacity=0).to_edge(LEFT)
        self.code_area.move_to(self.code_area.get_center() + DOWN * 0.4)
        self.algo_area = Rectangle(
            width=algo_width, height=height, fill_opacity=0).to_edge(RIGHT)
        self.algo_area.move_to(self.algo_area.get_center() + DOWN * 0.4)

    def construct(self):
        self.setup_layout()