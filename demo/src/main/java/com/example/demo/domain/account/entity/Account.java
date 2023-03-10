package com.example.demo.domain.account.entity;

import com.example.demo.domain.common.vo.Email;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 엔티티 ? Entity란 무엇인가 ?
// DB상에서 관리되어야 하는 Lifecycle이 존재하는 정보들
// 이러한 객체를 전문 용어로 불변 객체 (Immutable Object)
@RequiredArgsConstructor
@ToString
public class Account {

    // 수정을 못하게 만들기 위해 final을 붙였음
    // 근데 왜 붙여야 할까 ?
    // 어떤 상황에서 단 하나의 값만 한 번 쓰고 상황을 유지하기 위함
    // 이것을 통해 얻고자 하는 바는 무엇일까 ?

    // 시나리오. 현재 SW를 고도화하는 과정에서 신입이 입사하였음.
    //         어떤 임무를 맡아서 신입이 작업을 시작하게 됨
    //         근데 Setter를 사용하고 있었다.
    //         이런 경우 유발되는 문제는 무엇일까 ? 가 위의 질문의 연장선입니다.

    // 실제로 특정 데이터 값이 들어온 상태에서 데이터가 처리되는지 여부가 중요합니다.
    // 그러나 신입은 예로 id가 3이어야 하는데 4가 들어왔기 때문에
    // setter를 써서 3으로 바꾸고 테스트를 완료합니다.
    // 어찌 되었든 임무는 완료이니 '빠이짜이찌엔!' 때립니다.
    // 시간이 한 몇 달 흘러서 나중에 'x발 ? 이거 뭐지 ?' 상황이 발생하게 됩니다.
    // 혹은 해당 코드가 업로드 되는 순간 잘 돌아가던 서비스가 다 터지기 시작합니다.
    // (결론적으로 대형 사고가 발생합니다 <<< 근데 이게 사실 신입 잘못이 아닙니다.)
    // 그런데 만약 애초에 final 키워드가 붙어 있었다면 어땟을까요 ?
    // 수정을 하고 빌드하는 순간 컴파일러가 final 값 수정한다고 노발대발합니다.
    // 그러면 위와 같은 문제가 근본적으로 차단이 되기 때문에 원천 차단 역할이 가능합니다.
    // 수십 ~ 수백명이 함께 개발하는 상황에선 반드시 필요한 방어 메커니즘이죠.

    // setter가 안좋은 이유는 무엇일까요 ?
    // 값을 수정할 여지를 남기기 때문이고 이 수정에 의해 위의 문제가 재연되게 됨
    // 역시 원천적으로 차단할 필요가 존재함.
    // 그러나 어쩔 수 없는 경우도 존재한다는 것!

    private final int id;
    private final Email email;
}
