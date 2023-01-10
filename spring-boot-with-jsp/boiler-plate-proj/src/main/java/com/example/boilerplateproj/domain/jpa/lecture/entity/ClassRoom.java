package com.example.boilerplateproj.domain.jpa.lecture.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroom_seq_gen")
    @SequenceGenerator(sequenceName = "classroom_seq", name = "classroom_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long classRoomId;

    private String roomName;

    public ClassRoom (String roomName) {
        this.roomName = roomName;
    }
}
