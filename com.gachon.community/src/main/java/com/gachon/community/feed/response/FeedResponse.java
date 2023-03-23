package com.gachon.community.feed.response;

import com.gachon.community.feed.domain.Feed;
import com.gachon.community.member.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FeedResponse {

    @Schema(description = "Feed ID", defaultValue = "1")
    private Long id;

    @Schema(description = "게시글 제목", defaultValue = "제목입니다")
    private String title;

    @Schema(description = "게시글 내용", defaultValue = "내용입니다")
    private String content;

    @Schema(description = "작성일", defaultValue = "2023-03-15 01:08:26")
    private Date createDate;

    @Schema(description = "작성자 정보")
    private Member member;

    public FeedResponse(Feed feed) {
        this.id = feed.getId();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.createDate = feed.getCreateDate();
        this.member = feed.getMember();
    }
}

