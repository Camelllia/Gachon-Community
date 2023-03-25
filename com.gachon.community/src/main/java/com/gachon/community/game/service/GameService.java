package com.gachon.community.game.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gachon.community.game.exception.GameMemberNotFoundException;
import com.gachon.community.game.response.MatchResponseDTO;
import com.gachon.community.game.response.UserInfoResponse;
import com.gachon.community.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final RestTemplate restTemplate;

    private final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjE2Mjc5MzcwNTAiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5NTI3MzA5OSwiaWF0IjoxNjc5NzIxMDk5LCJuYmYiOjE2Nzk3MjEwOTksInNlcnZpY2VfaWQiOiI0MzAwMTEzOTMiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.GAkNx8UlkfTlPSFeeCJBc1CGuugJnhb45NWcaPDKZMk";

    public ResponseEntity<?> search(String nickName) {

        final String userInfoUrl = "https://api.nexon.co.kr/kart/v1.0/users/nickname/{nickname}";
        final String matchInfoUrl = "https://api.nexon.co.kr/kart/v1.0/users/{access_id}/matches?&offset=0&limit=20";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
            UserInfoResponse userInfoResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, UserInfoResponse.class, nickName).getBody();
            MatchResponseDTO matchResponseDTO = restTemplate.exchange(matchInfoUrl, HttpMethod.GET, entity, MatchResponseDTO.class, userInfoResponse.getAccessId()).getBody();

            return new ResponseEntity<>(matchResponseDTO, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            throw new GameMemberNotFoundException();
        }
    }
}
