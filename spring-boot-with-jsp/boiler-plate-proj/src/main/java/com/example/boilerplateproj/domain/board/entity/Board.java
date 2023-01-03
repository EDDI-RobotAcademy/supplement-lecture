package com.example.boilerplateproj.domain.board.entity;

import java.time.LocalDateTime;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@Entity
@ToString
//@Table(name="board")
// 디폴트 생성자
@NoArgsConstructor
public class Board {

	// 모든 Entity는 자기 자신의 고유값을 가짐
	// 그러므로 이 정보를 Id (Identity)로 취급하겠음을 의미함
	// GeneratedValue(자동 생성) - Sequence 귀찮게 일일히 안만듬
	@Id
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_board_seq_gen")
	//@SequenceGenerator(sequenceName = "test_board_seq", name = "test_board_seq_gen", allocationSize = 1)
	//@Column(name = "id")
	private Long id;
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
