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

    @PostMapping("/create")
    public ResponseEntity createAssignment(@RequestBody AssignmentCreateRequest assignmentCreateRequest){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<AssignmentListResponse> findAssignmentList(@RequestParam(required = false) long courseId,
                                                                    @RequestParam(required = false) String guestEmail){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @GetMapping("/info")
    public ResponseEntity<AssignmentInfoResponse> getAssignmentInfo(@RequestParam long assignmentId){
        return ResponseEntity.ok(new AssignmentInfoResponse());
    }


    @PostMapping("/update")
    public ResponseEntity updateAssignmentInfo(@RequestBody AssignmentUpdateRequest assignmentUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAssignment(@RequestParam long assignmentId){
        return ResponseEntity.ok().build();
    }
}
