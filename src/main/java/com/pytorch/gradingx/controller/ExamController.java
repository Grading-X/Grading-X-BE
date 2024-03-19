package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.exam.ExamApplyRequest;
import com.pytorch.gradingx.dto.exam.ExamSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam")
public class ExamController {
    @GetMapping("/url/{examId}")
    public ResponseEntity<String> getExamURL(@PathVariable Long examId) {
        String testURL = "https://www.knu.ac.kr";
        return ResponseEntity.ok().body(testURL);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Void> applyExam(@PathVariable Long examId, @RequestBody ExamApplyRequest examApplyRequest) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{examId}/save")
    public ResponseEntity<Void> saveExam(@PathVariable Long examId, @RequestBody ExamSaveRequest examSaveRequest) {
        return ResponseEntity.ok().build();
    }
}
