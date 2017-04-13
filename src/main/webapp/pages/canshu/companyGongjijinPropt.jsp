<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>企业公积金缴费比例</title>
   <script type="text/javascript" src="${CP}/pages/canshu/companyGongjijinPropt.js"></script>
   <link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
    <form id="queryEnterprise" action="/EnterpriseProportionController/getEnterpriseByParameter" style="width: 100%;margin: 0;padding:0;" method="post">
	       <label style="padding: 0 5px">
	            企业名称：<select class="easyui-combobox" name="enterpriseName" style="width:140px;">
					<option value="">请选择或输入</option>
					<c:forEach var="s" items="${enterprise }">
						<option value="${s.id }">${s.name }</option>
					</c:forEach>
				</select>
	      </label>
	        <label style="padding: 0 5px">
	          公积金参数：<select  class="easyui-combobox" name="yearCity" style="width:140px;">
					<option value="">请选择或输入</option>
					<c:forEach var="s" items="${proportion }">
					<option value="${s.uuid }">${s.yearCity }</option>
					</c:forEach>
				</select>
	        </label>
	        <a href="#" class="easyui-linkbutton" onclick="queryEnterprise();">查询</a>
        </form>
      </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddCmpGongjjPropt()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="editorProportion()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="deleteProportion()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid">
        
        </table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none;">
  <form id="cmpGongjjPropt" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	公积金参数：<input id="cc" class= "easyui-combobox" name="yearCity" required ="required" maxlength="30" style="width:120px">
        </label>
        <label style="padding: 0 5px">
            	企业名称：<input id="cc1" class= "easyui-combobox" name="enterpriseId"   required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input type= "text" id="cc2" class= "easyui-datebox" editable="false" required ="required"  name="startTime" maxlength="30" style="width:100px">
        	至<input type= "text" id="cc3" class= "easyui-datebox" name="endTime" editable="false" required ="required"  maxlength="30" style="width:100px">
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 100%;padding-top: 30px;">
    		<input type="hidden" id="uuid" name="uuid">
    		<input type="hidden" id="enterpriseNameAdd" name="enterpriseName">
	        <table id="addCmpGongjjPropt" class="td">   
			    <thead>   
			        <tr>   
			           <th style="width: 80px;">户口类型</th>  
			           <th>企业</th>  
			           <th>个人非下限</th>  
			           <th>个人下限</th> 
			         </tr> 
			    </thead>   
			    <tbody class="cgjrTb">   
			    <c:forEach var="s" items="${huokou }">
			        <tr>   
			            <input type="hidden" name="codes" value="${s.code }">
			            <input type="hidden" name="names" value="${s.name }">
			            <td >${s.name }</td>
			            <td><input id="qy" class="easyui-numberbox" name='enterprises' required="required" style="width: 80px;"/></td>
			            <td><input id="gfx" class="easyui-numberbox" name='personalNotFloors' required="required" style="width: 80px;"/></td>
			            <td><input id="gx" class="easyui-numberbox" name='personalFloors' required="required" style="width: 80px;"/></td>
			        </tr>  
			    </c:forEach>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 编辑 -->
<div id="editorDlg"/>
</body>
</html>