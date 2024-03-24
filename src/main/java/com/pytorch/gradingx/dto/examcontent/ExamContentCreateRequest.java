package com.pytorch.gradingx.dto.examcontent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;


@AllArgsConstructor
@Builder
@Schema(description = "시험 생성 요청")
public class ExamContentCreateRequest {
    @Schema(description = "시험 이름", example = "시험1")
    public String name;
    @Schema(description = "시험 설명", example = "시험1 설명")
    public String description;
    @Schema(description = "시험 시작 시간", example = "2021-01-01T00:00:00")
    public LocalDateTime startTime;
    @Schema(description = "시험 종료 시간", example = "2021-01-01T23:59:59")
    public LocalDateTime endTime;
}
