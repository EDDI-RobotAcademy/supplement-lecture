<template>
  <div>
    <table>
      <tr>
        <td>상품 번호</td>
        <td>
          <input type="text" :value="product.id" readonly>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" :value="product.name" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 가격</td>
        <td>
          <input type="text" :value="product.price" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="product.createdTime" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 세부 정보</td>
        <td>
          <textarea cols="50" rows="20" :value="product.description" readonly>
          </textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "ProductRead",
  props: {
    product: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>