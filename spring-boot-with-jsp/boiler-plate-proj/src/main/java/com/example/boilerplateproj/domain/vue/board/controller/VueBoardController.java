package com.example.boilerplateproj.domain.vue.board.controller;

import com.example.boilerplateproj.domain.vue.board.controller.request.VueBoardRequest;
import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;
import com.example.boilerplateproj.domain.vue.board.service.VueBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("39th/jpa/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private VueBoardService service;

    @GetMapping("/list")
    public List<VueBoard> boardList () {
        log.info("boardList()");

        return service.list();
    }

    @PostMapping("/register")
    public void boardRegister (@RequestBody VueBoardRequest boardRequest) {
        log.info("boardRegister()");

        service.register(boardRequest);
    }

    @GetMapping("/{boardNo}")
    public VueBoard boardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");

        return service.read(boardNo);
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public VueBoard boardModify (@PathVariable("boardNo") Long boardNo, @RequestBody VueBoard board) {
        log.info("boardModify()");

        board.setBoardNo(boardNo);
        service.modify(board);

        return board;
    }
}
