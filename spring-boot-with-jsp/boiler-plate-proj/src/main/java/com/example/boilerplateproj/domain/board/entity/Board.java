package com.example.boilerplateproj.domain.board.entity;

import java.time.LocalDateTime;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name="test_board")
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boardNo;
	private String title;
	private String content;
	private String writer;

	@CreationTimestamp
	private LocalDateTime regDate;

	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
}
