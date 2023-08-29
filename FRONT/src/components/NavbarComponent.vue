<template>
  <div>
    <div class="bg-image" ref="imageSection"></div>
    <v-app-bar v-if="showNavbar" color="primary" prominent class="my-navbar">
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

    <v-overlay v-model="overlay" class="d-flex align-center justify-center" scrim="#000" @click:outside="overlay = false">
      <div class="my-overlay-content" style="max-height: 80vh; overflow-y: auto; background-color: white; z-index: 2001;">
        <FormComponent />
      </div>
    </v-overlay>
  </div>
</template>

<script setup>
import { ref, watch, onMounted } from 'vue';
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

const showNavbar = ref(false);
const imageSection = ref(null);

onMounted(() => {
  window.addEventListener('scroll', handleScroll);
});

const handleScroll = () => {
  const rect = imageSection.value.getBoundingClientRect();
  if (rect.top < 0) {
    showNavbar.value = true;
    // Ajusta el valor del filtro en función de la posición de scroll
    const brightnessValue = Math.max(0, 1 + rect.top / 700);
    imageSection.value.style.filter = `brightness(${brightnessValue})`;
  } else {
    showNavbar.value = false;
    imageSection.value.style.filter = 'none';
  }
};
</script>

<style scoped>
.bg-image {
  height: 100vh;
  background-image: url('C:\Users\toyos\OneDrive\Escritorio\to-do-list-apiRest\FRONT\public\tshirts.jpg');
  background-size: cover;
  background-position: center;
}
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
