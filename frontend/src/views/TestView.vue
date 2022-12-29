<template>
    <div>
        <p>Hello {{ message }}</p>
        <h2>{{ message.length }}</h2>
        <h3>{{ list[2] }}</h3>
        <h4>{{ list[num] }}</h4>
        <p>{{ buttonClickCount }} 번 클릭했습니다.</p>
        <button v-on:click="buttonClickIncrementHandler">카운트하기</button>

        <!-- GlobalComponent.vue -->
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