package com.flab.modulemember.member.controller;

import com.flab.modulemember.member.dto.MemberDTO;
import com.flab.modulemember.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
    public ResponseEntity<String> create(@RequestBody MemberDTO.RegisterReq req) {
        String userId = memberService.create(req);
        return ResponseEntity.status(HttpStatus.OK).body(userId);
    }

}
