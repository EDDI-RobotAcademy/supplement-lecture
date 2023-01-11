package com.example.boilerplateproj.domain.jpa.board.repository;

import com.example.boilerplateproj.domain.jpa.board.entity.JpaComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<JpaComment, Long> {
}
