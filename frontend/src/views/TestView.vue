<template>
    <div>
        <p>Hello {{ message }}</p>
        <h2>{{ message.length }}</h2>
        <h3>{{ list[2] }}</h3>
        <h4>{{ list[number] }}</h4>
        <p>{{ buttonClickCount }} 번 클릭했습니다.</p>
        <button v-on:click="buttonClickIncrementHandler">카운트하기</button><br/>

        <!-- GlobalComponent.vue -->
        <!-- 부가적으로 현재 케이스에서 global-component 라는 이름 보다는
             가독성 향상을 위해 global-common-counter 라는 형태의 이름으로 만들면 더 좋을 것입니다
             만약 이렇게 만든다면 GlobalComponent.vue가 아니라
             GlobalCommonCounter.vue 라는 형태로 만들면 됩니다. 
             그렇다면 다른 영역의 작업을 하고 있다가
             다시 해당 작업으로 돌아와서 보는 상황에서도
             '아 이게 전역으로 공통화된 카운터 컴포넌트구나'라는 것을 바로 파악할 수 있을 것입니다
             현재는 구성이 단순하지만 작업을 할 수록 복잡해지기 때문에
             이러한 네이밍도 잘 만들어 두는 것이 중요합니다 -->

        <!-- 축약을 하지 않는다면 v-bind:initial-test="counter" 와 같이 작성하며
             현재 작성된 모습은 v-bind를 생략한 :initial-test="counter"에 해당합니다
             :initial-test는 실제 global-component가 가지고 있는 정보이며
             이 정보로 전달되는 내용이 현재 컴포넌트의 counter임을 의미합니다.
             사실상 Vue의 시작이자 끝인 부분 - 컴포넌트(Component) -->
        <global-component :initial-test="counter"/><br/>
        <!-- Local Component는 위에 보이는 것과 같이
             사용 방식은 Global Component와 동일함 -->
        <local-component :initial-value="num"/><br/>
        <button @click="plus">클릭해봐!</button>
    </div>
</template>

<script>

import Vue from 'vue'
import GlobalComponent from '@/components/GlobalComponent.vue'
import LocalComponent from '@/components/LocalComponent.vue'

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
    name: "TestView",
    // 아래 컴포넌트에 등록한 내역은 TestView라는 Vue 컴포넌트에서만 활용이 가능하다.
    // 결론적으로 Global Component로 만든 내용은 다른 A, B, C, D에서도 활용이 가능하고
    // Local Component는 현재의 TestView에서만 사용 가능한 형태이기 때문에
    // A, B, C 상황에는 대응하지 못한다.

    // 둘 중 무엇이 더 좋은가 ?
    // 글로벌   13
    // 로컬     2

    // 정답: 정답이 없다
    // 재활용성: 로컬이 좋은 방식
    // 고정적인 작업(해당 서비스 차원에서 불변): 글로벌

    // 의식의 흐름: 음 ? 재활용성을 생각하면 전역으로 있는것이 더 좋을것 같은데 왜 로컬이지 ?
    //             현실적인 측면에서 생각을 해보면 좀 더 와닿는 부분이 존재하는데
    //             A 그룹 사람들과의 관계, B 그룹 사람들과의 관계 등등에 해당합니다.
    //             만약 우리가 A 그룹의 사람들과 굉장히 많이 엮여 있다면
    //             여기서 특정한 무엇을 분리하는 작업이 쉬울까요 ? 어려울까요 ? '매우 어렵습니다'
    //             반면 B 그룹의 사람들과는 굉장히 엮여 있는 것이 별로 없습니다.(느슨하게 엮여있음)
    //             이 경우 해당 그룹과의 분리는 쉬울까요 ? 어려울까요 ? 'A 그룹에 비해 쉬움'
    
    //             프로그래밍도 동일합니다.
    //             의존성을 분리하여 재활용성을 높이다는 것이
    //             결국엔 이와 같이 만들어놓은
    //             매서드, 클래스, 컴포넌트 간의 결합을 낮추는 것을 의미합니다.

    // 위와 같은 구성이 되어야 우리가 만든 java 및 kotlin 클래스,
    // 혹은 vue, react 등등과 같은 UI 컴포넌트들을 필요에 따라 적절하게 분리할 수 있을 것입니다.
    // ...... - [A] - [B] - [C] - [D] - ......
    // 만약 B를 별개로 빼내려고 하면 A에 붙어 있는 정보들과
    // C에 붙어 있는 정보들이 모두 다 같이 딸려서 넘어오게 됩니다.
    // 결국 B만 별개로 분리해서 바라 볼 수 없다는 뜻이 되고
    // 이것은 B가 심각한 의존성 덩어리를 가지고 있다고 볼 수 있는 부분이 됩니다.
    // 그래서 B 주변에 interface를 붙여서 A와 C의 결합을 느슨하게 만드는 것입니다.
    // 지금 이런 부분을 좀 더 정리를 더 해보고 싶다면
    // 로버트 마틴의 Clean Architecture 책을 추천합니다.

    // https://book.interpark.com/product/BookDisplay.do?_method=detail&sc.prdNo=314531122&gclid=CjwKCAiAkrWdBhBkEiwAZ9cdcCNa9P_GNeOeKvQa4J2R7RvZA4EGvtQzvdhPFh_jaAZ1ZpOwnzyqRhoCgTcQAvD_BwE

    // vue에서도 이와 같은 개념이 동일하게 적용이 됩니다.
    // * 화면 내부에는 여러가지 버튼이 존재
    //   버튼의 기능들은 상황에 따라서 제각각 달라짐
    //   이런 경우 버튼 컴포넌트에 대한 재활용성을 어떻게 높여야 할까 ?
    //   버튼 껍데기 [ 눌럿을때: 반응할것, 텍스트 영역: 글자 ] <<<--- 이런 형태가 된다면 ?

    //   예로 결제 시스템을 처리하는 버튼이라면
    //   <custom-button :actionHandler="submitPayment" :buttonText="결제"/>

    //   회원 가입하는 버튼이라면
    //   <custom-button :actionHandler="submitMemberRegister" :buttonText="가입"/>

    //   현재 actionHandler에 전달하는 것이 (결제, 회원가입 등등 필요에 따라 바꿔 쓰고 있음)

    //   만약 게시판을 만드는 상황이다.
    //   진짜 말 그대로 커뮤니티형 게시판
    //   상품 형태의 이미지 갤러리형 게시판 등등의 상황에서도
    //   위와 같은 형태로 재활용성을 높일 수 있다는 것이 핵심입니다.

    // 또한 여기에는 한 가지 차이점이 더 존재합니다.
    // 어쨋든 컴퓨터의 모든 정보들은 메모리라는 HW 장치에 올라가야 합니다.
    // 이뜻은 메모리 상에 Load(로드) 할 정보가
    // 많아지면 많아질수록 사용자 응답성이 떨어짐을 의미합니다.
    // 전역 컴포넌트는 모든 컴포넌트에 해당 정보를 때려박아놓기 때문에 메모리 사용량이 매우매우 높아집니다.
    // 반면 로컬은 필요한 경우에만 사용하기 때문에 상대적으로 메모리 사용량이 적습니다.
    // Java에서도 지역 변수와 전역 변수와 같은 개념과 동일하다 봐도 무방합니다.
    // Thread를 다룰 때 일부 전역 변수를 허용하였고
    // 또 이 전역 변수 때문에 발생하는 Critical Section 문제를 해결하기 위해
    // Syncrhonization 이나 Mutex, Semaphore 같은 기법들을 사용 했을 것입니다.

    components: {
        'local-component': LocalComponent
    },
    data () {
        return {
            message: "이렇게 html과 javascript가 변수화되어 연결이 가능하다.",
            list: ['apple', 'banana', 'grape', 'strawberry'],
            number: 1,
            buttonClickCount: 0,
            counter: 0,
            num: 0,
        }
    },
    methods: {
        buttonClickIncrementHandler: function () {
            this.buttonClickCount += 1
        },
        plus () {
            this.num++
        }
    }
}

</script>