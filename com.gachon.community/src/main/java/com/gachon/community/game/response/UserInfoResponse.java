package com.gachon.community.game.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfoResponse {

    private String accessId;

    private String name;

    private String level;
}
