package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatchDTO {

    @Schema(description = "매치 게임 유형", example = "7b9f0fd5377c38514dbb78ebe63ac6c3b81009d5a31dd569d1cff8f005aa881a")
    private String matchType;

    @Schema(description = "매치 상세 정보 목록")
    private MatchInfoDTO[] matches;
}
