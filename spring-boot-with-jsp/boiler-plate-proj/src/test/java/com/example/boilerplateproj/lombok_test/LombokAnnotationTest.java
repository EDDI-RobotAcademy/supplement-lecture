package com.example.boilerplateproj.lombok_test;

import com.example.boilerplateproj.domain.lombok_test.entity.LombokTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokAnnotationTest {

    @Test
    void lombok_test1 () {
        LombokTest lombokTest = new LombokTest("test", 10L);
        System.out.println(lombokTest);

        lombokTest.setAge(77L);

        System.out.println(lombokTest);

        System.out.println("name: " + lombokTest.getName());
    }
}
