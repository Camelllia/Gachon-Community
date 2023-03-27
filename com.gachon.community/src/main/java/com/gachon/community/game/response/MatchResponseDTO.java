package com.gachon.community.game.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MatchResponseDTO {

    @Schema(description = "라이더명", example = "능동대장승헌")
    private String nickName;

    @Schema(description = "매치 정보 목록")
    private MatchDTO[] matches;
}
