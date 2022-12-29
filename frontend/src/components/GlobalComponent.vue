<template>
    <!-- @click 은 v-on:click과 동의어(취향것 선택) -->
    <button @click="addCounter">{{ counterValue }}</button>
</template>

<script>

export default {
    name: "global-component",
    // vue에서 파라메터(인자)를 처리하는 방식임 - props
    // TestView.vue에 있었던 initial-test에 해당하는 녀석입니다.
    // 앞서 설명했던 네이밍 규칙 '-'가 오면
    // '-'를 지우면서 대문자로 변환하는 규칙이 적용되어 있는 것입니다.
    props: ['initialTest'],
    data () {
        return {
            // 즉 TestView.vue에 있는 counter 값이
            // 현재 GlobalComponent의 counterValue로 설정되어 있는 상태
            counterValue: this.initialTest
        }
    },
    methods: {
        addCounter () {
            this.counterValue += 1
        }
    }
}

</script>