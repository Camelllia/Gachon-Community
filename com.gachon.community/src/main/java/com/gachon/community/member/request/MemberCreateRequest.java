package com.gachon.community.member.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberCreateRequest {

    @Schema(description = "유저 이메일" , example = "test@test.com")
    @NotBlank()
    private String email;

    @Schema(description = "유저 비밀번호" , example = "1234!@#")
    @NotBlank()
    private String password;

    @Schema(description = "유저 비밀번호 확인" , example = "1234!@#")
    @NotBlank()
    private String passwordCheck;

    @Schema(description = "유저 닉네임" , example = "홍길동123")
    @NotBlank()
    private String nickname;
}
