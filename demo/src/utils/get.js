const http = require('http');
let result = ''
const request = http.request('http://interface.sina.cn/news/wap/fymap2020_data.d.json', {
    method: "GET"
}, res => {
    
    res.on('data', chunk => {
        console.log(chunk)
        result += chunk.toString('utf-8');
    })
    res.on('end', () => {
        console.log(result)
    })
})
request.end();

// module.exports{
//     result: JSON.parse(result)
// } ;

exports.res = result;