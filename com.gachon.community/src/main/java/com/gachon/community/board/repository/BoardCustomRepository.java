package com.gachon.community.board.repository;

import com.gachon.community.board.domain.Board;
import com.gachon.community.board.request.BoardUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface BoardCustomRepository {

    List<Board> getBoardList(Long menuId);

    Optional<Board> getBoardItem(Long menuId, Long boardId);

    long update(Long boardId, BoardUpdateRequest request);

    long delete(Long boardId);
}
