package com.flab.modulemember.member.dto;

import com.flab.modulemember.member.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberDTO {

    @Data
    @NoArgsConstructor
    public static class BasicInfo {
        private String memberId;
        private String memberInputId;
        private String password;
        private String email;
        private String phoneNumber;
        private String accountType;
    }

    @Data
    @NoArgsConstructor
    public static class RegisterReq {
        private String memberId;
        private String memberInputId;
        private String password;
        private String email;
        private String phoneNumber;
        private String accountType;

        @Builder
        public Member dtoToDomain(MemberDTO.RegisterReq req) {
            return Member.builder()
                    .memberInputId(req.memberInputId)
                    .password(req.password)
                    .email(req.email)
                    .phoneNumber(req.phoneNumber)
                    .accountType(req.accountType)
                    .created(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .updated(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class LoginReq {
        private String memberInputId;
        private String password;
    }
}
