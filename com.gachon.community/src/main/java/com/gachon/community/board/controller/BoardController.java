package com.gachon.community.board.controller;

import com.gachon.community.board.request.BoardCreateRequest;
import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.board.service.BoardService;
import com.gachon.community.exception.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "BOARD ITEM", description = "게시글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시글 리스트 조회", description = "게시글 리스트 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공 케이스", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardResponse.class)))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/{menuId}")
    public ResponseEntity<?> getBoardLists(@PathVariable("menuId") Long menuId) {
        return boardService.getBoardLists(menuId);
    }

    @Operation(summary = "게시글 조회", description = "게시글 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공 케이스", content = @Content(schema = @Schema(implementation = BoardResponse.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/{menuId}/{boardId}")
    public ResponseEntity<?> getBoardItem(@PathVariable("menuId") Long menuId, @PathVariable("boardId") Long boardId) {
        return boardService.getBoardItem(menuId, boardId);
    }

    @Operation(summary = "게시글 작성", description = "게시글 작성 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "등록 성공 케이스", content = @Content(schema = @Schema(implementation = BoardResponse.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid BoardCreateRequest request) {
        return boardService.create(request);
    }
}
