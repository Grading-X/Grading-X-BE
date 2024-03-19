package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.member.MemberUpdateRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @GetMapping
    public ResponseEntity<MemberInfoResponse> getMemberInfo(){
        return ResponseEntity.ok(new MemberInfoResponse());
    }

    @PutMapping
    public ResponseEntity updateMemberInfo(@RequestBody MemberUpdateRequest memberUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteMember(){
        return ResponseEntity.ok().build();
    }
}
