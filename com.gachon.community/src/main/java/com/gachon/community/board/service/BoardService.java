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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final MenuRepository menuRepository;

    public ResponseEntity<?> getBoardLists(Long menuId) {
        return new ResponseEntity<>(boardRepository.getBoardLists(menuId).stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<?> getBoardItem(Long menuId, Long boardId) {

        BoardMenu boardMenu = menuRepository.findByMenuId(menuId)
                .orElseThrow(MenuNotFoundException::new);

        return new ResponseEntity<>(new BoardResponse(boardRepository.getBoardItem(menuId, boardId)
                .orElseThrow(BoardNotFoundException::new)), HttpStatus.OK);
    }
}
