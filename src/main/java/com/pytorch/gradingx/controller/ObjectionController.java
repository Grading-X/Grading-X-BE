package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.objection.ObjectionCreateRequest;
import com.pytorch.gradingx.dto.objection.ObjectionListResponse;
import com.pytorch.gradingx.dto.objection.ObjectionReplyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/objection")
public class ObjectionController {

    @PostMapping
    public ResponseEntity createObjection(@RequestBody ObjectionCreateRequest objectionCreateRequest){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/guest/{guestEmail}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByGuest(@PathVariable String guestEmail){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @GetMapping("/list/course/{courseId}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByCourse(@PathVariable long courseId){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @PostMapping("/{objectionId}")
    public ResponseEntity updateObjection(@PathVariable long objectionId, @RequestBody ObjectionReplyRequest objectionReplyRequest){
        return ResponseEntity.ok().build();
    }

}
