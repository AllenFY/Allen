<template>
  <div class="data-container">
      <div class="dataTitle">{{title}}</div>
      <slot></slot>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
    props: ["title"]
};
</script>

<style scoped lang='less'>
.data-container {
  position: relative;
  width: 260px;
  height: 260px;
  display: flex;
  flex-direction: column;
  .dataTitle{
      font-size: 20px;
    //   margin: auto;
      position: absolute;
      left: 50%;
      transform: translateX(-50%);
      top: 20px;
      color: #fff;
      text-shadow: 1px 1px 3px #fff;
  }
}
</style>