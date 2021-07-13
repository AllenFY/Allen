import * as echarts from "echarts";
var option1 = {
    backgroundColor: 'rgba(255, 255, 255, 0)',
    title: {
        // text: '新增城市TOP6',
        // left: 'center',
        // textStyle: {
        //     fontSize: 18,
        //     color: "#fff"
        // },
    },
    tooltip: {
        trigger: 'item'
    },

    legend: {
        left: 'center',
        top: 10,
        bottom: 0,
        textStyle: {
            fontSize: 16,
            color: "#fff"
        },
    },
    series: [{
        name: '访问来源',
        type: 'pie',
        radius: '64%',
        center: ['55%', '62%'],
        data: [{
                value: 1048,
                name: '搜索引擎'
            },
            {
                value: 735,
                name: '直接访问'
            },
            {
                value: 580,
                name: '邮件营销'
            },
            {
                value: 484,
                name: '联盟广告'
            },
            {
                value: 300,
                name: '视频广告'
            }
        ],
        itemStyle: {
            emphasis: {
                itemStyle: {
                    // shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    color: '#fff'
                }
            },
        }
    }]
};


export default option1;