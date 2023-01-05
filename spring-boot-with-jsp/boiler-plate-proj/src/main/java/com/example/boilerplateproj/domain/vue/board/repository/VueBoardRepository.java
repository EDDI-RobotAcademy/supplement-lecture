package com.example.boilerplateproj.domain.vue.board.repository;

import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueBoardRepository extends JpaRepository<VueBoard, Long> {
}
