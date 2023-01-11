package com.example.boilerplateproj.comment;

import com.example.boilerplateproj.domain.jpa.board.entity.JpaBoard;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaBoardRepository;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaCommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
