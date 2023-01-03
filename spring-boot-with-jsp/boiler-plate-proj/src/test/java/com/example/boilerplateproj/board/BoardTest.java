package com.example.boilerplateproj.board;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService service;

    @Test
    public void writeTest () throws Exception {
        // DB Query 일절 신경쓰지 않고
        // 아래 엔티티 정보를 DB에 넣겠다.
        // 그리고 알아서 Query를 생성해서 보내는 모습을 볼 수 있음
        // Hibernate: insert into test_board
        // (content, reg_date, title, writer, board_no) values (?, ?, ?, ?, ?)
        Board board = new Board("제목5", "본문5", "작성자1223");
        service.register(board);
    }

    @Test
    public void findAllTest () throws Exception {
        List<Board> boardLists = service.list();
        System.out.println(boardLists);
    }

    @Test
    public void findByEntityMemberField () throws Exception {
        final long BOARD_NUMBER = 1;
        System.out.println(service.read((int) BOARD_NUMBER));
    }

    @Test
    public void deleteByEntityMemberField () throws Exception {
        final long TARGET_BOARD_NUMBER = 3;
        service.remove((int) TARGET_BOARD_NUMBER);
    }

    @Test
    public void modifyTest () throws Exception {
        final long TARGET_BOARD_NUMBER = 4;
        BoardRequest boardRequest = new BoardRequest("제목을 바꿔", "내용도 바꿔");
        service.modify(boardRequest, (int) TARGET_BOARD_NUMBER);
    }
}
