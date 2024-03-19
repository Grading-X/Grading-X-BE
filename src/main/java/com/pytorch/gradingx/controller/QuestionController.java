package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.question.QuestionCreateRequest;
import com.pytorch.gradingx.dto.question.QuestionCriteriaResponse;
import com.pytorch.gradingx.dto.question.QuestionUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionCreateRequest questionCreateRequest){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionCriteriaResponse> getQuestionCriteria(@PathVariable long questionId){
        return ResponseEntity.ok(new QuestionCriteriaResponse());
    }

    @PutMapping("/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable long questionId, @RequestBody QuestionUpdateRequest questionUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable long questionId){
        return ResponseEntity.ok().build();
    }


}
