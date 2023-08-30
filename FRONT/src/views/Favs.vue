<script setup>
import { ref } from "vue";
import ProductData from "@/services/ProductDataService";
import {myUserStore} from '@/services/PiniaStore';
import Connection from '../services/LoginDataService';
import router from "@/router"

const cards = ref([]);
const userStore = myUserStore();
const favsArray= ref([]);

const favoriteForm = async () => {
  try {
      if(userStore.uFavs!==''){
        (JSON.parse(userStore.uFavs)).forEach(element => {
          favsArray.value.push(element);
        });

        cards.value = favsArray.value.map(product => ({
        prodMessage: product.prodMessage,
        prodType: product.prodType,
        prodSize: product.prodSize,
        prodColor: product.prodColor,
        src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 12,
        }));
      }  
  } 
  catch (error) {
    console.log(error);
  }
};

function deleteFavs(event){
  console.log(event.target.parentNode.parentNode.parentNode.parentNode.parentNode);
  console.log(event.target.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes);
  
  let myTarget=event.target.parentNode.parentNode.parentNode.parentNode.parentNode;
  let parentOfTarget=event.target.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes;
  
  let indexOfTarget=Array.from(parentOfTarget).indexOf(myTarget);

  favsArray.value=JSON.parse(userStore.uFavs);

  (favsArray.value).splice(indexOfTarget-1,1);

  userStore.uFavs=JSON.stringify(favsArray.value);

  if(userStore.uEmail!==''){
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
  router.push("/refreshFavs");
}

favoriteForm();
</script>

<template>
    <v-card
      class="mx-auto"
      max-width="500"
    >
      <v-container fluid>
        <v-row dense>
          <v-col
            v-for="card in cards"
            :key="card.id"
            :cols="card.flex"
          >
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
               
                <v-card-subtitle class="mt-4 text-subtitle-2" v-text="'Talla ' + (card.prodType === 'Camiseta' || card.prodType === 'Sudadera' ? card.prodSize : 'Única')"></v-card-subtitle>
                <v-spacer></v-spacer>
  
                <v-btn size="medium" color="surface-variant" variant="text" @click="deleteFavs"><i class="fas fa-heart-broken"></i></v-btn>

                <v-btn size="medium" color="surface-variant" variant="text"><i class="fa fa-shopping-cart" aria-hidden="true"></i></v-btn>
  
                <v-btn size="small" color="surface-variant" variant="text" icon="mdi-share-variant"></v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
</template>