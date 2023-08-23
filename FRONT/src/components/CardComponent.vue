<script setup>
import ProductDataService from '@/services/ProductDataService';
import {ref} from 'vue';

const newProduct=ref();
const selectedSize = ref("");
const sizes = ["S", "M", "L", "XL"];
const selectedColor = ref("");
const colors = ["Rojo", "Azul", "Verde", "Amarillo"];
const name = ref("");
const selectedITem = ref("");
const items = ["Camiseta", "Pantalón", "Vestido", "Falda"];
const response = ref(null);

function createNewProduct(){
    ProductDataService.create(newProduct.value)
    .then(response => {
        console.log(response.data);
        newProduct.value.name= response.data.name;
        newProduct.value.item= response.data.type;
        newProduct.value.color= response.data.color;
        newProduct.value.size= response.data.size;
        newProduct.value.message= response.data.message;
    } 
    )
}

 const submitForm = async () => {
      try {
        const result = await axios.post( {
          size: selectedSize.value,
          color: selectedColor.value,
          name: name.value,
          message: message.value,
          item: selectedItem.value
        });
        response.value = result.data;
      } catch (error) {
        console.log(error);
      }
    };

    return {
      selectedSize,
      sizes,
      selectedColor,
      colors,
      name,
      selectedItem,
      types,
      response,
      submitForm
    };

</script>

<template> 
<form @submit.prevent="createNewProduct">
    <div>
      <label for="name-input">Nombre:</label>
      <input id="name-input" type="text" v-model="name" />
    </div>
    <div>
      <label for="mensaje-select">Mensaje:</label>
      <select id="mensaje-select" v-model="selectedSize">
        <option disabled value="">Introduce una frase!</option>
        <option v-for="size in sizes" :key="size" :value="size">{{ size }}</option>
      </select>
    </div>
    <div>
      <label for="type-select">Tipo:</label>
      <select id="type-select" v-model="selectedItem">
        <option disabled value="">Selecciona un tipo</option>
        <option v-for="item in items" :key="item" :value="item">{{ type }}</option>
    </select>
    </div>
    <div>
      <label for="size-select">Talla:</label>
      <select id="size-select" v-model="selectedSize">
        <option disabled value="">Selecciona una talla</option>
        <option v-for="size in sizes" :key="size" :value="size">{{ size }}</option>
      </select>
    </div>
    <div>
      <label for="color-select">Color:</label>
      <select id="color-select" v-model="selectedColor">
        <option disabled value="">Selecciona un color</option>
        <option v-for="color in colors" :key="color" :value="color">{{ color }}</option>
      </select>
    </div>
   
    <button type="submit" @click="submitForm" >Validar</button>
</form>


</template>