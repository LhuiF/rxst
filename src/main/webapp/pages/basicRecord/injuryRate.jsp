<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>工伤费率</title>
   <script type="text/javascript" src="${CP}/js/page/basicRecord/injuryRate.js"></script>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="searchBox" data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
         企业列表： <select class="easyui-combobox" name="company" id="company" style="width:140px">
            	<option value=""></option>
            	<option value="ynix">ynix</option>
           		<option value="al">al</option>
         		<option value="jd">jd</option>
            	
             </select>
        </label>
            <label style="padding: 0 5px">
         年度：<select class="easyui-combobox" id="year" name="year"  style="width:140px">
	            		<option value="">请选择</option>
	                    <option value="2015">2015</option>
	                    <option value="2016">2016</option>
	            </select>
         </label>
        <a href="#" class="easyui-linkbutton" onclick="Listsearch();">查询</a>
      </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddInjuryRate()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="openEditorInjuryRate()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="deleteInjuryrate()" class="easyui-linkbutton" >删除</a>
        </div>
        
        <table id="datagrid"></table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none;">
  <form id="addInjuryRate" style="width: 100%;margin: 0;padding:0;" method="post">
    <div style="margin-bottom: 10px;padding:10px;">
           <label style="padding: 0 5px">
         企业列表： <select name="company" style="width:140px">
         		<option value="">请选择</option>
             	<option value="ynix">ynix</option>
           		<option value="al">al</option>
         		<option value="jd">jd</option>
             </select>
        </label>
            <label style="padding: 0 5px">
         年度：<select name="year" style="width:140px">
         		<option value="">请选择</option>
            	<option value="2016">2016</option>
            	<option value="2015">2015</option>
            	<option value="2014">2014</option>
               <%-- <c:forEach var="sex" items="${user}">
                    <option value="${sex}"></option>
                </c:forEach> --%>
             </select>
         </label>
         <br/><br/>
        <label style="padding: 0 5px">
           	开始时间：<input  class= "easyui-datebox" editable="false" required ="required"  name="startTime"   maxlength="30" style="width:140px">
        	结束时间：<input class= "easyui-datebox" name="endTime"   editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
        <br/><br/>
          <label style="padding: 0 5px">
         费率：<input class="easyui-numberbox" name="rate"   maxlength="30" style="width:140px">%
        </label>
    </div>
  </form>
</div>

<!-- 修改 -->
<div id="editorDlg"   style="padding:10px 10px;display: none;">
  <form id="editorInjuryRate" style="width: 100%;margin: 0;padding:0;" method="post">
    <div style="margin-bottom: 10px;padding:10px;">
    	<input type="hidden" name="id" value='id'/>
             <label style="padding: 0 5px">
         企业列表： <select class="easyui-combobox" name="company"  style="width:140px"
             	data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
            	<option value="ynix">ynix</option>
           		<option value="al">al</option>
         		<option value="jd">jd</option>
             </select>
        </label>
            <label style="padding: 0 5px">
         年度：<select class="easyui-combobox" name="year" style="width:140px"
             	data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
            	<option value="2016">2016</option>
            	<option value="2015">2015</option>
            	<option value="2014">2014</option>
               <%-- <c:forEach var="sex" items="${user}">
                    <option value="${sex}"></option>
                </c:forEach> --%>
             </select>
         </label>
         <br/><br/>
        <label style="padding: 0 5px">
           	开始时间：<input  class= "easyui-datebox" editable="false" required ="required"  name="startTime"  value="startTime" maxlength="30" style="width:140px">
        	结束时间：<input class= "easyui-datebox" name="endTime"  value="endTime" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
        <br/><br/>
          <label style="padding: 0 5px">
         费率：<input class="easyui-numberbox" data-options="min:0,precision:2" name="rate"  value="rate" maxlength="30" style="width:140px">%
        </label>
    </div>
  </form>
</div>


</body>
</html>