import Vue from 'vue'
import Vuex from 'vuex'
import BoardModule from '@/store/board/BoardModule'

Vue.use(Vuex)

export default new Vuex.Store ({
  strict: true,
  modules: {
    BoardModule,
  }
})

