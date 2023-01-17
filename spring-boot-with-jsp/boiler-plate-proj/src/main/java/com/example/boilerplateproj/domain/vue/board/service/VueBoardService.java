package com.example.boilerplateproj.domain.vue.board.service;

import com.example.boilerplateproj.domain.vue.board.controller.request.VueBoardRequest;
import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;

import java.util.List;

public interface VueBoardService {
    public void register(VueBoardRequest boardRequest);
    public List<VueBoard> list();
    public VueBoard read(Long boardNo);
    public VueBoard modify(Long boardNo, VueBoardRequest boardRequest);
    public void remove(Long boardNo);
}
