<script setup>
import { toast } from 'vue3-toastify';
import { ref } from 'vue'
import { api } from '../../apis/https';
import { store } from '../../store';

const props = defineProps({
  id: Number,
  label: {type: String},
  votes: {type: Number, default: 1},
  totalVotes: {type: Number, default: 12},
  selected: {type: Boolean, default: false},
  isEditing: {type: Boolean, default: false},
})
const emit = defineEmits(['refresh'])
const labelInput = ref(props.label)

const save = () => {
  api.put(`options/${props.id}`, {"label": labelInput.value}).then((res) => {
    toast.success(`已儲存 ${labelInput.value}`)
  })
}
const handleDelete = () => {
  api.delete(`options/${props.id}`).then((res) => {
    emit("refresh")
    toast.success(`已刪除 ${props.label}`)
  })
}

const handleVote = () => {
  if (props.selected) {
    api.delete(`votes`, {params: {userId: store.user_id, optionId: props.id}}).then((res) => {
      emit("refresh")
      toast.success(`已取消投票 ${props.label}`)
    })
  } else {
    api.post(`votes`, {userId: store.user_id, optionId: props.id}).then((res) => {
      emit("refresh")
      toast.success(`已投票 ${props.label}`)
    })
  }
}

</script>

<template>
  <div class="option">
    <button class="checkbox-wrapper"  @click="handleVote" v-if="!isEditing">
      <div class="checkbox">
        <div class="check" v-if="selected">
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"  width="100%" height="100%" version="1.1" id="Capa_1" viewBox="0 0 17.837 17.837" xml:space="preserve">
            <g>
              <path d="M16.145,2.571c-0.272-0.273-0.718-0.273-0.99,0L6.92,10.804l-4.241-4.27   c-0.272-0.274-0.715-0.274-0.989,0L0.204,8.019c-0.272,0.271-0.272,0.717,0,0.99l6.217,6.258c0.272,0.271,0.715,0.271,0.99,0   L17.63,5.047c0.276-0.273,0.276-0.72,0-0.994L16.145,2.571z"/>
            </g>
          </svg>
        </div>
      </div>
    </button>
    <div class="info-wrapper">
      <div class="info-header">
        <div class="title" v-if="!isEditing">{{ label }}</div>
        <input class="title" type="text" placeholder="輸入選項" v-model="labelInput" v-if="isEditing" />
        <div class="ratio">{{totalVotes > 0 ? (votes/totalVotes * 100).toFixed(1)  : 0}}%</div>
      </div>
      <div class="progress">
        <div class="value" :style="{width: `${totalVotes > 0 ? (votes/totalVotes * 100).toFixed(1)  : 0}%`}"></div>
      </div>
      <div class="votes">{{votes}}票</div>
    </div>
    <div class="controls" v-if="isEditing">
      <button class="button" @click="save">儲存</button>
      <button class="button" @click="handleDelete">刪除</button>
    </div>
  </div>
</template>

<style scoped lang="scss">
.option {
  display: flex;
  align-items: center;
  gap: 20px;
  width: 100%;
  background-color: #1a1a1a;
  border-radius: 10px;
  padding: 15px 20px;
  min-width: none;
  .checkbox-wrapper {
    .checkbox {
      position: relative;
      display: flex;
      align-items: center;
      justify-content: center;
      border: solid 2px #4CA29C;
      border-radius: 5000px;
      width: 35px;
      height: 35px;
      .check {
        position: absolute;
        width: 20px;
        height: 20px;
        path {
          fill: #4CA29C;
        }
      }
    }
  }
  .info-wrapper {
    display: flex;
    flex-direction: column;
    align-items: end;
    width: 100%;
    gap: 5px;
    .info-header {
      width: 100%;
      display: flex;
      align-items: end;
      justify-content: space-between;
      line-height: 1;
      .title {
        font-size: 22px;
        font-weight: bold;
      }
    }
    .progress {
      position: relative;
      width: 100%;
      height: 5px;
      background-color: rgba($color: #4CA29C, $alpha: 0.2);
      .value {
        height: 5px;
        background-color: rgba($color: #4CA29C, $alpha: 1.0);
      }
    }
  }
  .controls {
    display: flex;
    flex-shrink: 0;
    gap: 7px;
  }
}
</style>
