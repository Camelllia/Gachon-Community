package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SummonerDTO {

    @Schema(description = "암호화된 소환사 ID", example = "JmmmuF2AtBjTiZvdCp97lcGeW1Ght-hg_C0sexQj4mZKpn0")
    private String id;

    @Schema(description = "암호화된 계정 ID(최대 56의 길이를 가지는 문자)", example = "IWXZRIvpwb1NEUHZ6oNCcbD9o3uOg7mXYsRFljmIx2CaGho")
    private String accountId;

    @Schema(description = "암호화된 PUUID", example = "hNmoVUQBgKwkpQAQhzJGAdxt2UADT0RBc5QZj8fFJhx18Fudukq1yfBSSxazIfhBiFmbLMnDYDEppQ")
    private String puuid;

    @Schema(description = "소환사명", example = "Doshisha")
    private String name;

    @Schema(description = "소환사 아이콘 ID", example = "4320")
    private int profileIconId;

    @Schema(description = "소환사가 마지막으로 수정된 날짜(epoch 밀리초)", example = "1680321391000")
    private long revisionDate;

    @Schema(description = "소환사 레벨", example = "413")
    private long summonerLevel;
}
