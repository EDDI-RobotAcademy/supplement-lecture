import {
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
    REQUEST_PRODUCT_LIST_TO_SPRING,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestBoardListFromSpring ({ commit }) {
        console.log('requestBoardListFromSpring()')

        // axios.get을 통해 Spring Controller로 요청을 보내고
        // Controller가 리턴한 값이 아래쪽 .thes(res)
        // 결론적으로 res에 배치됩니다.
        // commit을 호출하게 되면 mutations.js에 있는
        // REQUEST_BOARD_LIST_FROM_SPRING이 동작하게 됩니다.
        // Thread를 공부할 때 동기 / 비동기 방식이 있었는데
        // 기본적으로 최신형 JavaScript 들은 대부분 비동기 처리를 바탕으로 하고 있습니다.
        // 처리할 데이터량이 많고 응답성도 중요하니까요.
        // 그러다보니 Critical Section에 대한 Race Condition 문제가 발생하게 됩니다.
        // 이 문제를 해결하기 위해 여러분들은
        // Java에서 synchronize 혹은 Lock, Mutex 등을 사용했을 것입니다.
        // vue 또한 최신 JavaScript에 해당하므로 비동기 처리를 바탕으로 하고
        // action에서 처리되는 부분은 전부 비동기 처리입니다.
        // 그렇기 때문에 위의 문제가 동일하게 발생 할 수 있고
        // 이를 해결하기 위해 mutatations에서는 동기 처리를 보장하는 작업을 진행하게 됩니다.
        // state가 사실상 여러개의 스레드들이 동시다발적으로 접근할 수 있는
        // Critical Section이라 보면 됩니다.
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

        // 변수를 URL과 연결하여 처리 할 때는 백틱이라는 ESC키 아래쪽에 있는 '`' 녀석을 사용합니다.
        return axios.put(`http://localhost:7777/39th/jpa/board/${boardNo}`,
            { title, content, writer, regDate })
            .then(() => {
                alert('수정 성공')
            })
    },
    requestProductListToSpring ({ commit }) {
        console.log('requestProductListToSpring()')

        return axios.get('http://localhost:7777/product/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
            })
    },
}