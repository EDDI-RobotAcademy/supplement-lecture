<template>
    <div>
        <p>Hello {{ message }}</p>
    </div>
</template>

<script>

export default {
    name: "TestView",
    data () {
        return {
            message: "이렇게 html과 javascript가 변수화되어 연결이 가능하다."
        }
    }
}

</script>