// store.js
import { reactive } from 'vue'

export const store = reactive({
  user_id: localStorage.getItem('user_id'),
  login(user_id) {
    this.user_id = user_id
    localStorage.setItem('user_id', user_id);
  },
  logout() {
    this.user_id = null
  }
})
