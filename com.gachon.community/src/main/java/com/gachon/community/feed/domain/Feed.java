package com.gachon.community.feed.domain;

import com.gachon.community.member.domain.Member;
import com.gachon.community.menu.domain.BoardMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Schema(description = "커뮤니티 피드 테이블")
@Entity
@Data
@NoArgsConstructor
@Table(name = "community_feed")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_idx")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "image_url")
    private String imagePath;

    @Column(name = "regist_ip")
    private String registIp;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean delYn;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    @Builder
    public Feed(String title, String imagePath, String content, String registIp, Member member) {
        this.title = title;
        this.imagePath = imagePath;
        this.content = content;
        this.registIp = registIp;
        this.member = member;
    }
}
