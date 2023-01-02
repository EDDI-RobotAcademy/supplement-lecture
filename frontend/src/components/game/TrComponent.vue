<template>
    <tr>
        <td-component
            v-for="(cellData, index) in rowData" :key="index"
            :cell-data="cellData"
            :cell-index="index"
            :row-index="rowIndex"
            :table-data="tableData"
            :current-turn-shape="currentTurnShape"/>
    </tr>
</template>

<script>

import TdComponent from './TdComponent.vue';

export default {
    name: "TrComponent",
    components: {
        TdComponent
    },
    props: {
        rowData: Array,
        rowIndex: Number,
        tableData: Array,
        currentTurnShape: String,
    }
}

</script>