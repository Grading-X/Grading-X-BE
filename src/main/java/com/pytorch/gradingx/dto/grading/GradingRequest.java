package com.pytorch.gradingx.dto.grading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Schema(description = "채점 요청")
public class GradingRequest {
    @Schema(description = "정답 ID", example = "1")
    private Long answerId;
    @Schema(description = "제출한 정답", example = "knu")
    private String answer;
    @Schema(description = "문제 ID", example = "1")
    private Long questionId;
    @Schema(description = "게스트 이메일", example = "chaejm55@gmail.com")
    private String email;
}
