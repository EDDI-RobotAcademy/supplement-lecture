<template>
  <div>
    <h3>상품 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="640">상품명</th>
        <th align="center" width="150">가격</th>
        <th align="center" width="240">등록일자</th>
      </tr>
      <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
        <td colspan="4">
          현재 등록된 게시물이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="product in products" :key="product.id">
        <td align="center">
          {{ product.id }}
        </td>
        <td align="left">
          <router-link :to="{ name: 'ProductReadView',
                              params: { id: product.id.toString() }}">
            {{ product.name }}
          </router-link>
        </td>
        <td align="right">
          {{ product.price }}
        </td>
        <td align="center">
          {{ product.regDate }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "ProductList",
  props: {
    products: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>