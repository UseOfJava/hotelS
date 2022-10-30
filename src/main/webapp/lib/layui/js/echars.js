/*房间收入*/
let myChart4 = echarts.init(document.getElementById('roomincome'));
let code = [];
let r_money = [];
$.ajax({
    url: 'order/roomincome',
    async: false,
    success: function (result3) {
        if (result3) {
            for (let i = 0; i < result3.length; i++) {
                code.push(result3[i].r_name);
                r_money.push(result3[i].money);
            }
        }
    }
});
let option4 = {
    color: [
        '#db0fe8',
    ],
    title: {
        text: '房间收入详情'
    },
    textStyle: {
        color: '#ffffff',
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {},
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: code,
    },
    series: [
        {
            name: '消费金额',
            type: 'bar',
            data: r_money,
        },
    ]
};
myChart4.setOption(option4);

/*会员消费查询*/
let myChart3 = echarts.init(document.getElementById('vipcosume'));
let v_name = [];
let v_money = [];

$.ajax({
    url: 'order/vipconsum',
    async: false,
    success: function (result3) {
        if (result3) {
            for (let i = 0; i < result3.length; i++) {
                v_name.push(result3[i].vname);
                v_money.push(result3[i].money);
            }
        }
    }
});
let option3 = {
    title: {
        text: 'VIP消费金额'
    },
    textStyle: {
        color: '#ffffff',
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {},
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: v_name,
    },
    series: [
        {
            name: '消费金额',
            type: 'bar',
            data: v_money,
        },
    ]
};
myChart3.setOption(option3);

/*按年份*/
let myChart2 = echarts.init(document.getElementById('year'));
let years = [];
let money2 = [];
$.ajax({
    url: 'order/incomeyear',
    async: false,
    success: function (result2) {
        if (result2) {
            for (let i = 0; i < result2.length; i++) {
                years.push(result2[i].start_time);
                money2.push(result2[i].money);
            }
        }
    }
});
// 指定图表的配置项和数据
let option2 = {
    color: [
        'yellow',
    ],
    textStyle: {
        color: '#e31c84',
    },
    title: {
        text: '年收入'
    },
    tooltip: {},
    legend: {
        data: ['单位（元）'],

    },
    xAxis: {
        data: years
    },
    yAxis: {},
    series: [
        {
            name: '收入',
            type: 'line',
            data: money2,
            smooth: true,
            color: '#ffffff',
        },
        {
            name: '收入',
            type: 'bar',
            data: money2,
        },
    ]
};
myChart2.setOption(option2);


/*按月份*/
let myChart1 = echarts.init(document.getElementById('month'));
let months = [];
let money1 = [];
$.ajax({
    url: 'order/incomemonth',
    async: false,
    success: function (result1) {
        if (result1) {
            for (let i = 0; i < result1.length; i++) {
                months.push(result1[i].start_time);
                money1.push(result1[i].money);
            }
        }
    }
});
// 指定图表的配置项和数据
let option1 = {
    color: [
        '#22db3a',
    ],
    textStyle: {
        color: '#b341db',
    },
    title: {
        text: '月收入'
    },
    tooltip: {},
    legend: {
        data: ['单位（元）'],

    },
    xAxis: {
        data: months,
    },
    yAxis: {},
    series: [
        {
            name: '收入',
            type: 'line',
            data: money1,
            smooth: true,
            color: '#ffffff',
        },
        {
            name: '收入',
            type: 'bar',
            data: money1,
        },
    ]
};
myChart1.setOption(option1);


/*按日期*/
let myChart = echarts.init(document.getElementById('day'));
let days = [];
let money = [];
$.ajax({
    url: 'order/incomeday',
    async: false,
    success: function (result) {
        if (result) {
            for (let i = 0; i < result.length; i++) {
                days.push(result[i].start_time);
                money.push(result[i].money);
            }
        }
    }
});
// 指定图表的配置项和数据
let option = {
    color: [
        '#19e8b8',
    ],
    textStyle: {
        color: '#D2691E',
    },
    title: {
        text: '日收入'
    },
    tooltip: {},
    legend: {
        data: ['单位（元）'],

    },
    xAxis: {
        data: days
    },
    yAxis: {},
    series: [
        {
            name: '收入',
            type: 'line',
            data: money,
            smooth: true,
            color: '#ffffff',
        },
        {
            name: '收入',
            type: 'bar',
            data: money,
        }
    ]
};
myChart.setOption(option);