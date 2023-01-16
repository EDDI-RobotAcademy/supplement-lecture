package com.example.boilerplateproj.domain.jpa.board.entity;

import com.example.boilerplateproj.domain.jpa.account.entity.JpaAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Builder
// 이 녀석을 사용하는 목적은 명시성이라 봐도 무방합니다.
// builder를 이용해서 객체를 설정한다면
// 해당 객체가 어떤 정보들을 어떤 이름으로 관리하는지 파악할 수 있습니다.
@NoArgsConstructor
public class JpaComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_comment_seq_gen")
    @SequenceGenerator(sequenceName = "jpa_comment_seq", name = "jpa_comment_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "jpa_board_id")
    private JpaBoard jpaBoard;

    @OneToOne
    @JoinColumn(name = "jpa_account_id")
    private JpaAccount jpaAccount;

    public JpaComment (String content) {
        this.content = content;
    }
}
