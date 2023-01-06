import {
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.boards = passingData
    },
    [REQUEST_BOARD_FROM_SPRING] (state, passingData) {
        state.board = passingData
    },
}