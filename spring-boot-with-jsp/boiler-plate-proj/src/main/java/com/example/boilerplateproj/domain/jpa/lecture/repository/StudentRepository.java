package com.example.boilerplateproj.domain.jpa.lecture.repository;

import com.example.boilerplateproj.domain.jpa.lecture.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s join s.classRoom cr where cr.roomName = :roomName")
    Optional<Student> findStudentByRoomName (String roomName);

    @Query("select s from Student s join s.classRoom cr where cr.roomName = :roomName")
    List<Student> findStudentListByRoomName (String roomName);
}
