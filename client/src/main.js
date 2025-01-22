import { createApp } from 'vue'
import router from './router'
import 'vue3-toastify/dist/index.css';
import './style.css'
import App from './App.vue'

createApp(App).use(router).mount('#app')
