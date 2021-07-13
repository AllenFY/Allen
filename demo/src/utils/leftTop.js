import * as echarts from 'echarts'
var option1 = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985",
            },
          },
        },
        //图例
        legend: {
          top: "0%",
          //图例字体样式
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "12",
          },
        },
        // 坐标系
        grid: {
          left: "10",
          top: "30",
          right: "10",
          bottom: "10",
          //文字标注算入
          containLabel: true,
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ['06-11', '06-11', '06-1', '06-1', '06-1', '06-1', '06-1', '06-1', '06-1', '06-1'],
            // 文本颜色为rgba(255,255,255,.6)  文字大小为 12
            inverse: true,
            axisLabel: {
                rotate: 60,
              textStyle: {
                color: "rgba(255,255,255,.6)",
                fontSize: 10,
              },
            },
            // x轴线的颜色为   rgba(255,255,255,.2)
            axisLine: {
              lineStyle: {
                color: "rgba(255,255,255,.2)",
              },
            },
          },
        ],
        yAxis: [
          {
            min: 0,
            max: 800,
            type: "value",
            //隐藏坐标轴刻度
            axisTick: { show: false },
            //标注y轴线样式
            axisLine: {
              lineStyle: {
                color: "rgba(255,255,255,.1)",
              },
            },
            //标注文本
            axisLabel: {
              textStyle: {
                color: "rgba(255,255,255,.6)",
                fontSize: 10,
              },
            },
            // 修改分割线的颜色
            splitLine: {
              lineStyle: {
                color: "rgba(255,255,255,.1)",
              },
            },
          },
        ],
        //主题样式设计
        series: [
          {
            name: "确诊",
            type: "line",
            // stack: '总量', //数据堆叠
            data: [220, 182, 191, 234, 290, 330, 310],
            //线圆滑
            smooth: true,
            // 单独修改线的样式
            lineStyle: {
              color: "#0184d5",
              width: 2,
            },
            // 填充区域
            areaStyle: {
              // 渐变色
              color: new echarts.graphic.LinearGradient(
                0,
                0,
                0,
                1,
                [
                  {
                    offset: 0,
                    color: "rgba(1, 132, 213, 0.4)", // 渐变色的起始颜色
                  },
                  {
                    offset: 0.8,
                    color: "rgba(1, 132, 213, 0.1)", // 渐变线的结束颜色
                  },
                ],
                false
              ),
              shadowColor: "rgba(0, 0, 0, 0.1)", //阴影颜色
            },
            // 设置拐点 小圆点
            symbol: "circle",
            // 拐点大小
            symbolSize: 8,
            // 设置拐点颜色以及边框
            itemStyle: {
              color: "#0184d5",
              borderColor: "rgba(221, 220, 107, .1)",
              borderWidth: 12,
            },
            //开始不显示坐标圆点
            // showSymbol: false,
          },
          {
            // 开始不显示拐点， 鼠标经过显示
            // showSymbol: false,
            name: "疑似",
            type: "line",
            smooth: true,
            lineStyle: {
              normal: {
                color: "#00d887",
                width: 2,
              },
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0,
                  0,
                  0,
                  1,
                  [
                    {
                      offset: 0,
                      color: "rgba(0, 216, 135, 0.4)",
                    },
                    {
                      offset: 0.8,
                      color: "rgba(0, 216, 135, 0.1)",
                    },
                  ],
                  false
                ),
                shadowColor: "rgba(0, 0, 0, 0.1)",
              },
            },
            // 设置拐点 小圆点
            symbol: "circle",
            // 拐点大小
            symbolSize: 5,
            // 设置拐点颜色以及边框
            itemStyle: {
              color: "#00d887",
              borderColor: "rgba(221, 220, 107, .1)",
              borderWidth: 12,
            },
            // 开始不显示拐点， 鼠标经过显示
            // showSymbol: false,
            data: [120, 132, 101, 134, 90, 230, 210]
            // stack: '总量',
          },
        ],
      };
      export default option1;
