<script setup>
  import NavbarComponent from '@/components/NavbarComponent.vue';
  import FormComponent from '@/components/FormComponent.vue';
  import FooterComponent from '@/components/FooterComponent.vue';
  import { RouterView } from 'vue-router';
</script>

<template>
  <v-app>
    <navbar-component />
    <v-main>
      <router-view />
    </v-main>
    <form-component/>
    <footer-component />
  </v-app>
</template>

<style scoped>
  main{
    margin-top: 50px;
    padding: 50px 10px;
  }
</style>
