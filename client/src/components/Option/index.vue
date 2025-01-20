<script setup>
import { ref } from 'vue'

defineProps({
  msg: String,
})

const checked = ref(false)
</script>

<template>
  <button class="option"  @click="checked=!checked">
    <div class="checkbox-wrapper">
      <div class="checkbox">
        <div class="check" v-if="checked">
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"  width="100%" height="100%" version="1.1" id="Capa_1" viewBox="0 0 17.837 17.837" xml:space="preserve">
            <g>
              <path d="M16.145,2.571c-0.272-0.273-0.718-0.273-0.99,0L6.92,10.804l-4.241-4.27   c-0.272-0.274-0.715-0.274-0.989,0L0.204,8.019c-0.272,0.271-0.272,0.717,0,0.99l6.217,6.258c0.272,0.271,0.715,0.271,0.99,0   L17.63,5.047c0.276-0.273,0.276-0.72,0-0.994L16.145,2.571z"/>
            </g>
          </svg>
        </div>
      </div>
    </div>
    <div class="info-wrapper">
      <div class="info-header">
        <div class="title">電腦</div>
        <div class="ratio">15%</div>
      </div>
      <div class="progress">
        <div class="value"></div>
      </div>
      <div class="votes">102票</div>
    </div>
  </button>
</template>

<style scoped lang="scss">
.option {
  display: flex;
  align-items: center;
  gap: 20px;
  width: 100%;
  .checkbox-wrapper {
    .checkbox {
      position: relative;
      display: flex;
      align-items: center;
      justify-content: center;
      border: solid 2px blue;
      border-radius: 5000px;
      width: 35px;
      height: 35px;
      .check {
        position: absolute;
        width: 20px;
        height: 20px;
        path {
          fill: blue;
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
    }
    .progress {
      position: relative;
      width: 100%;
      height: 5px;
      background-color: rgba($color: blue, $alpha: 0.2);
      .value {
        width: 80%;
        height: 5px;
        background-color: rgba($color: blue, $alpha: 1.0);
      }
    }
  }
}
</style>
