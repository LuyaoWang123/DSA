from manim import *


class CodeAnimator:
    def __init__(
        self,
        scene,
        code_str,
        language="java",
        fill_opacity=0.5,
        line_spacing=1.0
    ):
        self.scene = scene
        self.code = Code(
            code_string=code_str,
            tab_width=4,
            background="rectangle",
            language=language,
            formatter_style="friendly_grayscale",
            background_config={
                "fill_color": BLACK,
                "fill_opacity": fill_opacity
            },
            paragraph_config={
                "line_spacing": line_spacing
            }
        )
        self.scene.add(self.code)
        self.original_colors = {}
        for line in self.code.code_lines:
            for submob in line:
                self.original_colors[submob] = submob.get_fill_color()

    def highlight_line(self, line_index, highlight_color=YELLOW, run_time=2, lag_ratio=0.1):
            line = self.code.code_lines[line_index]
            self.scene.play(
                LaggedStart(
                    *[submob.animate.set_fill(highlight_color)
                      for submob in line],
                    lag_ratio=lag_ratio,
                ),
                run_time=run_time
            )

    def revert_line(self, line_index, run_time=1, lag_ratio=0.1):
            line = self.code.code_lines[line_index]
            self.scene.play(
                LaggedStart(
                    *[submob.animate.set_fill(self.original_colors[submob])
                      for submob in line
                      ],
                    lag_ratio=lag_ratio
                ),
                run_time=run_time
            )

    def get_code_mobject(self):
            return self.code