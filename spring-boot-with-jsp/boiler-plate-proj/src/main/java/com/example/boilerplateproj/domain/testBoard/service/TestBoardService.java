package com.example.boilerplateproj.domain.testBoard.service;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.testBoard.controller.request.TestBoardRequest;
import com.example.boilerplateproj.domain.testBoard.entity.TestBoard;

import java.util.List;
public interface TestBoardService {

	public void register(TestBoardRequest testBoardRequest) throws Exception;

	public TestBoard read(Integer boardNo) throws Exception;

	public void modify(TestBoardRequest testBoardRequest, Integer boardNo) throws Exception;

	public void remove(Integer boardNo) throws Exception;

	public List<TestBoard> list() throws Exception;

}