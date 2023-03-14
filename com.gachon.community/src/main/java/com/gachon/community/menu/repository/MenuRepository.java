package com.gachon.community.menu.repository;

import com.gachon.community.menu.domain.BoardMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<BoardMenu, Long>, MenuCustomRepository {

}
