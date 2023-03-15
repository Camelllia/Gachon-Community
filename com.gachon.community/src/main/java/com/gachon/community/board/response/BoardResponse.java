package com.gachon.community.board.response;

import com.gachon.community.board.domain.Board;
import com.gachon.community.member.domain.Member;
import com.gachon.community.menu.domain.BoardMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BoardResponse {

    @Schema(description = "게시글 ID", defaultValue = "1")
    private Long id;

    @Schema(description = "게시글 제목", defaultValue = "제목입니다")
    private String title;

    @Schema(description = "게시글 내용", defaultValue = "내용입니다")
    private String content;

    @Schema(description = "작성일", defaultValue = "2023-03-15 01:08:26")
    private Date createDate;

    @Schema(description = "메뉴 정보")
    private BoardMenu boardMenu;

    @Schema(description = "작성자 정보")
    private Member member;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createDate = board.getCreateDate();
        this.boardMenu = board.getBoardMenu();
        this.member = board.getMember();
    }
}
