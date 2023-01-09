<template>
    <div id="board">
      <h2>Vue + Spring + JPA Boards</h2>
      <router-link :to="{ name: 'ProductRegisterView' }">
        게시물 작성
      </router-link>
      <product-list :products="products"/>
    </div>
  </template>
  
  <script>
  
  import { mapState, mapActions } from "vuex";
  import ProductList from "@/components/products/ProductList";
  
  export default {
    name: "ProductListView.vue",
    components: {
        ProductList
    },
    computed: {
      ...mapState([
          'products'
      ]),
    },
    mounted() {
      this.requestProductListToSpring()
    },
    methods: {
      ...mapActions([
          'requestProductListToSpring'
      ])
    }
  }
  </script>
  
  <style scoped>
  
  </style>