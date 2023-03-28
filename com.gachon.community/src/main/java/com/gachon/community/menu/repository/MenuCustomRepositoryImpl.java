package com.gachon.community.menu.repository;

import com.gachon.community.menu.domain.BoardMenu;
import static com.gachon.community.menu.domain.QBoardMenu.boardMenu;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MenuCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<BoardMenu> getMenuList() {
        return jpaQueryFactory.selectFrom(boardMenu)
                .where(boardMenu.delYn.eq(Boolean.FALSE))
                .orderBy(boardMenu.createDate.asc())
                .fetch();
    }

    @Override
    public Optional<BoardMenu> findByMenuId(Long menuId) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(boardMenu)
                .where(boardMenu.delYn.eq(Boolean.FALSE))
                .where(boardMenu.id.eq(menuId))
                .fetchOne());
    }

    @Override
    public long delete(Long id) {
        return jpaQueryFactory.update(boardMenu)
                .set(boardMenu.delYn, Boolean.TRUE)
                .set(boardMenu.deleteDate, Expressions.currentTimestamp())
                .where(boardMenu.id.eq(id))
                .execute();
    }
}
