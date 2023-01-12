<template>
    <div>
        <v-container>
            <v-row>
                <v-col v-for="image in images" :key="image" cols="4">
                    <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate color="grey lighten-5"/>
                            </v-row>
                        </template>
                    </v-img>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>

export default {
    data() {
        return {
            images: [
                require('@/assets/carousel/mario1.png'),
                require('@/assets/carousel/mu1.png'),
                require('@/assets/carousel/link1.png'),
                require('@/assets/carousel/yadon1.png'),
                require('@/assets/carousel/mario1.png'),
                require('@/assets/carousel/mu1.png'),
                require('@/assets/carousel/link1.png'),
                require('@/assets/carousel/yadon1.png'),
                require('@/assets/carousel/mario1.png'),
                require('@/assets/carousel/mu1.png'),
                require('@/assets/carousel/link1.png'),
                require('@/assets/carousel/yadon1.png'),
                require('@/assets/carousel/mario1.png'),
                require('@/assets/carousel/mu1.png'),
                require('@/assets/carousel/link1.png'),
            ]
        }
    }
}

</script>