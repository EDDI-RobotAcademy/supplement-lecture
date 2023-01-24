package com.example.boilerplateproj.domain.member.service;

import com.example.boilerplateproj.domain.member.service.request.MemberLoginRequest;
import com.example.boilerplateproj.domain.member.service.request.MemberRegisterRequest;

public interface MemberService {
    Boolean signUp(MemberRegisterRequest request);
    Boolean emailValidation(String email);
    String signIn(MemberLoginRequest request);
}
