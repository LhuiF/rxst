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
			url : '${CP}/companyshebaoController/geCompanyShebaoList',
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
					field : 'companyName',
					title : '企业名称',
					align:'center',
					width:'20%'
					
				},
				{
					field : 'shebaoCanshuYearcity',
					title : '社保参数',
					align:'center',
					width:'20%'
				},
				{
					field : 'shebaoCanshuStarttime',
					title : '政策开始日期',
					align:'center',
					idth:'20%'
				},
				
				{
					field : 'shebaoCanshuEndtime',
					title : '政策结束日期',
					align:'center',
					sortable : false,
					width:'20%'
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
						href += "[<a href='#' onclick=delObj('${CP}/companyshebaoController/delObjById/"
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
		url:'${CP}/companyshebaoController/geCompanyShebaoList',
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
            企业名称：<select class="easyui-combobox" name="companyUuid" id="companyUuid" style="width:140px;">
					<option value="">请选择或输入</option>
					<c:forEach var="s" items="${enterprise }">
						<option value="${s.id }">${s.name }</option>
					</c:forEach>
				</select>
        </label>
        <label style="padding: 0 5px">
            <!-- <input class="easyui-combobox" name="shebaoCanshuYearcity" id="shebaoCanshuYearcity" maxlength="30" style="width:140px"> -->
            社保参数：<select id="cc" class="easyui-combobox" name="shebaoCanshuUuid" id="shebaoCanshuUuid" style="width:140px;">
				<option value="">请选择</option>
				<c:forEach var="s" items="${insurance }">
					<option value="${s.uuid }">${s.yearCity }</option>
				</c:forEach>
			</select>
        </label>
       <a href="#" class="easyui-linkbutton" onclick="Listsearch()">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
           <a id="btn_add" onclick="add('录入','${CP}/companyshebaoController/companyshebaoAdd','sheBaoMainList',1000,400)" class="easyui-linkbutton" >新增</a> 
           <a id="btn_edit" onclick="update('编辑','${CP}/companyshebaoController?companyShebaocanshuEdit','sheBaoMainList',1000,400)" class="easyui-linkbutton">修改</a>
           <a id="btn_delete" href="#" onclick="delete('删除','${CP}/companyshebaoController?addorupdateNoTag','sheBaoMainList',1000,400)" class="easyui-linkbutton">删除</a>
	      <a id="btn_detail" href="#" onclick="detail('详情','${CP}/companyshebaoController?companyShebaocanshuEdit','sheBaoMainList',1000,400)" class="easyui-linkbutton btn-add">详情</a>
        </div>
        <table width="100%" id="sheBaoMainList"></table>
    </div>
</div>
