<template>
    <v-container>
        <v-data-table :headers="headerTitle" :items="contents" :items-per-page="10" class="elevation-1"/>
    </v-container>
</template>

<script>

export default {
    name: "TableView",
    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '내용', value: 'content', width: "100px" },
            ],
            contents: [
                { boardNo: 1, title: '야호', writer: '으아아앜', content: '으아아앜' },
                { boardNo: 2, title: '야호야호', writer: '으아아앜', content: '으아아앜' },
                { boardNo: 3, title: '야호야호야호', writer: '으아아앜', content: '으아아앜' },
                { boardNo: 4, title: 'ㅇㅋ', writer: 'ㄷㅋ', content: 'ㅇㅋㄷㅋ' },
                { boardNo: 5, title: '가즈아', writer: '주식폭망', content: '손잡고한강' },
                { boardNo: 6, title: '간드앗', writer: '주식 폭등!!!', content: '다같이손잡고' },
                { boardNo: 7, title: '존버', writer: '존버승리', content: '나락감' },
                { boardNo: 8, title: '끝까지버틴다', writer: '존버승리', content: '나락감' },
                { boardNo: 9, title: '마포대교줄서라', writer: '한강어디', content: '주식 조짐' },
                { boardNo: 10, title: '한강도만원', writer: '주식골로감', content: '다들어디서정모합니까' },
                { boardNo: 11, title: '한국주식', writer: '단타만쳐라', content: '장타치다나락감' },
                { boardNo: 12, title: '미국주식', writer: '지금다나락', content: '존버뿐이다' },
                { boardNo: 13, title: '코인사기', writer: '비트코인', content: '자금세탁용' },
            ]
        }
    }
}

</script>
