package com.example.boilerplateproj.comment;

import com.example.boilerplateproj.domain.jpa.board.controller.response.CommentResponse;
import com.example.boilerplateproj.domain.jpa.board.entity.JpaBoard;
import com.example.boilerplateproj.domain.jpa.board.entity.JpaComment;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaBoardRepository;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaCommentRepository;
import org.hibernate.annotations.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CommentTest {

    @Autowired
    private JpaBoardRepository boardRepository;

    @Autowired
    private JpaCommentRepository commentRepository;

    @Test
    void saveBoard () {
        JpaBoard board = new JpaBoard("제목", "작성자", "내용");
        boardRepository.save(board);
    }

    @Test
    void saveComment () {
        Optional<JpaBoard> maybeBoard = boardRepository.findById(1L);

        if (maybeBoard.isEmpty()) {
            System.out.println("찾는 글이 없습니다!");
            return;
        }

        JpaBoard board = maybeBoard.get();
        JpaComment comment = new JpaComment("음 ... ?");

        board.setComment(comment);
        boardRepository.save(board);

        commentRepository.save(comment);
    }

    @Test
    void saveComment2 () {
        Optional<JpaBoard> maybeBoard = boardRepository.findById(1L);

        if (maybeBoard.isEmpty()) {
            System.out.println("찾는 글이 없습니다!");
            return;
        }

        JpaBoard board = maybeBoard.get();
        JpaComment comment = new JpaComment("무플방지위원회입니다!");

        board.setComment(comment);
        boardRepository.save(board);

        commentRepository.save(comment);
    }

    @Test
    void saveBoard2 () {
        JpaBoard board = new JpaBoard("새로운 글", "작성자2", "뭥미");
        boardRepository.save(board);
    }

    @Test
    void saveComment3 () {
        Optional<JpaBoard> maybeBoard = boardRepository.findById(2L);

        if (maybeBoard.isEmpty()) {
            System.out.println("찾는 글이 없습니다!");
            return;
        }

        JpaBoard board = maybeBoard.get();
        JpaComment comment = JpaComment.builder()
                .content("무플방지위원회에서 나왔습니다!")
                .jpaBoard(board)
                .build();

        commentRepository.save(comment);
    }

    @Test
    void findBoardComment () {
        List<JpaComment> commentList = commentRepository.findAllCommentsByJpaBoardId(1L);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (JpaComment comment : commentList) {
            commentResponses.add(new CommentResponse(comment.getContent()));
        }

        System.out.println(commentResponses);
    }
}
