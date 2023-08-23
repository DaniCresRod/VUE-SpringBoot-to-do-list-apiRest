<script setup>
import { ref } from "vue";
import ProductData from "@/services/ProductDataService";

const message = ref("");
const messageRules = [
  (v) => !!v || "Frase es obligatoria",
  (v) => (v && v.length <= 20) || "Name must be less than 20 characters",
];
const select = ref(null);
const items = ["Camiseta", "Sudadera", "Taza", "Botella"];
const size = ["S", "M", "L", "XL"];
const colour = [
  "Blanco",
  "Negro",
  "Rojo",
  "Azul",
  "Amarillo",
  "Verde",
  "Rosa",
  "Violeta",
];
const checkbox = ref(false);
const response = ref(null);

const validate = async ({}) => {
    try {
      const result = await ProductData.create({
        message: message.value,
        product: select.value,
        size:
          select.value === "Camiseta" || select.value === "Sudadera"
            ? size.value
            : null,
        color: colour.value,
        terms: checkbox.value,
      });
      response.value = result.data;
    } catch (error) {
      console.log(error);
  }
};

</script>

<template>
  <v-sheet width="300" class="mx-auto">

    <v-form ref="form">
      <v-text-field
        v-model="message"
        :counter="20"
        :rules="messageRules"
        label="Escribe una frase!"
        required
      ></v-text-field>

      <v-select
        v-model="select"
        :items="items"
        :rules="[v => !!v || 'El tipo de producto es necesario']"
        label="Producto"
        required
      ></v-select>

      <v-select
        v-if="select === 'Camiseta' || select === 'Sudadera'"
        :items="size"
        :rules="[v => !!v || 'La talla es necesaria']"
        label="Talla"
      ></v-select>

      <v-select
        :items="colour"
        :rules="[v => !!v || 'El color es obligatorio']"
        label="Color"
      ></v-select>

      <v-checkbox
        v-model="checkbox"
        :rules="[v => !!v || 'Acepta para continuar']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <div class="d-flex flex-column">
        <v-btn
          class="mt-4"
          block
          @click="validate"
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