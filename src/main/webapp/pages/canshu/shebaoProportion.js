$(function(){
    initDatagrid();
	initSheBaoProptDialog();
	//initEditorDialog();
});

/**
 * 初始化 社保参数比例列表
 */
function initDatagrid(){
	$("#datagrid").datagrid({
        url : basePath+'/RsInsuranceProportionController/getInsuranceByProp',
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
                field : 'dictName',
                width : '25%',
                formatter:function(val,row,index){
                	 return '<a class="show" onclick="showCity('+row.id+')" href="javascript:void(0)">'+row.dictName+'</a>';
                }
            }, {
                title : '年度',
                field : 'insuranceYear',
                width : '20%'
            }
          ] ],
        toolbar : "#tb",
        onLoadSuccess:function(data){  //为格式化列添加样式，变成有图标的按钮
           $(".tp_source").parents("td").tooltip({
                content:function() {
                    return $(this).find(".tp_source").html();
                },
                onShow: function(){
                    $(this).tooltip('tip').css({});
                }
            });
        }
    });
}

/**
 *  打开新增对话框
 */
function openAddShebaoProportion() {
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
    $('#cc1').combobox({
	    url:basePath+'/RsInsuranceProportionController/insurance',
	    valueField:'uuid',    
	    textField:'yearCity',
	    onSelect: function(rec){
	    	var data = rec.uuid;
	    	var baseurl = basePath+'/RsInsuranceProportionController/getInsuranceByUuid';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc2').datebox('setValue', data[0].startTime);	
	            	 $('#cc3').datebox('setValue', data[0].endTime);
	            	 $('#insuranceUuid').attr("value", data[0].uuid);
	             }
	         });  
		}
	});  
}
/**
 * 初始新增化对话框
 */
function initSheBaoProptDialog(){
	
    $('#dlg').dialog({
        title: '新增',
        width:1000,
        height:600,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveSheBaoProportion();
            }
        },{
            text:'取消',
            handler:function(){
            	$('#shebaoProptData').form('reset');
                $('#dlg').dialog('close');
            }
        }],
        onClose:function() {
            $("#shebaoProptData").form("reset");
        }
    });
}


/**
 * 保存
 */
function saveSheBaoProportion(){
    $.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#shebaoProptData').form('submit', {
                url: basePath + '/RsInsuranceProportionController/saveOrUpdate',
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

                        query();
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
 * 保存修改
 */
function updateGongjjPropt() {
	var s= $(window.frames["iframeName"].document).find("#editorShebaoProportion");
	s.form('submit', {
        url: basePath + '/RsInsuranceProportionController/saveOrUpdate',
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
   				query();
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
function deleteShebaoProportion(){
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
    var url = basePath+"/RsInsuranceProportionController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    query();
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function editorShebaoProportion(){
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
	var sendUrl = basePath+"/RsInsuranceProportionController/getProportionById?id="+id;
	$('#editorDlg').dialog({
    	title: '编辑',
        width: 1000,
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
	//为了保障只发送一次请求，在窗口创建完之后再对iframe的src属性进行赋值
	$('#editAccumula').attr('src',sendUrl);
	$('#editorDlg').window('open'); 
	
}

function alert_warn(mes){
	$.messager.alert('警告',mes); 
}

//查询
function query(){
	//将表单的数据封装成json
	var formdata = $("#queryInsurance").serializeJson();
	//alert(formdata);
	$('#datagrid').datagrid('unselectAll');
	$('#datagrid').datagrid('load', formdata);
}

