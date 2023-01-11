package com.example.boilerplateproj.domain.jpa.board.repository;

import com.example.boilerplateproj.domain.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
