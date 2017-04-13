$(function(){
	initDatagrid();
	initDialog();
});

/**
 * 初始化 公积金缴费比例参数列表
 */
function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/EnterpriseProportionController/getEnterpriseByParameter',
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
                title : '企业名称',
                field : 'enterpriseName',
                width : '15%'
            }, {
                title : '公积金参数',
                field : 'yearCity',
                width : '15%'
            },
            {
                title : '政策开始日期',
                field : 'startTime',
                width : '15%',
                formatter:formatterdate
            },
            {
                title : '政策结束日期',
                field : 'endTime',
                width : '20%',
                formatter:formatterdate
            }
        ] ],
        toolbar : "#tb"
    });
}

/**
 *  打开新增对话框
 */
function openAddCmpGongjjPropt() {
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
    $('#cc').combobox({
	    url:basePath+'/EnterpriseProportionController/accumulationEnterprise',
	    valueField:'yearCity',    
	    textField:'yearCity',
	    onSelect: function(rec){
	    	var data = rec.uuid;
	    	var baseurl = basePath+'/EnterpriseProportionController/getEnterpriseByAdd';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc2').datebox('setValue', data[0].startTime);	
	            	 $('#cc3').datebox('setValue', data[0].endTime);
	            	 $('#uuid').attr("value", data[0].uuid);
	            	 $.each(data,function(index,item){
	            		 $('.cgjrTb tr').eq(index).find('#qy').numberbox('setValue', item.enterprise);
	            		 $('.cgjrTb tr').eq(index).find('#gfx').numberbox('setValue',item.personalNotFloor );
	            		 $('.cgjrTb tr').eq(index).find('#gx').numberbox('setValue', item.personalFloor);
	            	 });
	             }
	         });  
		}
	});  
    $('#cc1').combobox({
    	url:basePath+'/EnterpriseProportionController/enterprise',
	    valueField:'id',    
	    textField:'name',
	    onSelect: function(rec){
	    	 $('#enterpriseNameAdd').attr("value", rec.name);
	    }
    });
}
/**
 * 初始化对话框
 */
function initDialog(){
    $('#dlg').dialog({
        title: '新增',
        width:800,
        height:600,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveCmpGongjjPropt();
            }
        },{
            text:'取消',
            handler:function(){
            	cancelCmpGongjjPropt();
            }
        }],
        onClose:function() {
            $("#cmpGongjjPropt").form("reset");
        }
    });
}


/**
 * 保存
 */
function saveCmpGongjjPropt(){
    $.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#cmpGongjjPropt').form('submit', {
                url: basePath + '/EnterpriseProportionController/saveOrUpdate',
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
                        queryEnterprise();
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
 *  打开修改对话框
 */
function openEditorCmpGongjjPropt(){
    $('#editorDlg').dialog({
        title:"修改",
        closed:false
    });
}

//更新方法
function updateGongjjPropt() {
	var s= $(window.frames["iframeName"].document).find("#updateGongjjPropt");
	s.form('submit', {
        url: basePath + '/EnterpriseProportionController/saveOrUpdate',
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
          /*  //校验表单
            var isValid = $(this).form("validate");
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
   				queryEnterprise();
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
		id = rows[i].enterpriseId;
	}
	var sendUrl = basePath+"/EnterpriseProportionController/getProportionById?id="+id;
	$('#editorDlg').dialog({
    	title: '编辑',
        width: 800,
        height: 600,
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
            	$('#editorShebaoProportion').form('reset');
                $('#editorDlg').dialog('close');
                $('#datagrid').datagrid('unselectAll');
            }
        }],
        onClose: function () {
            $("#editorUserData").form("clear");
        }
    });
	
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
		id = rows[i].enterpriseId;
	}
    var url = basePath+"/EnterpriseProportionController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    queryEnterprise();
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
function cancelCmpGongjjPropt(){
    $('#dlg').dialog('close');
}
function cancelEditorCmpGongjjPropt() {
    $('#editorCmpGongjjPropt').form('clear');
    $('#editorDlg').dialog('close');
}

//查询
function queryEnterprise(){
	//将表单的数据封装成json
	var formdata = $("#queryEnterprise").serializeJson();
	//alert(formdata);
	$('#datagrid').datagrid('unselectAll');
	$('#datagrid').datagrid('load', formdata);
}

function alert_warn(mes){
	$.messager.alert('警告',mes); 
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

function editFund(){
	var id = $('#fund').val();
	var baseurl = basePath+'/EnterpriseProportionController/getEnterpriseByAdd';
	 $.ajax({
	     type: "GET",
		 url: baseurl,
		 data: {id:id},
		 dataType: "json",
		 success: function(data){
			 $('#cc2').datebox('setValue', data[0].startTime);	
			 $('#cc3').datebox('setValue', data[0].endTime);
			 $('#yearCity').attr("value", data[0].yearCity);
			 $.each(data,function(index,item){
				 $('.cgjrTb tr').eq(index).find('#qy').numberbox('setValue', item.enterprise);
				 $('.cgjrTb tr').eq(index).find('#gfx').numberbox('setValue',item.personalNotFloor );
				 $('.cgjrTb tr').eq(index).find('#gx').numberbox('setValue', item.personalFloor);
			    	 });
		     }
	 });  
	
}

function editEnterprise(){
	var name = $('#enterprise option:selected').text();
	$('#enterpriseName').attr("value", name);
}
