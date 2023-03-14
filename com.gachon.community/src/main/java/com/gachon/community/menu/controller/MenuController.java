package com.gachon.community.menu.controller;

import com.gachon.community.menu.response.BoardMenuResponse;
import com.gachon.community.menu.service.MenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "BOARD MENU", description = "게시글 메뉴 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menus")
    public List<BoardMenuResponse> getAllMenus() {
        return menuService.getAllMenus();
    }
}
