package com.example.boilerplateproj.domain.board.entity;

import java.time.LocalDateTime;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name="board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;

}
