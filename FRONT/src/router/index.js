// Composables
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/layouts/default/View.vue'),
      },
      {
        path: '/team',
        name: 'Team',
        component: () => import('@/layouts/Team.vue'),
      },
      {
        path: '/services',
        name: 'Services',
        component: () => import('@/layouts/Services.vue'),
      },
      {
        path: '/contact',
        name: 'Contact Us',
        component: () => import('@/layouts/ContactUs.vue'),
      },
      {
        path: '/favourites',
        name: 'Favourites',
        component: () => import('@/components/FavouriteComponent.vue'),
      },
      {
        path: '/login',
        name: 'Login',
        component: () => import('@/components/LoginComponent.vue'),
      },
      {
        path: '/card',
        name: 'Card',
        component: () => import('@/components/CardComponent.vue'),
      }
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
