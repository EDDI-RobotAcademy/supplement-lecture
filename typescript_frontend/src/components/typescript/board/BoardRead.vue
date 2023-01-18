<template>
    <div>
        <table>
        <tr>
            <td>게시물 번호</td>
            <td>
            <input type="text" :value="board.boardNo" readonly>
            </td>
        </tr>
        <tr>
            <td>제목</td>
            <td>
            <input type="text" :value="board.title" readonly>
            </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>
            <input type="text" :value="board.writer" readonly>
            </td>
        </tr>
        <tr>
            <td>등록일자</td>
            <td>
            <input type="text" :value="board.regDate" readonly>
            </td>
        </tr>
        <tr>
            <td>본문</td>
            <td>
            <textarea cols="50" rows="20" :value="board.content" readonly>
            </textarea>
            </td>
        </tr>
        </table>
    </div>
</template>

<script lang="ts">

import { Component, Prop, Vue } from 'vue-property-decorator';
import { Board } from '@/store/board/BoardModule'

@Component
export default class BoardRead extends Vue {
    @Prop() board!: Board
}

</script>

<style scoped>

</style>