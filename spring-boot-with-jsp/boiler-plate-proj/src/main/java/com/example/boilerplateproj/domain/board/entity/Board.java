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
// 디폴트 생성자
@NoArgsConstructor
public class Board {

	// 모든 Entity는 자기 자신의 고유값을 가짐
	// 그러므로 이 정보를 Id (Identity)로 취급하겠음을 의미함
	// GeneratedValue(자동 생성) - Sequence 귀찮게 일일히 안만듬
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long boardNo;
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
