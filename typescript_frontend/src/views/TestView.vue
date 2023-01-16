<template>
    <v-container>
      <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
    </v-container>
  </template>
  
  <script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
  
  @Component({
    components: {
      HelloWorld,
    },
  })
  export default class HomeView extends Vue {}
  </script>
  