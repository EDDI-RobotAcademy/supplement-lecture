package com.example.boilerplateproj.board;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.repository.BoardRepository;
import com.example.boilerplateproj.domain.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService service;

    @Autowired
    private BoardRepository repository;

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
        BoardRequest boardRequest = new BoardRequest(TARGET_BOARD_NUMBER, "제목을 바꿔", "내용도 바꿔");
        service.modify(boardRequest, (int) TARGET_BOARD_NUMBER);
    }

    @Test
    public void insert10() throws Exception {
        for(int i = 0; i < 10; i++) {
            Board board = new Board("제목" + i, "test", "tester");
            service.register(board);
        }
    }

    @Test
    public void findByContent () {
        repository.findBoardByContent("test")
                .forEach(board -> System.out.println(board));
    }

    @Test
    public void findByWriter () {
        // select ... select ... select ... select ... select ...
        // select ... ...........................................
        // select ...............................................
        // select ...............................................
        repository.findBoardByWriter("tester")
                .forEach(board -> System.out.println(board));
    }

    @Test
    public void testIdOrderByPaging() {
        Pageable pageable = PageRequest.of(2, 5);
        Collection<Board> boards = repository.findByIdGreaterThanOrderByIdDesc(0L, pageable);
        boards.forEach(board -> System.out.println(board));
    }

    @Test
    public void testIdOrderByPaging2() {
        Pageable pageable = PageRequest.of(0, 5);
        Collection<Board> boards = repository.findByIdLessThanOrderByIdDesc(6L, pageable);
        boards.forEach(board -> System.out.println(board));
    }

    @Test
    public void testPagingSort() {
        Pageable pageable = PageRequest.of(1, 5, Sort.Direction.DESC, "id");
        Page<Board> result = repository.findByIdGreaterThan(0L, pageable);

        System.out.println("PAGE SIZE: " + result.getSize());
        System.out.println("TOTAL PAGE: " + result.getTotalPages());
        System.out.println("TOTAL COUNT: " + result.getTotalElements());
        System.out.println("NEXT: " + result.nextPageable());

        List<Board> boardsList = result.getContent();
        boardsList.forEach(board -> System.out.println(board));
    }

    /*
    @DisplayName("간단한 페이징을 적용해본다.")
    @Test
    void usePagination() {
        EntityManager entityManager = testEntityManager.getEntityManager();

        List<Board> posts = entityManager.createQuery("select b from Board b", Board.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();
    }
     */

    @Test
    void testPaging () {
        List<Board> boardList = repository.findWithPagination(Pageable.ofSize(5));
        System.out.println(boardList);
    }
}
