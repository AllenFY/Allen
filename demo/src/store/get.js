import {getChina} from '../utils/getStore'
export default {
    namespaced: true,
    state: {
        data: [],
    },
    mutations: {
        getData(state, payload){
            state.data = payload
        }
    },
    actions: {
        async fetchData(cxt){
            if(cxt.state.data.length){
                return;
            }
            const resp = await getChina();
            cxt.commit("getData", resp);
            return resp;
        }
    }
}