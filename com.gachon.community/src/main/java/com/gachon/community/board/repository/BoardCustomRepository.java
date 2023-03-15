package com.gachon.community.board.repository;

import com.gachon.community.board.domain.Board;
import java.util.List;
import java.util.Optional;

public interface BoardCustomRepository {

    List<Board> getBoardLists(Long menuId);

    Optional<Board> getBoardItem(Long menuId, Long boardId);
}
