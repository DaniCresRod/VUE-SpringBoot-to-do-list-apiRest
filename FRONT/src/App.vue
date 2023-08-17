<script setup>
  import FooterComponent from '@/components/FooterComponent.vue';
</script>

<template>

  <FooterComponent />
  <v-card class="mx-auto" width="400" prepend-icon="mdi-home">
    <template v-slot:title> This is a title </template>

    <v-card-text> This is content </v-card-text>
  </v-card>
</template>
