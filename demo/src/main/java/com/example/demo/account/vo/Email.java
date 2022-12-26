package com.example.demo.account.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Email {
    private final String email;

    public Boolean checkEmailValidation () {
        System.out.printf("지금은 예제니까 이메일(%s) 검증은 요래합니다 - 잘 되었다 가정", email);

        return true;
    }
}
