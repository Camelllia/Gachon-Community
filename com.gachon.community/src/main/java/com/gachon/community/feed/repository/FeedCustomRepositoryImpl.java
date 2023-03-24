package com.gachon.community.feed.repository;

import com.gachon.community.feed.domain.Feed;
import static com.gachon.community.feed.domain.QFeed.feed;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

public class FeedCustomRepositoryImpl implements FeedCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public FeedCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Feed> getFeedList() {
        return jpaQueryFactory.selectFrom(feed)
                .where(feed.delYn.eq(Boolean.FALSE))
                .orderBy(feed.createDate.desc())
                .fetch();
    }

    @Override
    public Optional<Feed> getFeedItem(Long feedId) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(feed)
                .where(feed.id.eq(feedId))
                .where(feed.delYn.eq(Boolean.FALSE))
                .fetchOne());
    }
}
