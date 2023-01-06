import {
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestBoardListFromSpring ({ commit }) {
        console.log('requestBoardListFromSpring()')

        return axios.get('http://localhost:7777/39th/jpa/board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_FROM_SPRING, res.data)
            })
    },
    requestBoardFromSpring ({ commit }, boardNo) {
        console.log('requestBoardFromSpring()')

        return axios.get(`http://localhost:7777/39th/jpa/board/${boardNo}`)
            .then((res) => {
                commit(REQUEST_BOARD_FROM_SPRING, res.data)
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestCreateBoardContentsToSpring ({ }, payload) {
        console.log('requestCreateBoardContentsToSpring()')

        const { title, content, writer } = payload
        return axios.post('http://localhost:7777/39th/jpa/board/register',
            { title, content, writer })
            .then(() => {
                alert('게시물 등록 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestDeleteBoardToSpring ({ }, boardNo) {
        console.log('requestDeleteBoardToSpring()')

        return axios.delete(`http://localhost:7777/39th/jpa/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공')
            })
    },
    // eslint-disable-next-line no-empty-pattern
    requestBoardModifyToSpring ({ }, payload) {
        console.log('requestBoardModifyToSpring()')

        const { title, content, boardNo, writer, regDate } = payload

        return axios.put(`http://localhost:7777/39th/jpa/board/${boardNo}`,
            { title, content, writer, regDate })
            .then(() => {
                alert('수정 성공')
            })
    },
}