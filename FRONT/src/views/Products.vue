<script setup>
import { ref, onMounted } from "vue";
import ProductData from "@/services/ProductDataService";
import FilterComponent from "@/components/FilterComponent/FilterCard.vue";

const selectedProdType = ref("");
const cards = ref([]);
const tab = ref("all");

const generateSrc = (prodType) => {
  const placeholderImages = {
    Camiseta: "https://www.monsterstoys.com/wp-content/uploads/2023/02/CAMISETA-NEGRA-e1676027065965.jpg",
    Sudadera: "https://static.wixstatic.com/media/f279e0_717c28f4e9754363ad5405f2e413de17~mv2.jpg/v1/fill/w_530,h_530,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/f279e0_717c28f4e9754363ad5405f2e413de17~mv2.jpg",
    Taza: "data:image/jpeg;base64,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",
    Botella: "https://www.regalospublicitarios.com/65901-thickbox_default/botella-de-aluminio-750-ml-big-moss.jpg",
  };

  return placeholderImages[prodType] || "https://ruta-de-tu-servidor/placeholder-generic.jpg";
};

const favoriteForm = async () => {
  try {
    const response = await ProductData.getAll();
    cards.value = response.data.map((product) => ({
      id: product.id,
      prodMessage: product.prodMessage,
      prodType: product.prodType,
      prodSize: product.prodSize,
      prodColor: product.prodColor,
      src: generateSrc(product.prodType),
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
