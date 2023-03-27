package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfoResponse {

    @Schema(description = "유저 고유 식별자", example = "1309435006")
    private String accessId;

    @Schema(description = "라이더명", example = "카트짱123")
    private String name;

    @Schema(description = "레벨", example = "88")
    private String level;
}
