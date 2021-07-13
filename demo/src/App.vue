<template>
  <div id="app" ref="app">
    <!-- <div class="topTop" style="width: 100%; height: 57px; position:relative; top: 0;"></div> -->
    <transition name="header">
      <div class="top" v-if="!isTable">
        <!-- <div class="top-container">中国疫情数据分析</div> -->
        {{ where === "/" ? "全国" : "全球" }}疫情数据分析
        <sub
          class="topage"
          @click="$router.push('/world')"
          v-show="where == '/'"
          >去看全球</sub
        >
        <sub
          class="topage"
          @click="$router.push('/')"
          v-show="where == '/world'"
          >去看全国</sub
        >
        <span class="endTime" @click="$router.push('/table')"
          >去看详情数据-></span
        >
        <span class="time">{{ time }}</span>
      </div>
    </transition>
    <transition name="view">
      <router-view :data="data"></router-view>
    </transition>
  </div>
</template>

<script>
import Nprogress from "./utils/nprogress";
export default {
  data() {
    return {
      time: "",
      result: "",
      where: "/",
      isTable: false,
      data: null,
    };
  },
  computed: {
    // isTable(){
    //     if(this.$route.path == '/table'){
    //         return false;
    //     }else{
    //         return true;
    //     }
    // }
  },
  async created() {
    this.$watch(
      () => this.$route.path,
      (newValue) => {
        if (newValue === "/" || newValue === "") {
          this.isTable = false;
          this.where = "/";
        } else if (newValue === "/table") {
          this.isTable = true;
        } else {
          this.isTable = false;
          this.where = "/world";
        }
      },
      { immediate: true }
    );
    setInterval(() => {
      let date = new Date();
      let year = date.getFullYear(); //获取年份
      let month = date.getMonth() + 1; //获取月份
      let day = date.getDate(); //获取日期
      let hour = checkTime(date.getHours()); //获取时
      let minite = checkTime(date.getMinutes()); //获取分
      let second = checkTime(date.getSeconds()); //获取秒
      /****当时、分、秒、小于10时，则添加0****/
      function checkTime(i) {
        if (i < 10) return "0" + i;
        return i;
      }
      this.time =
        year +
        "年" +
        month +
        "月" +
        day +
        "日 " +
        hour +
        ":" +
        minite +
        ":" +
        second;
    }, 1000);
    Nprogress.start();
    const result = await this.$store.dispatch("get/fetchData");
    if (result) {
      this.data = result;
    }
    Nprogress.done();
  },
  mounted(){
    const ref = this.$refs.app;
    window.ref = ref;
  },
  methods: {
    toPath() {
      this.$router.replace(this.where);
    },
  },
};
</script>

<style lang="less">
#app {
  position: absolute;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  //   background-color: rgb(16, 12, 42);
  // background-color: rgba(21, 25, 101);
  background-image: linear-gradient(#140568, #29073d);
  overflow-x: hidden;
  box-sizing: border-box;
  scroll-behavior: smooth;
  // background-color: #0F2573
  //   background-image: url("../public/bizhi3.jpg");
  //   background-repeat: no-repeat;
  //   background-size: 100% 100%;
  //   background-position: 10px 10px;
  //   object-fit: cover;
  // z-index: -2;
  // opacity: .5;
  // filter: drop-shadow(8px 8px 8px #000) invert(100%);
}
.top {
  position: relative;
  width: 100%;
  height: 57px;
  //   border-bottom: 1px solid #fff;
  background-color: transparent;
  box-shadow: 0px 1px 2px 2px #132650;
  margin-bottom: 10px;
  color: #fff;
  font-family: Georgia, serif;
  font-size: 30px;
  font-weight: 600;
  text-align: center;
  line-height: 60px;
  letter-spacing: 2px;
  text-shadow: 2px 2px 6px #fff, -2px -2px 6px #fff;
  .time {
    position: absolute;
    right: 50px;
    top: 0;
    font-size: 16px;
  }
  .topage {
    font-size: 14px;
    color: greenyellow;
    &:hover {
      cursor: pointer;
    }
  }
  .endTime {
    position: absolute;
    top: 0;
    left: 50px;
    font-size: 16px;
    cursor: pointer;
  }
}
// .content {
  // width: 100%;
  // padding-top: 57px;
  // background: #fff;
  // position: absolute;
  // top: 57px;
// }
.view-enter,
.view-leave-to {
  opacity: 0;
}
.view-enter {
  transform: translateX(100%);
}
.view-enter-active,
.view-leave-active {
  transition: 0.3s;
}
.view-leave-to {
  transform: translateX(-100%);
}
.view-enter-to,
.view-leave {
  opacity: 1;
}

.header-enter,
.header-leave-to {
  opacity: 0;
}
.header-enter {
  transform: translateX(100%);
}
.header-enter-active,
.header-leave-active {
  transition: 0.3s;
}
.header-leave-to {
  transform: translateX(-100%);
}
.header-enter-to,
.header-leave {
  opacity: 1;
}
</style>
