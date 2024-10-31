package com.flab.modulemember.auth.controller;

import com.flab.modulemember.auth.service.AuthService;
import com.flab.modulemember.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthApiController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDTO.LoginReq req) {
        String token = authService.login(req);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

}
