<template>
  <div class="left-container" ref="left">
    <Divs :width="containerWidth" :height="320" title="全国疫情新增趋势" v-loading="data == null">
      <div id="left-top"></div>
    </Divs>
    <Divs :width="containerWidth" :height="320" title="全国累计确诊/累计治愈" v-loading="data == null">
      <div id="left-bottom"></div>
    </Divs>
  </div>
</template>

<script>
import * as echarts from "echarts";
import option1 from "../utils/leftTop";
import option2 from "../utils/leftBottom";
import Divs from "../components/divs.vue";
export default {
    props: ['data'],
  data() {
    return {
      containerWidth: 400,
    };
  },
  components: {
    Divs,
  },
  methods: {
    getWidth() {
      if (this.$refs.left.clientWidth) {
        this.containerWidth = this.$refs.left.clientWidth;
      }
    },
  },
  mounted() {
    //   console.log(this.$refs.left.clientWidth)
    let res1 = [];
    let i1 = this.data.chinaDayList.length - 1;
    while(i1 > 0){
        res1.push(this.data.chinaDayList[i1]);
        i1 -= 3;
    }
    var charDom1 = document.getElementById("left-top");
    var myChart1 = echarts.init(charDom1);
    // this.getWidth();
    // console.log(this.$refs.left.clientWidth)
    let option1data = [];
    let option1confirm = [];
    let option1suspect = [];
    for (const item of res1) {
        option1data.push(item.date.split('-').slice(1,3).join("-"));
        option1confirm.push(item.today.confirm);
        option1suspect.push(item.today.suspect);       
    }
    
    option1.xAxis[0].data = option1data;
    option1.series[0].data = option1confirm;
    option1.series[1].data = option1suspect;
    option1 && myChart1.setOption(option1);

    var chartDom2 = document.getElementById("left-bottom");
    var myChart2 = echarts.init(chartDom2);
    let res2 = [];
    let i2 = this.data.chinaDayList.length - 1;
    while(i2 > 0){
        res2.push(this.data.chinaDayList[i2]);
        i2 -= 3;
    }
    // console.log(arr);
    // const res2 = this.data.chinaDayList.slice(this.data.chinaDayList.length - 20);
    // console.log(res2)
    let option2data = [];
    let option2confirm = [];
    let option2dead = [];
    let option2heal = [];
    for (const item of res2) {
        option2data.push(item.date.split('-').slice(1,3).join("-"));
        option2confirm.push(item.total.confirm);
        option2dead.push(item.total.dead);
        option2heal.push(item.total.heal);
    }
    
    option2.xAxis[0].data = option2data;
    option2.series[0].data = option2confirm;
    option2.series[1].data = option2heal;
    myChart2.setOption(option2);
  },
};
</script>

<style scoped lang="less">
.left-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
//   justify-content: space-between;
  justify-content: space-around;
  box-sizing: border-box;
}
#left-top {
  width: 100%;
  height: 100%;
  margin-bottom: 20px;
}
#left-bottom {
  width: 100%;
  height: 100%;
  //   margin-top: 20px;
}
</style>