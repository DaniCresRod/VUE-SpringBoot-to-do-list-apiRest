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
        path: '/favorites',
        name: 'Favorites',
        component: () => import('@/components/FavoriteComponent.vue'),
      },
      {
        path: '/login',
        name: 'Login',
        component: () => import('@/components/LoginComponent.vue'),
      },
      {
        path: '/form',
        name: 'Form',
        component: () => import('@/components/FormComponent.vue'),
      },
      {
        path: '/filter',
        name: 'Filter',
        component: () => import('@/components/FilterComponent.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
