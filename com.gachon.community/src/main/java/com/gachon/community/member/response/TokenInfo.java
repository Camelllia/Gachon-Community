package com.gachon.community.member.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenInfo {

    @Schema(description = "인증 유형" , example = "Bearer")
    private String grantType;

    @Schema(description = "JWT 액세스 토큰" , example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXM5MzRAZXN0LmNvbSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2Nzg4NjUzMzd9.oMs_5dfAmGLqS2cqYhNjgKtW414brkOi6HMipxgdrx4")
    private String accessToken;

    @Schema(description = "JWT 리프레시 토큰(토큰 재발급 용도)" , example = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Nzg4NjUzMzd9.GqVVvxo6uREva9yPqvF4_iIWjYcRKw4GiQO0963g_lE")
    private String refreshToken;

    @Builder
    public TokenInfo(String grantType, String accessToken, String refreshToken) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
