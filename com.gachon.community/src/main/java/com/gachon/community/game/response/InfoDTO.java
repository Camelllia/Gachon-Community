package com.gachon.community.game.response;

import lombok.Data;

import java.util.List;

@Data
public class InfoDTO {

    private long gameCreation;

    private long gameDuration;

    private long gameEndTimestamp;

    private long gameId;

    private String gameMode;

    private String gameName;

    private long gameStartTimestamp;

    private String gameType;

    private String gameVersion;

    private int mapId;

    private List<ParticipantDTO> participants;

    private String platformId;

    private int queueId;

    private List<TeamDTO> teams;

    private String tournamentCode;
}
