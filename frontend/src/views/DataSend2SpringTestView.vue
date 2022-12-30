<template>
    <div>
        <h2>Vue에서 Spring으로 데이터 전송 테스트</h2>
        <!-- DataSendTestForm에 있는 this.$emit에 의해 @submit="onSubmit" 이 동작함
             this.$emit('submit', ~~~)
             여기서 'submit' 이라고 되어 있는 부분이
             바로 하단에 있는 @submit에 대응하는 부분입니다. -->
        <data-send-test-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'

import DataSendTestForm from '@/components/DataSendTestForm.vue'

export default {
    name: "DataSend2SpringTestView",
    components: {
        DataSendTestForm
    },
    methods: {
        onSubmit (payload) {
            const { memberName, major } = payload

            // npm install axios --save-dev
            // axios는 vue에서 Spring으로 데이터를 전송하기 위한 라이브러리
            // Spring으로 전송하므로 Spring 쪽 PostMapping 작업이 필요함.
            axios.post('http://localhost:7777/vue/first/receive-test', { memberName, major })
                .then(() => {
                    alert('데이터 전송 완료!')
                })
                .catch(() => {
                    alert('문제 발생!')
                })
            
        }
    }
}

</script>