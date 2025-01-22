// store.js
import { reactive } from 'vue'
import router from './router';

export const store = reactive({
  user_id: localStorage.getItem('user_id') || 1,
  login(user_id) {
    this.user_id = user_id
    localStorage.setItem('user_id', user_id);
    window.location.reload();
  },
  logout() {
    this.user_id = null
  }
})
