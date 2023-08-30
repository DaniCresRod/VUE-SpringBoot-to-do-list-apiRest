<script setup>
import { ref, computed, defineProps, defineEmits } from "vue";
import ProductData from "@/services/ProductDataService";
import { myUserStore } from '@/services/PiniaStore'
import router from "@/router";
import Connection from '../services/LoginDataService'


const prodMessage = ref("");
const messageRules = [
  (v) => !!v || "Frase es obligatoria",
  (v) => (v && v.length <= 30) || "La frase debe tener menos de 30 caracteres",
];
const prodType = ref("");
const items = ["Camiseta", "Sudadera", "Taza", "Botella"];
const prodSizeOptions = ["S", "M", "L", "XL"];
const prodColorOptions = [
  "Blanco",
  "Negro",
  "Azul",
];
const prodId=ref();
const prodSize = ref("");
const prodColor = ref("");
const checkbox = ref(false);
const favsArray= ref([]);

let isFormValid = computed(() => {
  return (
    prodMessage.value.length > 0 &&
    prodMessage.value.length <= 30 &&
    !!prodMessage.value &&
    !!prodType.value &&
    (!["Camiseta", "Sudadera"].includes(prodType.value) || !!prodSize.value) &&
    !!prodColor.value &&
    checkbox.value
  );
});

const form = ref("");
const showConfirmation = ref(false); 
const overlay = defineProps(['overlay']); 
const emit = defineEmits(['closeOverlay']); 

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

      const userStore = myUserStore();
      let thisArticle={
        prodMessage: prodMessage.value,
        prodType: prodType.value,
        prodSize:
          prodType.value === "Camiseta" || prodType.value === "Sudadera"
            ? prodSize.value
            : null,
        prodColor: prodColor.value,
        terms: checkbox.value
      }
      
      if(userStore.uFavs!==''){
        (JSON.parse(userStore.uFavs)).forEach(element => {
          favsArray.value.push(element);
        });
      }

      let duplicated = false;
      (favsArray.value).forEach(eachComp => {

        if ((((eachComp.prodMessage).localeCompare(thisArticle.prodMessage))
          + ((eachComp.prodType).localeCompare(thisArticle.prodType))
          + ((eachComp.prodColor).localeCompare(thisArticle.prodColor)) === 0)) {

          if (((eachComp.prodSize) === null) || ((thisArticle.prodSize) === null)) {
            if (((eachComp.prodSize) === null) && ((thisArticle.prodSize) === null)) {
              duplicated = true;
            }
          }
          else if (((eachComp.prodSize).localeCompare(thisArticle.prodSize)) === 0) {
            duplicated = true;
          }
        }
      });

      if (!duplicated) {
        favsArray.value.push(thisArticle);
      }

      userStore.uFavs=JSON.stringify(favsArray.value);

      if(userStore.uEmail!==''){
        const data = {
          userEmail: userStore.uEmail,
          userPassword: userStore.uPass
        };

        try{
          const favsData = {
          userEmail: userStore.uEmail,
          userPassword: userStore.uPass,
          userName: userStore.uName,
          userFavs: userStore.uFavs
        };
        Connection.saveFavs(favsData);
        }
        catch(error){
          console.log(error);
        }
      }

      showConfirmation.value = true;
      isFormValid = false;

      setTimeout(() => {
        emit('closeOverlay', false);
        router.push("/");
       }, 1500);

    } catch (error) {
      console.log(error);
    }
  }
};
</script>

<template>
  <h2>Personaliza tu propio producto</h2>
  <v-sheet width="300" class="mx-auto">
    <v-form ref="form">
      <v-text-field
        v-model="prodMessage"
        :counter="30"
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
        <v-btn ref="formBtn" class="mt-4" block :disabled="!isFormValid" @click="validateForm">
          Enviar Modelo
        </v-btn>
      </div>

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

h2{
  text-align: center;
  padding: 10px 0px 35px;
}
</style>
