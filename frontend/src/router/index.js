import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TestView from '@/views/TestView.vue'
import DataSend2SpringTestView from '@/views/DataSend2SpringTestView.vue'
import SimpleBoardGameView from '@/views/game/SimpleBoardGameView.vue'
import Exercise1View from '@/views/exercise/Exercise1View.vue'

import FileUploadView from "@/views/file/FileUploadView"

import JpaBoardListView from "@/views/boards/JpaBoardListView"
import JpaBoardRegisterView from "@/views/boards/JpaBoardRegisterView"
import JpaBoardReadView from "@/views/boards/JpaBoardReadView"
import JpaBoardModifyView from "@/views/boards/JpaBoardModifyView"

import ProductListView from "@/views/products/ProductListView"
import ProductRegisterView from "@/views/products/ProductRegisterView"
import ProductReadView from "@/views/products/ProductReadView"
import ProductModifyView from "@/views/products/ProductModifyView"

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
  {
    path: '/file-upload-test',
    name: 'FileUploadTest',
    component: FileUploadView
  },
  {
    path: '/board-list',
    name: 'JpaBoardListView',
    component: JpaBoardListView
  },
  {
    path: '/board-register',
    name: 'JpaBoardRegisterView',
    component: JpaBoardRegisterView
  },
  {
    // vue router에서 가변 인자는 아래와 같이 :boardNo 형태로 작성
    path: '/board-read/:boardNo',
    name: 'JpaBoardReadView',
    components: {
      default: JpaBoardReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/board-modify/:boardNo',
    name: 'JpaBoardModifyView',
    components: {
      default: JpaBoardModifyView
    },
    props: {
      default: true
    }
  },
  {
    path: '/product-list',
    name: 'ProductListView',
    component: ProductListView
  },
  {
    path: '/product-register',
    name: 'ProductRegisterView',
    component: ProductRegisterView
  },
  {
    path: '/product-read/:id',
    name: 'ProductReadView',
    components: {
      default: ProductReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/product-modify/:id',
    name: 'ProductModifyView',
    components: {
      default: ProductModifyView
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
