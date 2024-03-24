package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.exam.ExamApplyRequest;
import com.pytorch.gradingx.dto.exam.ExamSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Exam", description = "시험 응시 관련 API")
@RestController
@RequestMapping("/api/exam")
public class ExamController {

    @Operation(summary = "게스트용 시험 응시 URL 발급", description = "examId를 이용하여 해당 시험의 응시 URL을 조회합니다.")
    @GetMapping("/url/{examId}")
    public ResponseEntity<String> getExamURL(@PathVariable Long examId) {
        String testURL = "https://www.knu.ac.kr";
        return ResponseEntity.ok().body(testURL);
    }

    @Operation(summary = "시험 응시", description = "examId와 게스트 이메일을 이용하여 해당 시험을 응시합니다.")
    @GetMapping("/{examId}")
    public ResponseEntity<Void> applyExam(@PathVariable Long examId, @RequestBody ExamApplyRequest examApplyRequest) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "시험 제출", description = "examId와 문제 정보를 이용하여 해당 시험을 제출합니다.")
    @PostMapping("/{examId}/save")
    public ResponseEntity<Void> saveExam(@PathVariable Long examId, @RequestBody ExamSaveRequest examSaveRequest) {
        return ResponseEntity.ok().build();
    }
}
