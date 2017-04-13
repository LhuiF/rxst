$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    initDialog();

});

/**
 * 初始化 用户管理列表
 */

function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/AccumulationController/getAccumulationList',
        method : 'post',
        pagination : true,
        queryParams :{
        	dictCode:$("#dictCode").val(),
        	fundYear:$("#fundYear option:selected").val()
        },
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
                field : 'dictName',
                width : '15%'
            }, {
                title : '公积金年度',
                field : 'fundYear',
                width : '15%'
            },
            {
                title : '基数核定月份',
                field : 'clearMonth',
                width : '15%'
            },
            {
                title : '备注',
                field : 'comment',
                width : '20%'
            }
        ] ],
        toolbar : "#tb"
    });
}
/**
 * 保存修改用户信息
 */
function updateUser() {
	var s= $(window.frames["iframeName"].document).find("#editorUserData");
	s.form('submit', {
        url: basePath + '/AccumulationController/saveAccumulation',
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
            //校验表单
            /*var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            }
            return isValid;*/
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
 * 保存用户管理
 */
function saveUser(){
    $.messager.confirm('提醒', '是否确定保存!', function (r) {
        if (r) {
            $('#userData').form('submit', {
                url: basePath + '/AccumulationController/saveAccumulation',
                method: "post",
                onSubmit: function () {
                    $.messager.progress({
                        title: "处理中,请稍候...."
                    });
                    //校验表单
                    var isValid = $(this).form("validate");
                    if (!isValid) {//校验不通过关提示信息
                        $.messager.progress("close");
                    }
                    return isValid;
                },
                success: function (result) {
                    $.messager.progress("close");
                    var data = eval('(' + result + ')');
                    if (data.success) {
                        $('#dlg').dialog('close');

                        $("#datagrid").datagrid({
                            url: basePath + '/AccumulationController/getAccumulationList'
                        });
                        noty({text: data.message, timeout: 2000});
                    } else {
                        $.messager.alert("错误", data.message, "error");
                    }
                }
            });
        }
        });

}


/**
 * 取消
 */
function cancelUser(){
    $('#userData').form('reset');
    $('#dlg').dialog('close');
}
/**
 * 取消
 */
function cancelEditorUser() {
    $('#editorDlg').dialog('close');
    $('#datagrid').datagrid('unselectAll');
}
/**
 *  打开新增对话框
 */
function openAddUser() {
    $('#loginNames').textbox('enable');
    $('#password').textbox('enable');
    $('#rpassword').textbox('enable');
    $('#organId').combobox('enable');
    $('#postId').combobox('enable');
    $('#roleId').combobox('enable');
    $('#setVlaue').combobox('setValue', '0');
    $("#userData").form("enableValidation");
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
}
/**
 * 初始化对话框
 */
function initDialog(){
    $('#dlg').dialog({
        title: '新增',
        width: 700,
        height: 450,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveUser();
            }
        },{
            text:'取消',
            handler:function(){
                cancelUser();
            }
        }],
        onClose:function() {
            $("#userData").form("reset");
        }
    });
}


/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function editorUser(){
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
	var sendUrl = basePath+"/AccumulationController/getgAccumulationById?id="+id;
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
                updateUser();
            }
        }, {
            text: '取消',
            handler: function () {
                cancelEditorUser();
            }
        }],
        onClose: function () {
            $("#editorUserData").form("reset");
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
function deleteUser(){
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
		id = rows[i].id;
	}
    var url = basePath+"/AccumulationController/deleteAccumulationById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/AccumulationController/getAccumulationList'
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

//查询
function queryAccumulation(){
	//将表单的数据封装成json
	var formdata = $("#queryAccumulation").serializeJson();
	//alert(formdata);
	$('#datagrid').datagrid('unselectAll');
	$('#datagrid').datagrid('load', formdata);
}

function clearForm(){
	$('#datagrid').datagrid('unselectAll');
	parent.closemodalwindow();
}

function alert_warn(mes){
	$.messager.alert('警告',mes); 
}
