<script setup>
import { ref, onBeforeMount } from 'vue';
import ProductData from "@/services/ProductDataService";
import FormComponent from '@/components/FormComponent.vue'; 

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

const mostrarFormulario = ref(false);

const abrirFormulario = () => {
  mostrarFormulario.value = true;
};

const cerrarFormulario = () => {
  mostrarFormulario.value = false;
};

</script>


<template>
<div class="general_home">
  <h2 class="h2_home">Nuestras Mierdas</h2>
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
<div class="btn_custom_block">
    <h2>O crea tu propio diseño</h2>
    <v-btn class="btn_custom" rounded="xl" @click="abrirFormulario">Aquí</v-btn>
    <FormComponent v-if="mostrarFormulario" @cerrarFormulario="cerrarFormulario" />
  </div>
</div>
</template>


<style scoped>
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

.btn_custom {
  margin-top: 15px;
  text-decoration: none;
  transition: 0.3s;
  background-color: rgba(54, 157, 178, 0.7) !important;
  color: white !important;
  padding: 0 50px;
  }
  
.btn_custom :hover{
  letter-spacing: 0.15rem;
  padding: 0 1rem;
  font-weight: bolder;
}

.btn_custom_block{
  text-align: center;
  padding-top: 30px;
  
}

.h2_home{
  text-align: center;
  padding-bottom: 15px;
}

.v-btn{
  margin-bottom: 25px ;
}
.v-main{
  margin-top: 0px !important;
}
</style>
