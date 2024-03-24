package com.pytorch.gradingx.dto.assignment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Schema(description = "과제 수정 요청")
public class AssignmentUpdateRequest {
    @Schema(description = "과제 이름", example = "과제1")
    public String name;
    @Schema(description = "과제 설명", example = "과제1 설명")
    public String description;
    @Schema(description = "과제 시작 시간", example = "2021-01-01T00:00:00")
    public LocalDateTime startTime;
    @Schema(description = "과제 종료 시간", example = "2021-01-01T23:59:59")
    public LocalDateTime endTime;
}
