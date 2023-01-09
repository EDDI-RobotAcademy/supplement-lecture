<template>
  <div align="center">
    <h2>Vue + Spring 상품 보기</h2>
    <product-read v-if="product" :product="product"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'ProductModifyView', params: { id } }">
      상품 정보 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'ProductListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>
import ProductRead from "@/components/products/ProductRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductReadView",
  components: {ProductRead},
  props: {
    id: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
        'requestProductToSpring',
        'requestDeleteBoardToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteProductToSpring(this.id);
      await this.$router.push({ name: 'ProductListView' })
    }
  },
  created() {
    this.requestProductToSpring(this.id)
  }
}
</script>

<style scoped>

</style>