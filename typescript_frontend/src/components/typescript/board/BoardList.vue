<template>
    <v-container>
        <h3>게시물 목록</h3>
        <v-data-table
            :headers="headerTitle"
            :items="boards"
            :items-per-page="10"
            @click:row="readRow"
            class="elevation-1"/>
    </v-container>
</template>

<script lang="ts">

import { Component, Prop, Vue } from 'vue-property-decorator';
import { Board } from '@/store'
import router from "@/router";

@Component
export default class BoardList extends Vue {
    @Prop() private boards!: Board[]

    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px" },
                { text: '제목', value: 'title', width: "300px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '등록일자', value: 'regDate', width: "100px" },
            ],
        }
    }

    readRow (value: Board) {
        alert('클릭하셨습니다!: ' + JSON.stringify(value))
        router.push({
            name: "JpaBoardReadView",
            params: { boardNo: value.boardNo.toString() }
        })
    }
}

</script>

<style scoped>

</style>