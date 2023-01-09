<template>
  <div align="center">
    <h2>Vue + Spring 상품 수정</h2>
    <product-modify-form v-if="product" :product="product" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>
import ProductModifyForm from "@/components/products/ProductModifyForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "ProductModifyView",
  components: {ProductModifyForm},
  props: {
    id: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
        'requestProductToSpring',
        'requestProductModifyToSpring'
    ]),
    async onSubmit (payload) {
      const { name, description, price } = payload
      const id = this.id

      await this.requestProductModifyToSpring({ id, name, description, price })
      await this.$router.push({
        name: 'ProductReadView',
        params: { id: this.id }
      })
    }
  },
  created () {
    this.requestProductToSpring(this.id)
  }
}
</script>

<style scoped>

</style>