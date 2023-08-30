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
    title: 'Productos',
    route: '/products',
  },
  {
    title: 'Login',
    route: '/login',
  },
];

watch(group, () => {
  drawer.value = false;
});

const closeOverlay = (newValue) => {
  overlay.value = newValue;
};
</script>

<template>
  <div>
    <v-app-bar color="primary" prominent>
      <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

        <v-toolbar-title class="text-no-wrap icon-navbar" title="Application">
          <RouterLink to="/">
            Tods List
          </RouterLink>
        </v-toolbar-title>

      <v-spacer></v-spacer>

      <RouterLink to="/favs">
        <v-btn variant="text" icon="mdi mdi-heart" class="i-navbar"></v-btn>
      </RouterLink>

      <v-btn variant="text" icon="mdi-pencil" @click.stop="overlay = true" class="i-navbar"></v-btn>

      <RouterLink to="/login">
        <v-btn variant="text" icon="mdi mdi-account-circle-outline" class="i-navbar"></v-btn>
      </RouterLink>

    </v-app-bar>

    <div v-if="$route.path === '/'" class="banner"></div>

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

    <v-overlay v-model="overlay" class="d-flex align-center justify-center" scrim="#000" @click:outside="closeOverlay">
      <div class="my-overlay-content" style="max-height: 80vh; overflow-y: auto; background-color: white; z-index: 2001;">
        <FormComponent :overlay="overlay" @closeOverlay="closeOverlay" />
      </div>
    </v-overlay>
  </div>
</template>

<style scoped>
.itemList {
  text-decoration: none;
  color: rgba(54, 157, 178, 1);
  padding-left: 10px;
  padding-top: 15px;
}

.itemList:hover {
  letter-spacing: 0.3rem;
  font-weight: bolder;
  background-color:rgba(54, 157, 178, 0.2);
}

.v-list {
  display: flex;
  flex-direction: column;
  gap: 0.6rem;
  margin-left: 1rem;
  padding-top: 1.1rem;
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

a{
  text-decoration: none;
  color: white;
}

.banner {
    width: 100%;
    height: 0;
    padding-bottom: 61.8%;
    background-image: url('../../public/tshirts_edit.jpg');
    background-size: cover;
    background-position: center;
}
.icon-navbar{
  transition: 0.3s;
}
.icon-navbar:hover{
  letter-spacing: 0.1rem;
  color: orange;
}
.i-navbar{
  transition: 0.3s;
}
.i-navbar:hover{
  color: orange;
  background-color: rgba(210, 210, 210, 0.3)
}
</style>
