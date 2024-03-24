package com.pytorch.gradingx.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@Schema(description = "강의 생성 요청")
public class CourseCreateRequest {
    @Schema(description = "강의명", example = "종합설계프로젝트2")
    private String courseName;

    @Schema(description = "강의 시작일", example = "2024-03-04")
    private LocalDate startDate;

    @Schema(description = "강의 종료일", example = "2024-06-15")
    private LocalDate endDate;
}
