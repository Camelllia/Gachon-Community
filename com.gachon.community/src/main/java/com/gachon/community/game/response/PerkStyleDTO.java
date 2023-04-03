package com.gachon.community.game.response;

import lombok.Data;

import java.util.List;

@Data
public class PerkStyleDTO {

    private String description;

    private List<PerkStyleSelectionDTO> selections;

    private int style;
}
