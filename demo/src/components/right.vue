<template>
  <div class="right-container" ref="right">
    <Divs :width="containerWidth" :height="320" title="新增省份TOP6">
      <div id="right-top"></div>
    </Divs>
    <Divs :width="containerWidth" :height="320" title="累计省份TOP6">
      <div id="right-bottom"></div>
    </Divs>
  </div>
</template>

<script>
import * as echarts from "echarts";
import option3 from "../utils/rightTop";
import option4 from "../utils/rightBottom";
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
      if (this.$refs.right.clientWidth) {
        this.containerWidth = this.$refs.right.clientWidth;
      }
    },
  },
  mounted() {
    let cityArr = [];
    let totalArr = [];
    for (const item of this.data.areaTree[2].children) {
        cityArr.push(item);
        totalArr.push(item)
    }
    
    cityArr.sort((a, b) => {
     return b.today.confirm - a.today.confirm;
    })
    totalArr.sort((a, b) => {
     return b.total.confirm - a.total.confirm;
    })

    const heightCity = cityArr.slice(0, 6);
    const totalCity  = totalArr.slice(0, 6);
    console.log(heightCity);


    var charDom3 = document.getElementById("right-top");
    var myChart3 = echarts.init(charDom3);
    option3.yAxis.data = heightCity.map(item => item.name).reverse();
    option3.series[0].data = heightCity.map(item => item.today.confirm).reverse();
    option3 && myChart3.setOption(option3);
    

    var charDom4 = document.getElementById("right-bottom");
    option4.series[0].data = totalCity.map(item => {
        let cityObj = {};
        cityObj.value = item.total.confirm;
        cityObj.name = item.name;
        return cityObj;
    })
    var mychart4 = echarts.init(charDom4);
    mychart4.setOption(option4);
  },
};
</script>

<style scoped lang="less">
.right-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  box-sizing: border-box;
}
#right-top {
  width: 100%;
  height: 100%;
  margin-bottom: 20px;
}
#right-bottom {
  width: 100%;
  height: 100%;
    // margin-top: 20px;
}
</style>