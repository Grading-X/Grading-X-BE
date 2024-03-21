package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.course.CourseCreateRequest;
import com.pytorch.gradingx.dto.course.CourseResponse;
import com.pytorch.gradingx.dto.course.CourseUpdateRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
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

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok().body(testResponse);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourse() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        courseResponseList.add(testResponse);
        courseResponseList.add(testResponse2);
        return ResponseEntity.ok().body(courseResponseList);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody CourseCreateRequest courseCreateRequest) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable Long courseId, @RequestBody CourseUpdateRequest courseUpdateRequest) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok().build();
    }
}
