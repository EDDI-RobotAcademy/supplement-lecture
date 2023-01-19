<template>
    <div align="center">
        <h2>Vue + Spring 게시물 수정</h2>
        <board-modify-form v-if="moduleStore.board" :board="moduleStore.board" @submit="onSubmit"/>
        <p v-else>Loading .........</p>
    </div>
</template>

<script lang="ts">

import BoardModifyForm from "@/components/typescript/board/BoardModifyForm.vue";
import { Board } from "@/store/board/BoardModule";
import { Component, Vue, Prop } from "vue-property-decorator";
import { State, Action } from "vuex-class";

@Component ({
    components: {
        BoardModifyForm
    }
})

export default class BoardModifyPage extends Vue {
    
    @Prop() boardNo!: number
    @State readonly board!: Board
    @Action readonly requestBoardToSpring: any
    @Action readonly requestBoardModifyToSpring: any

    get moduleStore () {
        return this.$store.state.BoardModule
    }
    
    async onSubmit (payload: Board) {
        const { title, content, writer, regDate } = payload
        const boardNo = this.boardNo

        //await this.requestBoardModifyToSpring({ boardNo, title, content, writer, regDate })
        await this.$store.dispatch('BoardModule/requestBoardModifyToSpring', {boardNo, title, content, writer, regDate})
        await this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: this.boardNo.toString() }
        })
    }
    created () {
        this.requestBoardToSpring(this.boardNo)
    }
}
</script>

<style scoped>

</style>