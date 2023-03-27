package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PlayerDTO {

    @Schema(description = "캐릭터", example = "03e6c20439f6cdee8470f26b0d5aff7406f6f7e0307f1fb491d6ce519504a135")
    private String character;

    @Schema(description = "아이템(카트)", example = "d47aa62de79d88ecee263e07456555d99ff8957f1760d0f248667913acbc2b67")
    private String kart;

    @Schema(description = "라이선스", example = "", defaultValue = "")
    private String license;

    @Schema(description = "아이템(펫)", example = "", defaultValue = "")
    private String pet;

    @Schema(description = "아이템(플라잉펫)", example = "a87cb96d91a4e0c357c4eaeb7dbc05ef515d183e79a8aa0e674c36f917400a4b")
    private String flyingPet;

    @Schema(description = "partsEngine", example = "88")
    private String partsEngine;

    @Schema(description = "partsHandle", example = "1")
    private String partsHandle;

    @Schema(description = "partsWheel", example = "0")
    private String partsWheel;

    @Schema(description = "partsKit", example = "0")
    private String partsKit;

    @Schema(description = "순위", example = "1")
    private String matchRank;

    @Schema(description = "승리 여부", example = "1")
    private String matchWin;

    @Schema(description = "매치 진행 시간", example = "92651")
    private String matchTime;

    @Schema(description = "리타이어 여부", example = "0")
    private String matchRetired;

    @Schema(description = "리뉴얼 라이선스", example = "4")
    private String rankinggrade2;

    @Schema(description = "게임 내 계정 닉네임", example = "", defaultValue = "")
    private String characterName;
}
