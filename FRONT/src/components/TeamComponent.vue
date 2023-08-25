<script>
export default {
  props: {
    imageSrc: String,
    title: String,
    subtitle: String,
    buttonLabel: String,
    content: String,
  },
  data() {
    return {
      show: false,
    };
  },
};
</script>

<template>
  <v-card class="mx-auto cardTeam" max-width="344" >
    <v-img :src="imageSrc" height="200px" cover></v-img>

    <v-card-title>{{ title }}</v-card-title>

    <v-card-subtitle>{{ subtitle }}</v-card-subtitle>

    <v-card-actions>
      <v-btn color="orange-lighten-2" variant="text" @click="show = !show">
        {{ buttonLabel }}
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn :icon="show ? 'mdi-chevron-up' : 'mdi-chevron-down'" @click="show = !show"></v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>{{ content }}</v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</template>
