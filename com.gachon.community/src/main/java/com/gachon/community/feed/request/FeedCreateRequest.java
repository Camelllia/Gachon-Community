package com.gachon.community.feed.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
public class FeedCreateRequest {

    @Schema(description = "피드 제목" , example = "제목입니다")
    @NotBlank()
    private String title;

    @Schema(description = "피드 내용" , example = "내용입니다")
    @NotBlank()
    private String content;

    @Schema(description = "이미지 파일" , example = "이미지 파일")
    private MultipartFile imageFile;
}