$(function(){
//	initDatagrid();
	initDialog();
	initDatagrid();

});

/**
 * 初始化 公积金缴费比例参数列表
 */
function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/ProportionController/getAccumByProp',
        method : 'post',
        pagination : true,
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        rownumbers:true,
        columns : [ [
			{
				field: 'ck',
				checkbox:true
			},
            {
                title : '城市',
                field : 'fundYear',
                width : '15%'
            }, {
                title : '政策开始日期',
                field : 'startTime',
                width : '15%',
                formatter: formatterdate
            },
            {
                title : '政策结束日期',
                field : 'endTime',
                width : '15%',
                formatter: formatterdate
            }
        ] ],
        toolbar : "#tb"
    });
}

/**
 *  打开新增对话框
 */
function openAddGongjjPropt() {
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
	$('#cc1').combobox({    
	    url:basePath+'/ProportionController/getAccumulation',
	    valueField:'uuid',    
	    textField:'yearCity',
	    onSelect: function(rec){
	    	var data = rec.uuid;
	    	var baseurl = basePath+'/ProportionController/getAccumulationByUuid';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc2').datebox('setValue', data[0].startTime);	
	            	 $('#cc3').datebox('setValue', data[0].endTime);
	            	 $('#accumulationFundUuid').attr("value", data[0].uuid);
	             }
	         });  
		}
	});  
}
/**
 * 初始化对话框
 */
function initDialog(){
    $('#dlg').dialog({
        title: '新增',
        width:700,
        height:450,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveGongjjPropt();
            }
        },{
            text:'取消',
            handler:function(){
            	cancelGongjjPropt();
            }
        }],
        onClose:function() {
        	$('#datagrid').datagrid('unselectAll');
            $("#gongjjPropt").form("reset");
        }
    });
}


/**
 * 保存
 */
function saveGongjjPropt(){
    $.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#gongjjPropt').form('submit', {
                url: basePath + '/ProportionController/saveProportion',
                method: "post",
                onSubmit: function () {
                    $.messager.progress({
                        title: "处理中,请稍候...."
                    });
                    //校验表单
                   /* var isValid = $(this).form("validate");
                    if (!isValid) {//校验不通过关提示信息
                        $.messager.progress("close");
                    }
                    return isValid;*/
                },
                success: function (result) {
                    $.messager.progress("close");
                    var data = eval('(' + result + ')');
                    if (data.success) {
                        $('#dlg').dialog('close');
                        $("#datagrid").datagrid({
                            url: basePath + '/ProportionController/getAccumByProp'
                        });
                        noty({text: data.message, timeout: 2000});
                        query();
                    } else {
                        $.messager.alert("错误", data.message, "error");
                    }
                }
               
                
            });
        }
        });
}

/**
 * 保存修改用户信息
 */
function updateGongjjPropt() {
	var s= $(window.frames["iframeName"].document).find("#editorGongjjPropt");
	s.form('submit', {
        url: basePath + '/ProportionController/saveProportion',
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
            //校验表单
            //var isValid = $(this).form("validate");
            //if (!isValid) {//校验不通过关提示信息
            //    $.messager.progress("close");
            //}
            //return isValid;
        },
        success: function (result) {
            $.messager.progress("close");
            var data = eval('(' + result + ')');
            if (data.success) {
            	//点击确定以后，执行回调函数关闭窗口
            	$('#editorDlg').dialog('close');
   				//清除选定状态
   				$('#datagrid').datagrid('unselectAll');
   				queryAccumulation();
            } else {
                $.messager.alert("错误", data.message, "error");
            }
        }
    });

}

/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function editorProportion(){
	var id = 0;//选择记录的序号
	var rows = $('#datagrid').datagrid('getSelections');
	if(rows.length>1){
		alert_warn("请确认单选");
		return;
	}else if(rows.length==0){
		alert_warn("请选择一条记录在进行操作");
		return;
	}
	for(var i=0;i<rows.length;i++){
		id = rows[i].uuid;
	}
	var sendUrl = basePath+"/ProportionController/getProportionById?id="+id;
	$('#editorDlg').dialog({
    	title: '编辑',
        width: 800,
        height: 500,
		modal: true,
        /*top:25, */ 
		shadow: false,
		minimizable:false,
		collapsible:false,
		closed: true,
		content: '<iframe id="editAccumula" name="iframeName" width="100%" height="100%" frameborder="0" style="width:100%;height:100%;"></iframe>',
        buttons: [{
            text: '确定',
            handler: function () {
            	updateGongjjPropt();
            }
        }, {
            text: '取消',
            handler: function () {
            	cancelEditorGongjjPropt();
            }
        }],
        onClose: function () {
            $("#editorUserData").form("clear");
        }
    });
	
      //为了保障只发送一次请求，在窗口创建完之后再对iframe的src属性进行赋值
	//为了保障只发送一次请求，在窗口创建完之后再对iframe的src属性进行赋值
	$('#editAccumula').attr('src',sendUrl);
	$('#editorDlg').window('open'); 
	
}

/**
 * 删除用户信息
 * @param id
 */
function deleteProportion(){
	var id = 0;//选择记录的序号
	var rows = $('#datagrid').datagrid('getSelections');
	if(rows.length>1){
		alert_warn("请确认单选");
		return;
	}else if(rows.length==0){
		alert_warn("请选择一条记录在进行操作");
		return;
	}
	for(var i=0;i<rows.length;i++){
		id = rows[i].uuid;
	}
    var url = basePath+"/ProportionController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    query()
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

/**
 * 取消
 */
function cancelGongjjPropt(){
    $('#dlg').dialog('close');
}
function cancelEditorGongjjPropt() {
    $('#editorGongjjPropt').form('clear');
    $('#editorDlg').dialog('close');
    $('#datagrid').datagrid('unselectAll');
}

function alert_warn(mes){
	$.messager.alert('警告',mes); 
}

//查询
function query(){
	//将表单的数据封装成json
	var formdata = $("#queryAccumulation").serializeJson();
	//alert(formdata);
	$('#datagrid').datagrid('unselectAll');
	$('#datagrid').datagrid('load', formdata);
}

/**
 * 格式化日期
 * @param val
 * @param row
 * @returns {String}
 */
function formatterdate(val, row) {
    var date = new Date(val);
    return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
}