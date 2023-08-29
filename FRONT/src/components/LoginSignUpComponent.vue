<script setup>
import { ref } from 'vue';
import Connection from '../services/LoginDataService'
import router from "@/router"
import {myUserStore} from '@/services/PiniaStore'

const userStore = myUserStore();

const agreement = ref(false);
const dialog = ref(false);
const myEmail = ref(undefined);
const isValid = ref(false);
const isLoading = ref(false);
const myPass = ref(undefined);
const userName = ref(undefined);

const emailValidationRule = (v) => !!(v || '').match(/@/) || 'Please enter a valid email';
const lengthValidationRule = (len) => (v) => (v || '').length >= len || `Invalid character length, required ${len}`;
const passwordValidationRule = (v) => !!(v || '').match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*(_|[^\w])).+$/) || 'Password must contain an upper case letter, a numeric character, and a special character';
const requiredValidationRule = (v) => !!v || 'This field is required';

let rules = {
  email: emailValidationRule,
  length: lengthValidationRule,
  password: passwordValidationRule,
  required: requiredValidationRule,
};

function myReset() {
  location.reload();
}

function navigateBack() {
  router.push("/login")
}

async function SignUp() {

  if (myEmail.value != null) {

    const data = {
      userEmail: myEmail.value,
      userPassword: myPass.value,
      userName: userName.value,
      userFavs: userStore.uFavs 
    };

    try {
      const response = await Connection.signUp(data);
      console.log(response.data);
      if (response.data === "") {
        router.push("/loginSignUp");
      }
      else {
        userStore.uName=response.data.userName;
        userStore.uEmail=response.data.userEmail;
        userStore.uPass=response.data.userPassword;
        router.push("/favorites");        
      }
    }
    catch (error) {
      console.log(error);
    }

  }
}

</script>

<template>
  <v-card class="mx-auto" style="max-width: 500px">
    <v-toolbar color="primary" cards dark flat prominent>

      <v-btn icon>
        <v-icon @click="navigateBack()">mdi-arrow-left</v-icon>
      </v-btn>

      <v-card-title class="text-h6 font-weight-regular"> Alta de usuario </v-card-title>
      <v-spacer></v-spacer>
    </v-toolbar>
    <v-form ref="form" v-model="isValid" class="pa-4 pt-6">
      <v-text-field v-model="myPass" :rules="[rules.password, rules.length(6)]" variant="filled" color="deep-purple"
        counter="6" label="Password" style="min-height: 96px" type="password"></v-text-field>
      <v-text-field v-model="userName" variant="filled" color="deep-purple" label="Nombre de Usuario"></v-text-field>
      <v-text-field v-model="myEmail" :rules="[rules.email]" variant="filled" color="deep-purple" label="Email"
        type="email"></v-text-field>
      <v-checkbox v-model="agreement" :rules="[rules.required]" color="deep-purple">
        <template v-slot:label>
          acepto los&nbsp;
          <a href="#" @click.stop.prevent="dialog = true">Terminos del servicio</a>
          *
        </template>
      </v-checkbox>
    </v-form>
    <v-divider></v-divider>
    <v-card-actions>
      <v-btn variant="text" @click="myReset()"> Borrar </v-btn>
      <v-spacer></v-spacer>
      <v-btn :disabled="!isValid" :loading="isLoading" color="deep-purple-accent-4" @click="SignUp()">
        Enviar
      </v-btn>
    </v-card-actions>
    <v-dialog v-model="dialog" max-width="400" persistent>
      <v-card>
        <v-card-title class="text-h5 bg-grey-lighten-3"> Legal </v-card-title>
        <v-card-text>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud exercitation ullamco laboris nisi ut
          aliquip ex ea commodo consequat. Duis aute irure dolor in
          reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
          pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
          culpa qui officia deserunt mollit anim id est laborum.
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn variant="text" @click="agreement = false, dialog = false">
            No
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn color="deep-purple" variant="tonal" @click="agreement = true, dialog = false">
            Si
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-card>
</template>

