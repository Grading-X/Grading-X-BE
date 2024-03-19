package com.pytorch.gradingx.dto.course;

import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
    private LocalDate startDate;
    private LocalDate endDate;
    private MemberInfoResponse memberDto;
}
