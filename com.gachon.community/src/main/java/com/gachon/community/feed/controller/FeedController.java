package com.gachon.community.feed.controller;

import com.gachon.community.board.request.BoardCreateRequest;
import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.exception.response.ErrorResponse;
import com.gachon.community.feed.request.FeedCreateRequest;
import com.gachon.community.feed.response.FeedResponse;
import com.gachon.community.feed.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Tag(name = "FEED ITEM", description = "피드 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {

    private final FeedService feedService;

    @Operation(summary = "피드 작성", description = "피드 작성 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "등록 성공 케이스", content = @Content(schema = @Schema(implementation = FeedResponse.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Valid FeedCreateRequest request) throws IOException {
        return feedService.create(request);
    }
}
