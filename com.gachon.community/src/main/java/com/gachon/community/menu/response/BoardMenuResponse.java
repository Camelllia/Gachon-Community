package com.gachon.community.menu.response;

import com.gachon.community.menu.domain.BoardMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class BoardMenuResponse {

    @Schema(description = "메뉴 ID", defaultValue = "1")
    private Long id;

    @Schema(description = "메뉴 이름", defaultValue = "자유게시판")
    private String name;

    public BoardMenuResponse(BoardMenu boardMenu) {
        this.id = boardMenu.getId();
        this.name = boardMenu.getName();
    }
}
