package com.gachon.community.menu.service;

import com.gachon.community.menu.domain.BoardMenu;
import com.gachon.community.menu.repository.MenuRepository;
import com.gachon.community.menu.response.BoardMenuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<BoardMenuResponse> getAllMenus() {
        return menuRepository.getAllMenus().stream()
                .map(BoardMenuResponse::new)
                .collect(Collectors.toList());
    }
}
