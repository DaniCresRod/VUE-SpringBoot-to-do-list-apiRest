<template>
   <div class="carousel-container">
  <v-carousel hide-delimiters hide-delimiter-bg>
    <v-carousel-item
      v-for="(item, i) in items"
      :key="i"
      :src="item.src"
      class="border-image"
    >
      <v-btn
        class="favorite-button"
        icon
        fab
        color="transparent"
        @click="toggleFavorite(item)"
      >
        <v-icon :color="isFavorite(item) ? 'blue' : 'grey'">
          {{ isFavorite(item) ? 'mdi-heart' : 'mdi-heart-outline' }}
        </v-icon>
      </v-btn>
    </v-carousel-item>
  </v-carousel>
</div>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            src: 'src/assets/biscocho_blanca.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/figma_azul.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/pildora_azul.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/vue_negra.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/ctrl_azul.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/inestabilidad_blanca.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/pull_blanca.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/span_azul.png',
            isFavorite: false,
          },
          {
            src: 'src/assets/rama_negra.png',
            isFavorite: false,
          },
        ],
      };
    },
    methods: {
      toggleFavorite(item) {
        item.isFavorite = !item.isFavorite;
      },
      isFavorite(item) {
        return item.isFavorite;
      },
    },
  };
</script>

<style>
.carousel-container {
  background-image: url('/tshirt_back.jpg'); 
  background-size: cover; 
  background-position: center;
  filter: grayscale(50%);
  opacity: 70%;
  backdrop-filter: blur(50px);

  } 


.favorite-button {
  position: absolute;
  top: 90%;
  left: 60%;
  transform: translate(-50%, -50%);
}
.border-image {
  border-radius: 25px;
}
.v-btn--variant-elevated{
      box-shadow: 0px 3px 1px -2px var(--v-shadow-key-umbra-opacity, rgba(0, 0, 0, 0.2)), 0px 2px 2px 0px var(--v-shadow-key-penumbra-opacity, rgba(0, 0, 0, 0.14)), 0px 1px 5px 0px var(--v-shadow-key-penumbra-opacity, rgba(0, 0, 0, 0.12));
}
</style>
