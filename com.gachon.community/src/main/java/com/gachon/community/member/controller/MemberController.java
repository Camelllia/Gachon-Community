package com.gachon.community.member.controller;

import com.gachon.community.exception.response.ErrorResponse;
import com.gachon.community.member.request.MemberCreateRequest;
import com.gachon.community.member.request.MemberLoginRequest;
import com.gachon.community.member.response.MemberResponse;
import com.gachon.community.member.response.TokenInfo;
import com.gachon.community.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "MEMBER", description = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입", description = "회원가입 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원가입 성공 케이스", content = @Content(schema = @Schema(implementation = MemberResponse.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid MemberCreateRequest request) {
        return memberService.join(request);
    }

    @Operation(summary = "로그인", description = "로그인 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공 케이스", content = @Content(schema = @Schema(implementation = TokenInfo.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid MemberLoginRequest request) {
        return memberService.login(request);
    }

    @Operation(summary = "회원 탈퇴", description = "회원 탈퇴 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "삭제 성공 케이스", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "400", description = "예외 발생 케이스", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PatchMapping("/{memberId}/delete")
    public ResponseEntity<?> delete(@PathVariable("memberId") Long memberId) {
        return memberService.delete(memberId);
    }
}
