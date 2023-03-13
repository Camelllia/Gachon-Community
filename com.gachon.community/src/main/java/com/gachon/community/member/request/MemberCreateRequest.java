package com.gachon.community.member.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberCreateRequest {

    @NotBlank()
    private String email;

    @NotBlank()
    private String password;

    @NotBlank()
    private String nickname;
}
