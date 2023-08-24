<script setup>
import { ref, watch } from 'vue';
import { RouterLink } from 'vue-router';

const drawer = ref(false);
const group = ref(null);

const items = [
  {
    title: 'Home',
    route: '/',
  },
  {
    title: 'Team',
    route: '/team',
  },
  {
    title: 'Services',
    route: '/services',
  },
  {
    title: 'Contact Us',
    route: '/contact',
  },
  {
    title: 'Login',
    route: '/login',
  },
];

watch(group, () => {
  drawer.value = false;
});
</script>

<template>
  <v-app-bar
    color="primary"
    prominent
  >
    <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

    <v-toolbar-title class="text-no-wrap" title="Application">Tods List</v-toolbar-title>

    <v-spacer></v-spacer>

    <RouterLink to="/favourites"><v-btn variant="text" icon="mdi-heart"></v-btn></RouterLink>

    <v-btn variant="text" icon="mdi-filter"></v-btn>

    <v-btn variant="text" icon="mdi-dots-vertical"></v-btn>
  </v-app-bar>

  <v-navigation-drawer
    v-model="drawer"
    location="top"
    temporary
  >

    <v-list>
      <RouterLink
        class="itemList"
        v-for="item in items"
        :key="item.title"
        :to="item.route"
      >
        {{ item.title }}
      </RouterLink>
    </v-list>
  </v-navigation-drawer>
</template>

<style>
  .itemList {
    text-decoration: none;
    color: rgba(54, 157, 178, 1);
  }
  .itemList:hover {
    letter-spacing: 0.15rem;
    font-weight: bolder;
  }
  .v-list{
    display: flex;
    flex-direction: column;
    gap: 1rem;
    margin-left: 1rem;
  }
</style>
