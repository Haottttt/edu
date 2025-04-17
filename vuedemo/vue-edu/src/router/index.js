// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/views/Login.vue'
import Dashboard from '@/views/Dashboard.vue'
import Home from '@/views/Home.vue'
import CourseList from '@/views/CourseList.vue'
import CourseDetail from '@/views/CourseDetail.vue'
import CourseVideo from '@/views/CourseVideo.vue'
import Homework from '@/views/Homework.vue'
import Chat from '@/views/Chat.vue'
import OrderHistory from '@/views/OrderHistory.vue'
import Notification from '@/views/Notification.vue'
import store from '@/store'

const routes = [
  { path: '/login', component: Login },
  {
    path: '/',
    component: Dashboard,
    meta: { requiresAuth: true },
    children: [
      { path: '', redirect: 'home' },
      { path: 'home',        component: Home },
      { path: 'courses',     component: CourseList },
      { path: 'courses/:id', component: CourseDetail, props: true },
      { path: 'courses/:id/video', component: CourseVideo, props: true },
      { path: 'homework',    component: Homework },
      { path: 'chat/:courseId', component: Chat, props: true },
      { path: 'orders',      component: OrderHistory },
      { path: 'notifications', component: Notification }
    ]
  },
  { path: '/:pathMatch(.*)*', redirect: '/login' }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 导航守卫
router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !store.getters.isAuthenticated) {
    next('/login')
  } else {
    next()
  }
})

export default router
