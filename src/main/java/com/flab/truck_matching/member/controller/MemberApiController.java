package com.flab.truck_matching.member.controller;

import com.flab.truck_matching.member.dto.MemberDTO;
import com.flab.truck_matching.member.service.MemberService;
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
    public ResponseEntity<String> addMember(@RequestBody MemberDTO.RegisterReq req) {
        String userId = memberService.addMember(req);
        return ResponseEntity.status(HttpStatus.OK).body(userId);
    }


}
