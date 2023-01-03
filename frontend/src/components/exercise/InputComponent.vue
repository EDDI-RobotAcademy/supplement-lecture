<template>
    <div>
        <p>{{ this.textData }}</p>
        <!-- 입력창에 기입한 내용이 $event.target.value로 들어가고
             그 정보는 text에 배치됨 -->
        <input type="text" @input="text=$event.target.value"/>
        <button @click="checkInputValue">확인</button>
    </div>
</template>

<script>
export default {
    name: "TableComponent",
    data () {
        return {
            text: ''
        }
    },
    props: {
        textData: String,
    },
    methods: {
        checkInputValue () {
            this.$emit('checkValue', this.text);
        }
    }
}

</script>