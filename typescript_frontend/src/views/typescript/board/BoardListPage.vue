<template>
    <v-container fluid>
        <h2>Vue + TypeScript + Spring + JPA Boards</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        <board-list :boards="moduleStore.boards"/>
    </v-container>
</template>

<script lang="ts">

import { Component, Vue } from "vue-property-decorator";
import { State } from 'vuex-class'
import BoardList from "@/components/typescript/board/BoardList.vue";
import { Board } from '@/store/board/BoardModule'

@Component({
    components: {
        BoardList
    }
})

export default class BoardListPage extends Vue {
    @State readonly boards!: Board[]
    //@Action readonly requestBoardListToSpring: any

    get moduleStore () {
        return this.$store.state.BoardModule
    }

    created () {
        this.$store.dispatch('BoardModule/requestBoardListToSpring')
    }
}
</script>

<style scoped>

</style>