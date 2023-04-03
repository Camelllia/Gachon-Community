package com.gachon.community.game.controller;

import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.exception.response.ErrorResponse;
import com.gachon.community.game.response.MatchDetailDTO;
import com.gachon.community.game.response.MatchResponseDTO;
import com.gachon.community.game.response.SummonerDTO;
import com.gachon.community.game.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "GAME", description = "게임 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @Operation(summary = "유저 정보 조회", description = "LOL 소환사명으로 유저 정보 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공 케이스", content = @Content(schema = @Schema(implementation = SummonerDTO.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/summoner-search/{summonerName}")
    public ResponseEntity<?> summonerSearch(@PathVariable("summonerName") String summonerName) {
        return gameService.summonerSearch(summonerName);
    }
}
