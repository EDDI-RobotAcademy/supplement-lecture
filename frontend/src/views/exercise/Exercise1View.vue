<template>
    <div>
        <input-component
            :text-data="textData"
            @checkValue="checkValue"/>
    </div>
</template>

<script>

import InputComponent from '@/components/exercise/InputComponent.vue'

export default {
    name: "SimpleBoardGameView",
    components: {
        InputComponent
    },
    data () {
        return {
            textData: '숫자를 입력하세요'
        }
    },
    methods: {
        checkValue (passingValue) {
            if (parseInt(passingValue) % 2 === 0) {
                alert("짝수입니다!")
            } else {
                alert("홀수입니다!")
            }
        }
    }
}

</script>