package com.pytorch.gradingx.dto.examcontent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Schema(description = "시험 목록 응답")
public class ExamContentListResponse {
    @Schema(description = "시험 목록")
    public List<ExamContentElement> examContents;

    @AllArgsConstructor
    @Schema(description = "시험 요소")
    class ExamContentElement {
        @Schema(description = "시험 ID", example = "1")
        public long id;
        @Schema(description = "시험 이름", example = "시험1")
        public String name;
        @Schema(description = "시험 시작 시간", example = "2021-01-01T00:00:00")
        public LocalDateTime startTime;
        @Schema(description = "시험 종료 시간", example = "2021-01-01T23:59:59")
        public LocalDateTime endTime;
    }
}
