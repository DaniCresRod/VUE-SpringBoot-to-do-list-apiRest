import Home from '@/views/Home.vue'
import Favs from '@/views/Favs.vue'
import Login from '@/views/Login.vue'
import Products from '@/views/Products.vue'
import SignUp from '@/views/SignUp.vue'
import Team from '@/views/Team.vue'
import NoRouter from '@/views/NoRouter.vue'
import Refresh from '@/views/FavsRefresh.vue'

import { createRouter, createWebHistory } from 'vue-router'

const routes = [
      {
        path: '/',
        name: 'Home',
        component: Home,
      },
      {
        path: '/favs',
        name: 'Favs',
        component: Favs,
      },
      {
        path: '/login',
        name: 'Login',
        component: Login,
      },
      {
        path: '/signUp',
        name: 'SignUp',
        component: SignUp,
      },
      {
        path: '/products',
        name: 'Products',
        component: Products,
      },
      {
        path: '/team',
        name: 'Team',
        component: Team,
      },
      {
        path: '/blank',
        name: 'Blank',
        component: NoRouter,
      },
      {
        path: '/refreshFavs',
        name: 'RefreshFavs',
        component: Refresh,
      },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
