package com.example.boilerplateproj.domain.jpa.lecture.repository;

import com.example.boilerplateproj.domain.jpa.lecture.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
