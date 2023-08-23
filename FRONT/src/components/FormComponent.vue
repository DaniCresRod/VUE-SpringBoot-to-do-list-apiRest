<script setup>
import { ref } from "vue";
import ProductData from "@/services/ProductDataService";

const name = ref("");
const nameRules = [
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

const validate = async () => {
  const { valid } = await $refs.form.validate();

  if (valid) {
    try {
      const result = await ProductData.create({
        name: name.value,
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
}
};

const reset = () => {
  $refs.form.reset();
};

const resetValidation = () => {
  $refs.form.resetValidation();
};
</script>

<template>
  <v-sheet width="300" class="mx-auto">

    <v-form ref="form">
      <v-text-field
        v-model="name"
        :counter="20"
        :rules="nameRules"
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
          color="success"
          class="mt-4"
          block
          @click="validate"
        >
          Validar
        </v-btn>

        <v-btn
          color="error"
          class="mt-4"
          block
          @click="reset"
        >
          Resetea Formulario
        </v-btn>

        <v-btn
          color="warning"
          class="mt-4"
          block
          @click="resetValidation"
        >
          Cancela envío
        </v-btn>
      </div>
    </v-form>
  </v-sheet>
</template>
