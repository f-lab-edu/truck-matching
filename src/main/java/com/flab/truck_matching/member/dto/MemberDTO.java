package com.flab.truck_matching.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    }

    @Data
    @NoArgsConstructor
    public static class LoginReq {
        private String memberInputId;
        private String password;
    }
}
