package com.example.boilerplateproj.domain.vue.board.service;

import com.example.boilerplateproj.domain.vue.board.controller.request.VueBoardRequest;
import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;
import com.example.boilerplateproj.domain.vue.board.repository.VueBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VueBoardServiceImpl implements VueBoardService {

    @Autowired
    VueBoardRepository repository;

    @Override
    public void register(VueBoardRequest boardRequest) {
        VueBoard board = new VueBoard();
        board.setTitle(boardRequest.getTitle());
        board.setContent(boardRequest.getContent());
        board.setWriter(boardRequest.getWriter());

        repository.save(board);
    }

    @Override
    public List<VueBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public VueBoard read(Long boardNo) {
        Optional<VueBoard> maybeBoard = repository.findById(boardNo);

        if (maybeBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }

        return maybeBoard.get();
    }

    @Override
    public VueBoard modify(Long boardNo, VueBoardRequest boardRequest) {
        VueBoard board = read(boardNo);

        board.setTitle(boardRequest.getTitle());
        board.setContent(boardRequest.getContent());

        repository.save(board);

        return board;
    }

    @Override
    public void remove(Long boardNo) {
        repository.deleteById(boardNo);
    }
}
