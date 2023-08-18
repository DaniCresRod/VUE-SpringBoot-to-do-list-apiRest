<template>
  <v-app>
    <navbar-component />
    <default-view />
    <footer-component />
  </v-app>

</template>

<script setup>
  import DefaultView from './View.vue'
  import NavbarComponent from '@/components/NavbarComponent.vue';
  import FooterComponent from '@/components/FooterComponent.vue';
</script>

