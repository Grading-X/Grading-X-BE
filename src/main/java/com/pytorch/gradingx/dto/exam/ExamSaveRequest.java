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
@Schema(description = "시험 응시 결과 저장 요청")
public class ExamSaveRequest {
    @Schema(description = "제출한 정답", example = "knu")
    private String answer;

    @Schema(description = "문제 ID", example = "1")
    private Long questionId;

    @Schema(description = "게스트 이메일", example = "chaejm55@knu.ac.kr")
    private String email;
}
