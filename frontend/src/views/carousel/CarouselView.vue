<template>
    <div class="slide-3d">
        <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="model">
            <v-carousel-item v-for="(picture, i) in pictures" :key="i">
                <v-sheet :height="height" tile>
                    <v-row class="fill-height" align="center" justify="center">
                        <div class="text-h2">
                            <v-img :src="picture.img" :height="height" contain></v-img>
                        </div>
                    </v-row>
                </v-sheet>
            </v-carousel-item>
        </v-carousel>
    </div>
</template>

<script>

export default {
    name: "CarouselView",
    data () {
        return {
            model: 0,
            pictures: [
                { img: require("@/assets/carousel/mu1.png") },
                { img: require("@/assets/carousel/link1.png") },
                { img: require("@/assets/carousel/mario1.png") },
            ],
            cycle: true,
            interval: 2500, // ms 단위
            height: 700,
        }
    }
}

</script>