let orderinfo = "";
let $content = $(".content");
let $text = $(".text");
let flag;
table.on("toolbar(datalist)", function (obj) {
    let event = obj.event;
    // layer.msg(event);
    if (event === 'check') {
        let check_text = $("[name = 'check']").val();
        table.reload("datalist", {
            where: {'check_text': check_text}
        });
    } else if (event === 'add') {
        form.val("room_addwindow", {
            code: '',
            state: '',
        });

        layer.open({
            type: 1,
            title: "添加房间",
            area: ['350px', '180px'],
            content: $("#room_addwindow"),
            btn: ['添加', '取消'],
            success: function (layobj, index) {
                console.log(layobj, index);
                layobj.addClass("layui-form");
                layobj.find(".layui-layer-btn0").attr("lay-submit", '').attr("lay-filter", 'roomaddsubmit');
                form.on("submit(roomaddsubmit)", function (data) {
                    let formdata = data.field;
                    $.ajax({
                        url: "room/add",
                        data: formdata,
                        success: function (result) {
                            console.log(result);
                            layer.closeAll();
                            table.reload("datalist");
                            layer.msg("数据保存成功", {icon: 1, time: 4000});
                        }
                    });
                })
            },
            btn1: function () {
                return false;
            }
        });
    }
});

table.on("tool(datalist)", function (obj) {
    let event = obj.event;
    let data = obj.data;
    if (event === 'del') {
        layer.confirm("确认要删除[" + data.code + "]这个房间的信息吗？", {icon: 3, title: "删除提示"}, function () {
            $.ajax({
                url: "room/del",
                data: data,
                success: function (result) {
                    table.reload("datalist");
                    console.log(result);
                    layer.msg("删除成功！", {icon: 1, time: 4000});
                }
            });
        });
    } else if (event === 'edit') {

        form.val("room_editwindow", data);

        layer.open({
            type: 1,
            title: "房间编辑窗口",
            area: ['450px', '320px'],
            content: $("#room_editwindow"),
            btn: ['保存', '取消'],
            success: function (layobj, index) {
                console.log(layobj, index);
                layobj.addClass("layui-form");
                layobj.find(".layui-layer-btn0").attr("lay-submit", '').attr("lay-filter", 'roomeditsubmit');
                form.on("submit(roomeditsubmit)", function (data) {
                    let formdata = data.field;
                    layer.alert(JSON.stringify(formdata));
                    console.log(formdata);
                    $.ajax({
                        url: "room/edit",
                        data: formdata,
                        success: function (result) {
                            console.log(result);
                            layer.closeAll();
                            table.reload("datalist");
                            layer.msg("数据保存成功", {icon: 1, time: 4000});
                        }
                    });
                });
            },
            btn1: function () {
                return false;
            }
        });
    } else if (event === 'free') {
        window.location.href = 'http://127.0.0.1/page/room_orderinfo.html?id=' + obj.data.id + "&code=" + obj.data.code;
    }
    // console.log(obj.data.code);

});







