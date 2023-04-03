package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LeagueEntryDTO {

    @Schema(description = "암호화된 리그 ID", example = "70d8c920-e79e-383e-b905-f8e94c2955d2")
    private String leagueId;

    @Schema(description = "암호화된 소환사 ID", example = "JmmmuF2AtBjTiZvdCp97lcGeW1Ght-hg_C0sexQj4mZKpn0")
    private String summonerId;

    @Schema(description = "소환사명", example = "Hide on bush")
    private String summonerName;

    @Schema(description = "큐 타입", example = "RANKED_SOLO_5x5")
    private String queueType;

    @Schema(description = "티어", example = "CHALLENGER")
    private String tier;

    @Schema(description = "랭크", example = "I")
    private String rank;

    @Schema(description = "리그 포인트", example = "941")
    private String leaguePoints;

    @Schema(description = "승리수", example = "211")
    private int wins;

    @Schema(description = "패배수", example = "181")
    private int losses;

    @Schema(description = "", example = "false")
    private boolean hotStreak;

    @Schema(description = "", example = "false")
    private boolean veteran;

    @Schema(description = "", example = "false")
    private boolean freshBlood;

    @Schema(description = "", example = "false")
    private boolean inactive;

    @Schema(description = "")
    private MiniSeriesDTO miniSeries;
}
