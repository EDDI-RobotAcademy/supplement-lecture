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
