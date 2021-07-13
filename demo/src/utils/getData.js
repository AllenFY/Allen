import axios from 'axios'
async function getData(){
    // const result = await axios.get('http://localhost:8080/g2/getOnsInfo?name=disease_h5').then(res => JSON.stringify(res.data.data));
    // console.log(result);
    const result = await axios.get('http://localhost:8080/news/wap/fymap2020_data.d.json').then(res => res.data.data);
    console.log(result);
}
getData();