package com.example.boilerplateproj.comment;

import com.example.boilerplateproj.domain.jpa.account.entity.JpaAccount;
import com.example.boilerplateproj.domain.jpa.account.repository.JpaAccountRepository;
import com.example.boilerplateproj.domain.jpa.board.controller.response.CommentResponse;
import com.example.boilerplateproj.domain.jpa.board.entity.JpaBoard;
import com.example.boilerplateproj.domain.jpa.board.entity.JpaComment;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaBoardRepository;
import com.example.boilerplateproj.domain.jpa.board.repository.JpaCommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class CommentWithAccountTest {

    @Autowired
    private JpaBoardRepository boardRepository;

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private JpaCommentRepository commentRepository;

    @Test
    void createNewAccount () {
        JpaAccount account = new JpaAccount("test@test.com");

        accountRepository.save(account);
    }

    @Test
    void createNewAccount2 () {
        JpaAccount account = new JpaAccount("account@test.com");

        accountRepository.save(account);
    }

    @Test
    void initialSettingForBoardTest () {
        for (int i = 0; i < 3; i++) {
            JpaBoard board = new JpaBoard("제목" + i, "닉네임" + i, "내용" + i);
            boardRepository.save(board);
        }
    }

    JpaBoard getBoardInfo (Long boardId) {
        Optional<JpaBoard> maybeBoard = boardRepository.findById(boardId);

        if (maybeBoard.isEmpty()) {
            System.out.println("찾는 글이 없습니다!");
            return null;
        }

        return maybeBoard.get();
    }

    JpaAccount getAccountInfo (Long accoutId) {
        Optional<JpaAccount> maybeAccout = accountRepository.findById(accoutId);

        if (maybeAccout.isEmpty()) {
            System.out.println("찾는 글이 없습니다!");
            return null;
        }

        return maybeAccout.get();
    }

    @Test
    void initialCommentSettingTest () {
        Random random = new Random();

        for (long i = 0; i < 3; i++) {
            JpaBoard board = getBoardInfo(i);

            for (long j = 0; j < 3; j++) {
                JpaAccount account = getAccountInfo(random.nextLong() % 2 + 1);
                JpaComment comment = JpaComment.builder()
                        .content("무플방지위원회에서 나왔습니다!")
                        .jpaBoard(board)
                        .jpaAccount(account)
                        .build();

                commentRepository.save(comment);
            }
        }
    }

    @Test
    void findCommentWhoWrite () {
        List<JpaComment> commentList = commentRepository.findAllCommentsByJpaAccountId(2L);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (JpaComment comment : commentList) {
            commentResponses.add(new CommentResponse(comment.getContent()));
        }

        System.out.println(commentResponses);
    }
}
