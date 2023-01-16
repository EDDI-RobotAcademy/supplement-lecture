package com.example.boilerplateproj.domain.lombok_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
// Getter / Setter는 말 그대로 게터 / 세터
// RequiredArgsConstructor는 Immutable Object(불변 객체)를 최최로 초기화하기 위한 목적으로 사용
// ToString은 실제로 객체 출력을 위해 사용하는 녀석
// EqualsAndHashCode 및 Value 파트는 당장 신경쓰지 않아도 무방
@AllArgsConstructor
// 내부의 모든 인자를 설정하는 경우의 생성자 지원
public class LombokTest {

    private String name;
    private Long age;
}
