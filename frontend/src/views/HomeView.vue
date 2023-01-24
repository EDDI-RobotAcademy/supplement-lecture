<template>
  <v-container>
    <div id="app">
      <nav>
        <router-link to="/">HomeView</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/test">Test</router-link> |
        <router-link to="/axiosDataSend2Spring">Vue에서 Spring으로 데이터 전송</router-link> |
        <router-link to="/simple-board-game">보드 게임</router-link> |
        <router-link to="/exercise1">연습 문제 1</router-link> |
        <router-link to="/file-upload-test">파일 업로드 테스트</router-link><br/>
        <router-link to="/board-list">Vue 게시판</router-link> |
        <router-link to="/product-list">상품 게시판</router-link> |
        <router-link to="/carousel-view">크로셀</router-link> |
        <router-link to="/img-gallery-view">이미지 갤러리</router-link> |
        <router-link to="/dialog-view">다이얼로그</router-link> |
        <router-link to="/navigation-view">네비뷰</router-link> |
        <router-link to="/table-view">테이블뷰</router-link> |
        <router-link to="/exercise2">연습 문제 2</router-link> |
        <router-link to="/sign-up">회원 가입</router-link> |
        <router-link to="/sign-in">로그인</router-link> |
      </nav>
      <router-view/>
    </div>
  </v-container>
</template>

<script>

export default {
  name: 'HomeView',
  components: {}
}

</script>