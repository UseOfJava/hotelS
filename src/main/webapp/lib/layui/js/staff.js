// 声明 table 的头部按钮监听

table.on("toolbar(datalist)",function(obj){
	let event = obj.event; // 工具栏按钮的lay-event属性

//	layer.msg(event);
	
	if(event === 'check'){
		// 执行查询 --点击查询按钮后会执行
		/*输入框文本*/
		let check_text = $("[name = 'check']").val();
		/*据输入内容重新加载表格的数据*/
		table.reload("datalist",{
			where:{'check_text':check_text}
		});
				
		
	}
	
	else if(event === 'add'){
		// 执行新增
		/*打开对话框前清空表单中的数据*/

		form.val("staff_addwindow",{
			login_name:'',
			name:'',
			age:'',
		});

		/*js的语法---打开对话框前清空表单中的数据*/
		/*$("#staff_addform")[0].reset();*/

		layer.open({
			type:1,
			title:"添加员工",
			area:['500px','330px'],
			content:$("#staff_addwindow"),
			btn:['保存','取消'],
			success: function (layobj, index) {
				// console.log(layobj);
				/*将整个弹出层作为layui表单组件*/
				layobj.addClass("layui-form");
				/*将弹出层的第一个按钮视作提交按钮 --目的是发出表单的验证功能*/
				layobj.find(".layui-layer-btn0").attr("lay-submit", '').attr("lay-filter", 'staffaddsubmit');

				/*当点击了第一个按钮(提交按钮)，进行表单验证后，如果验证成功则触发提交方法*/
				form.on("submit(staffaddsubmit)",function (data) {
					/*获取输入框中的数据*/
					let formdata = data.field;
					/*发送数据到后台保存数据*/
					$.ajax({
						url: "staff/add",
						data: formdata,
						success: function (result) {
							/*关闭当前窗口*/
							layer.closeAll();
							/*表格重新加载*/
							table.reload("datalist");
							layer.msg("数据保存成功", {icon: 1, time: 4000});
						}
					});
				});
			},
			btn1:function(){
				/*不要让窗口关闭*/
				return false;
			}
		});
	}
});


// 行内工具栏监听
table.on("tool(datalist)",function(obj){
	// console.log(obj);
	/*按钮事件*/
	let event = obj.event;
	/*当前行的数据*/
	let data = obj.data;
	if(event === 'del'){
		/*执行删除*/
		/*首先要进行防止误操作提示*/
		layer.confirm("确认要删除["+data.login_name+"]账户的信息吗？",{icon:3,title:"删除提示"},function(){
			// 发送删除请求
			$.ajax({
				url:"staff/del",
				data:data,
				success:function(result){
					/*表格重新加载*/
					table.reload("datalist");
					console.log(result);
					layer.msg("删除成功！",{icon:1,time:5000});
				}
			});
		});
	}
	else if (event === 'edit'){

		form.val("staff_editwindow",data);

		layer.open({
			type:1,
			title:"员工编辑窗口",
			area:['500px','330px'],
			content:$("#staff_editwindow"),
			btn:['保存','取消'],
			success: function (layobj, index) {
				console.log(layobj);
				/*将整个弹出层作为layui表单组件*/
				layobj.addClass("layui-form");
				/*将弹出层的第一个按钮视作提交按钮*/
				layobj.find(".layui-layer-btn0").attr("lay-submit", '').attr("lay-filter", 'staffeditsubmit');
				/*当点击了第一个按钮(提交按钮)，进行表单验证后，如果验证成功则提交*/
				form.on("submit(staffeditsubmit)",function (data) {
					/*获取输入框中的数据*/
					let formdata = data.field;
					/*发送数据到后台保存数据*/
					$.ajax({
						url: "staff/edit",
						data: formdata,
						success: function (result) {
							console.log(result);
							/*关闭当前窗口*/
							layer.closeAll();
							/*表格重新加载*/
							table.reload("datalist");
							layer.msg("数据保存成功", {icon: 1, time: 4000});
						}
					});
				});
			},
			btn1:function(){
				/*不要让窗口关闭*/
				return false;
			}

		});
	}
	/*辞退员工*/
	else if (event === 'kill'){
		layer.confirm("确认要辞退账号为["+data.login_name+"]的员工吗？",{icon:3,title:"辞退提示"},function(){
			$.ajax({
				url:"staff/kill",
				data:data,
				success:function(result){
					table.reload("datalist");
					console.log(result);
					layer.msg("辞退成功！",{icon:1,time:4000});
				}
			});
		});
	}
	/*恢复员工*/
	else  if (event === 'recover'){
		layer.confirm("确认要恢复账号为["+data.login_name+"]的员工信息吗？",{icon:3,title:"恢复提示"},function(){
			$.ajax({
				url:"staff/recover",
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







