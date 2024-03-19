package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.course.CourseCreateRequest;
import com.pytorch.gradingx.dto.course.CourseResponse;
import com.pytorch.gradingx.dto.course.CourseUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long courseId) {
        CourseResponse testResponse = CourseResponse.builder()
                .id(1L)
                .courseName("종합설계프로젝트2")
                .startDate(LocalDate.of(2024, 3, 4))
                .endDate(LocalDate.of(2024, 6, 15))
                .memberId(1L)
                .build();
        return ResponseEntity.ok().body(testResponse);
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
