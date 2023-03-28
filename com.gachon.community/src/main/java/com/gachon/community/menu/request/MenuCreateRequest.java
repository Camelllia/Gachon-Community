package com.gachon.community.menu.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MenuCreateRequest {

    @Schema(description = "메뉴 이름" , example = "자유게시판")
    @NotBlank()
    private String name;
}
