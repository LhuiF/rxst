<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    
    <title>证书管理</title>
   <script type="text/javascript" src="${CP}/js/page/basicRecord/certificate.js"></script>
       <script type="text/javascript">
        //业务类型
        var type = ${u:getJsonArray("20001")};        
     </script>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">企业名称：
        	<input class="easyui-textbox" id="name" name="name" style="width:140px">
        </label>
        <label style="padding: 0 5px">证书编号：
        	<input class="easyui-textbox"  id="certificateNumber" name="certificateNumber" style="width:140px"
             	maxlength="6" style="width:140px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="queryCertificate();">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAdd()" class="easyui-linkbutton" >新增</a>
            <a id="btn_edit" onclick="openEditor()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="deleteCertificate()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid"></table>
    </div>
</div>
<!-- 新增对话框 -->
<div id="dlg" style="padding:10px 10px;display: none">
		<form id="userData" style="width: 100%;margin: 0;padding:0;" method="post">
			<table class="fm_table" style="width:100%;height: 40%;table-layout:fixed">
				<tr>
					<td style="width:50px;" class="fm_lable">企业名称</td>
					<td style="width:50%;">
						<input type="hidden" id="cc4" name="enterpriseUuid">
						<select id="cc1" class="easyui-combobox"  name="name"  style="width: 100%" data-options="required:true,prompt:'请选择',
		                     editable:false">
	              		</select>
					<td style="width:50px;" class="fm_lable">业务类型</td>
					<td style="width:50%;">
						<select class="easyui-combobox" id="businessType" name="businessType"  style="width: 100%" data-options="
		                     required:true,
		                     editable:false,
		                     data:type,
		                     valueField:'code',
		                     textField:'name',
		                     prompt:'请选择'">
	              		</select>
					</td>
					<td style="width:50px;" class="fm_lable">证书编号</td>
					<td style="width:50%;"><input class="easyui-textbox" id="certificateNumber" name="certificateNumber" 
						style="width: 100%" maxlength="30" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">数字证书失效日期</td>
					<td style="width:50%;">
						<input class="easyui-datebox" id="expiryDate" name="expiryDate" style="width: 100%" data-options="required:true,editable:false"></td>
					<td style="width:50px;" class="fm_lable">预警天数设置</td>
					<td style="width:50%;">
						<input id="warningDays" name="warningDays" class="easyui-textbox" style="width: 100%" data-options="required:true">
					</td>
					<td style="width:50px;" class="fm_lable">组织机构代码证号</td>
					<td style="width:50%;">
						<input class="easyui-textbox" id="cc2" name="orgCode" style="width: 100%" data-options="editable:false">
					</td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">社保登记证号</td>
					<td style="width:50%;">
						<input class="easyui-textbox" id="cc3" name="insuranceAccount" style="width: 100%" data-options="editable:false">
					</td>
					<td style="width:100px;" class="fm_lable">登录口令</td>
					<td style="width:50%;">
						<input id="loginPassword" name="loginPassword" 
							   class="easyui-textbox" style="width: 100%" data-options="required:true">
					</td>
					<td style="width:50px;" class="fm_lable">证书密码</td>
					<td style="width:50%;">
						<input class="easyui-textbox" id="certificatePassword"
							   name="certificatePassword" style="width: 100%" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">创建人</td>
					<td style="width:50%;">
						<input class="easyui-textbox" id="createName"
							   name="createName" style="width: 100%" data-options="editable:false" value="${createName}">
					</td>
					<td style="width:100px;" class="fm_lable">创建日期</td>
					<td style="width:50%;">
						<input id="createDate" name="createDate" readonly="readonly"
							   class="easyui-datebox" style="width: 100%" value="javascript:new Date();">
					</td>
				</tr>
			</table>
		</form>
</div>

<!-- 修改 -->
<div id="editDlg" style="padding:10px 10px;display: none">
		<form id="editData" style="width: 100%;margin: 0;padding:0;" method="post">
			<table class="fm_table" style="width:100%;height: 40%;table-layout:fixed">
				<tr>
					<td style="width:50px;" class="fm_lable">企业名称</td>
						<input type="hidden" id="id" name="id" value="${data[0].id}" />
					<td style="width:50%;">
						<select id="cc5" name="name" class="easyui-combobox" style="width: 100%" data-options="
		                     required:true,
		                     editable:false">
						</select>
					</td>
					<td style="width:50px;" class="fm_lable">业务类型</td>
					<td style="width:50%;">
						<select class="easyui-combobox" id="businessType" name="businessType" style="width: 100%" data-options="
		                     required:true,
		                     editable:false,
		                     data:type,
		                     valueField:'code',
		                     textField:'name',
		                     prompt:'请选择'">
	              		</select>
	              	</td>
					<td style="width:50px;" class="fm_lable">证书编号</td>
					<td style="width:50%;"><input class="easyui-textbox" id="certificateNumber"
						name="certificateNumber" style="width: 100%" maxlength="30" data-options="required:true"></td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">数字证书失效日期</td>
					<td style="width:50%;"><input class="easyui-datebox" id="expiryDate"
						name="expiryDate" style="width: 100%" data-options="required:true,editable:false"></td>
					<td style="width:100px;" class="fm_lable">预警天数设置</td>
					<td style="width:50%;"><input id="warningDays" name="warningDays"
						class="easyui-textbox" style="width: 100%" data-options="required:true"></td>
					<td style="width:50px;" class="fm_lable">组织机构代码证号</td>
					<td style="width:50%;"><input class="easyui-textbox" id="cc6"
						name="orgCode" style="width: 100%" data-options="editable:false"></td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">社保登记证号</td>
					<td style="width:50%;"><input class="easyui-textbox" id="cc7"
						name="insuranceAccount" style="width: 100%" data-options="editable:false"></td>
					<td style="width:100px;" class="fm_lable">登录口令</td>
					<td style="width:50%;"><input id="loginPassword" name="loginPassword"
						class="easyui-textbox" style="width: 100%" data-options="required:true"></td>
					<td style="width:50px;" class="fm_lable">证书密码</td>
					<td style="width:50%;"><input class="easyui-textbox" id="certificatePassword"
						name="certificatePassword" style="width: 100%" data-options="required:true"></td>
				</tr>
				<tr>
					<td style="width:50px;" class="fm_lable">创建人</td>
					<td style="width:50%;"><input class="easyui-textbox" id="createName"
						name="createName" style="width: 100%" value="${createName}" data-options="editable:false"></td>
					<td style="width:100px;" class="fm_lable">创建日期</td>
					<td style="width:50%;"><input id="createDate" name="createDate"
						class="easyui-datebox" style="width: 100%" value="javascript:new Date();" readonly="readonly"></td>
				</tr>
			</table>
		</form>
</div>


</body>
</html>