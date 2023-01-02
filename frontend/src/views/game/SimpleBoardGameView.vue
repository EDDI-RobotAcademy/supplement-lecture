<template>
    <div>
        <!-- 현재 누구의 차례인지 표기 -->
        <table-component
            :table-data="tableData"
            :current-turn-shape="currentTurnShape"
            @updateTurnShape="updateTurnShape"/>
        <!-- 누가 이겼는지 출력 -->
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
        }
    }
}

</script>