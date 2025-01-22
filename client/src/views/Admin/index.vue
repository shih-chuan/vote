<script setup>
import Container from "@/components/Container/index.vue"
import { reactive, ref, onMounted, computed } from 'vue';
import Option from "@/components/Option/index.vue"
import { api } from '../../apis/https';
import { toast } from "vue3-toastify";
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
    fetchData()
    toast.success(`新增成功 ${labelInput.value}`)
    labelInput.value = ""
  })
}
</script>

<template>
  <Container>
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
  </Container>
</template>

<style scoped>
.options {
  position: relative;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
  padding-top: 30px;
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
  @media (max-width: 768px) {
    .title {
      max-width: 150px;
    }
  }
}
</style>
