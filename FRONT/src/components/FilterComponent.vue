<template>
  <div>
    <label>Filtrar por tipo:</label>
    <select v-model="selectedProdType" @change="favoriteForm">
      <option value="">Todos</option>
      <option v-for="prodType in prodTypes" :key="prodType" :value="prodType">{{ prodType }}</option>
    </select>
    <v-card class="mx-auto" max-width="500">
      <v-container fluid>
        <v-row dense>
          <v-col v-for="card in cards" :cols="card.flex">
            <v-card>
              <v-img
                :src="card.src"
                class="align-end"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                height="200px"
                cover
              >
                <v-card-title class="text-white" v-text="card.prodMessage"></v-card-title>
              </v-img>

              <v-card-actions>
                <v-card-subtitle
                  class="mt-4 text-subtitle-2"
                  v-text="'Talla ' + card.prodSize"
                ></v-card-subtitle>
                <v-spacer></v-spacer>

                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-heart"
                  @click="cancelfavorite(card.id)"
                ></v-btn>

                <v-btn size="medium" color="surface-variant" variant="text">
                  <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                </v-btn>

                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-share-variant"
                ></v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </div>
</template>

<script setup>
import { ref } from "vue";
import ProductData from "@/services/ProductDataService";

const prodTypes = ["Camiseta", "Sudadera", "Taza", "Botella"];
const selectedProdType = ref("");
const cards = ref([]);

const favoriteForm = async () => {
  try {
    const response = await ProductData.getAll({ type: selectedProdType.value });
    cards.value = response.data.map((product) => ({
      id: product.id,
      prodMessage: product.prodMessage,
      prodType: product.prodType,
      prodSize: product.prodSize,
      prodColor: product.prodColor,
      src: "https://cdn.vuetifyjs.com/images/cards/house.jpg",
      flex: 12,
    }));
  } catch (error) {
    console.log(error);
  }
};

const cancelfavorite = async (productId) => {
  try {
    await ProductData.delete(productId);
    console.log("Eliminado de favoritos");
  } catch (error) {
    console.log("No se ha podido eliminar de favoritos", error);
  }
};

favoriteForm();
</script>

<style></style>

