import Vuex from "vuex"
import Vue from "vue"
import get from './get'
Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
        get
    },
    strict: true
})

export default store;