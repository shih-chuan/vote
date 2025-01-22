<script setup>
import Container from "@/components/Container/index.vue"
import { RouterLink } from 'vue-router'
import { store } from '@/store.js'
import { onMounted, reactive, ref } from 'vue'
import { api } from '../../apis/https'
import { toast } from "vue3-toastify"
const users = reactive([])
const nameInput = ref("")

onMounted(() => {
  fetchData()
})

async function fetchData() {
  const res = await api.get("/users")
  users.length = 0
  users.push(...res.data)
}

const add = () => {
  api.post("/users", {"name": nameInput.value}).then(res => {
    fetchData()
    toast.success(`新增成功 ${nameInput.value}`)
    nameInput.value = ""
  })
}
</script>

<template>
  <div class="header">
    <Container>
      <div class="header-body">
        <nav>
          <RouterLink class="nav-item button" :to="`/`">投票</RouterLink>
          <RouterLink class="nav-item button" :to="`/admin`">管理後臺</RouterLink>
        </nav>
        <div class="user-controls">
          <div class="add-form">
            <input class="title" type="text" placeholder="輸入使用者名稱" v-model="nameInput"/>
            <span class="controls">
              <button @click="add">註冊</button>
            </span>
          </div>
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
      </div>
    </Container>
  </div>
</template>

<style scoped lang="scss">
.header {
  position: relative;
  width: 100%;
  .header-body {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    nav {
      display: flex;
      gap: 10px;
    }
  }
  .user-controls {
    display: flex;
    flex-direction: column;
    align-items: start;
    gap: 5px;
    .add-form {
      display: flex;
      button {
        background-color: blue;
        padding: 5px;
        font-size: 14px;
      }
    }
  }
  @media (max-width: 768px) {
    .header-body {
      flex-direction: column;
      gap: 15px;
      nav {
        width: 100%;
        .nav-item {
          width: 100%;
        }
      }
      .user-controls {
        width: 100%;
        .add-form {
          position: relative;
          width: 100%;
          height: 40px;
          input {
            width: 100%;
          }
          button {
            width: 70px;
            height: 100%;
          }
        }
      }
    }
  }
}
</style>
