package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.member.MemberRequest;
import com.pytorch.gradingx.dto.member.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @GetMapping("/info")
    public ResponseEntity<MemberResponse> getMemberInfo(){
        return ResponseEntity.ok(new MemberResponse());
    }

    @PostMapping("/update")
    public ResponseEntity updateMemberInfo(@RequestBody MemberRequest memberRequest){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteMember(){
        return ResponseEntity.ok().build();
    }
}
