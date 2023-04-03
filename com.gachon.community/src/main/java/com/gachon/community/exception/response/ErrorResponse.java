package com.gachon.community.exception.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    @Schema(description = "코드", example = "400")
    private final String code;

    @Schema(description = "메세지", example = "에러메세지입니다")
    private final String message;

    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
