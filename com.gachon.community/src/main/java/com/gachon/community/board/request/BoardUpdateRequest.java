package com.gachon.community.board.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardUpdateRequest {

    @Schema(description = "게시글 제목" , example = "수정될 제목")
    @NotBlank()
    private String title;

    @Schema(description = "게시글 내용" , example = "수정될 내용")
    @NotBlank()
    private String content;
}
