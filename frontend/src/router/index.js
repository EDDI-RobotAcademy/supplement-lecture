import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TestView from '@/views/TestView.vue'
import DataSend2SpringTestView from '@/views/DataSend2SpringTestView.vue'
import SimpleBoardGameView from '@/views/game/SimpleBoardGameView.vue'
import Exercise1View from '@/views/exercise/Exercise1View.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/test',
    name: 'test',
    component: TestView
  },
  {
    path: '/axiosDataSend2Spring',
    name: 'axiosDataSend2Spring',
    component: DataSend2SpringTestView
  },
  {
    path: '/simple-board-game',
    name: 'simpleBoardGame',
    component: SimpleBoardGameView
  },
  {
    path: '/exercise1',
    name: 'exercise1',
    component: Exercise1View
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
