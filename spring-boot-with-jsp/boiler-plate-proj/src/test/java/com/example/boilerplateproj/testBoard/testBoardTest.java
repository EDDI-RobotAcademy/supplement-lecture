package com.example.boilerplateproj.testBoard;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.testBoard.controller.request.TestBoardRequest;
import com.example.boilerplateproj.domain.testBoard.entity.TestBoard;
import com.example.boilerplateproj.domain.testBoard.service.TestBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class testBoardTest {

    @Autowired
    private TestBoardService service;

    private final long TARGET_BOARD_NUMBER = 6;

    @Test
    public void testBoardWrite () throws Exception {
        TestBoardRequest testBoardRequest = new TestBoardRequest(
                "테스트 제목1", "테스트 내용1", "테스터1", 0L
        );

        service.register(testBoardRequest);
    }

    @Test
    public void findAllTest () throws Exception {
        List<TestBoard> boardLists = service.list();
        System.out.println(boardLists);
    }

    @Test
    public void findByEntityMemberField () throws Exception {
        System.out.println(service.read((int) TARGET_BOARD_NUMBER));
    }

    @Test
    public void modifyTest () throws Exception {
        TestBoardRequest boardRequest = new TestBoardRequest(
                "제목을 바꿔", "내용도 바꿔",
                "작성자도일단 바꾸자", 3L);
        service.modify(boardRequest, (int) TARGET_BOARD_NUMBER);
    }

    @Test
    public void deleteByEntityMemberField () throws Exception {
        service.remove((int) TARGET_BOARD_NUMBER);
    }
}
