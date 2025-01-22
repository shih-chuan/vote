<script setup>
import { reactive, ref, onMounted, computed } from 'vue';
import Option from "@/components/Option/index.vue"
import { api } from '../../apis/https';
defineProps({
  msg: String,
})

const labelInput = ref("")
const options = reactive([])

onMounted(() => {
  fetchData()
})

async function fetchData() {
  const res = await api.get("/options")
  options.length = 0
  options.push(...res.data)
  console.log(options)
}

const totalVotes = computed(() => {
  let total = 0;
  for (let option of options) {
    total += option.votes
  }
  return total
});

const add = () => {
  api.post("/options", {"label": labelInput.value}).then(res => {
    console.log(res)
    fetchData()
  })
}
</script>

<template>
  <div class="container">
    <div class="options">
        <Option
          v-for="(item, i) in options"
          :key="item.id"
          :votes="item.votes"
          :totalVotes="totalVotes"
          :isEditing="true"
          :id="item.id"
          :label="item.label"
          @refresh="fetchData"
        />
      <div class="add-form">
        <input class="title" type="text" placeholder="輸入選項" v-model="labelInput"/>
        <div class="controls">
          <button class="button" @click="add">新增</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 60px 0;
}
.options {
  position: relative;
  width: 600px;
  max-width: 100%;
  display: flex;
  flex-direction: column;
  gap: 20px;
}
.add-form {
  width: 100%;
  display: flex;
  justify-content: space-between;
  padding: 15px 20px;
  background-color: #1a1a1a;
  border-radius: 10px;
  .title {
    font-size: 22px;
    font-weight: bold;
  }
}
</style>
