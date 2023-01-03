package com.example.boilerplateproj.domain.testBoard.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TestBoardRequest {

    private String title;
    private String content;
    private String writer;
    private Long recommendNumber;
}
