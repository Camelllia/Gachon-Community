package com.gachon.community.game.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MatchResponseDTO {

    private String nickName;

    private MatchDTO[] matches;
}
