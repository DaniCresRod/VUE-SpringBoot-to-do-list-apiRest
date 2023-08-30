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

async function Login(){

  if(myEmail.value!=null){      
     
  const data = {
    userEmail: myEmail.value,
    userPassword: myPass.value
  };
  console.log(favsArray1.value);
  try{
    const response=await Connection.create(data);
    console.log(response.data);
    if (response.data !== "") {

      userStore.uEmail = response.data.userEmail;
      userStore.uName = response.data.userName;
      userStore.uPass = response.data.userPassword;
      //userStore.uFavs = response.data.userFavs;
      
      if( (response.data.userFavs)!==null){

     
      console.log(JSON.parse(response.data.userFavs));
      //Pasa al array los favoritos que pudiera haber en la base de datos
      (JSON.parse(response.data.userFavs)).forEach(element => {        
        favsArray1.value.push(element);        
      });
      console.log(favsArray1.value);
    }
      //Pasa al array los favoritos que haya en pinia, si hay...
      if(userStore.uFavs!==""){
        (JSON.parse(userStore.uFavs)).forEach(element => {

          console.log(element);
          console.log(favsArray1.value);

          let duplicated=false;

          (favsArray1.value).forEach(eachComp=>{            

            //Revisa cada valor de cada componente del array y lo compara con los favoritos
            //Si encuentra alguna coincidencia total, no deja que ese elemento se guarde
            if((((eachComp.prodMessage).localeCompare(element.prodMessage))
              +((eachComp.prodType).localeCompare(element.prodType))
              +((eachComp.prodColor).localeCompare(element.prodColor))===0)              
            ){ 
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

          // if(!((favsArray1.value).includes(element))){
          //   favsArray1.value.push(element);
          // }        
        });
      }      
      console.log(favsArray1.value);
      //Mete en pinia todos los favoritos para poder visualizarlos
      userStore.uFavs = JSON.stringify(favsArray1.value);
      console.log(userStore.uFavs);
      //Resubir nuevos favoritos a la base de datos 
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

      //Aqui va un mensaje de que ese usuario NO existe en la base de datos
      
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
          class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between"
        >
          Contraseña
  
          <!-- <a
            class="text-caption text-decoration-none text-blue"
            href="#"
            rel="noopener noreferrer"
            target="_blank"
          >
            Forgot login password?</a
          > -->
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
  
        <v-card-text class="text-center">
          <!-- <a
            class="text-blue text-decoration-none"
            href="/loginSignUp"
            rel="noopener noreferrer"
            target="_self"
          > -->
          <router-link to="/SignUp">
            Darse de alta <v-icon icon="mdi-chevron-right"></v-icon>
          </router-link>
            <!-- </a> -->
        </v-card-text>
      </v-card>
    </div>
  </template>