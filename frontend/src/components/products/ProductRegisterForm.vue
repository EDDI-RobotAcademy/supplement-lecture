<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="name">
        </td>
      </tr>
      <tr>
        <td>가격</td>
        <td>
          <input type="text" v-model="price">
        </td>
      </tr>
      <tr>
        <td>상품 설명</td>
        <td>
          <textarea cols="50" rows="20" v-model="description">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link to="{ name: 'ProductListView' }">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "ProductRegisterForm",
  data () {
    return {
      name: '상품명을 입력하세요',
      price: '',
      description: '상품 상세 정보를 작성하세요',
    }
  },
  methods: {
    onSubmit () {
      const { name, price, description } = this
      this.$emit('submit', { name, price, description })
    }
  }
}
</script>

<style scoped>

</style>