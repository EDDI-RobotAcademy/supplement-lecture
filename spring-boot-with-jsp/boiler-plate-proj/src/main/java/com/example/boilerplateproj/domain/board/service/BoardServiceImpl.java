package com.example.boilerplateproj.domain.board.service;

import java.util.List;
import java.util.Optional;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public void register(Board board) throws Exception {
		boardRepository.save(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

		if (maybeBoard.equals(Optional.empty())) {
			log.info("Can't read board!!!");
			return null;
		}

		return maybeBoard.get();
	}

	@Override
	public void modify(BoardRequest boardRequest, Integer boardNo) throws Exception {
		Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

		if (maybeBoard.equals(Optional.empty())) {
			log.info("Can't read board!!!");
			return;
		}

		Board findedBoard = maybeBoard.get();
		findedBoard.setTitle(boardRequest.getTitle());
		findedBoard.setContent(boardRequest.getContent());

		boardRepository.save(findedBoard);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		boardRepository.deleteById(Long.valueOf(boardNo));
	}

	@Override
	public List<Board> list() throws Exception {
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

}
