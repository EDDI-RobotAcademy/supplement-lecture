package com.example.boilerplateproj.domain.jpa.board.repository;

import com.example.boilerplateproj.domain.jpa.board.entity.JpaComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaCommentRepository extends JpaRepository<JpaComment, Long> {

    @Query("select jc from JpaComment jc join jc.jpaBoard jb where jb.id = :id")
    List<JpaComment> findAllCommentsByJpaBoardId (Long id);

    @Query("select jc from JpaComment jc join fetch jc.jpaAccount ja where ja.id = :accountId")
    List<JpaComment> findAllCommentsByJpaAccountId (Long accountId);
}
