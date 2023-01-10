package com.example.boilerplateproj.student;

import com.example.boilerplateproj.domain.jpa.lecture.entity.ClassRoom;
import com.example.boilerplateproj.domain.jpa.lecture.entity.Student;
import com.example.boilerplateproj.domain.jpa.lecture.repository.ClassRoomRepository;
import com.example.boilerplateproj.domain.jpa.lecture.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Test
    void saveStudent () {
        //ClassRoom classRoom = new ClassRoom("기본반");
        ClassRoom classRoom = new ClassRoom("응용반");
        classRoomRepository.save(classRoom);

        //Student student = new Student("크리스티나");
        //Student student = new Student("제시카");
        Student student = new Student("마이클");

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }

    @Test
    void findStudent () {
        Optional<Student> maybeStudent = studentRepository.findById(1L);

        if (maybeStudent.isEmpty()) {
            System.out.println("찾는 학생이 없습니다!");
            return;
        }

        Student student = maybeStudent.get();
        System.out.println(student);
    }

    @Test
    void finaAllStudents () {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
    
    @Test
    void findStudentWithRoomName () {
        List<Student> students = studentRepository.findStudentListByRoomName("응용반");
        System.out.println(students);
    }

    @Test
    void modifyStudent () {
        Optional<Student> maybeStudent = studentRepository.findStudentByRoomName("기본반");

        if (maybeStudent.isEmpty()) {
            System.out.println("찾는 학생이 없습니다!");
            return;
        }

        Student student = maybeStudent.get();
        ClassRoom newClassRoom = new ClassRoom("새로운 과정");

        classRoomRepository.save(newClassRoom);

        student.setClassRoom(newClassRoom);
        studentRepository.save(student);
    }
}
