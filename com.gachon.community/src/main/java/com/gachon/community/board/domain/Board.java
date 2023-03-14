package com.gachon.community.board.domain;

import com.gachon.community.member.domain.Member;
import com.gachon.community.menu.domain.BoardMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Schema(description = "커뮤니티 게시글 테이블")
@Entity
@Data
@NoArgsConstructor
@Table(name = "community_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_idx")
    private BoardMenu boardMenu;

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
}
