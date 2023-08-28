<script setup>
import { ref, computed } from "vue";
import ProductData from "@/services/ProductDataService";

const prodMessage = ref("");
const messageRules = [
  (v) => !!v || "Frase es obligatoria",
  (v) => (v && v.length <= 20) || "La frase debe tener menos de 20 caracteres",
];
const prodType = ref("");
const items = ["Camiseta", "Sudadera", "Taza", "Botella"];
const prodSizeOptions = ["S", "M", "L", "XL"];
const prodColorOptions = [
  "Blanco",
  "Negro",
  "Azul",
];
const prodSize = ref("");
const prodColor = ref("");
const checkbox = ref(false);

// Función validación para activar/desactivar el botón de envío de formulario
let isFormValid = computed(() => {
  return (
    prodMessage.value.length > 0 &&
    prodMessage.value.length <= 20 &&
    !!prodMessage.value &&
    !!prodType.value &&
    (!["Camiseta", "Sudadera"].includes(prodType.value) || !!prodSize.value) &&
    !!prodColor.value &&
    checkbox.value
  );
});

const form = ref("");
const showConfirmation = ref(false); // Variable para controlar la visibilidad del mensaje de confirmación

const validateForm = async () => {
  if (isFormValid.value) {
    try {
      const result = await ProductData.create({
        prodMessage: prodMessage.value,
        prodType: prodType.value,
        prodSize:
          prodType.value === "Camiseta" || prodType.value === "Sudadera"
            ? prodSize.value
            : null,
        prodColor: prodColor.value,
        terms: checkbox.value,
      });

      // Mostrar el mensaje de confirmación al enviar el form
      showConfirmation.value = true;
      // Deasctivar el botón al enviar el form
      isFormValid = false;

      // Actualizar la página después de 1.5 segundos
      setTimeout(() => {
        location.reload();
       }, 1500);

    } catch (error) {
      console.log(error);
    }
  }

};

</script>

Listas con <span></span>

<template>
  <h2>Personaliza tu propio producto</h2>
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
        <!-- Botón con validación -->
        <v-btn ref="formBtn" class="mt-4" block :disabled="!isFormValid" @click="validateForm">
          Enviar Modelo
        </v-btn>
      </div>

      <!-- Mensaje de confirmación -->
      <div v-if="showConfirmation" class="confirMessage">
        ¡El formulario se ha enviado correctamente!
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
.confirMessage {
  color: green;
  margin-top: 10px;
}
h2{text-align: center;
padding: 10px 0px 35px;}
</style>
