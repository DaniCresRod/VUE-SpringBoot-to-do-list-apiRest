<template>
  <v-carousel hide-delimiters>
    <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      :src="item.src"
    ></v-carousel-item>
  </v-carousel>
  <!-- insertar boton fav traslucido en el centro de la imagen -->
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            src: 'src/assets/biscocho_azul.png',
          },
          {
            src: 'src/assets/biscocho_blanca.png',
          },
          {
            src: 'src/assets/biscocho_negra.png',
          },
          {
            src: 'src/assets/blanca_span.png',
          },
        ],
      };
    },
  };
</script>
