package com.gachon.community.menu.repository;

import com.gachon.community.menu.domain.BoardMenu;

import java.util.List;
import java.util.Optional;

public interface MenuCustomRepository {

    List<BoardMenu> getMenuList();

    Optional<BoardMenu> findByMenuId(Long menuId);
}
