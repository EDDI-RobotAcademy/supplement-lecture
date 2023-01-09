<template>
  <div align="center">
    <h2>상품 등록</h2>
    <product-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import ProductRegisterForm from "@/components/products/ProductRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "ProductRegisterView",
  components: {
    ProductRegisterForm
  },
  methods: {
    ...mapActions([
      'requestCreateProductContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateProductContentsToSpring(payload)
      await this.$router.push({
        name: 'ProductListView'
      })
    }
  }
}
</script>

<style scoped>

</style>