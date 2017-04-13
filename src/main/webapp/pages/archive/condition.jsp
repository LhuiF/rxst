<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../resources.jsp" />
<title>情况档案</title>
<script type="text/javascript" src="${CP}/js/page/archive/condition.js"></script>
<script type="text/javascript" src="${CP}/js/page/proxyInfo/formToJson.js"></script>
<script type="text/javascript">

	function resetTrNum(tableId) {
		$tbody = $("#" + tableId + "");
		$tbody.find('>tr').each(function(i){
			$(':input', this).each(function() {
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if (name != null) {
					if (name.indexOf("#index#") >= 0) {
						$this.attr("name",name.replace('#index#',i));
					} else {
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s + 1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
		});
	}
	
	
	$(function (){
		$("#addTiaojianBtn1").linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$("#delBtn").linkbutton({   
		    iconCls: 'icon-remove'  
		});  
	    $("#addTiaojianBtn1").bind('click', function(){
	    	var tr =  $("#add_tiaojian_table_template tr").clone();
	     	 $("#add_tiaojian_table").append(tr);
	     	 var nidx = $("#add_tiaojian_table tr").length;
	     	$("#add_tiaojian_table tr").eq(nidx-1).find('.atbidx').html(""+nidx+"");
	    });
	    $("#conditions_table").delegate(".btn-remove","click",function(){
	    	 $(this).parents('tr').remove();
	    	 var listId = $(this).parents('tr').find('.xglId').html();
	    	 var baseurl = basePath+"/rsConditionArchiveController/deleteConditionById";
	    	 if(listId){
	    		 $.ajax({
		             type: "POST",
		             url: baseurl,
		             data: {id:listId},
		             dataType: "json",
		             success: function(data){
		             }
		         });
	    	 };
	    	resetTrNum('addTJ_add'); 
     	});
	})
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
			<label style="padding: 0 5px">产品名称：
				<input class="easyui-textbox" name="produtName" id="produtName" maxlength="30" style="width:140px">
			</label> 
			<label style="padding: 0 5px">是否网申： 
				<select id="isOnlineApply" class="easyui-combobox" name="isOnlineApply" style="width:140px"
						data-options="required:true,editable:false,panelHeight:'auto'">
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</label>
			<a href="#" class="easyui-linkbutton" onclick="queryArchive()">查询</a>
		</div>
		<div data-options="region:'center',border:0,fit:true">
			<div id="tb">
				<a id="btn_add" onclick="openAddUser()" class="easyui-linkbutton">新增</a>
				<a id="btn_update" onclick="updateUser()" class="easyui-linkbutton">修改</a>
				<a id="btn_del" onclick="deleteUser()" class="easyui-linkbutton">删除</a>
			</div>
			<table style="height: 91%" id="datagrid"></table>
		</div>
	</div>

	<!-- 新增对话框 -->
	<div id="dlg" style="padding:10px 10px;display: none">
		<form id="userData" style="width: 100%;margin: 0;padding:0;"
			method="post">
			<div style="height:0px; width:0px; overflow:hidden;">
				<input type="hidden" id="cpId" name="produtUuid">
				<input type="hidden" id="id" name="id" class="easyui-textbox">
			</div>
			<table class="fm_table" >
				
				<tr>
					<td class="fm_lable">产品名称</td>
					<td>
						<select id="cp1" name="produtName" class="easyui-combobox"  
						data-options="required:true">
						</select>
					</td>
					<td  class="fm_lable">是否网申</td>
					<td>
					    <select id="isOnlineApply" class="easyui-combobox" name="isOnlineApply" 
					     data-options="required:true">
							<option value="是">是</option>
							<option value="否">否</option>
					    </select>
				  	</td>
					<td  class="fm_lable">创建人</td>
					<td>
						<input class="easyui-textbox" id="createName" name="createName" data-options="editable:false" value="${createName}">
					</td>
					<td  class="fm_lable">创建日期</td>
					<td>
					    <input class="easyui-datebox" id="createDate"  readonly="readonly"  value="javascript:new Date();">
					</td>
				</tr>
				<tr>
					<td class="fm_lable">备注</td>
					<td colspan="7">
						<input id="remark" name="remark" class="easyui-textbox" style="width: 100%;height: 50px;"
							   data-options=" multiline:true,validType:'maxLength[550]'">
					</td>
				</tr>
			</table>

			<div style="width: auto; height: 200px; padding-top:30px;">
				<div style="width: 690px; height: 1px;"></div>
						<div style="padding: 3px; height: 25px; width: auto;"
							class="datagrid-toolbar">
							<span>添加符合条件</span>
							<a id="addTiaojianBtn1" data-options="" href="#" >新增</a> 
							<!-- <a id="delBtn" href="#" >删除</a> -->
						</div>
						<table id="conditions_table" border="0" cellpadding="2" cellspacing="0" >
							<tbody id="add_tiaojian_table">
							</tbody>
						</table>
				</div>
		</form>
    <table style="display: none">
	 <tbody id="add_tiaojian_table_template">
		<tr>
			<td style="align:center;bgcolor:#EEEEEE" >
			<span class="atbidx" style="width:20px;display:inline-block"></span>
			<p class="xglId" style="display: none"></p>
			<input id="conditions" name="conditions" 
				style="width: 658px;height: 50px; margin-right: 10px;"
				data-options="multiline:true,validType:'maxLength[550]'">
			<a id="delBtn" href="#" >删除</a>
			</td>
		</tr>
	</tbody>
  </table>
</div>


</body>
</html>