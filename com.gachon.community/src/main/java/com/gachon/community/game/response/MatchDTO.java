package com.gachon.community.game.response;

import lombok.Data;

@Data
public class MatchDTO {

    private String matchType;

    private MatchInfoDTO[] matches;
}
