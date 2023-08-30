<script setup>
  import NavbarComponent from '@/components/NavbarComponent.vue';
  import FooterComponent from '@/components/FooterComponent.vue';
  import { RouterView } from 'vue-router';
</script>

<template>
  <v-app>
    <navbar-component />
    <v-main>
      <router-view />
    </v-main>
    <footer-component />
  </v-app>
</template>

<style>
  main{
    margin-top: 50px;
    padding: 50px 10px;
  }
  
  .v-overlay__content {
    z-index: 2001;
    opacity: 100%;
  }
</style>