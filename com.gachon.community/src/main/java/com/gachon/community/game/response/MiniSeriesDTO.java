package com.gachon.community.game.response;

import lombok.Data;

@Data
public class MiniSeriesDTO {

    private int losses;

    private String progress;

    private int target;

    private int wins;
}
