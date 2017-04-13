$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    initDialog();
    initEditorDialog();

});
/**
 * 数据
 */
function initDatagrid() {
	$("#datagrid").datagrid({
		url : basePath + '/rsMaterialArchiveController/getArchiveList',
		method : 'post',
		pagination:true,//分页控件
        singleSelect:true,//是否单选true是、false否
		pageSize : 10,
/*		fit : true,
		fitColumns : true,
		idField : 'id',
		singleSelect : true,*/
		rownumbers : true,
		columns : [ [
		{
			field: 'ck',
			checkbox:true
		}, {
			title : '材料名称',
			field : 'materialName',
			width : '20%'
		}, {
			title : '图片',
			field : 'pictureUrl',
			width : '8%',
            formatter: function(value,row,index){
            	if( row.pictureUrl !=null){
            	 return "<img src='"+basePath+"/fileController/returnFile/"+row.pictureUrl.substring(0,31)+"' alt='' height='85' width='75'>";
            	}
            	else{
	            	return '';
	            } 
			}
		}, {
			title : '创建日期',
			field : 'createDate',
			width : '12%'
		}, {
			title : '创建人',
			field : 'createName',
			width : '5%'
		}, {
			title : '备注',
			field : 'remark',
			width : '45%'
		} ] ],
		toolbar : "#tb"
	});
}


/**
 * 保存用户管理
 */
function saveUser(){
    $.messager.confirm('提醒', '确定新增材料档案?', function (r) {
        if (r) {
            $('#userData').form('submit', {
                url: basePath + '/rsMaterialArchiveController/save',
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
                            url: basePath + '/rsMaterialArchiveController/getArchiveList'
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
 * 保存修改用户信息
 */
function editUser() {
	
 $('#editorUserData').form('submit', {
        url: basePath + '/rsMaterialArchiveController/updateArchive',
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
                $('#editorDlg').dialog('close');
                $("#datagrid").datagrid({
                    url: basePath + '/rsMaterialArchiveController/getArchiveList'
                });
                noty({text: data.message, timeout: 2000});
            } else {
                $.messager.alert("错误", data.message, "error");
            }
        }
    });

}

/**
 * 删除用户信息
 * @param id
 */
function deleteUser(id){
	alert(00);
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
	var url = basePath+"/rsMaterialArchiveController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/rsMaterialArchiveController/getArchiveList'
                    });
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
function cancelUser(){
    $('#userData').form('clear');
    $('#dlg').dialog('close');
}
/**
 * 取消
 */
function cancelEditorUser() {
    $('#editorUserData').form('clear');
    $('#editorDlg').dialog('close');
    $('#datagrid').datagrid('unselectAll');
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
				 $('#userData').form('clear');
				 $('#datagrid').datagrid("reload");
				 $('#dlg').dialog('close');
			}
		}],
    });
}

/**
 * 编辑对话框
 */
function initEditorDialog(){
	$('#editorDlg').dialog({
        title: '编辑',
        width: 700,
        height: 450,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	editUser();
            }
        },{
            text:'取消',
            handler:function(){
            	cancelEditorUser();
            }
        }],
        onClose:function() {
            $("#editorUserData").form("clear");
        }
    });
}

/**
 * 新增
 */
function openAddUser() {
    $("#userData").form("enableValidation");    
    $("#dlg").dialog({
        title:"新增",
        closed:false
    });
}


/**
 * 编辑
 */
function updateUser(){
	alert(666);
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
	$.messager.confirm('提醒', '确定修改当前信息?',function(r) {
		if (r) {
		 var url = basePath+"/rsMaterialArchiveController/getArchiveById";
		    $.post(url,{id:id},function(res){
		        $form.form("disableValidation");
		        if(res.success){
		            $form.form("load",res.data);
		            $("#log").val(res.data.loginName);
		            $('#editorDlg').dialog({
		                title:"编辑",
		                closed:false
		            });
		        }else{
		            $.messager.alert("错误",res.message,"error");
		        }
		        $form.form("enableValidation");
		    },"json");
		}
	});
	
}

/**
 * 查询
 */
function queryArchive(){	
	var name = $("#materialName").val();		
	$("#datagrid").datagrid({
		url : basePath + '/rsMaterialArchiveController/getByName?name=' + name,
		method : 'post',
		pagination : true,
		pageSize : 10,
		fit : true,
		fitColumns : true,
		idField : 'id',
		singleSelect : true,
		rownumbers : true,
		columns : [ [
		{
			field: 'ck',
			checkbox:true,
		}, {
			title : '材料名称',
			field : 'materialName',
			width : '20%'
		}, {
			title : '图片',
			field : 'pictureUrl',
			width : '8%',
            formatter: function(value,row,index){
            	if( row.pictureUrl !=null){
            	 return "<img src='"+basePath+"/fileController/returnFile/"+row.pictureUrl.substring(0,31)+"' alt='' height='85' width='75'>";
            	}
            	else{
	            	return '';
	            } 
			}
		}, {
			title : '创建日期',
			field : 'createDate',
			width : '20%'
		}, {
			title : '创建人',
			field : 'createName',
			width : '20%'
		}, {
			title : '备注',
			field : 'remark',
			width : '40%'
		} 
		] ],
		toolbar : "#tb"
	});
}
