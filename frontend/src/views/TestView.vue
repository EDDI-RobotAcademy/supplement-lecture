<template>
    <div>
        <p>Hello {{ message }}</p>
        <h2>{{ message.length }}</h2>
        <h3>{{ list[2] }}</h3>
        <h4>{{ list[num] }}</h4>
        <p>{{ buttonClickCount }} 번 클릭했습니다.</p>
        <button v-on:click="buttonClickIncrementHandler">카운트하기</button>

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
        <global-component :initial-test="counter"/>
    </div>
</template>

<script>

import Vue from 'vue'
import GlobalComponent from '@/components/GlobalComponent.vue'

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
    name: "TestView",
    data () {
        return {
            message: "이렇게 html과 javascript가 변수화되어 연결이 가능하다.",
            list: ['apple', 'banana', 'grape', 'strawberry'],
            num: 1,
            buttonClickCount: 0,
            counter: 0,
        }
    },
    methods: {
        buttonClickIncrementHandler: function () {
            this.buttonClickCount += 1
        }
    }
}

</script>