package com.pytorch.gradingx.dto.grading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@Schema(description = "채점 결과")
public class GradingResponse {
    @Schema(description = "정답 ID", example = "1")
    private Long answerId;

    @Schema(description = "제출한 정답", example = "knu")
    private String answer;

    @Schema(description = "문제 ID", example = "1")
    private Long score;
}
