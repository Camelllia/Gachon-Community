package com.gachon.community.feed.service;

import com.gachon.community.board.exception.BoardNotFoundException;
import com.gachon.community.board.response.BoardResponse;
import com.gachon.community.feed.domain.Feed;
import com.gachon.community.feed.exception.FeedNotFoundException;
import com.gachon.community.feed.exception.InvalidExtensionException;
import com.gachon.community.feed.repository.FeedRepository;
import com.gachon.community.feed.request.FeedCreateRequest;
import com.gachon.community.feed.response.FeedResponse;
import com.gachon.community.member.domain.Member;
import com.gachon.community.member.exception.MemberNotFoundException;
import com.gachon.community.member.repository.MemberRepository;
import com.gachon.community.util.common.CommonUtil;
import com.gachon.community.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;

    private final CommonUtil commonUtil;

    public ResponseEntity<?> create(FeedCreateRequest request) throws IOException {

        String filePath = "YOUR FILE PATH";

        // Authentication 바탕으로 Member 조회
        Member member = memberRepository.findByMemberId(Long.parseLong(SecurityUtil.getCurrentMemberId()))
                .orElseThrow(MemberNotFoundException::new);

        if(request.getImageFile() != null) {
            String originalFileName = request.getImageFile().getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

            if(!commonUtil.isValidExtension(extension)) {
                throw new InvalidExtensionException();
            }

            String fileName = UUID.randomUUID().toString() + "." + extension;
            filePath += fileName;

            request.getImageFile().transferTo(new File(filePath));
        }

        Feed feed = Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .imagePath(request.getImageFile() == null ? null : filePath)
                .member(member)
                .registIp(commonUtil.getIp())
                .build();

        feedRepository.save(feed);

        return new ResponseEntity<>(new FeedResponse(feed), HttpStatus.OK);
    }

    public ResponseEntity<?> getFeedList() {
        return new ResponseEntity<>(feedRepository.getFeedList().stream()
                .map(FeedResponse::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<?> getFeedItem(Long feedId) {
        return new ResponseEntity<>(new FeedResponse(feedRepository.getFeedItem(feedId)
                .orElseThrow(FeedNotFoundException::new)), HttpStatus.OK);
    }
}
