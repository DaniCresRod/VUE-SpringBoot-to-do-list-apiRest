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
            src: 'src/assets/inestabilidad_blanca.png',
          },
          {
            src: 'src/assets/pull_blanca.png',
          },
          {
            src: 'src/assets/span_azul.png',
          },
          {
            src: 'src/assets/rama_negra.png',
          },
        ],
      };
    },
  };
</script>
