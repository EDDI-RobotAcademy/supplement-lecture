package com.example.boilerplateproj.domain.board.entity;

import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;

}
