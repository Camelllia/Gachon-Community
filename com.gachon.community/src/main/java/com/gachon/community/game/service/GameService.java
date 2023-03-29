package com.gachon.community.game.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gachon.community.game.exception.GameMemberNotFoundException;
import com.gachon.community.game.response.MatchDetailDTO;
import com.gachon.community.game.response.MatchResponseDTO;
import com.gachon.community.game.response.UserInfoResponse;
import com.gachon.community.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final RestTemplate restTemplate;

    @Value("${nexon.openapi.key}")
    private String API_KEY;

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

    public ResponseEntity<?> detail(String matchId) {
        final String matchDetailUrl = "https://api.nexon.co.kr/kart/v1.0/matches/{match_id}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
            MatchDetailDTO matchDetailDTO = restTemplate.exchange(matchDetailUrl, HttpMethod.GET, entity, MatchDetailDTO.class, matchId).getBody();

            return new ResponseEntity<>(matchDetailDTO, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            throw new GameMemberNotFoundException();
        }
    }
}
