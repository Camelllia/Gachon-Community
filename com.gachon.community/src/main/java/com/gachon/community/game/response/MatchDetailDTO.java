package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;

@Data
public class MatchDetailDTO {

    @Schema(description = "매치 고유 식별자", example = "0358001135b05bb9")
    private String matchId;

    @Schema(description = "매치 종류", example = "effd66758144a29868663aa50e85d3d95c5bc0147d7fdb9802691c2087f3416e")
    private String matchType;

    @Schema(description = "매치 결과", example = "2")
    private String matchResult;

    @Schema(description = "게임 스피드 모드", example = "7")
    private int gameSpeed;

    @Schema(description = "게임 시작 시간", example = "2022-10-30")
    private Date startTime;

    @Schema(description = "게임 종료 시간", example = "2022-10-30")
    private Date endTime;

    @Schema(description = "게임 진행 시간", example = "83")
    private int playTime;

    @Schema(description = "채널 명", example = "speedTeamCombine")
    private String channelName;

    @Schema(description = "트랙 고유 식별자", example = "37af020d27f898e4fa9db2c96ff97fefff8491f49b08bdc68e71c35e43d53b7b")
    private String trackId;

    @Schema(description = "참여 팀 정보 목록")
    private TeamDTO[] teams;
}
