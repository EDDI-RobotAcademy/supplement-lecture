<template>
    <div>
        <form @submit.prevent="onSubmit">
        <table>
            <tr>
            <td>게시물 번호</td>
            <td>
                <input type="text" :value="board.boardNo" disabled>
            </td>
            </tr>
            <tr>
            <td>제목</td>
            <td>
                <input type="text" v-model="title">
            </td>
            </tr>
            <tr>
            <td>작성자</td>
            <td>
                <input type="text" :value="board.writer" disabled>
            </td>
            </tr>
            <tr>
            <td>등록일자</td>
            <td>
                <input type="text" :value="board.regDate" disabled>
            </td>
            </tr>
            <tr>
            <td>본문</td>
            <td>
                <textarea cols="50" rows="20" v-model="content">
                </textarea>
            </td>
            </tr>
        </table>

        <div>
            <button type="submit">수정 완료</button>
            <router-link :to="{ name: 'BoardReadPage',
                                params: { boardNo: board.boardNo.toString() } }">
                취소
            </router-link>
        </div>

        </form>
    </div>
</template>

<script lang="ts">

import { Component, Prop, Emit, Vue } from 'vue-property-decorator'
import { Board } from '@/store/board/BoardModule'

@Component
export default class BoardModifyForm extends Vue {

    @Prop() board!: Board
    
    title: string = ''
    content: string = ''
    boardNo!: number
    writer!: string
    regDate!: string

    created () {
        this.title = this.board.title
        this.content = this.board.content
        this.boardNo = this.board.boardNo
        this.writer = this.board.writer
        this.regDate = this.board.regDate
    }

    @Emit('submit')
    onSubmit () {
        const { boardNo, title, content, writer, regDate } = this
        return { boardNo, title, content, writer, regDate }
    }
}
</script>

<style scoped>

</style>