package com.pytorch.gradingx.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class CourseUpdateRequest {
    private String field;
    private LocalDate endDate;
}
