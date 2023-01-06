<template>
  <div id="board">
    <h2>Vue + Spring + JPA Boards</h2>
    <!-- 게시물 작성을 눌렀을 때 어떤 페이지가 보이게 만들 것인가 ? -->
    <router-link :to="{ name: 'JpaBoardRegisterView' }">
      게시물 작성
    </router-link>
    <!-- 게시물 리스트를 보여줘야 하니
         전달 받은 객체 정보를 jpa-board-list 컴포넌트에서 출력
         이와 같은 구성이라면 product 정보가 들어올 때도
         아래와 같이 작성해서 clean code를 설계할 수 있음.
         jpa-board-list :boards="products"/>

         만약 컴포넌트에 사진이 필요하다 ?
         jpa-board-list :boards="products" :need-img="true" />
         이와 같은 형태로 사용자 커스텀 태그를 만들어서 코드 자체를 간결하고 깔끔하게 만든다.
         뿐만 아니라 무엇을 하는지 컴포넌트 이름에서 굉장히 명시적으로 드러나기 때문에
         대규모 협업을 하는 상황에서도 정보 전달에 있어 누락을 대부분 방지 할 수 있다. -->
    <jpa-board-list :boards="boards"/>
  </div>
</template>

<script>

import { mapState, mapActions } from "vuex";
import JpaBoardList from "@/components/boards/JpaBoardList";

export default {
  name: "JpaBoardListView.vue",
  components: {
    JpaBoardList
  },
  computed: {
    ...mapState([
        'boards'
    ]),
  },
  mounted() {
    // vue는 기본적으로 아래와 같은 Life Cycle을 가집니다.
    // 1. created(최초 실행) -> 
    // 2. mounted(export default에 배치된 값들이 {{ test }} 와 같은 부분에 붙음) ->
    // 3. updated(화면의 변화가 감지되면 항상 이게 동작 - 비동기) ->
    // 4. destroy (종료시점에만)
    this.requestBoardListFromSpring()
  },
  methods: {
    // 요놈은 store/actions에 있는 requestBoardListFromSpring을
    // vue 객체가 사용할 수 있도록 만드는 작업
    // 보편적으로 서버에게 정보를 요청하는 api들을 이 영역에 배치함
    ...mapActions([
        'requestBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>