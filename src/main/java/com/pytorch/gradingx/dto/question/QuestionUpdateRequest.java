package com.pytorch.gradingx.dto.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
@Schema(description = "문제 수정 요청")
public class QuestionUpdateRequest {
    @Schema(description = "문제 수정 리스트")
    public List<QuestionElement> questions;

    @AllArgsConstructor
    @Schema(description = "문제 요소")
    class QuestionElement {
        @Schema(description = "문제 ID", example = "1")
        public Long id;
        @Schema(description = "문제 내용", example = "1 + 1 = ?")
        public String query;
        @Schema(description = "문제 번호", example = "1")
        public int index;
        @Schema(description = "문제 배점", example = "1")
        public int weightage;

        @Schema(description = "모범 답안 리스트")
        public List<String> answers;
        @Schema(description = "키워드 리스트")
        public List<String> keywords;
    }
}
