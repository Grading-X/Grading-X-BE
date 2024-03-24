package com.pytorch.gradingx.dto.objection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "이의 목록 응답")
public class ObjectionListResponse {
    @Schema(description = "이의 리스트")
    List<ObjectionElement> objections;

    @AllArgsConstructor
    @Schema(description = "이의 요소")
    class ObjectionElement {
        @Schema(description = "이의 ID", example = "1")
        public Long id;
        @Schema(description = "문제 ID", example = "1")
        public Long questionId;
        @Schema(description = "게스트 이메일", example = "user.example.com")
        public String guestEmail;
        @Schema(description = "제목", example = "문제 이의 제기")
        public String title;
        @Schema(description = "내용", example = "이 문제는 이렇게 풀어야 하는데...")
        public String content;
    }
}
