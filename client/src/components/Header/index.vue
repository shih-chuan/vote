<script setup>
import { RouterLink } from 'vue-router'
import { store } from '@/store.js'
import { onMounted, reactive } from 'vue'
import { api } from '../../apis/https'
const users = reactive([])

onMounted(() => {
  fetchData()
})

async function fetchData() {
  const res = await api.get("/users")
  users.length = 0
  users.push(...res.data)
  console.log(users)
}
</script>

<template>
  <div class="header">
    <nav>
      <RouterLink class="nav-item" to="/">前往投票</RouterLink>
      <RouterLink class="nav-item" to="/admin">管理後臺</RouterLink>
    </nav>
    <div>
      <label>切換使用者： </label>
      <select @input="event => {
        store.login(event.target.value)
      }">
        <option
          v-for="(user, i) in users"
          :key="user.id"
          :value="user.id"
          :name="user.name"
          :selected="store.user_id && store.user_id == user.id"
        >
          {{user.name}}
        </option>
      </select>
    </div>
  </div>
</template>

<style scoped lang="scss">
.header {
  display: flex;
  justify-content: space-between;
  padding: 0 50px;
  nav {
    display: flex;
    gap: 10px;
  }
}
</style>
