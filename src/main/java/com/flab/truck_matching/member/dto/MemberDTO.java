package com.flab.truck_matching.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberDTO {

    @Data
    @NoArgsConstructor
    public static class RegisterReq {
        private String userId;
        private String password;
        private String email;
        private String phoneNumber;
        private String accountType;
    }
}
