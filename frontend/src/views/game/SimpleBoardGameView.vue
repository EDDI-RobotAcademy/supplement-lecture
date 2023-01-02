<template>
    <div>
        <!-- 현재 누구의 차례인지 표기 -->
        <div>{{ currentTurnShape }} 님의 턴입니다.</div>
        <table-component
            :table-data="tableData"
            :current-turn-shape="currentTurnShape"
            @updateTurnShape="updateTurnShape"
            @updateWinner="updateWinner"
            @updateTableData="updateTableData"/>
        <!-- 누가 이겼는지 출력 -->
        <div v-if="winner">{{ winner }} 님의 승리!</div>
    </div>
</template>

<script>

import TableComponent from '@/components/game/TableComponent.vue';

export default {
    name: "SimpleBoardGameView",
    components: {
        TableComponent
    },
    data () {
        return {
            currentTurnShape: 'O',
            winner: '',
            tableData: [
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
            ]
        }
    },
    methods: {
        updateTurnShape (passingValue) {
            console.log('SimpleBoardGameView received TableComponent info: ' + passingValue)
            this.currentTurnShape = passingValue
        },
        updateWinner (passingValue) {
            console.log('TrComponent received TdComponent winner info: ' + passingValue)
            this.winner = passingValue
        },
        updateTableData () {
            this.tableData = [
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
            ]
        }
    }
}

</script>

<style>

table {
    width: 10%;
    border: 2px solid #cccccc
}

</style>