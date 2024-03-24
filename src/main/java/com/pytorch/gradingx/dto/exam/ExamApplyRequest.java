package com.pytorch.gradingx.dto.exam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Schema(description = "게스트 시험 응시 요청")
public class ExamApplyRequest {
    @Schema(description = "게스트 이메일", example = "chaejm55@knu.ac.kr")
    private String email;
}
