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

            let win = this.checkWinner()
            console.log('win = ' + win)

            if (win) {
                this.game.propsWinner = this.currentTurnShape

                this.$emit('updateWinner', this.game.propsWinner)
            }

            this.game.propsTurnShape = this.currentTurnShape === 'O' ? 'X' : 'O'
            // 상위 컴포넌트로 정보를 전달 할 수 있음
            this.$emit('updateTurnShape', this.game.propsTurnShape)
        },
        checkWinner () {
            console.log('승자 판정을 시작합니다!')

            if (
                this.tableData[this.rowIndex][0] === this.currentTurnShape &&
                this.tableData[this.rowIndex][1] === this.currentTurnShape &&
                this.tableData[this.rowIndex][2] === this.currentTurnShape &&
                this.tableData[this.rowIndex][3] === this.currentTurnShape &&
                this.tableData[this.rowIndex][4] === this.currentTurnShape
            ) {
                return true
            } else if (
                this.tableData[0][this.cellIndex] === this.currentTurnShape &&
                this.tableData[1][this.cellIndex] === this.currentTurnShape &&
                this.tableData[2][this.cellIndex] === this.currentTurnShape &&
                this.tableData[3][this.cellIndex] === this.currentTurnShape &&
                this.tableData[4][this.cellIndex] === this.currentTurnShape
            ) {
                return true
            } else if (
                this.tableData[0][0] === this.currentTurnShape &&
                this.tableData[1][1] === this.currentTurnShape &&
                this.tableData[2][2] === this.currentTurnShape &&
                this.tableData[3][3] === this.currentTurnShape &&
                this.tableData[4][4] === this.currentTurnShape
            ) {
                return true
            } else if (
                this.tableData[0][4] === this.currentTurnShape &&
                this.tableData[1][3] === this.currentTurnShape &&
                this.tableData[2][2] === this.currentTurnShape &&
                this.tableData[3][1] === this.currentTurnShape &&
                this.tableData[4][0] === this.currentTurnShape
            ) {
                return true
            }
        }
    }
}

</script>

<style>



</style>