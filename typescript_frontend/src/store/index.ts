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
      return AxiosService.instance.get('/39th/jpa/board/list')
        .then((res) => {
          commit(REQUEST_BOARD_LIST, res.data)
        })
    },
    requestBoardList ({ commit }, boardNo: number) {
      return AxiosService.instance.get(`/39th/jpa/board/${boardNo}`)
        .then((res) => {
          commit(REQUEST_BOARD, res.data)
        })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateBoardContentsToSpring ({ }, payload) {
      console.log('requestCreateBoardContentsToSpring()')

      const { title, content, writer } = payload
      return AxiosService.instance.post('/39th/jpa/board/register',
          { title, content, writer })
          .then(() => {
              alert('게시물 등록 성공')
          })
  },
  },
  modules: {
  }
}

export default new Vuex.Store(store)