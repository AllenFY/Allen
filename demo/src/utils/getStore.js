import axios from 'axios'
export async function getChina(){
    return await axios.get('/ug/api/wuhan/app/data/list-total').then(res => res.data.data);
}