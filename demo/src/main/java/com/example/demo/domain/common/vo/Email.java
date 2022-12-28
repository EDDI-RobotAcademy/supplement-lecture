package com.example.demo.domain.common.vo;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Email {
    private final String email;

    public Boolean checkEmailValidation () {
        // 실제라면 맨앞에 숫자 오면 안되고 글자 이후 '@' 가 존재하는지 확인
        // 또한 그 뒤에도 naver.com, gmail.com 형태의 글자가 배치되는지 검사하여
        // 올바른 email 주소인지 검사하는 유효성 검사를 진행한다.
        // 보편적으로 String Matching 과 관련하여 정규표현식을 사용하는 편이다.
        System.out.printf("지금은 예제니까 이메일(%s) 검증은 요래합니다 - 잘 되었다 가정\n", email);

        return false;
    }
}
