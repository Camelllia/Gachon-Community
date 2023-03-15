package com.gachon.community.board.repository;

import static com.gachon.community.board.domain.QBoard.board;

import com.gachon.community.board.domain.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

public class BoardCustomRepositoryImpl implements BoardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Board> getBoardLists(Long menuId) {
        return jpaQueryFactory.selectFrom(board)
                .where(board.delYn.eq(Boolean.FALSE))
                .where(board.boardMenu.id.eq(menuId))
                .orderBy(board.createDate.desc())
                .fetch();
    }

    @Override
    public Optional<Board> getBoardItem(Long menuId, Long boardId) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(board)
                .where(board.delYn.eq(Boolean.FALSE))
                .where(board.boardMenu.id.eq(menuId))
                .where(board.id.eq(boardId))
                .fetchOne());
    }
}
