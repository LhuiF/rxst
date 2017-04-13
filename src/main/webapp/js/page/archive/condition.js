$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    //initDialog();
    //initEditorDialog();
});

function initDatagrid() {
	$("#datagrid").datagrid({
		url : basePath + '/rsConditionArchiveController/getArchiveList',
		method : 'post',
		pagination : true,
		pageSize : 10,
		/*fit : true,*/
		/*fitColumns : true,*/
		/*idField : 'id',*/
		singleSelect : true,
		rownumbers : true,
		columns : [ [
		{
			field: 'ck',
			checkbox:true
		}, {
			title : '产品名称',
			field : 'produtName',
			width : '30%'
		}, {
			title : '符合条件',
			field : 'situation',
			width : '30%'
		}, {
			title : '是否网申',
			field : 'isOnlineApply',
			width : '5%'
		}, {
			title : '创建人',
			field : 'createName',
			width : '5%'
		}, {
			title : '创建时间',
			field : 'createDate',
			width : '12%'

		}, {
			title : '备注',
			field : 'remark',
			width : '15%'
		}
		] ],
		toolbar : "#tb"
	});
}
/**
 * 查询数据信息
 */
function queryArchive(){
	var produtName=$("#produtName").val();
	var isOnlineApply=$("#isOnlineApply").combobox("getValue");
	var queryParams=$("#datagrid").datagrid('options').queryParams;
	console.log(isOnlineApply);
	queryParams.produtName=produtName;
	queryParams.isOnlineApply=isOnlineApply;
	$("#datagrid").datagrid('options').queryParams=queryParams;
	$("#datagrid").datagrid('reload');
}

/**
 * 初始化对话框
 */
function initDialog(){
	$("#userData").form("enableValidation");
	$('#dlg').dialog({
        title: '新增',
        width: 750,
        height: 500,
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
        height: 500,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	editCondition();
            }
        },{
            text:'取消',
            handler:function(){
            	$('#datagrid').datagrid("reload");
            	$("#editorUserData").form("clear");
            }
        }],
    });
}

function openAddUser() {
	$("#userData").form("enableValidation"); 
    $("#dlg").dialog({
        title:"新增",
        closed:false,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveUser();
            }
        },{
            text:'取消',
            handler:function(){
                $("#datagrid").datagrid('reload');
            	/*$('#userData').form('clear');*/
                $('#dlg').dialog('close');
            }
        }],

    });
    $('#cp1').combobox({
	    url:basePath+'/rsConditionArchiveController/condition',
	    valueField:'name',    
	    textField:'name',
	    onSelect: function(rec){
	    	var data = rec.id;
	    	var baseurl = basePath+'/rsConditionArchiveController/getConditionById';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cpId').attr("value", data[0].id);
	             }
	         });  
		}
	});
}

/**
 * 保存用户管理
 */
function saveUser(){
    $.messager.confirm('提醒', '确定新增情况档案?', function (r) {
        if (r) {
            $('#userData').form('submit', {
                onSubmit: function () {
                    $.messager.progress({
                        title: "处理中,请稍候...."
                    });
                    var isValid = $(this).form("validate");
                    if (!isValid) {//校验不通过关提示信息
                        $.messager.progress("close");
                    }
                    var data= getFormInfo($('#userData'),"#add_tiaojian_table");
                    $.ajax({
						  type: "POST",
						  url: basePath + '/rsConditionArchiveController/saveOrUpdate',
						  dataType: "json",
						  data:  JSON.stringify(data),
						  contentType:"application/json",
						  success: function(result){
							  $.messager.progress("close");
							  if(result.success){
								  $('#userData').form('clear');
								  $('#datagrid').datagrid("reload");
								  $('#dlg').dialog('close');
								  noty({text:"保存成功!", timeout: 2000});
							  }else{
								  $.messager.alert('警告','保存失败');   
							  }
							}
						});
                }
            });
        }
        });

}

/**
 * 保存修改用户信息
 */
function editCondition() {
    $.messager.confirm('提醒', '确定修改情况档案?', function (r) {
        if (r) {
            $('#userData').form('submit', {
                onSubmit: function () {
                    $.messager.progress({
                        title: "处理中,请稍候...."
                    });
                    var isValid = $(this).form("validate");
                    if (!isValid) {//校验不通过关提示信息
                        $.messager.progress("close");
                    }
                    var data= getFormInfo($('#userData'),"#add_tiaojian_table");
                    $.ajax({
						  type: "POST",
						  url: basePath + '/rsConditionArchiveController/saveOrUpdate',
						  dataType: "json",
						  data:  JSON.stringify(data),
						  contentType:"application/json",
						  success: function(result){
							  console.log(result);
							  $.messager.progress("close");
							  if(result.success){
								  $('#userData').form('clear');
								  $('#datagrid').datagrid("reload");
								  $('#dlg').dialog('close');
								  noty({text: "编辑成功", timeout: 2000});
							  }else{
								  $.messager.alert('警告','编辑失败');   
							  }
							}
                    		
						});
                }
            });
        }
    });
}

function updateUser() {
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要修改的行');
    }else{
     	$.messager.confirm('提醒', '确定修改当前信息?',
			function(r) {
				if (r) {
					var url = basePath+ "/rsConditionArchiveController/getArchiveById/"+row.id;
					$.ajax({
		         		  type: "get",
		         		  url:url,
		         		  dataType: "json",
		         		  async: false,
		         		  success: function(data){
		         			  	/*alert(data.produtName);
		         			  	alert(data.isOnlineApply);*/
		         			  	$('#cp1').combobox('setValue', data.produtName);
		         			  	//setElement("#produtUuid",data.produtUuid,true);
		         			  	setselect("#cp1",data.produtName,false);
		         			  	setselect("#isOnlineApply",data.isOnlineApply,false);
		         			  	setElement("#createName",data.createName,true);
		         			  	setElement("#createDate",data.createDate,true);
		         			  	setElement("#remark",data.remark,false);
		         			  	setElement("#id",data.id,false);
		         			  var list=data.conditions;
		         			  for(var i=0;i<list.length;i++){
		         				  
		         				 var index=i+1;
		         				 $('#add_tiaojian_table').append("<tr><td style='align:center;bgcolor:#EEEEEE'>"+
								"<span class='atbidx' style='width:20px;display:inline-block'>"+index+"</span>"+
								"<p class='xglId' style='display: none'>"+list[i].id+"</p>"+
								"<input id='conditions' name='conditions' style='width: 658px;height: 50px; margin-right: 10px;'"+
									"data-options='multiline:true,validType:'maxLength[550]'' value='"+list[i].condition+"'>"+
								"<a id='delBtn' href='#' class='btn-remove l-btn l-btn-small' group=''>"+
		         				 "<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>删除</span>"+
		         				 "<span class='l-btn-icon icon-remove'>&nbsp;</span>"+
		         				 "</span>"+
		         				"</a>"+
								"</td>" +
								"</tr>");
		         			  }
		         			  var data= getFormInfo($('#userData'),"#add_tiaojian_table");
		         			  console.log(data);
		         		  }
		         		});
					$('#dlg').dialog({    
					    title: '编辑情况信息',    
					    closed: false,    
					    modal: true,
				        buttons: [{
				            text:'确定',
				            handler:function(){
				            	editCondition();
				            }
				        },{
				            text:'取消',
				            handler:function(){
				                cancelUser();
				            }
				        }],
				        onClose:function() {
				            $("#userData").form("clear");
				            $('#add_tiaojian_table').html("");
				            $('#datagrid').datagrid('unselectAll');
				        }   
					});
				    $('#cp1').combobox({
					    url:basePath+'/rsConditionArchiveController/condition',
					    valueField:'name',    
					    textField:'name',
					    onSelect: function(rec){
					    	var data = rec.id;
					    	var baseurl = basePath+'/rsConditionArchiveController/getConditionById';
					    	 $.ajax({
					             type: "GET",
					             url: baseurl,
					             data: {id:data},
					             dataType: "json",
					             success: function(data){
					            	 $('#produtUuid').attr('value', data[0].id);
					             }
					         });  
						}
					});
				}
			});
   }
}
/**
 * 删除用户信息
 * @param id
 */
function deleteUser(id){
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
    var url = basePath+"/rsConditionArchiveController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/rsConditionArchiveController/getArchiveList'
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

$("#addTiaojianBtn1").bind('click', function(){
	var tr =  $("#add_tiaojian_table_template tr").clone();
 	$("#addTJ").append(tr);
 	resetTrNum('addTJ_add'); 
});

/**
 * 取消
 */
function cancelUser(){
	$('#userData')[0].reset();
    //$('#userData').form('clear');
    $('#dlg').dialog('close');
}
/**
 * 取消
 */
function cancelEditorUser() {
    $('#editorConditionData').form('clear');
    $('#editorDlg').dialog('close');
    $('#datagrid').datagrid('unselectAll');
}
function getFormInfo(form,datagrid){
	var proxyInfodata=formToJson(form);
	var peopledatas = [];
	$(datagrid).find('tr').each(function (i,val) {  
		var peopledata={};
			$(this).find('td').each(function (i,val) {
				peopledata.condition=$(val).children("input").val();
				peopledata.id=$(val).children("p").text();
			});
			peopledatas.push(peopledata);
    });
	proxyInfodata.conditions=peopledatas;
	return  proxyInfodata;
}
//设置文本框
function setElement(id,data,is_no){
	$(id).textbox('setValue', data);	
	var  options=$(id).textbox("options");
	options.disabled=is_no;
	$(id).textbox(options);
}
//设置下拉框
function setselect(id,data,is_no){
	$(id).combobox('setValue', data);	
	var  options=$(id).combobox("options");
	options.disabled=is_no;
	$(id).combobox(options);
}
