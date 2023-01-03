package com.example.boilerplateproj.domain.testBoard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="exercise1_board")
@NoArgsConstructor
public class TestBoard {

    // '글 번호', '제목', '본문', '작성자', '추천개수', '등록일자'
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise1_board_seq_gen")
    @SequenceGenerator(sequenceName = "exercise1_board_seq", name = "exercise1_board_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long boardNo;

    private String title;
    private String content;
    private String writer;
    private Long recommendNumber;

    @CreationTimestamp
    private LocalDateTime createdTime;


    public TestBoard(String title, String content, String writer, Long recommendNumber) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.recommendNumber = recommendNumber;
    }
}
