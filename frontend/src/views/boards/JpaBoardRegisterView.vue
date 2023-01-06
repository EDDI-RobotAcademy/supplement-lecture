<template>
  <div align="center">
    <h2>게시물 작성</h2>
    <jpa-board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import JpaBoardRegisterForm from "@/components/boards/JpaBoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "JpaBoardRegisterView",
  components: {
    JpaBoardRegisterForm
  },
  methods: {
    ...mapActions([
      'requestCreateBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      // 만약 여기서 async 및 await가 빠지면 어떤 상황이 발생할 수 있을까 ?
      // 비동기 처리를 하게 됩니다.
      // ??? asynchronous가 비동기인데 async가 빠졌는데 왜 비동기 처리를 하지 ?
      // 최신 JavaScript 엔진은 디폴트가 비동기 처리이기 때문
      // synchronous가 동기를 의미합니다.

      // 근데 아래쪽에 await는 왜 필요할까 ?
      // await는 무조건 이 부분이 끝날때까지 전원 대기!
      await this.requestCreateBoardContentsToSpring(payload)

      // 위 작업이 끝나면 리스트 뷰로 이동해라!
      await this.$router.push({
        name: 'JpaBoardListView'
      })
    }
  }
}
</script>

<style scoped>

</style>