package com.gachon.community.feed.repository;

import com.gachon.community.feed.domain.Feed;

import java.util.List;
import java.util.Optional;

public interface FeedCustomRepository {

    List<Feed> getFeedList();

    Optional<Feed> getFeedItem(Long feedId);
}
