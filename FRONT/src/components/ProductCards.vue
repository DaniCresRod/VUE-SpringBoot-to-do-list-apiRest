<script setup>
import { ref, onBeforeMount } from 'vue';
import ProductData from "@/services/ProductDataService";


const items= ref([
          {
            src: 'src/assets/biscocho_blanca.png',
            color: "Blanco",
            name: "BISCOCHO",
            isFavorite: false,
          },
          {
            src: 'src/assets/figma_azul.png',
            name: "Mi figmita y mis cosas",
            color: "Azul",
            isFavorite: false,
          },
          {
            src: 'src/assets/pildora_azul.png',
            name: "Vine buscando PILDORA y encontre una MASTERCLASS",
            color: "Azul",
            isFavorite: false,
          },
          {
            src: 'src/assets/vue_negra.png',
            isFavorite: false,
            name: "Puxa Vue.js, Puxa Asturies",
            color: "Negro",
          },
          {
            src: 'src/assets/ctrl_azul.png',
            name: "CTRL + Kete Comentes",
            color: "Azul",
            isFavorite: false,
          },
          {
            src: 'src/assets/inestabilidad_blanca.png',
            name: "Somos los trabajadores de la inestabilidad mental",
            color: "Blanco",
            isFavorite: false,
          },
          {
            src: 'src/assets/pull_blanca.png',
            name: "PULL antes de PUSH",
            color: "Blanco",
            isFavorite: false,
          },
          {
            src: 'src/assets/span_azul.png',
            name: "Puxa Vue.js, Puxa Asturies",
            color: "Azul",
            isFavorite: false,
          },
          {
            src: 'src/assets/rama_negra.png',
            name: "Trabaja en tu putita rama",
            color: "Negro",
            isFavorite: false,
          },
        ]);

const isFavorite = (item) => {
  return item.isFavorite;
};

const toggleFavorite = async (item) => {
  if (!item.isFavorite) {
    item.isFavorite = true;
  
    try {
      const response = await ProductData.create({
        prodMessage: item.name,
        prodSize: " ",
        prodType: "Camiseta",
        prodColor: item.color
      });
      console.log('Añadido a favoritos:', response.data);
    } catch (error) {
      console.log('Error', error);
    }
  
  } else {
      item.isFavorite = false;

    try {
      const response = await ProductData.getAll();
      const dataFromServer = response.data;
      
      const matchingItem = dataFromServer.find((serverItem) =>
          serverItem.prodMessage === item.name &&
          serverItem.prodColor === item.color &&
          serverItem.prodType === "Camiseta"
      );

        if (matchingItem) {
          try {
            await ProductData.delete(matchingItem.id);
            console.log("Eliminado de favoritos");
          } catch (error) {
            console.log("No se ha podido eliminar de favoritos", error);
          }
        }
    } catch (error) {
      console.log(error);
    }
  }
};

const favoriteProduct = async () => {
  try {
    const response = await ProductData.getAll();
    const dataFromServer = response.data;
    console.log(dataFromServer);
    
    dataFromServer.forEach(serverItem => {
      const matchingItem = items.value.find
      (item => item.name === serverItem.prodMessage && item.color === serverItem.prodColor && serverItem.prodType === "Camiseta");
      if (matchingItem) {
        matchingItem.isFavorite = true;
      }
          });
      } catch (error) {
        console.log(error);
      }
    };
onBeforeMount(() => {
  favoriteProduct();
});

</script>

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
  box-shadow: 0px 3px 1px -2px var(--v-shadow-key-umbra-opacity, rgba(0, 0, 0, 0.2)), 0px 2px 2px 0px var(--v-shadow-key-penumbra-opacity, rgba(0, 0, 0, 0.14)), 0px 1px 5px 0px var(--v-shadow-key-penumbra-opacity, rgba(0, 0, 0, 0.12));
}
</style>
