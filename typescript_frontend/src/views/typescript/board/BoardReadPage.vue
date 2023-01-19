<template>
    <div align="center">
        <h2>Vue + TypeScript + Spring + JPA 게시판 읽기</h2>
        <board-read v-if="moduleStore.board" :board="moduleStore.board"/>
        <p v-else>Loading .......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            돌아가기
        </router-link>
    </div>
</template>

<script lang="ts">

import BoardRead from "@/components/typescript/board/BoardRead.vue";
import { Vue, Prop, Component } from 'vue-property-decorator'
import { State, Action } from 'vuex-class'
import { Board } from '@/store/board/BoardModule'

@Component ({
    components: {
        BoardRead
    }
})

export default class BoardReadPage extends Vue {

    @Prop() boardNo!: number
    @State readonly board!: Board
    @Action readonly requestBoardToSpring: any
    @Action readonly requestDeleteBoardToSpring: any

    get moduleStore () {
        return this.$store.state.BoardModule
    }

    async onDelete () {
        //await this.requestDeleteBoardToSpring(this.boardNo);
        await this.$store.dispatch('BoardModule/requestDeleteBoardToSpring', [this.boardNo])
        await this.$router.push({ name: 'BoardListPage' })
    }

    created() {
        //this.requestBoardToSpring(this.boardNo)
        this.$store.dispatch('BoardModule/requestBoardToSpring', [this.boardNo])
    }
}
</script>

<style scoped>

</style>