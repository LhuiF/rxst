<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../resources.jsp"/>
 <script type="text/javascript">
        //城市信息
        var allcity = ${u:getJsonArray("20025")};
        //缴费人员类别
        var allrytype=${u:getJsonArray("20003")};
        //险种信息
        var allsbxz=${u:getJsonArray("20009")};
        
     </script>
<script type="text/javascript">
	$(function() {
		$('#sheBaoMainList').datagrid({
			idField : 'id',
			url : '${CP}/sheBaoMainListController/geRsInsuranceList',
			fit : true,
			loadMsg : '数据加载中...',
			pageSize : 10,
			pagination : true,
			sortOrder : 'asc',
			rownumbers : true,
			singleSelect : true,
			fitColumns : true,
			showFooter : true,
			/* frozenColumns : [[{
				field : 'goOrderCode',
				title : '订单号',
				sortable : true
			}]], */
			columns : [[
				{
					field : 'id',
					title : '编号',
					hidden : true,
					sortable : true
				    
				},
				{
					field : 'id',
					title : 'uuid',
					hidden : true
					
				},
				{
					field : 'dictName',
					title : '城市名称',
					width:'20%'
					
				},
				{
					field : 'insuranceYear',
					title : '社保年度',
					width:'20%'
				},
				{
					field : 'checkMonth',
					title : '基数核定月份',
					idth:'20%'
				},
				
				{
					field : 'comment',
					title : '备注',
					sortable : false,
					width:'30%'
				},
				{
					field : 'opt',
					title : '操作',
					width : '10%',
					formatter : function(value, rec, index) {
						if (!rec.id) {
							return '';
						}
						var href = '';
						href += "[<a href='#' onclick=delObj('${CP}/sheBaoMainListController/delObjById/"
								+ rec.id
								+ "','sheBaoMainList')>";
						href += "删除</a>]";
						return href;
					}
				}]],
				
			onLoadSuccess : function(data) {
				$("#sheBaoMainList").datagrid("clearSelections");
			},
			onClickRow : function(rowIndex, rowData) {
			  	rowid = rowData.id;
				gridname = 'sheBaoZhuMainList';
				 //alert(gridname);
			},
			toolbar:"#tb" 
		});
	
	});
	function reloadTable() {
		$('#' + gridname).datagrid('reload');
	}

  function Listsearch(){
	var queryParams=$('#sheBaoMainList').datagrid('options').queryParams;
	$('#searchBox').find('*').each(function(){
		queryParams[$(this).attr('name')]=$(this).val();
	});
	$('#sheBaoMainList').datagrid({
		url:'${CP}/sheBaoMainListController/geRsInsuranceList',
		pageNumber:1
		}
	);
	}
	
</script>
<script type="text/javascript" src="${CP}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
<script type="text/javascript" src="${CP}/plug-in/lhgDialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="${CP}/plug-in/tools/curdtools_zh-cn.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div id="searchBox" data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            城市：<!-- <input class="easyui-combobox" name="dictName"  id="dictName" maxlength="30" style="width:140px"> -->
            <select class="easyui-combobox" id="dictCode" name="dictCode"  style="width:140px" data-options="
	           data:allcity,
	           valueField:'code',
	           textField:'name'">
	        </select>
        </label>
        <label style="padding: 0 5px">
            社保年度：<input class="easyui-combobox" name="insuranceYear" id="insuranceYear" maxlength="30" style="width:140px">
        </label>
       <a href="#" class="easyui-linkbutton" onclick="Listsearch()">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
           <a id="btn_add" onclick="add('录入','${CP}/sheBaoMainListController/shebaoCanshuAdd','sheBaoMainList',1000,600)" class="easyui-linkbutton" >新增</a> 
           <a id="btn_edit" href="#" onclick="update('编辑','${CP}/sheBaoMainListController?ShebaocanshuEdit','sheBaoMainList',1000,600)" class="easyui-linkbutton">修改</a>
           <a id="btn_delete" href="#" onclick="delete('删除','sheBaoMainListController.do?addorupdateNoTag','sheBaoMainList',1000,400)" class="easyui-linkbutton">删除</a>
	      <a id="btn_detail" href="#" onclick="detail('详情','${CP}/sheBaoMainListController?ShebaocanshuEdit','sheBaoMainList',1000,600)" class="easyui-linkbutton btn-add">详情</a>
        </div>
        <table width="100%" id="sheBaoMainList"></table>
    </div>
</div>
