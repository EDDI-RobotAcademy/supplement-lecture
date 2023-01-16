<template>
    <v-container>
        <local-component :initial-value="num"/><br/>
        <button @click="plus">클릭해봐!</button>
    </v-container>
</template>

<script lang="ts">

import { Vue } from 'vue-property-decorator';
import LocalComponent from '@/components/LocalComponent.vue'

export default Vue.extend({
  name: 'Home',

  components: {
    LocalComponent,
  },
  data () {
    return {
        num: 0,
    }
  },
  methods: {
    plus () {
        this.num++
    }
  }
})

</script>
