package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.objection.ObjectionCreateRequest;
import com.pytorch.gradingx.dto.objection.ObjectionListResponse;
import com.pytorch.gradingx.dto.objection.ObjectionReplyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Objection", description = "이의 관련 API")
@RestController
@RequestMapping("/api/objection")
public class ObjectionController {

    @Operation(summary = "이의 생성", description = "이의를 생성합니다.")
    @PostMapping
    public ResponseEntity createObjection(@RequestBody ObjectionCreateRequest objectionCreateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이의 목록 조회", description = "guestEmail을 이용하여 해당 게스트의 이의 목록을 조회합니다.")
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByGuest(@PathVariable String guestEmail){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @Operation(summary = "이의 목록 조회", description = "courseId를 이용하여 해당 과목의 이의 목록을 조회합니다.")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByCourse(@PathVariable long courseId){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @Operation(summary = "이의 답변", description = "objectionId를 이용하여 해당 이의에 답변합니다.")
    @PostMapping("/{objectionId}")
    public ResponseEntity updateObjection(@PathVariable long objectionId, @RequestBody ObjectionReplyRequest objectionReplyRequest){
        return ResponseEntity.ok().build();
    }

}
