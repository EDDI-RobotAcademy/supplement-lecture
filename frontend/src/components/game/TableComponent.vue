<template>
    <table>
        <tr-component
            v-for="(rowData, index) in tableData" :key="index"
            :row-data="rowData"
            :row-index="index"
            :table-data="tableData"
            :current-turn-shape="currentTurnShape"/>
    </table>
</template>

<script>

import TrComponent from './TrComponent.vue';

export default {
    name: "TableComponent",
    data () {
        return {

        }
    },
    components: {
        TrComponent
    },
    props: {
        tableData: Array,
        currentTurnShape: String,
    }
}

</script>