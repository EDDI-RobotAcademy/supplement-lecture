package com.example.boilerplateproj.domain.board.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BoardRequest {

    private Long id;
    private String title;
    private String content;
}
