package com.example.boilerplateproj.domain.jpa.lecture.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @SequenceGenerator(sequenceName = "student_seq", name = "student_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long studentId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;

    public Student (String name) {
        this.name = name;
    }

    public void setClassRoom (ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
