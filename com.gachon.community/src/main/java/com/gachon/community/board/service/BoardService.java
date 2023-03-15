package com.gachon.community.board.service;

import com.gachon.community.board.exception.BoardNotFoundException;
import com.gachon.community.board.repository.BoardRepository;
import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.menu.domain.BoardMenu;
import com.gachon.community.menu.exception.MenuNotFoundException;
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
public class BoardService {

    private final BoardRepository boardRepository;

    private final MenuRepository menuRepository;

    public List<BoardResponse> getBoardLists(Long menuId) {
        return boardRepository.getBoardLists(menuId).stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }

    public BoardResponse getBoardItem(Long menuId, Long boardId) {

        BoardMenu boardMenu = menuRepository.findByMenuId(menuId)
                .orElseThrow(MenuNotFoundException::new);

        return new BoardResponse(boardRepository.getBoardItem(menuId, boardId)
                .orElseThrow(BoardNotFoundException::new));
    }
}
