<template>
  <div id="main">
    <!-- curetotal 累计治愈 -->
    <!-- econNum 现有确诊 -->
    <!-- gntotal 累计确诊 -->
    <div class="card">
      <div class="card-data">
        <div class="data-input cover">
          <div class="title">境外输入</div>
          <div class="number">{{ data.chinaTotal.total.input }}</div>
          <div class="added">较昨日<span>{{data.chinaTotal.today.input > 0 ? '+' : ''}}{{ data.chinaTotal.today.input }}</span></div>
        </div>
        <div class="data-input cover">
          <div class="title">无症状感染者</div>
          <div class="number">{{ data.chinaTotal.extData.noSymptom }}</div>
          <div class="added">较昨日<span>{{data.chinaTotal.extData.incrNoSymptom > 0 ? '+' : ''}}{{data.chinaTotal.extData.incrNoSymptom}}</span></div>
        </div>
        <div class="data-input cover">
          <div class="title">现有确诊</div>
          <div class="number">{{data.chinaTotal.total.confirm - data.chinaTotal.total.dead - data.chinaTotal.total.heal}}</div>
          <div class="added">较昨日<span>{{data.chinaTotal.today.storeConfirm > 0 ? "+" : ""}}{{data.chinaTotal.today.storeConfirm}}</span></div>
        </div>
        <div class="data-input cover">
          <div class="title">累计确诊</div>
          <div class="number">{{ data.chinaTotal.total.confirm }}</div>
          <div class="added">较昨日<span>+{{ data.chinaTotal.today.confirm }}</span></div>
        </div>
        <div class="data-input cover">
          <div class="title">累计死亡</div>
          <div class="number">{{ data.chinaTotal.total.dead }}</div>
          <div class="added">较昨日<span>+{{ data.chinaTotal.today.dead }}</span></div>
        </div>
        <div class="data-input cover">
          <div class="title">累计治愈</div>
          <div class="number">{{ data.chinaTotal.total.heal }}</div>
          <div class="added">较昨日<span>+{{ data.chinaTotal.today.heal }}</span></div>
        </div>
      </div>
    </div>
    <div class="main-map"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import "../utils/china";
import Data from "../components/data.vue";
import optionMap from "../utils/mapChina";
export default {
  components: {
    Data,
  },
  data() {
    return {
      count: 2,
    };
  },
  props: ["data"],
  mounted() {
      console.log(this.data)
    var myEcharts = echarts.init(document.querySelector(".main-map"));
    const d = this.data.areaTree[2].children.map(item => {
        var rObj = {};
        rObj.name = item.name;
        rObj.value = item.total.confirm;
        return rObj;
    })
    optionMap.series[0].data = d;
    myEcharts.setOption(optionMap);

    let _this = this;
    myEcharts.on("click", function (params) {
      var city = params.name;
      // loadChart(city);
      console.log(city);
      console.log(this)
      _this.$router.push({path: '/table', query: {name: city}});
    });
  },
};
</script>

<style scoped lang='less'>
@font-face {
  font-family: electronicFont;
  src: url(../assets/DS-DIGIT.TTF);
}
#main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-around;
  flex-direction: column;
  .card {
    width: 600px;
    .card-data {
      padding-top: 15px;
      padding-bottom: 10px;
      display: flex;
      flex-wrap: wrap;
      .cover {
        text-align: center;
        width: 200px;
        height: 100px;
        display: flex;
        flex-direction: column;
        box-sizing: border-box;
        margin-bottom: 34px;
        .title {
          font-size: 20px;
          font-weight: 600;
          color: #fff;
        }
        .number {
          font-size: 45px;
          font-weight: 700;
        //   font-family: electronicFont;
        }
        .added {
          color: #999;
          font-size: 18px;
        }
      }
    }
  }
  .main-map {
    //   position: absolute;
    //   width: 700px;
    height: 400px;
    // flex: 1 1 auto;
  }
}

.cover:nth-child(1) {
  .number,
  span {
    color: #ffa352;
  }
}
.cover:nth-child(2) {
  .number,
  span {
    color: #791618;
  }
}
.cover:nth-child(3) {
  .number,
  span {
    color: #e44a3d;
  }
}
.cover:nth-child(4) {
  .number,
  span {
    color: #a31d13;
  }
}
.cover:nth-child(5) {
  .number,
  span {
    color: #e1e1e1;
  }
}
.cover:nth-child(6) {
  .number,
  span {
    color: #34aa70;
  }
}
</style>