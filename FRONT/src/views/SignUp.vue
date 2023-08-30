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

const emailValidationRule = (v) => !!(v || '').match(/@/) || 'Introduce una dirección de email válida';
const lengthValidationRule = (len) => (v) => (v || '').length >= len || `Se requiere una longitud de ${len} caracteres`;
const passwordValidationRule = (v) => !!(v || '').match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*(_|[^\w])).+$/) || 'La contraseña debe incluir, al menos, una mayúscula, un número y un caracter especial';
const requiredValidationRule = (v) => !!v || 'Este campo es obligatorio';

let rules = {
  email: emailValidationRule,
  length: lengthValidationRule,
  password: passwordValidationRule,
  required: requiredValidationRule,
};

function myReset() {
  router.push("/blank");
}

function navigateBack() {
  router.push("/login");
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
      const response = await Connection.SignUp(data);
      if (response.data === "") {

        router.push("/SignUp");
      }
      else {
        userStore.uName=response.data.userName;
        userStore.uEmail=response.data.userEmail;
        userStore.uPass=response.data.userPassword;

        const favsData = {
          userEmail: userStore.uEmail,
          userPassword: userStore.uPass,
          userName: userStore.uName,
          userFavs: userStore.uFavs
        };

        Connection.saveFavs(favsData);

        router.push("/favs");
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
          Acepto los&nbsp;
          <a href="#" @click.stop.prevent="dialog = true">Términos del servicio</a>
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
        <v-card-title class="text-h5 bg-grey-lighten-3"> Aviso Legal </v-card-title>
        <v-card-text>
          Bajo el reglamento europeo los consumidores tienen los siguientes derechos:

Derecho al acceso – a ver u obtener los datos personales que se han recopilado
Derecho a la rectificación – a corregir datos incompletos o incorrectos sobre ellos
Derecho a la eliminación – a pedir la eliminación de sus datos personales (también conocido como “”derecho al olvido””)
Derecho a la restricción al tratamiento – a limitar qué datos personales sobre ellos pueden ser tratados y con qué fines
Derecho a oposición (al tratamiento) – a rechazar totalmente el tratamiento de sus datos
Derecho a la notificación – en relación a la rectificación, eliminación, o restricción del tratamiento
Derecho a la portabilidad – a recibir una copia de sus datos en un formato empleable para ser llevados a otro lugar
Derecho en relación a la toma de decisiones automatizada, incluyendo la cración de perfiles – a rechazar el uso de tecnologías para tomar decisiones sobre el usuario        </v-card-text>
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
