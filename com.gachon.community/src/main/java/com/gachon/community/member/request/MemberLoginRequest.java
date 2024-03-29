package com.gachon.community.member.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberLoginRequest {

    @Schema(description = "유저 이메일" , example = "test@test.com")
    @NotBlank()
    private String email;

    @Schema(description = "유저 비밀번호" , example = "1234")
    @NotBlank()
    private String password;
}
