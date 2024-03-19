package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.assignment.AssignmentCreateRequest;
import com.pytorch.gradingx.dto.assignment.AssignmentInfoResponse;
import com.pytorch.gradingx.dto.assignment.AssignmentListResponse;
import com.pytorch.gradingx.dto.assignment.AssignmentUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @GetMapping
    public ResponseEntity<AssignmentListResponse> findAssignmentList(){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentInfoResponse> getAssignmentInfo(@PathVariable long assignmentId){
        return ResponseEntity.ok(new AssignmentInfoResponse());
    }

    @PostMapping
    public ResponseEntity<Long> createAssignment(@RequestBody AssignmentCreateRequest assignmentCreateRequest){
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{assignmentId}")
    public ResponseEntity updateAssignmentInfo(@PathVariable long assignmentId, @RequestBody AssignmentUpdateRequest assignmentUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity deleteAssignment(@PathVariable long assignmentId){
        return ResponseEntity.ok().build();
    }
}
