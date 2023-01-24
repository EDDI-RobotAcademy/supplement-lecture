package com.example.boilerplateproj.domain.member.service.request;

import com.example.boilerplateproj.domain.member.entity.Member;
import com.example.boilerplateproj.domain.member.entity.MemberProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberRegisterRequest {

    private final String email;
    private final String password;

    private final String city;
    private final String street;
    private final String addressDetail;
    private final String zipcode;

    public Member toMember () {
        return new Member(
                email,
                MemberProfile.of(city, street, addressDetail, zipcode)
        );
    }
}
