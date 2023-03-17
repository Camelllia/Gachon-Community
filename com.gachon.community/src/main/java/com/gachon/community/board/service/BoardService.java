package com.gachon.community.board.service;

import com.gachon.community.board.domain.Board;
import com.gachon.community.board.exception.BoardNotFoundException;
import com.gachon.community.board.repository.BoardRepository;
import com.gachon.community.board.request.BoardCreateRequest;
import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.util.common.CommonUtil;
import com.gachon.community.util.security.SecurityUtil;
import com.gachon.community.member.domain.Member;
import com.gachon.community.member.exception.MemberNotFoundException;
import com.gachon.community.member.repository.MemberRepository;
import com.gachon.community.menu.domain.BoardMenu;
import com.gachon.community.menu.exception.MenuNotFoundException;
import com.gachon.community.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final MenuRepository menuRepository;

    private final MemberRepository memberRepository;

    private final CommonUtil commonUtil;

    public ResponseEntity<?> getBoardList(Long menuId) {
        return new ResponseEntity<>(boardRepository.getBoardList(menuId).stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<?> getBoardItem(Long menuId, Long boardId) {
        BoardMenu boardMenu = menuRepository.findByMenuId(menuId)
                .orElseThrow(MenuNotFoundException::new);

        return new ResponseEntity<>(new BoardResponse(boardRepository.getBoardItem(menuId, boardId)
                .orElseThrow(BoardNotFoundException::new)), HttpStatus.OK);
    }

    public ResponseEntity<?> create(BoardCreateRequest request) {
        // Authentication 바탕으로 Member 조회
        Member member = memberRepository.findByMemberId(Long.parseLong(SecurityUtil.getCurrentMemberId()))
                .orElseThrow(MemberNotFoundException::new);

        // Menu ID 바탕으로 BoardMenu 조회
        BoardMenu boardMenu = menuRepository.findByMenuId(request.getMenuId())
                .orElseThrow(MenuNotFoundException::new);

        // Board 생성
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .registIp(commonUtil.getIp())
                .member(member)
                .boardMenu(boardMenu)
                .build();

        // 저장
        boardRepository.save(board);

        // 로깅
        log.info("CREATE NEW BOARD ITEM : {}", board);
        log.info("CREATE NEW BOARD ITEM REGISTRATION IP : {}", commonUtil.getIp());

        return new ResponseEntity<>(new BoardResponse(board), HttpStatus.OK);
    }
}
