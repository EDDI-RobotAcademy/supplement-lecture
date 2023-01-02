<template>
    <td @click="onClickTd" style="width: 30px; height: 30px;">
        {{ cellData }}
    </td>
</template>

<script>

export default {
    name: "TdComponent",
    data () {
        return {
            game: {
                propsTurnShape: this.currentTurnShape,
                propsWinner: '',
            }
        }
    },
    props: {
        cellData: String,
        cellIndex: Number,
        rowIndex: Number,
        tableData: Array,
        currentTurnShape: String,
    },
    methods: {
        onClickTd () {
            console.log('게임판을 클릭했습니다!')
            //this.$set(this.tableData[this.rowIndex], this.cellIndex, this.game.propsTurnShape)
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.currentTurnShape)

            this.game.propsTurnShape = this.currentTurnShape === 'O' ? 'X' : 'O'
            // 상위 컴포넌트로 정보를 전달 할 수 있음
            this.$emit('updateTurnShape', this.game.propsTurnShape)
        }
    }
}

</script>

<style>



</style>