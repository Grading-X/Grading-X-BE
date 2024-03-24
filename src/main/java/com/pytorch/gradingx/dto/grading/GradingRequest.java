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
    @Schema(description = "시험 ID", example = "1")
    private Long assignmentId;
    @Schema(description = "게스트 이메일", example = "chaejm55@gmail.com")
    private String email;
}
