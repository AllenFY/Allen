<template>
  <div class="useBlock" :style="{
      width: width + 'px',
      height: height + 'px'
    }">
      <div class="item item-rt"></div>
      <div class="item item-rb"></div>
      <div class="item item-lt"></div>
      <div class="item item-lb"></div>
      <div class="item-title" v-if=" title != '' ">{{title}}</div>
      <div class="item-content">
          <slot></slot>
      </div>
      
  </div>
</template>

<script>
export default {
    props: {
        width: {
            type: Number,
            default: 100
        },
        height: {
            type: Number,
            default: 100
        },
        title: {
            type: String,
            default: ''
        }
    },
    
}
</script>

<style scoped lang="less">
.useBlock{
    position: relative;
    // color: #240842
    border: 2px solid rgba(68, 46, 145, 0.3);
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    &:hover{
        cursor: pointer;
    }
}
.item{
    height: 15px;
    width: 15px;
    position: absolute;
}
.item-rt{
    top: 0;
    right: 0;
    border-right: 3px solid #2f7f9d;
    border-top: 3px solid #2f7f9d;
    margin: -2px -2px 0 0;
}
.item-rb{
    bottom: 0;
    right: 0;
    border-right: 3px solid #2f7f9d;
    border-bottom: 3px solid #2f7f9d;
    margin: 0 -2px -2px 0;
}
.item-lt{
    left: 0;
    top: 0;
    border-left: 3px solid #2f7f9d;
    border-top: 3px solid #2f7f9d;
    margin: -2px 0 0 -2px;
}
.item-lb{
    left: 0;
    bottom: 0;
    border-left: 3px solid #2f7f9d;
    border-bottom: 3px solid #2f7f9d;
    margin: 0 0 -2px -2px;
}
.item-content{
    width: 100%;
    // height: 100%;
    flex: 1;
    cursor: pointer;
    &:hover{
        cursor: pointer;
    }
}

.item-title{
    color: #fff !important;
    font-size: 20px;
    text-align: center;
}
</style>