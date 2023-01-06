package com.example.boilerplateproj.domain.vue.board.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class VueBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vue_board_seq_gen")
    @SequenceGenerator(sequenceName = "vue_board_seq", name = "vue_board_seq_gen", allocationSize = 1)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
