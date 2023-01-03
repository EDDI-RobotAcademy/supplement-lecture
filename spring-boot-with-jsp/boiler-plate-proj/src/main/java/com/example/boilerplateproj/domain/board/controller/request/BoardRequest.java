package com.example.boilerplateproj.domain.board.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class BoardRequest {

    private String title;
    private String content;
}
