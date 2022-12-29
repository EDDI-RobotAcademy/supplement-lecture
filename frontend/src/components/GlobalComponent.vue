<template>
    <!-- @click 은 v-on:click과 동의어(취향것 선택) -->
    <button @click="addCounter">{{ counterValue }}</button>
</template>

<script>

export default {
    name: "global-component",
    // vue에서 파라메터(인자)를 처리하는 방식임 - props
    props: ['initialTest'],
    data () {
        return {
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