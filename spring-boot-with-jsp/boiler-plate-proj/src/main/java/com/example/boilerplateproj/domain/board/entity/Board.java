package com.example.boilerplateproj.domain.board.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {

	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;

}
