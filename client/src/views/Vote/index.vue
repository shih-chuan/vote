<script setup>
import { reactive, ref, onMounted, computed } from 'vue';
import Container from "@/components/Container/index.vue"
import Option from "@/components/Option/index.vue"
import Empty from "@/components/Empty/index.vue"
import { api } from '../../apis/https';
import { store } from '../../store';
defineProps({
  msg: String,
})

const state = reactive({options: []})

onMounted(() => {
  fetchData()
})

async function fetchData() {
  const optionRes = await api.get("/options")
  const voteRes = await api.get(`/users/${store.user_id}/votes`)
  let options = optionRes.data
  let selections = voteRes.data
  state.options = options.map(option => {
    return {...option, selected: selections.includes(option.id)}
  })
}

const totalVotes = computed(() => {
  let total = 0;
  for (let option of state.options) {
    total += option.votes
  }
  return total
});

</script>

<template>
  <Container>
    <div class="options">
      <Empty v-if="state.options.length <= 0"/>
      <Option
        v-for="(item, i) in state.options"
        :key="item.id"
        :votes="item.votes"
        :totalVotes="totalVotes"
        :selected="item.selected"
        :isEditing="false"
        :id="item.id"
        :label="item.label"
        @refresh="fetchData"
      />
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
</style>
