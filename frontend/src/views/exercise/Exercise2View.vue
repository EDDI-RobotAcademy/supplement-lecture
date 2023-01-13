<template>
    <v-container>
        <v-data-table
            :headers="headerTitle"
            :items="boards"
            :items-per-page="10"
            @click:row="readRow"
            class="elevation-1"/>
    </v-container>
</template>

<script>

import router from "@/router";
import { mapState, mapActions } from "vuex";

export default {
    name: "TableView",
    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px" },
                { text: '제목', value: 'title', width: "300px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '등록일자', value: 'regDate', width: "100px" },
            ],
        }
    },
    computed: {
        ...mapState([
            'boards'
        ]),
    },
    mounted() {
        this.requestBoardListFromSpring()
    },
    methods: {
        ...mapActions([
            'requestBoardListFromSpring'
        ]),
        readRow (value) {
            alert('클릭하셨습니다!: ' + JSON.stringify(value))
            router.push({
                name: "JpaBoardReadView",
                params: { boardNo: value.boardNo.toString() }
            })
        }
    }
}

</script>
