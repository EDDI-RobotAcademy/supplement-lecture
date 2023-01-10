package com.example.boilerplateproj.student;

import com.example.boilerplateproj.domain.jpa.lecture.entity.ClassRoom;
import com.example.boilerplateproj.domain.jpa.lecture.entity.Student;
import com.example.boilerplateproj.domain.jpa.lecture.repository.ClassRoomRepository;
import com.example.boilerplateproj.domain.jpa.lecture.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Test
    void saveStudent () {
        ClassRoom classRoom = new ClassRoom("기본반");
        classRoomRepository.save(classRoom);

        Student student = new Student("크리스티나");

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }
}
