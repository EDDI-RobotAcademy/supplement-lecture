<template>
    <form @submit.prevent="onSubmit">
        <table>
        <tr>
            <td>제목</td>
            <td>
            <input type="text" v-model="title">
            </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>
            <input type="text" v-model="writer">
            </td>
        </tr>
        <tr>
            <td>본문</td>
            <td>
            <textarea cols="50" rows="20" v-model="content">
            </textarea>
            </td>
        </tr>
        </table>

        <div>
        <button type="submit">등록</button>
        <router-link to="{ name: 'BoardListPage' }">
            취소
        </router-link>
        </div>
    </form>
</template>

<script lang="ts">

import { Component, Emit, Vue } from 'vue-property-decorator'

@Component
export default class BoardRegisterForm extends Vue {
    
    title: string = ''
    writer: string = ''
    content: string = ''

    @Emit('submit')
    onSubmit () {
        const { title, writer, content } = this
        return { title, writer, content }
    }
}

</script>

<style scoped>

</style>