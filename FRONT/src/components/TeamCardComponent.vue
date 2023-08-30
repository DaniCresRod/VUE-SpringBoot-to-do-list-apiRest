<script setup>
  import { ref } from 'vue';

  const props = defineProps({
    imageSrc: String,
    title: String,
    subtitle: String,
    buttonLabel: String,
    content: String,
  });

  const show = ref(false);
</script>

<template>
  <v-card class="mx-auto cardTeam" width="225" >
    <v-img :src="imageSrc" height="200px" cover></v-img>

    <v-card-title>{{ title }}</v-card-title>

    <v-card-subtitle>{{ subtitle }}</v-card-subtitle>

    <v-card-actions>
      <v-btn color="primary" variant="text" @click="show = !show">
        {{ buttonLabel }}
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn :icon="show ? 'mdi-chevron-up' : 'mdi-chevron-down'" @click="show = !show"></v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show" color="primary" variant="text">
        <v-divider></v-divider>

        <v-card-text class="content">{{ content }}</v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</template>

<style>

.cardTeam {
  margin-top: 1rem;
}

.content{
  color: rgba(54, 157, 178, 1);
  text-align: center;
}

</style>
