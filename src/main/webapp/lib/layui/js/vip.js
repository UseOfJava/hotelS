table.on("toolbar(datalist)",function (obj) {
    let event = obj.event;
    // layer.msg(event);
    if (event === 'check'){
        let check_text = $("[name = 'check']").val();
        table.reload("datalist",{
            where:{'check_text':check_text}
        });
    }else if (event === 'add'){
        form.val("vip_addwindow",{
            name:'',
            tel:'',
            age:'',
        });

        layer.open({
            type:1,
            title:"添加VIP",
            area:['600','320'],
            content:$("#vip_addwindow"),
            btn:['添加','取消'],
            success:function (layobj,index) {
                layobj.addClass("layui-form");
                layobj.find(".layui-layer-btn0").attr("lay-submit",'').attr("lay-filter",'vipaddsubmit');
                form.on("submit(vipaddsubmit)",function (data) {
                    let formdata = data.field;
                    $.ajax({
                        url:"vip/add",
                        data:formdata,
                        success:function (result) {
                            layer.closeAll();
                            table.reload("datalist");
                            layer.msg("数据保存成功",{icon:1,time:4000});
                        }
                    });
                })
            },
            btn1:function () {
                return false;
            }
        });
    }
});

table.on("tool(datalist)",function (obj) {
    let event = obj.event;
    let data = obj.data;
    if (event === 'del'){
        layer.confirm("确认要删除VIP["+data.name+"]的信息吗？",{icon:3,title:"删除提示"},function(){
            $.ajax({
                url:"vip/del",
                data:data,
                success:function (result) {
                    table.reload("datalist");
                    console.log(result);
                    layer.msg("删除成功！",{icon:1,time:4000});
                }
            });
        });
    }
    else if (event === 'edit'){

        form.val("vip_editwindow",data);

        layer.open({
            type:1,
            title:"VIP编辑窗口",
            area:['600','320'],
            content:$("#vip_editwindow"),
            btn:['保存','取消'],
            success:function (layobj,index) {
                console.log(layobj);
                layobj.addClass("layui-form");
                layobj.find(".layui-layer-btn0").attr("lay-submit", '').attr("lay-filter", 'vipeditsubmit');
                form.on("submit(vipeditsubmit)",function (data) {
                    let formdata = data.field;
                    console.log(formdata);
                    $.ajax({
                        url: "vip/edit",
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
            btn1:function () {
                return false;
            }
        });
    }
    /*会员过期*/
    else if (event === 'kill'){
        layer.confirm("确认要取消["+data.name+"]的会员身份吗？",{icon:3,title:"辞退提示"},function(){
            $.ajax({
                url:"vip/kill",
                data:data,
                success:function(result){
                    table.reload("datalist");
                    console.log(result);
                    layer.msg("注销成功！",{icon:1,time:4000});
                }
            });
        });
    }
    /*恢复会员正常使用*/
    else  if (event === 'recover'){
        layer.confirm("确认要恢复["+data.name+"]的会员身份吗？",{icon:3,title:"恢复提示"},function(){
            $.ajax({
                url:"vip/recover",
                data:data,
                success:function(result){
                    table.reload("datalist");
                    console.log(result);
                    layer.msg("恢复成功！",{icon:1,time:4000});
                }
            });
        });

    }

});