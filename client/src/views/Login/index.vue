<script setup>
import { reactive, ref, onMounted, computed } from 'vue';
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
}

const add = () => {
  api.post("/options", {"label": labelInput.value}).then(res => {
    fetchData()
  })
}

const totalVotes = computed(() => {
  let total = 0;
  for (let option of options) {
    total += option.votes
  }
  return total
});

</script>

<template>
  <div class="container">
    <select name="cars" id="cars">
      <option value="volvo">Volvo</option>
      <option value="saab">Saab</option>
      <option value="mercedes">Mercedes</option>
      <option value="audi">Audi</option>
    </select>
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
