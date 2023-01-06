<template>
    <div>
        <!-- 현재 누구의 차례인지 표기 -->
        <div>{{ currentTurnShape }} 님의 턴입니다.</div>
        <table-component
            :table-data="tableData"
            :current-turn-shape="currentTurnShape"
            @updateTurnShape="updateTurnShape"
            @updateWinner="updateWinner"
            @updateTableData="updateTableData"/>
        <!-- 누가 이겼는지 출력 -->
        <div v-if="winner">{{ winner }} 님의 승리!</div>
    </div>
</template>

<script>
/*
예: 오목 게임 만들기
    -> 요구사항을 뽑아내자!
       -> 바둑판, 승자 판정, 그 외 등등 뭔가 더 필요 ? 할지도 모르겠음 <--- 전형적인 폭포수 설계
          -> 이러한 설계 방식이 가지는 제일 큰 문제
             -> 뭔가를 바꾸려고 하면 바꾸기가 매우 어려워짐
             -> 만들고보니 필요 없는 경우도 존재함

       -> 근데 바둑판도 우선 윤곽만 잡았음 (처음부터 무엇을 할 것인지 굉장히 러프하게 구성)
          -> 그 다음에 무엇을 할까 ? 사용자가 클릭한 부분에 표시하기
          -> 그 다음은 ? (만들었는데 O, X가 안바뀌네 ?) O, X 턴 개념 적용하기
          -> 그 다음은 ? (만들었는데 승자 판정이 안되네 ?) 승자 판정 매서드 추가 후 승자 판정하기
          -> 그 다음은 ? (승자 판정도 되는데 판이 초기화되지 않네 ?) 판 초기화 하기
          -> 더 할 작업이 존재하는가 ?
        -> 끝

    -> 일단 무조건 윤곽을 잡고 세부 사항의 결정을 최대한 늦춘다!
    -> x 쓰기, y 쓰기, z 쓰기 -> 어 ? 인터페이스네
       -> 인터페이스 레이어 배치
          -> 각각의 구현체로 분리

            if (z) { write(); }
            else if (y) { ~~~ }
            else if (x) { ~~~ }
            ....

    ArrayList vs HashSet 속도 빠르기로 승부하면 ? HashSet은 Red Black Tree를 사용함
    1 ~ 1억까지 검색을 한다 가정
    리스트 방식에서는 최악의 경우 1억개를 다 검색해야함
    트리 방식은 2^n -> 2^32 = 42억 9천만 정도
    2^30 = 10억, 2^29 = 5억, 2^28 = 2.5억, 2^27 = 1.25억, 2^26 = 0.625억

    대략 1억번을 검색하는데 최악의 경우 28번의 검색으로 1억개의 데이터 검색이 가능함.

    28번 검색으로 1억개의 데이터를 검색하겠습니까 ?
    아니면 1억 번 검색해서 1억개의 데이터를 검색하겠습니까 ?

    코드의 길이가 성능에 영향을 미치나요 ? 네 미칩니다.
    왜냐하면 운영체제가 Memory(메모리)를 관리하는 방법 때문에 그렇고
    또한 우리가 프로그램을 구동할 때 모든 정보가 메모리에 올라가기 때문에 그렇습니다.

    OS는 4KB(4096 byte) = 2^12 단위로 실제 물리적인 전자 장비(DRAM)를 제어하게 됨
    문제는 이 부분의 크기 단위로 정보가 할당되어 있지 않으면 엄청난 성능 이슈가 발생하게 됨
    파일 -> 하드디스크에 저장된 정보 -> I/O로서 Memory에 올리는 작업이 진행되고
    이 정보를 읽어다가 CPU가 기계어를 실행(Java도 똑같아요 - 어떤 언어가 오던 다 똑같습니다)
    그렇기 때문에 읽을 정보가 많거나 혹은 같은 코드의 크기가 더 커지거나 짧아지는 것에 따라 영향을 받습니다.

    별개로 코드 크기와 또 다른 이슈가 있는데
    for, if 같은 것이 많이 발생하는 것도 성능 이슈상 좋지 않습니다.
    (이 세부 사항까지 궁금하다면 컴퓨터 구조론의 파이프라인에 대해 공부하세요)
*/

import TableComponent from '@/components/game/TableComponent.vue';

export default {
    name: "SimpleBoardGameView",
    components: {
        TableComponent
    },
    data () {
        return {
            currentTurnShape: 'O',
            winner: '',
            tableData: [
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
            ]
        }
    },
    methods: {
        updateTurnShape (passingValue) {
            console.log('SimpleBoardGameView received TableComponent info: ' + passingValue)
            this.currentTurnShape = passingValue
        },
        updateWinner (passingValue) {
            console.log('TrComponent received TdComponent winner info: ' + passingValue)
            this.winner = passingValue
        },
        updateTableData () {
            this.tableData = [
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
                ['', '', '', '', ''],
            ]
        }
    }
}

</script>

<style scoped>

table {
    width: 10%;
    border: 2px solid #cccccc
}

</style>