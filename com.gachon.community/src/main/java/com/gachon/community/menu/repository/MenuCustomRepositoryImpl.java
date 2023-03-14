package com.gachon.community.menu.repository;

import com.gachon.community.menu.domain.BoardMenu;
import static com.gachon.community.menu.domain.QBoardMenu.boardMenu;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MenuCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<BoardMenu> getAllMenus() {
        return jpaQueryFactory.selectFrom(boardMenu)
                .where(boardMenu.delYn.eq(Boolean.FALSE))
                .fetch();
    }
}
