package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TeamDTO {

    @Schema(description = "팀 고유 식별자", example = "1")
    private String teamId;

    @Schema(description = "참여 유저 정보 목록")
    private PlayerDTO[] players;
}
