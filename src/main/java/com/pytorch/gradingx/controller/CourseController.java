package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.course.CourseCreateRequest;
import com.pytorch.gradingx.dto.course.CourseResponse;
import com.pytorch.gradingx.dto.course.CourseUpdateRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Course", description = "강의 관련 API")
@RestController
@RequestMapping("/api/course")
public class CourseController {
    CourseResponse testResponse = CourseResponse.builder()
            .id(1L)
            .courseName("종합설계프로젝트2")
            .startDate(LocalDate.of(2024, 3, 4))
            .endDate(LocalDate.of(2024, 6, 15))
            .member(new MemberInfoResponse())
            .build();

    CourseResponse testResponse2 = CourseResponse.builder()
            .id(2L)
            .courseName("컴퓨터그래픽스")
            .startDate(LocalDate.of(2024, 3, 4))
            .endDate(LocalDate.of(2024, 6, 15))
            .member(new MemberInfoResponse())
            .build();

    @Operation(summary = "강의 목록 조회", description = "모든 강의의 정보를 조회합니다.")
    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourse() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        courseResponseList.add(testResponse);
        courseResponseList.add(testResponse2);
        return ResponseEntity.ok().body(courseResponseList);
    }

    @Operation(summary = "강의 조회", description = "courseId에 해당하는 강의의 정보를 조회합니다.")
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok().body(testResponse);
    }


    @Operation(summary = "강의 생성", description = "새로운 강의를 생성합니다.")
    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody CourseCreateRequest courseCreateRequest) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "강의 정보 수정", description = "해당 강의의 정보(강의 이름, 종료 일자)를 수정합니다.")
    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable Long courseId, @RequestBody CourseUpdateRequest courseUpdateRequest) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "강의 삭제", description = "courseId를 이용하여 해당 강의를 삭제합니다.")
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok().build();
    }
}
