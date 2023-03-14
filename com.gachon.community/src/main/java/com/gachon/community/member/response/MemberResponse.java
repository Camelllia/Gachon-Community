package com.gachon.community.member.response;

import com.gachon.community.member.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    @Schema(description = "이메일", example = "test@test.com")
    private String email;

    @Schema(description = "닉네임", example = "홍길동123")
    private String nickname;

    public MemberResponse(Member member) {
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

    @Builder
    public MemberResponse(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
