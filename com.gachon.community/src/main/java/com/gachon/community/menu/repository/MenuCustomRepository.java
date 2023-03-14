package com.gachon.community.menu.repository;

import com.gachon.community.menu.domain.BoardMenu;

import java.util.List;

public interface MenuCustomRepository {

    List<BoardMenu> getAllMenus();
}
