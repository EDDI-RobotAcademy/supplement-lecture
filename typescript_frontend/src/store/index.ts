import { moduleBoard, BoardState } from '@/store/board/boardIndex'

export interface RootState {
  moduleBoard: BoardState
  //moduleProduct: ProductState
}

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store ({
  strict: true,
  modules: {
    moduleBoard,
  }
})

