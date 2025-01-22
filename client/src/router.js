import { createMemoryHistory, createRouter } from 'vue-router'
import { store } from './store.js'

import Admin from './views/Admin/index.vue'
import Vote from './views/Vote/index.vue'
import Login from './views/Login/index.vue'

const routes = [
  { path: '/login', component: Login },
  { path: '/admin', component: Admin },
  { path: '/', component: Vote },
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

// router.beforeEach(async (to, from) => {
//   console.log(to.path)
//   if (
//     // make sure the user is authenticated
//     !store.user &&
//     // ❗️ Avoid an infinite redirect
//     to.path !== '/login'
//   ) {
//     // redirect the user to the login page
//     return { path: '/login' }
//   }
//   return to
// })

export default router
