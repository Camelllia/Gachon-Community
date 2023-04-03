package com.gachon.community.game.response;

import lombok.Data;

import java.util.List;

@Data
public class PerksDTO {

    private PerkStatsDTO statPerks;

    private List<PerkStyleDTO> styles;
}
