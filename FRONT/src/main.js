/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'
import { createPinia } from 'pinia';

//Estilos globales
import './assets/styles/global.css'; // Importa el archivo de estilos globales


// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'

const app = createApp(App)

// Crea una instancia de Pinia
const pinia = createPinia();

registerPlugins(app)

app.use(pinia);
app.mount('#app')