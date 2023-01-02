<template>
    <td @click="onClickTd">
        {{ cellData }}
    </td>
</template>

<script>

export default {
    name: "TdComponent",
    data () {
        return {
            propsTurnShape: this.currentTurnShape,
            propsWinner: '',
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
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.propsTurnShape)
        }
    }
}

</script>