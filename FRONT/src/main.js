import App from './App.vue'
import { createPinia } from 'pinia';

import './assets/styles/global.css'; 
import { createApp } from 'vue'
import { registerPlugins } from '@/plugins'

const app = createApp(App)

const pinia = createPinia();

registerPlugins(app)

app.use(pinia);
app.mount('#app')