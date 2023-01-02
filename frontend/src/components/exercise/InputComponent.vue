<template>
    <div>
        <p>{{ this.textData }}</p>
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