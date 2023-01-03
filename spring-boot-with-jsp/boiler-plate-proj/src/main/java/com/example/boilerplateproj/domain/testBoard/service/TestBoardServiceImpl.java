package com.example.boilerplateproj.domain.testBoard.service;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.repository.BoardRepository;
import com.example.boilerplateproj.domain.testBoard.controller.request.TestBoardRequest;
import com.example.boilerplateproj.domain.testBoard.entity.TestBoard;
import com.example.boilerplateproj.domain.testBoard.repository.TestBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TestBoardServiceImpl implements TestBoardService {

	@Autowired
	private TestBoardRepository boardRepository;

	@Override
	public void register(TestBoardRequest testBoardRequest) throws Exception {
		TestBoard testBoard = new TestBoard(
				testBoardRequest.getTitle(),
				testBoardRequest.getContent(),
				testBoardRequest.getWriter(),
				testBoardRequest.getRecommendNumber()
		);

		boardRepository.save(testBoard);
	}

	@Override
	public TestBoard read(Integer boardNo) throws Exception {
		Optional<TestBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

		if (maybeBoard.equals(Optional.empty())) {
			log.info("Can't read board!!!");
			return null;
		}

		return maybeBoard.get();
	}

	@Override
	public void modify(TestBoardRequest boardRequest, Integer boardNo) throws Exception {
		Optional<TestBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

		if (maybeBoard.equals(Optional.empty())) {
			log.info("Can't read board!!!");
			return;
		}

		TestBoard findedBoard = maybeBoard.get();
		findedBoard.setTitle(boardRequest.getTitle());
		findedBoard.setContent(boardRequest.getContent());

		boardRepository.save(findedBoard);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		boardRepository.deleteById(Long.valueOf(boardNo));
	}

	@Override
	public List<TestBoard> list() throws Exception {
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
	}

}
