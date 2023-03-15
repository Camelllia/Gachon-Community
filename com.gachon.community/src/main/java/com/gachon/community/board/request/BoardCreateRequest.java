package com.gachon.community.board.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BoardCreateRequest {

    @Schema(description = "게시글 제목" , example = "제목입니다")
    @NotBlank()
    private String title;

    @Schema(description = "게시글 내용" , example = "내용입니다")
    @NotBlank()
    private String content;

    @Schema(description = "메뉴 ID" , example = "1")
    @NotNull()
    private Long menuId;
}