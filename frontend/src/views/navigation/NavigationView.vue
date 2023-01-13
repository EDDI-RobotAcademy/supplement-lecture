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
        <v-navigation-drawer app v-model="navigation_drawer" temporary>
            <v-list nav dense>
                <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                    <v-list-item-action>
                        <v-icon left>
                            {{  link.icon }}
                        </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>
                            {{  link.text }}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
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
