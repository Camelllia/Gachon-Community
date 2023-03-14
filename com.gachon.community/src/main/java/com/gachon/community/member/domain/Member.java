package com.gachon.community.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Schema(description = "회원 정보 테이블")
@Entity
@Data
@NoArgsConstructor
@Table(name = "community_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String registIp;

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
    public Member(String email, String password, String nickname, String registIp) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.registIp = registIp;
    }
}
