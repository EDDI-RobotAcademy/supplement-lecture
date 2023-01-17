<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
        <tr>
            <th align="center" width="10%">No</th>
            <th align="center" width="55%">제목</th>
            <th align="center" width="15%">작성자</th>
            <th align="center" width="20%">등록일자</th>
        </tr>
        <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
            <td colspan="4">
            현재 등록된 게시물이 없습니다!
            </td>
        </tr>
        <tr v-else v-for="board in boards" :key="board.boardNo">
            <td align="center">
            {{ board.boardNo }}
            </td>
            <td align="left">
            <router-link :to="{ name: 'JpaBoardReadView',
                                params: { boardNo: board.boardNo.toString() }}">
                {{ board.title }}
            </router-link>
            </td>
            <td align="right">
            {{ board.writer }}
            </td>
            <td align="center">
            {{ board.regDate }}
            </td>
        </tr>
        </table>
    </div>
</template>

<script lang="ts">

import { Component, Prop, Vue } from 'vue-property-decorator';
import { Board } from '@/store'

@Component
export default class BoardList extends Vue {
    @Prop() private boards!: Board[]
}

</script>

<style scoped>

</style>