package com.pytorch.gradingx.dto.course;

import com.pytorch.gradingx.dto.member.MemberInfoResponse;
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
@Schema(description = "강의 조회 결과")
public class CourseResponse {
    @Schema(description = "강의 ID", example = "1")
    private Long id;

    @Schema(description = "강의명", example = "종합설계프로젝트2")
    private String courseName;

    @Schema(description = "강의 시작일", example = "2024-03-04")
    private LocalDate startDate;

    @Schema(description = "강의 종료일", example = "2024-06-15")
    private LocalDate endDate;

    @Schema(description = "강의 담당자 정보", implementation = MemberInfoResponse.class)
    private MemberInfoResponse member;
}
