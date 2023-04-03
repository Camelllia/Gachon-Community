package com.gachon.community.game.response;

import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {

    private List<BanDTO> bans;

    private ObjectivesDTO objectives;

    private int teamId;

    private boolean win;
}
