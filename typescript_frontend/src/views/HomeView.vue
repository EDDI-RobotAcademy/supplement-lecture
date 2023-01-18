<template>
  <v-container>
    <v-spacer></v-spacer>
    <v-layout row wrap>
      <v-flex xs2 md2 class="teal white--text">
        <router-link :to="{ name: 'HomeView' }">
          Home
        </router-link>
      </v-flex>
      <v-flex xs2 md2 class="blue white--text">
        <router-link :to="{ name: 'About' }">
          About
        </router-link>
      </v-flex>
      <v-flex xs1 md1 class="orange white--text">
        <router-link :to="{ name: 'TestView' }">
          Test
        </router-link>
      </v-flex>
      <v-flex xs1 md1 class="red white--text">
        <router-link :to="{ name: 'BoardListPage' }">
          BoardListPage
        </router-link>
      </v-flex>
      <v-flex xs2 md2 class="teal white--text">
        <router-link :to="{ name: 'HomeView' }">
          Home
        </router-link>
      </v-flex>
      <v-flex xs2 md2 class="blue white--text">
        <router-link :to="{ name: 'About' }">
          About
        </router-link>
      </v-flex>
      <v-flex xs2 md2 class="orange white--text">
        <router-link :to="{ name: 'TestView' }">
          Test
        </router-link>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script lang="ts">

import Vue from 'vue'

export default Vue.extend({
  name: 'HomeView',

  components: {
  },
})

</script>

<style scoped>

.v-application a {
  color: black;
}

</style>
