let $ = layui.$;
let table = layui.table;
let layer = layui.layer;
let form = layui.form;







$.ajax({
    url:"islogin",
    success:function (result) {
        if (!result){
            top.location.href="login.html";
        }
    }
});





/*自定义表单验证---staff*/
form.verify({
    login_item:[
        /^\w{4,16}$/,
        "必须填入4-16字符，可以包含字母、数字或下划线"
    ],
    vip_phone:[
        /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
        "手机号输入不合法，请输入正确手机号"
    ],
    vip_age:[
        /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
        "年龄输入不合法，请输入正确的年龄[1-120]"
    ],
    room_item:[
        /^[A-Z][1-9][0-9]{0,2}$/,
        "房间号输入不合法，请输入正确的房间号。\n如：A101，A区1楼01室。"
    ],
    norepeat:function(value,item){
        console.log(item);
        /*验证数据库中是否已经存在填报的账号信息---  发送请求到后台验证是否已经有账号了*/
        /*repeat:true  代表数据库中存在填报的账号信息*/
        let repeat = false;
        $.ajax({
            url:"staff/loginNameRepeat",
            data:{login_name:value},
            async:false,
            success:function (result) {
                console.log(result);
                repeat = result;
            }
        });
        if (repeat){
            return "账号已被注册，请重新注册";
        }

    },
    repeat:function(value,item){
        console.log(item);
        let repeat = false;
        $.ajax({
            url:"room/roomCodeRepeat",
            data:{code:value},
            async:false,
            success:function (result) {
                console.log(result);
                repeat = result;
            }
        });

        if (repeat){
            return "房间号已重复，请重新输入";
        }

    }

});



