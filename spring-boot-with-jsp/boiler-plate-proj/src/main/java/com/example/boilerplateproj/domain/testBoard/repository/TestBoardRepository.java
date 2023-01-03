package com.example.boilerplateproj.domain.testBoard.repository;

import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.testBoard.entity.TestBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestBoardRepository extends JpaRepository<TestBoard, Long> {
}