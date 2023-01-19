<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script lang="ts">

import { Component, Vue } from "vue-property-decorator";
import BoardRegisterForm from "@/components/typescript/board/BoardRegisterForm.vue";
import { Board } from '@/store/board/BoardModule'
import { Action } from 'vuex-class'

@Component ({
    components: {
        BoardRegisterForm
    }
})

export default class BoardRegisterPage extends Vue {
    @Action readonly requestCreateBoardContentsToSpring: any

    async onSubmit (payload: Board) {
        //await this.requestCreateBoardContentsToSpring(payload)
        await this.$store.dispatch('BoardModule/requestCreateBoardContentsToSpring', payload)
        await this.$router.push({
            name: 'BoardListPage'
        })
    }
}

</script>

<style scoped>

</style>