package com.example.boilerplateproj.domain.jsp_test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class JspTestController {

    @GetMapping("/test")
    public String jsp_test () {
        // log.debug는 디버깅 시점에만 출력됨
        log.info("Spring Boot with JSP!");

        return "jsp_test";
    }
}
