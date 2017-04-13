<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../resources.jsp" />
<title>材料档案</title>
<link rel="stylesheet" type="text/css" href="${CP}/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="${CP}/css/diyUpload.css">
<script type="text/javascript" src="${CP}/js/page/file/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="${CP}/js/page/file/diyUpload.js"></script>
<script type="text/javascript" src="${CP}/js/page/archive/material.js"></script>
<style>
*{ margin:0; padding:0;}
#box{ margin:4px auto; width:540px; min-height:400px}
</style>
<script type="text/javascript">
function updateUser(){
	var $form = $("#editorUserData");
	var id = 0;//选择记录的序号
	var rows = $("#datagrid").datagrid('getSelections');
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
	 var url = basePath+"/rsMaterialArchiveController/getArchiveById";
	    $.post(url,{id:id},function(res){
	        $form.form("disableValidation");
	        if(true){
	            $form.form("load",res);
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
</script>
<%-- 按钮模板--%>
<script id="optBtns" type="text/html">
        <a  href="javascript:editorUser('{{id}}')">编辑</a>
        <a  href="javascript:resetPassword('{{id}}')">重置密码</a>
        <a  href="javascript:deleteUser('{{id}}')">删除</a>
</script>
<%-- 按钮模板--%>
<script id="supOptBtns" type="text/html">
        <a href="javascript:editorUser('{{id}}')">编辑</a>
        <a href="javascript:resetPassword('{{id}}')">重置密码</a>
</script>
</head>
<body class="easyui-layout">
	<div class="easyui-layout" data-options="fit:true">
	<!-- <form id="queryArchive" action="/rsMaterialArchiveController/getArchiveList" method="post"> -->
		<div data-options="region:'north',title:'',split:false,border:1"
			style="margin-bottom: 10px;padding:10px">
			<label style="padding: 0 5px">材料名称：
				<input class="easyui-textbobox" name="materialName" id="materialName" maxlength="30" style="width:140px"/>
			</label> 
			<a href="#" class="easyui-linkbutton" onclick="queryArchive();">查询</a>
		</div>
		<div data-options="region:'center',border:0,fit:true">
			<div id="tb">
				<a id="btn_add" onclick="openAddUser()" class="easyui-linkbutton" >新增</a>
				<a id="btn_update" onclick="updateUser()" class="easyui-linkbutton">修改</a>
				<a id="btn_del" onclick="deleteUser()" class="easyui-linkbutton">删除</a>
			</div>
			<table style="height: 91%" id="datagrid" ></table>
		</div>
	</div>
<!-- 新增对话框 -->
	<div id="dlg" style="padding:10px 10px;display: none">
		<form id="userData" style="width: 100%;margin: 0;padding:0;" method="post">
			<table class="fm_table" style="width:100%;table-layout:fixed">
				<tr>
					<td class="fm_lable">材料名称</td>
					<td>
						<input id="materialName" name="materialName" class="easyui-textbox" style="width: 100%" data-options="required:true"/>
					</td>
					<td class="fm_lable">创建人</td>
					<td>
						<input class="easyui-textbox" id="createName" name="createName" style="width: 100%" data-options="editable:false" value="${createName}"/>
					</td>
					<td class="fm_lable">创建日期</td>
					<td>
						<input class="easyui-datebox" id="createDate" name="createDate" style="width: 100%" readonly="readonly" value="javascript:new Date();"/>
					</td>
				</tr>
				<tr>
					<td class="fm_lable">图片上传</td>
					<td colspan="5">					
					<div id="box">
						<input id="picUrl" name="pictureUrl" type="hidden" />
						<div id="test" >
							<!-- <input type="image" id="picUrl" /> -->
						</div>
					</div>
					</td>
				</tr>
				<tr>
					<td class="fm_lable">备注</td>
					<td colspan="5"><input id="remark" name="remark"
						class="easyui-textbox" style="width: 100%;height: 100px;"
						data-options="multiline:true,validType:'maxLength[550]'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>

<!-- 编辑对话框 -->
	<div id="editorDlg" style="padding:10px 10px;display: none">
		<form id="editorUserData" style="width: 100%;margin: 0;padding:0;"
			method="post">
				<input name="id" type="hidden"/>
				<input name="uuid" type="hidden"/>
			<table class="fm_table" style="width:100%;table-layout:fixed">
				<tr>
					<td class="fm_lable">材料名称</td>
					<td>
						<input id="materialName" name="materialName" class="easyui-textbox" style="width: 100%" data-options="required:true"/>
					</td>
					<td class="fm_lable">创建人</td>
					<td>
						<input class="easyui-textbox" id="createName" name="createName" style="width: 100%" data-options="editable:false" value="${createName}"/>
					</td>
					<td class="fm_lable">创建日期</td>
					<td>
						<input class="easyui-datebox" id="createDate" name="createDate" style="width: 100%" readonly="readonly" value="javascript:new Date();"/>
					</td>
				</tr>
				<tr>
					<td class="fm_lable">图片上传</td>
					<td colspan="5">					
					<div id="box">
						<input id="picUrl" name="pictureUrl" type="hidden"  />
						<div id="test" >
							<!-- <input type="image" id="picUrl" /> -->
						</div>
					</div>
				</tr>
				<tr>
					<td class="fm_lable">备注</td>
					<td colspan="5">
						<input id="remark" name="remark" class="easyui-textbox" style="width: 100%;height: 60px;"  
									data-options="multiline:true,validType:'maxLength[550]'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
<script type="text/javascript">
/*
* 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
* 其他参数同WebUploader
*/
$('#test').diyUpload({
	url: basePath+'/fileController/pictureUploadBydb',
	dataType: 'json',
	formData:{'topDirectory':'materials','twoDirectory':'info'},
	success:function( data ) {
		if(data.success){
		    var value=$('#picUrl').val();
			if(value==''){
				$('#picUrl').val(data.data); 
			}else{
				$('#picUrl').val(value+","+data.data); 
			}
		}else{
			 $.messager.alert("错误", data.message, "error");
		}
	},
	error:function( err ) { 
		alert( err);
		console.info( err );	
	}
});

</script>
</body>
</html>
