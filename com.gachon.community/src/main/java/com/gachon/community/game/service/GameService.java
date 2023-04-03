package com.gachon.community.game.service;

import com.gachon.community.game.exception.GameMemberNotFoundException;
import com.gachon.community.game.response.LeagueEntryDTO;
import com.gachon.community.game.response.MatchDTO;
import com.gachon.community.game.response.SummonerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final RestTemplate restTemplate;

    @Value("${riot.openapi.key}")
    private String API_KEY;

    public ResponseEntity<?> summonerSearch(String summonerName) {

        final String summonerInfoAPI = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}";
        final String leagueInfoAPI = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}";
        final String matchListAPI = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/{puuid}/ids?count=10";
        final String matchInfoAPI = "https://asia.api.riotgames.com/lol/match/v5/matches/{matchId}";

        // Header RIOT API Key Include
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Riot-Token", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {

            // 소환사 고유 정보 조회
            SummonerDTO summonerDTO = restTemplate.exchange(summonerInfoAPI, HttpMethod.GET, entity, SummonerDTO.class, summonerName).getBody();

            // 암호화된 소환사 ID
            String summonerId = summonerDTO.getId();

            // 암호화된 PUUID
            String puuid = summonerDTO.getPuuid();

            // 암호화된 계정 ID
            String accountId = summonerDTO.getAccountId();

            // 소환사의 리그 정보 조회
            LeagueEntryDTO[] leagueEntryDTO = restTemplate.exchange(leagueInfoAPI, HttpMethod.GET, entity, LeagueEntryDTO[].class, summonerId).getBody();

            // 매치 ID 리스트 조회
            List<String> matchIdList = restTemplate.exchange(matchListAPI, HttpMethod.GET, entity, List.class, puuid).getBody();

            // 매치 정보를 담은 리스트
            List<MatchDTO> matchInfoList = new ArrayList<>();

            // 매치 ID로 매치 정보 조회 후 리스트에 삽입
            for(String matchId : matchIdList) {
                MatchDTO matchDTO = restTemplate.exchange(matchInfoAPI, HttpMethod.GET, entity, MatchDTO.class, matchId).getBody();
                matchInfoList.add(matchDTO);
            }

            log.info("SEARCH SUCCESS SUMMONER NAME : {}", summonerName);

            return new ResponseEntity<>(matchInfoList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            throw new GameMemberNotFoundException();
        }
    }
}
