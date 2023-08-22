<script setup>

import { ref, watch } from 'vue';


const drawer = ref(false);
const group = ref(null);

const items = [
  {
    title: 'Home',
    value: '/',
  },
  {
    title: 'Bar',
    value: 'bar',
  },
  {
    title: 'Fizz',
    value: 'fizz',
  },
  {
    title: 'Login',
    value: '/login',
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

        <v-btn variant="text" icon="mdi-heart" v-for="link in links" :key="link.name" :to="link.route"></v-btn>

        <v-btn variant="text" icon="mdi-filter"></v-btn>

        <v-btn variant="text" icon="mdi-dots-vertical"></v-btn>
      </v-app-bar>

      <v-navigation-drawer v-model="drawer" location="top" temporary>        
        <v-list>
          <router-link v-for="item in items" :key="items.title" :to="item.value">
            {{item.title}}
          </router-link>
        </v-list>     
      </v-navigation-drawer>
</template>
