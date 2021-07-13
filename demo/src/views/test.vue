<template>
  <div class="test-container" v-if="data">
    <Layout :end="data.times">
      <template #left>
        <Left :data="data"/>
      </template>
      <template>
        <Map :data="data" />
      </template>
      <template #right >
        <Right :data="data"/>
      </template>
    </Layout>
  </div>
</template>

<script>
import Layout from "./layout.vue";
import Map from "../components/map.vue";
import Left from "../components/left.vue";
import Right from "../components/right.vue";
import axios from 'axios'
export default {
    props: ['data'],
    components: {
    Layout,
    Map,
    Left,
    Right,
  },
  data(){
      return {
        //   data: null
      }
  },
  computed: {
    // newData(){
    //     if(data){
    //         return this.data;
    //     }
        
    // }  
  },
  async created(){
    //   Nprogress.start();
    //   const result = await this.$store.dispatch('get/fetchData');
    //   if(result){
    //       this.data = result;
    //   }
    //   Nprogress.done();
    //   const res = await axios.get('http://localhost:8080/api').then(resp => resp)
    //   console.log(res.data);
    //   const res = await axios.get('http://localhost:8080/ug/api/wuhan/app/data/list-total').then(resp => resp)
    //   const resp = await axios.get('http://localhost:8080/newsqa/v1/automation/modules/list?modules=FAutoGlobalStatis,FAutoContinentStatis,FAutoGlobalDailyList,FAutoCountryConfirmAdd').then( resp => resp);
    //   console.log(resp.data)
    //   console.log(res.data.data);
    const res = await axios.get('/ug/api/wuhan/app/data/list-total').then(res => res.data.data);
    console.log(res)
    
  }
}
</script>

<style>
.test-container{
    width: 100%;
    height: 100%;
    /* overflow: hidden; */
}
</style>