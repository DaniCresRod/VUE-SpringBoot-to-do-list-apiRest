<script setup>
import { ref, onMounted } from "vue";
import ProductData from "@/services/ProductDataService";
import FilterComponent from "@/components/FilterComponent/FilterCard.vue";

const selectedProdType = ref("");
const cards = ref([]);
const tab = ref("all");

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
      flex: 4,
      gap: 2
    }));
  } catch (error) {
    console.log(error);
  }
};

const filteredCards = (type) => {
  return cards.value.filter((card) => type === 'all' || card.prodType === type);
};

const cancelfavorite = async (productId) => {
  try {
    await ProductData.delete(productId);
    console.log("Eliminado de favoritos");
    setTimeout(() => {
        location.reload();
        alert("Producto eliminado correctamente")
       }, 1500);
  } catch (error) {
    console.log("No se ha podido eliminar de favoritos", error);
  }
};

onMounted(favoriteForm);
</script>

<template>
  <v-card>
    <v-tabs v-model="tab" bg-color="primary">
      <v-tab value="all">Todos</v-tab>
      <v-tab value="Camiseta">Camisetas</v-tab>
      <v-tab value="Sudadera">Sudaderas</v-tab>
      <v-tab value="Taza">Tazas</v-tab>
      <v-tab value="Botella">Botellas</v-tab>
    </v-tabs>

    <v-card-text>
      <v-window v-model="tab">
        <v-window-item value="all">
          <div class="card-container">
            <v-row dense>
              <v-col v-for="card in filteredCards('all')" :cols="card.flex" :key="card.id">
                <FilterComponent :card="card" @cancel-favorite="cancelfavorite(card.id)" />
              </v-col>
            </v-row>
          </div>
        </v-window-item>
        <v-window-item value="Camiseta">
          <div class="card-container">
            <v-row dense>
              <v-col v-for="card in filteredCards('Camiseta')" :cols="card.flex" :key="card.id">
                <FilterComponent :card="card" @cancel-favorite="cancelfavorite(card.id)" />
              </v-col>
            </v-row>
          </div>
        </v-window-item>
        <v-window-item value="Sudadera">
          <div class="card-container">
            <v-row dense>
              <v-col v-for="card in filteredCards('Sudadera')" :cols="card.flex" :key="card.id">
                <FilterComponent :card="card" @cancel-favorite="cancelfavorite(card.id)" />
              </v-col>
            </v-row>
          </div>
        </v-window-item>
        <v-window-item value="Taza">
          <div class="card-container">
            <v-row dense>
              <v-col v-for="card in filteredCards('Taza')" :cols="card.flex" :key="card.id">
                <FilterComponent :card="card" @cancel-favorite="cancelfavorite(card.id)" />
              </v-col>
            </v-row>
          </div>
        </v-window-item>
        <v-window-item value="Botella">
          <div class="card-container">
            <v-row dense>
              <v-col v-for="card in filteredCards('Botella')" :cols="card.flex" :key="card.id">
                <FilterComponent :card="card" @cancel-favorite="cancelfavorite(card.id)" />
              </v-col>
            </v-row>
          </div>
        </v-window-item>
      </v-window>
    </v-card-text>
  </v-card>
</template>

<style>
.v-slide-group__content{
  display: flex;
  justify-content: center;
}
</style>
