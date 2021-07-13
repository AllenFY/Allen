let option3 = {
    title: {
        // text: '世界人口总量',
        // subtext: '数据来自网络'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    
    grid: {
        top: '8%',
        left: '3%',
        right: '6%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        // boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        axisLine: {
            lineStyle: {
                // type: 'solid',
                color: '#fff',
                // width: '2'
            }
        },
        axisTick: {
            show: false
        },
        data: []
    },
    series: [{
            name: '昨日新增',
            type: 'bar',
            data: [],
            itemStyle: {
                normal: {
                    label: {
                        show: true, //开启显示
                        position: 'right', //在上方显示
                        textStyle: { //数值样式
                            color: '#fff',
                            fontSize: 16
                        }
                    }
                }
            },
        },

    ]
};
export default option3;