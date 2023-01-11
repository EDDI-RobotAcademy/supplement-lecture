package com.example.boilerplateproj.domain.jpa.board.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class JpaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_board_seq_gen")
    @SequenceGenerator(sequenceName = "jpa_board_seq", name = "jpa_board_seq_gen", allocationSize = 1)
    @Column(name = "jpa_board_id")
    private Long id;

    private String title;
    private String writer;
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(mappedBy = "jpaBoard", fetch = FetchType.EAGER)
    private List<JpaComment> commentList = new ArrayList<>();

    public JpaBoard (String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public void setComment (JpaComment comment) {
        commentList.add(comment);
        comment.setJpaBoard(this);
    }
}
