<template>
    <v-container>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">쵝오의 여행!!!</span>
                <span> 꾸르팁</span>
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{  link.text }}
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>
    </v-container>
</template>

<script>

export default {
    name: "NavigationView",
    data () {
        return {
            navigation_drawer: false,
            links: [
                { icon: 'mdi-home', text: 'Home', name: 'home', route: '/' },
                { icon: 'mdi-airplane-edit', text: '뱅기 예약', name: 'airplane', route: '/carousel-view' },                
            ]
        }
    }
}

</script>
