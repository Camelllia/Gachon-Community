package com.gachon.community.menu.service;

import com.gachon.community.menu.domain.BoardMenu;
import com.gachon.community.menu.exception.MenuNotFoundException;
import com.gachon.community.menu.exception.OverlapMenuNameException;
import com.gachon.community.menu.repository.MenuRepository;
import com.gachon.community.menu.request.MenuCreateRequest;
import com.gachon.community.menu.response.BoardMenuResponse;
import com.gachon.community.util.common.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    private final CommonUtil commonUtil;

    public ResponseEntity<?> getMenuList() {
        return new ResponseEntity<>(menuRepository.getMenuList().stream()
                .map(BoardMenuResponse::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<?> create(MenuCreateRequest request) {
        if(menuRepository.existsByName(request.getName())) {
            throw new OverlapMenuNameException();
        }

        BoardMenu boardMenu = BoardMenu.builder()
                .name(request.getName())
                .build();

        menuRepository.save(boardMenu);

        log.info("CREATE NEW BOARD ITEM : {}", boardMenu);
        log.info("CREATE NEW BOARD ITEM REGISTRATION IP : {}", commonUtil.getIp());

        return new ResponseEntity<>(new BoardMenuResponse(boardMenu), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> delete(Long id) {
        BoardMenu boardMenu = menuRepository.findByMenuId(id)
                .orElseThrow(MenuNotFoundException::new);

        menuRepository.delete(id);

        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
