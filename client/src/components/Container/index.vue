<template>
  <div class="container">
    <slot></slot>
  </div>
</template>

<style scoped lang="scss">
.container {
  padding: 0 10px;
  margin: 0 auto;
  max-width: none;
  @media (min-width: 768px) {
    padding: 0 60px;
    max-width: 768px;
  }
  @media (min-width: 1024px) {
    padding: 0 96px;
    max-width: 1024px;
  }
  @media (min-width: 1440px) {
    padding: 0 120px;
    max-width: 14440px;
  }
}
</style>
