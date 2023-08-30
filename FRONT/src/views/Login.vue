<script setup>
import { ref } from 'vue'
import Connection from '../services/LoginDataService'
import router from '@/router';
import {myUserStore} from '@/services/PiniaStore'

const visible=ref();
const myEmail=ref();
const myPass=ref();

const favsArray1=ref([])

const userStore = myUserStore();

const showConfirmation = ref(false); 

async function Login(){

  if(myEmail.value!=null){

  const data = {
    userEmail: myEmail.value,
    userPassword: myPass.value
  };
  try{
    const response=await Connection.create(data);
    if (response.data !== "") {
      userStore.uEmail = response.data.userEmail;
      userStore.uName = response.data.userName;
      userStore.uPass = response.data.userPassword;

      if( (response.data.userFavs)!==null){
      (JSON.parse(response.data.userFavs)).forEach(element => {
        favsArray1.value.push(element);
      });
    }
      if(userStore.uFavs!==""){
        (JSON.parse(userStore.uFavs)).forEach(element => {

          let duplicated=false;
          (favsArray1.value).forEach(eachComp=>{

            if((((eachComp.prodMessage).localeCompare(element.prodMessage))
              +((eachComp.prodType).localeCompare(element.prodType))
              +((eachComp.prodColor).localeCompare(element.prodColor))===0)
            )
            {
              if(((eachComp.prodSize)===null)||((element.prodSize)===null)){
                if(((eachComp.prodSize)===null)&&((element.prodSize)===null)){
                  duplicated=true;
                }
              }
              else if (((eachComp.prodSize).localeCompare(element.prodSize))===0){
                duplicated=true;
              }
            }
          });

          if(!duplicated){
            favsArray1.value.push(element);
          }
        });
      }
      userStore.uFavs = JSON.stringify(favsArray1.value);

      const favsData = {
          userEmail: userStore.uEmail,
          userPassword: userStore.uPass,
          userName: userStore.uName,
          userFavs: userStore.uFavs
        };

        Connection.saveFavs(favsData);

      router.push("/favs");
    }
    else{
        showConfirmation.value = true;
    }
  }
  catch(error){
    console.log(error);
  }
  }
}
</script>

<template>
    <div>
      <v-card
        class="mx-auto pa-12 pb-8"
        elevation="8"
        max-width="448"
        rounded="lg"
      >
        <div class="text-subtitle-1 text-medium-emphasis">Email</div>
        <v-text-field
          v-model="myEmail"
          density="compact"
          placeholder="Email"
          prepend-inner-icon="mdi-email-outline"
          variant="outlined"
        ></v-text-field>

        <div
          class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
          Contraseña
        </div>

        <v-text-field
          v-model="myPass"
          :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
          :type="visible ? 'text' : 'password'"
          density="compact"
          placeholder="Introduce tu contraseña"
          prepend-inner-icon="mdi-lock-outline"
          variant="outlined"
          @click:append-inner="visible = !visible"
        ></v-text-field>

        <v-btn block class="mb-8" color="blue" size="large" variant="tonal" @click="Login()">
          Acceder
        </v-btn>

        <div v-if="showConfirmation" class="confirMessage">
          El usuario no existe.
        </div>

        <v-card-text class="text-center">

          <router-link to="/SignUp">
            Darse de alta <v-icon icon="mdi-chevron-right"></v-icon>
          </router-link>
        </v-card-text>
      </v-card>
    </div>
</template>

<style scoped>
.confirMessage {
  color: red;
  margin-top: 10px;
}

a{
  text-decoration: none;
  font-weight: bolder;
  font-size: 1.2rem;
}

a:visited{
  color:rgba(54, 157, 178, 1);
 }
 
</style>
