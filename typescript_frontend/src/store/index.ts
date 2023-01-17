import Vue from 'vue'
import Vuex, { StoreOptions } from 'vuex'
import AxiosService from '@/service'
import {
  REQUEST_BOARD_LIST,
  REQUEST_BOARD
} from './mutation-types'

Vue.use(Vuex)

export interface Board {
  boardNo: number
  title: string
  writer: string
  content: string
  regDate: string
}

interface BoardState {
  boards: Board[]
  board: Board
}

const store: StoreOptions<BoardState> = {
  state: {
    boards: [],
    board: { boardNo: 0, title: '', writer: '', content: '', regDate: '' }
  },
  getters: {
  },
  mutations: {
    [REQUEST_BOARD_LIST] (state, boards: Board[]) {
      state.boards = boards
    },
    [REQUEST_BOARD] (state, board: Board) {
      state.board = board
    }
  },
  actions: {
    requestBoardListToSpring ({ commit }, boardNo: number) {
      return AxiosService.instance.get('/ts/board/lists')
        .then((res) => {
          commit(REQUEST_BOARD_LIST, res.data)
        })
    },
    requestBoardList ({ commit }, boardNo: number) {
      return AxiosService.instance.get(`/ts/board/${boardNo}`)
        .then((res) => {
          commit(REQUEST_BOARD, res.data)
        })
    }
  },
  modules: {
  }
}

export default new Vuex.Store(store)