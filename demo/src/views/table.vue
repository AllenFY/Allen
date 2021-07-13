<template>
  <div class="container">
    <div class="layout-container">
      <div class="header">
        <img src="../assets/fengmian.png" alt="" width="100%" />
        <span class="header-title">肺炎疫情实时动态播报</span>
        <span class="back" @click="$router.push('/')">返回</span>
      </div>
      <div class="layout-content">
        <div class="card-box">
          <div class="card-tag">
            <div
              class="tag-left tag"
              :class="activeChina ? '' : 'active'"
              @click="activeChina = true"
            >
              国内疫情
            </div>
            <div
              class="tag-right tag"
              :class="activeChina ? 'active' : ''"
              @click="activeChina = false"
            >
            <!-- <span v-if="$route.query!={}">{{ $route.query != {} ? '全球' : ($route.query.name || $route.query.provice) }}疫情</span>
            <span v-else>{{$route.query.name}}</span> -->
              
              {{ JSON.stringify(this.$route.query)==='{}' ? '全球' : ($route.query.name || $route.query.provice) }}疫情{{  JSON.stringify(this.$route.query)==='{}' ? "(含中国)" : ""}}
            </div>
          </div>
          <div class="card-data" key="1" v-show="activeChina">
            <div class="data-input cover">
              <div class="title">境外输入</div>
              <div class="number">{{ data.chinaTotal.total.input }}</div>
              <div class="added">
                较昨日<span
                  >{{ data.chinaTotal.today.input > 0 ? "+" : ""
                  }}{{ data.chinaTotal.today.input }}</span
                >
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">无症状感染者</div>
              <div class="number">{{ data.chinaTotal.extData.noSymptom }}</div>
              <div class="added">
                较昨日<span
                  >{{ data.chinaTotal.extData.incrNoSymptom > 0 ? "+" : ""
                  }}{{ data.chinaTotal.extData.incrNoSymptom }}</span
                >
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">现有确诊</div>
              <div class="number">
                {{
                  data.chinaTotal.total.confirm -
                  data.chinaTotal.total.dead -
                  data.chinaTotal.total.heal
                }}
              </div>
              <div class="added">
                较昨日<span
                  >{{ data.chinaTotal.today.storeConfirm > 0 ? "+" : ""
                  }}{{ data.chinaTotal.today.storeConfirm }}</span
                >
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">累计确诊</div>
              <div class="number">{{ data.chinaTotal.total.confirm }}</div>
              <div class="added">
                较昨日<span>+{{ data.chinaTotal.today.confirm }}</span>
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">累计死亡</div>
              <div class="number">{{ data.chinaTotal.total.dead }}</div>
              <div class="added">
                较昨日<span>+{{ data.chinaTotal.today.dead }}</span>
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">累计治愈</div>
              <div class="number">{{ data.chinaTotal.total.heal }}</div>
              <div class="added">
                较昨日<span>+{{ data.chinaTotal.today.heal }}</span>
              </div>
            </div>
          </div>

          <div class="card-data" key="2" v-show="!activeChina">
            <div class="data-input cover">
              <div class="title">累计确诊</div>
              <div class="number" :class="city ? '' : 'world'">
                {{ city ? city.total.confirm : totalConfirm }}
              </div>
              <div class="added">
                较昨日<span>+{{ city ? city.today.confirm : newConfirm }}</span>
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">累计死亡</div>
              <div class="number" :class="city ? '' : 'world'">
                {{ city ? city.total.dead : totalDead }}
              </div>
              <div class="added">
                较昨日<span>+{{ city ? city.today.dead : newDead }}</span>
              </div>
            </div>
            <div class="data-input cover">
              <div class="title">累计治愈</div>
              <div class="number" :class="city ? '' : 'world'">
                {{ city ? city.total.heal : totalHeal }}
              </div>
              <div class="added">
                较昨日<span>+{{ city ? city.today.heal : newHeal }}</span>
              </div>
            </div>
          </div>
          <div class="time">
            <div class="time-content">
              数据截止至 {{ data.overseaLastUpdateTime }}
            </div>
          </div>
        </div>
        <!-- <div class="toolbox">
          <div class="toolbox-item">隔离政策</div>
          <div class="toolbox-item">隔离政策</div>
          <div class="toolbox-item">隔离政策</div>
          <div class="toolbox-item">隔离政策</div>
          <div class="toolbox-item">隔离政策</div>
        </div> -->
        <div class="box-bottom">
          <div class="titles">
            <div
              class="title-1"
              :class="curActive == 'china' ? 'tableActive' : ''"
              @click="curActive = 'china'"
            >
              国内疫情
            </div>
            <div
              class="title-2"
              :class="curActive == 'other' ? 'tableActive' : ''"
              @click="curActive = 'other'"
            >
              国外疫情
            </div>
            <div
              class="title-3"
              :class="curActive == 'provice' ? 'tableActive' : ''"
              @click="curActive = 'provice'"
              v-if="city"
            >
              {{ $route.query.name || $route.query.provice}}疫情
            </div>
          </div>
          <div class="tables" v-show="curActive == 'china'" key="1">
            <table>
              <thead class="thead" :class="{ fixed: istop == true }" ref="tree">
                <th>地区</th>
                <th>现有确诊</th>
                <th>确诊</th>
                <th>死亡</th>
                <th>治愈</th>
              </thead>
              <tbody>
                <tr
                  v-for="(item, index) in chinaDatas"
                  :key="index"
                  @click="
                    $router.replace({
                      path: '/table',
                      query: { provice: item.name },
                    })
                  "
                >
                  <td>{{ item.name }}</td>
                  <td>
                    {{ item.total.confirm - item.total.dead - item.total.heal }}
                  </td>
                  <td>{{ item.total.confirm }}</td>
                  <td>{{ item.total.dead }}</td>
                  <td>{{ item.total.heal }}</td>
                </tr>
              </tbody>
            </table>
          </div>

          <div class="tables" v-show="curActive == 'other'" key="2">
            <table>
              <thead class="thead">
                <th>地区</th>
                <th>现有确诊</th>
                <th>确诊</th>
                <th>死亡</th>
                <th>治愈</th>
              </thead>
              <tbody>
                <tr v-for="(item, index) in allDatas" :key="index">
                  <td>{{ item.name }}</td>
                  <td>
                    {{
                      item.total.confirm - item.total.dead - item.total.heal > 0
                        ? item.total.confirm - item.total.dead - item.total.heal
                        : "0"
                    }}
                  </td>
                  <td>{{ item.total.confirm }}</td>
                  <td>{{ item.total.dead }}</td>
                  <td>{{ item.total.heal }}</td>
                </tr>
              </tbody>
            </table>
          </div>

          <div class="tables" v-show="curActive == 'provice'" key="3">
            <table>
              <thead class="thead">
                <th>地区</th>
                <th>现有确诊</th>
                <th>确诊</th>
                <th>死亡</th>
                <th>治愈</th>
              </thead>
              <tbody>
                <tr v-for="(item, index) in provice" :key="index">
                  <td>{{ item.name }}</td>
                  <td>
                    {{
                      item.total.confirm - item.total.dead - item.total.heal > 0
                        ? item.total.confirm - item.total.dead - item.total.heal
                        : "0"
                    }}
                  </td>
                  <td>{{ item.total.confirm }}</td>
                  <td>{{ item.total.dead }}</td>
                  <td>{{ item.total.heal }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- <div class="table-container">
    <div class="table-content">
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
        <el-tab-pane label="中国病例" name="first">
          <el-table
            :data="tableData"
            style="width: 100%"
            height="250"
            row-key="id"
            border
            lazy
            :load="load"
            :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
          >
            <el-table-column prop="date" label="日期" width="180">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="180">
            </el-table-column>
            <el-table-column prop="address" label="地址"> </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="世界病例" name="second">世界病例</el-tab-pane>
        <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
      </el-tabs>
    </div>
  </div> -->
</template>

<script>
export default {
  props: ["data"],
  data() {
    return {
      activeChina: true,
      curActive: "china",
      chinaDatas: null,
      allDatas: null,
      city: null,
      provice: null,
      totalConfirm: 0,
      totalDead: 0,
      totalHeal: 0,
      newConfirm: 0,
      newDead: 0,
      newHeal: 0,
      istop: false,
    };
  },
  mounted() {
    console.log(JSON.stringify(this.$route.query)==='{}')
    let cityTotal = [];
    for (const item of this.data.areaTree[2].children) {
      cityTotal.push(item);
    }
    cityTotal.sort((a, b) => {
      return (
        b.total.confirm -
        b.total.dead -
        b.total.heal -
        (a.total.confirm - a.total.dead - a.total.heal)
      );
    });
    this.chinaDatas = cityTotal;
    this.$watch(
      () => this.$route.query,
      (newValue) => {
        if (newValue) {
          if (newValue.name) {
            for (const item of this.chinaDatas) {
              if (item.name == newValue.name) {
                this.city = item;
                this.provice = item.children;
                this.activeChina = false;
                this.curActive = "provice";
              }
            }
          }else{
              for (const item of this.chinaDatas) {
              if (item.name == newValue.provice) {
                this.city = item;
                this.provice = item.children;
                this.activeChina = false;
                this.curActive = "provice";
                window.ref.scrollTo(0, 623);
              }
            }
          }
        }
      },
      { immediate: true }
    );

    let allTotal = [];
    let totalConfirm = 0;
    let totalDead = 0;
    let totalHeal = 0;
    let newConfirm = 0;
    let newDead = 0;
    let newHeal = 0;
    for (const item of this.data.areaTree) {
      totalConfirm += item.total.confirm;
      totalDead += item.total.dead;
      totalHeal += item.total.heal;
      newConfirm += item.today.confirm;
      newDead += item.today.dead;
      newHeal += item.today.heal;
    }
    this.totalConfirm = totalConfirm;
    this.totalDead = totalDead;
    this.totalHeal = totalHeal;
    this.newConfirm = newConfirm;
    this.newDead = newDead;
    this.newHeal = newHeal;
    for (let i = 0; i < 99; i++) {
      allTotal.push(this.data.areaTree[i]);
    }
    allTotal.sort((a, b) => {
      return (
        b.total.confirm -
        b.total.dead -
        b.total.heal -
        (a.total.confirm - a.total.dead - a.total.heal)
      );
    });
    this.allDatas = allTotal;
    window.addEventListener("scroll", this.handleScroll, true);
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll, true);
  },
  methods: {
    handleScroll(e) {
      var scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;

      console.log(scrollTop);
      let thead = document.querySelector(".thead");
      //   console.log(e.target)
      //   console.log(thead.getBoundingClientRect());
      //   console.log(thead.scrollTop);
    //   if (thead.scrollTop > 1300) {
    //     let timer = setTimeout(() => {
    //       clearTimeout(timer);
    //       this.istop = true;
    //     }, 50);
    //   } else {
    //     let timer = setTimeout(() => {
    //       clearTimeout(timer);
    //       this.istop = false;
    //     }, 50);
    //   }
    },
  },
};
</script>

<style scoped lang="less">
@import url("../style/layout.less");
</style>