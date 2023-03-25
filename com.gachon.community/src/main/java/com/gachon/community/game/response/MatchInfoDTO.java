package com.gachon.community.game.response;

import lombok.Data;

import java.util.Date;

@Data
public class MatchInfoDTO {

    private String accountNo;

    private String matchId;

    private String matchType;

    private String teamId;

    private String character;

    private Date startTime;

    private Date endTime;

    private int playTime;

    private String channelName;

    private String trackId;

    private int playerCount;

    private PlayerDTO player;
}
