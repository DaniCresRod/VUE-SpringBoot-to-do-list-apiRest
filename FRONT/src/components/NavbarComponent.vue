<template>
  <div>
    <v-app-bar color="primary" prominent class="my-navbar">
      <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title class="text-no-wrap" title="Application">Tods List</v-toolbar-title>

      <v-spacer></v-spacer>

      <RouterLink to="/favorites">
        <v-btn variant="text" icon="mdi-heart"></v-btn>
      </RouterLink>

      <v-btn variant="text" icon="mdi-pencil" @click.stop="overlay = !overlay"></v-btn>

      <v-btn variant="text" icon="mdi-dots-vertical"></v-btn>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" location="top" temporary>
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

    <!-- <div class="image-container">
      <img class="grayscale" src="/public/tshirt_back.jpg" alt="fabrica de camisetas" />
    </div> -->

    <v-overlay v-model="overlay" class="d-flex align-center justify-center" scrim="#000" @click:outside="overlay = false">
      <div class="my-overlay-content" style="max-height: 80vh; overflow-y: auto; background-color: white; z-index: 2001;">
        <FormComponent />
      </div>
    </v-overlay>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { RouterLink } from 'vue-router';
import FormComponent from '@/components/FormComponent.vue';

const drawer = ref(false);
const group = ref(null);
const overlay = ref(false);

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

<style scoped>
.itemList {
  text-decoration: none;
  color: rgba(54, 157, 178, 1);
}
.itemList:hover {
  letter-spacing: 0.60rem;
  font-weight: bolder;
}
.v-list {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  margin-left: 1rem;
}
.my-overlay-content {
  padding: 4rem;
  border-radius: 0.3rem;
}
.my-overlay-content::-webkit-scrollbar {
  display: none;
}
.my-navbar {
   transition: opacity .5s ease-in-out;
}
</style>
