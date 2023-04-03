package com.gachon.community.game.response;

import lombok.Data;

import java.util.List;

@Data
public class MetadataDTO {

    private String dataVersion;

    private String matchId;

    private List<String> participants;
}
