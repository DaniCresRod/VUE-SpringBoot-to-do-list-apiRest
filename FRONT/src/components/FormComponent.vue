<script setup>
import { ref } from "vue";
import ProductData from "@/services/ProductDataService";

const prodMessage = ref("");
const messageRules = [
  (v) => !!v || "Frase es obligatoria",
  (v) => (v && v.length <= 20) || "La frase debe tener menos de 20 caracteres",
];
const prodType = ref(null);
const items = ["Camiseta", "Sudadera", "Taza", "Botella"];
const prodSizeOptions = ["S", "M", "L", "XL"];
const prodColorOptions = [
  "Blanco",
  "Negro",
  "Rojo",
  "Azul",
  "Amarillo",
  "Verde",
  "Rosa",
  "Violeta",
];
const prodSize = ref(null);
const prodColor = ref(null);
const checkbox = ref(false);
const response = ref(null);

const validateForm = async () => {
  try {
    const result = await ProductData.create({
      prodMessage: prodMessage.value,
      prodType: prodType.value,
      prodSize: (prodType.value === "Camiseta" || prodType.value === "Sudadera") ? prodSize.value : null,
      prodColor: prodColor.value,
      terms: checkbox.value,
    });
    response.value = result.data;
  } catch (error) {
    console.log(error);
  }
};
</script>

Listas con <span></span>

<template>
  <v-sheet width="300" class="mx-auto">
    <v-form ref="form">
      <v-text-field
        v-model="prodMessage"
        :counter="20"
        :rules="messageRules"
        label="Escribe una frase!"
        required
      ></v-text-field>

      <v-select
        v-model="prodType"
        :items="items"
        :rules="[v => !!v || 'El tipo de producto es necesario']"
        label="Producto"
        required
      ></v-select>

      <v-select
        v-if="prodType === 'Camiseta' || prodType === 'Sudadera'"
        v-model="prodSize"
        :items="prodSizeOptions"
        :rules="[v => !!v || 'La talla es necesaria']"
        label="Talla"
      ></v-select>

      <v-select
        v-model="prodColor"
        :items="prodColorOptions"
        :rules="[v => !!v || 'El color es obligatorio']"
        label="Color"
      ></v-select>

      <v-checkbox
        v-model="checkbox"
        :rules="[v => !!v || 'Acepta para continuar']"
        label="¿Estás de acuerdo?"
        required
      ></v-checkbox>

      <div class="d-flex flex-column">
        <v-btn
          class="mt-4"
          block
          @click="validateForm"
        >
          Validar
        </v-btn>
      </div>
    </v-form>
  </v-sheet>
</template>

<style scoped>

.mt-4 {
  text-decoration: none;
  transition: 0.3s;
  background-color: rgba(54, 157, 178, 1);
  color: white;
}
.mt-4:hover{

  letter-spacing: 0.15rem;
  padding: 0 1rem;
  font-weight: bolder;
}
</style>
