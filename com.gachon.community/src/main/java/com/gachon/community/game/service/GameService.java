package com.gachon.community.game.service;

import com.gachon.community.game.exception.GameMemberNotFoundException;
import com.gachon.community.game.response.MatchDetailDTO;
import com.gachon.community.game.response.MatchResponseDTO;
import com.gachon.community.game.response.SummonerDTO;
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

    @Value("${riot.openapi.key}")
    private String API_KEY;

    public ResponseEntity<?> summonerSearch(String summonerName) {

        final String summonerInfoAPI = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Riot-Token", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
            SummonerDTO summonerDTO = restTemplate.exchange(summonerInfoAPI, HttpMethod.GET, entity, SummonerDTO.class, summonerName).getBody();

            log.info("SEARCH SUCCESS SUMMONER NAME : {}", summonerName);

            return new ResponseEntity<>(summonerDTO, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            throw new GameMemberNotFoundException();
        }
    }
}
