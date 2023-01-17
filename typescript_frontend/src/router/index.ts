import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TestView from '@/views/TestView.vue'

import BoardListPage from '@/views/typescript/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/typescript/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/typescript/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/typescript/board/BoardModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/test',
    name: 'TestView',
    component: TestView
  },
  {
    path: '/board-list',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/board-register',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/board-read/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board-modify/:boardNo',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
