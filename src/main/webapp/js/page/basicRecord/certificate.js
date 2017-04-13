$(function(){
	initDatagrid();
	initEditorDialog();
	initDialog();
});

/**
 * 初始化 证书列表
 */
function initDatagrid(){

	$("#datagrid").datagrid({
        url : basePath+'/rsCertificateController/getCertificateList',
        method : 'post',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
        singleSelect:true,//是否单选true是、false否
        fit : true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
			{
				field: 'ck',
				checkbox:true
			},
            {
                title : '企业名称',
                field : 'name',
                width : '30%'
            },
            {
                title : '业务类型',
                field : 'businessType',
                width : '15%'
            }, {
                title : '证书编号',
                field : 'certificateNumber',
                width : '12%'
            },{
            	title : '数字证书失效时期',
                field : 'expiryDate',
                width : '12%'
            },{
            	title : '预警天数',
                field : 'warningDays',
                width : '10%'
            },{
            	title : '创建人',
                field : 'createName',
                width : '5%'
            },{
            	title : '创建日期',
                field : 'createDate',
                width : '12%'
            }
          ] ],
        toolbar : "#tb",
    });
}
/**
 *  打开新增对话框
 */
function openAdd() {
    $("#userData").form("enableValidation"); 
    $("#dlg").dialog({
        title:"新增",
        closed:false
    });
    $('#cc1').combobox({
	    url:basePath+'/rsCertificateController/rsCertificate',
	    valueField:'name',    
	    textField:'name',
	    onSelect: function(rec){
	    	var data = rec.id;
	    	var baseurl = basePath+'/rsCertificateController/getRsCertificateById';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc2').textbox('setValue', data[0].orgCode);	
	            	 $('#cc3').textbox('setValue', data[0].insuranceAccount);
	            	 $('#cc4').attr("value", data[0].id);
	             }
	         });  
		}
	});
}
/**
 * 初始化对话框
 */
function initDialog(){
	$("#dlg").dialog({
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
            	saveCertificate();
            }
        },{
            text:'取消',
            handler:function(){
				$('#datagrid').datagrid("reload");
				$('#dlg').dialog('close');
            }
        }],
    });
}


/**
 * 保存
 */
function saveCertificate(){
    $.messager.confirm('提醒', '确定保存该信息', function (r) {
        if (r) {
            $('#userData').form('submit', {
                url: basePath + '/rsCertificateController/saveOrUpdate',
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
                            url: basePath + '/rsCertificateController/getCertificateList'
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
 * 编辑对话框
 */
function initEditorDialog(){
	$('#editDlg').dialog({
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
            	updateCertificate();
            }
        },{
            text:'取消',
            handler:function(){
				$('#datagrid').datagrid("reload");
				$('#editDlg').dialog('close');
				$('#datagrid').datagrid('unselectAll');
            }
        }],

    });
    $('#cc5').combobox({
	    url:basePath+'/rsCertificateController/rsCertificate',
	    valueField:'name',    
	    textField:'name',
	    onSelect: function(rec){
	    	var data = rec.id;
	    	var baseurl = basePath+'/rsCertificateController/getRsCertificateById';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc6').textbox('setValue', data[0].orgCode);	
	            	 $('#cc7').textbox('setValue', data[0].insuranceAccount);
	             }
	         });  
		}
	});
	
}

function openEditor() {
			var $form = $("#editData");
			var id = 0;// 选择记录的序号
			var rows = $("#datagrid").datagrid('getSelections');
			if (rows.length > 1) {
				alert_warn("请确认单选");
				return;
			} else if (rows.length == 0) {
				alert_warn("请选择一条记录在进行操作");
				return;
			}
			for ( var i = 0; i < rows.length; i++) {
				id = rows[i].id;
			}
			$.messager.confirm('提醒', '确定修改当前信息?',function(r) {
				if (r) {
			var url = basePath
					+ "/rsCertificateController/getCertificateById";
			$.post(url, {
				id : id
			}, function(res) {
				$form.form("disableValidation");
				if (true) {
					$form.form("load", res);
					$('#editDlg').dialog({
						title : "编辑",
						closed : false
					});
				} else {
					$.messager.alert("错误", res.message, "error");
				}
				$form.form("enableValidation");
			}, "json");
		}
	});
}

/**
 * 保存修改信息
 */
function updateCertificate(){
	
	  var rows = $("#datagrid").datagrid("getSelections");
	     if(rows.length>1 || rows.length==0){
	         $.messager.alert("提示框","请正确选择修改的内容",'info');
	         return ;
	     }
     $('#editData').form('submit', {
         url: basePath + '/rsCertificateController/saveOrUpdate',
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
                 $('#editDlg').dialog('close');
                 //$('#datagrid').datagrid('reload');
                 $("#datagrid").datagrid({
                     url: basePath + '/rsCertificateController/getCertificateList'
                 });
                 //$('#datagrid').datagrid('reload');
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
function deleteCertificate(id){
	
	//var id = 0;//选择记录的序号
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
    var url = basePath+"/rsCertificateController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/rsCertificateController/getCertificateList'
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

/**
 * 查询数据信息
 */
function queryCertificate(){
	alert("66");
	var name=$("#name").val();
	var certificateNumber=$("#certificateNumber").val();
	var queryParams=$("#datagrid").datagrid('options').queryParams;
	queryParams.name=name;
	queryParams.certificateNumber=certificateNumber;
	$("#datagrid").datagrid('options').queryParams=queryParams;
	$("#datagrid").datagrid('reload');
	
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
    $('#editData').form('clear');
    $('#editDlg').dialog('close');
    $('#datagrid').datagrid('unselectAll');
}

