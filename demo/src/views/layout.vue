<template>
  <div class="layout-container">
    <div class="container">
      <div class="left">
        <slot name="left"></slot>
      </div>
      <div class="main" id="content">
        <slot></slot>
      </div>
      <div class="right">
        <slot name="right"></slot>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {

};
</script>

<style lang="less" scoped>
.layout-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  box-sizing: border-box;
  align-content: stretch;
  overflow: hidden;
  .container {
    display: flex;
    justify-content: space-around;
    box-sizing: border-box;
    width: 100%;
    height: 100%;
    .left {
      width: 400px;
      flex: 0 0 auto;
      //   border: 1px solid #fff;
      margin-right: 20px;
    }
    .main {
      //   flex: 1 1 auto;
      width: 600px;
      // border: 1px solid #fff;
    }
    .right {
      width: 400px;
      flex: 0 0 auto;
      //   border: 1px solid #fff;
    }
  }
}

</style>>
