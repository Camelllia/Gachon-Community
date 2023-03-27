package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class MatchInfoDTO {

    @Schema(description = "계정 고유 식별자", example = "1309435006")
    private String accountNo;

    @Schema(description = "매치 고유 식별자", example = "02e0000b328171fd")
    private String matchId;

    @Schema(description = "매치 종류", example = "7b9f0fd5377c38514dbb78ebe63ac6c3b81009d5a31dd569d1cff8f005aa881a")
    private String matchType;

    @Schema(description = "매치 Team ID", example = "0")
    private String teamId;

    @Schema(description = "캐릭터", example = "03e6c20439f6cdee8470f26b0d5aff7406f6f7e0307f1fb491d6ce519504a135")
    private String character;

    @Schema(description = "게임 시작 시간", example = "2022-07-02T17:44:16")
    private Date startTime;

    @Schema(description = "게임 종료 시간", example = "2022-07-02T17:46:09")
    private Date endTime;

    @Schema(description = "게임 진행 시간(초)", example = "", defaultValue = "")
    private int playTime;

    @Schema(description = "채널", example = "speedIndiInfinit")
    private String channelName;

    @Schema(description = "트랙 고유 식별자", example = "4cd670f582e1fc5db858df3c43a51adcd645053ad3c2ea2c49120e58f61f17e3")
    private String trackId;

    @Schema(description = "참여 유저 수", example = "3")
    private int playerCount;

    @Schema(description = "참여 유저 정보")
    private PlayerDTO player;
}
