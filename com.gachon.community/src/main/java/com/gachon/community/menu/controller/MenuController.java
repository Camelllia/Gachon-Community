package com.gachon.community.menu.controller;

import com.gachon.community.exception.response.ErrorResponse;
import com.gachon.community.menu.response.BoardMenuResponse;
import com.gachon.community.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "BOARD MENU", description = "게시글 메뉴 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "게시글 메뉴 조회", description = "메뉴 리스트 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공 케이스", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BoardMenuResponse.class)))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/menus")
    public ResponseEntity<?> getMenuList() {
        return menuService.getMenuList();
    }
}
