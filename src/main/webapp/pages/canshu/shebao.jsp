<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>社保管理</title>
    
<script type="text/javascript" src="${CP}/pages/canshu/shebao.js"></script>
<link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
           城市：<input class="easyui-combobox" name="city"  id="city" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            社保年度：<input class="easyui-combobox" name="year" id="year" maxlength="30" style="width:140px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddParam()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="openEditorParam()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="opendeleteParam()" class="easyui-linkbutton" >删除</a>
       
        </div>
        <table id="datagrid"></table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none">
  <form id="paramData" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
         	城市：<input class="easyui-combobox" name="city"  id="city" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            	社保年度：<input  class= "easyui-combobox" name="year"  id="year" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input  class= "easyui-datebox" editable="false" required ="required"  name="year"  id="year1" maxlength="30" style="width:140px">
        	至<input type= "text" class= "easyui-datebox" name="year"  id="year2" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
       <br/><br/>
        <label style="padding: 5px 5px">
        	基数核定月份：<input  class= "easyui-combobox" name="month"  id="month" required ="required" maxlength="30" style="width:140px">
   		</label>
	     <label style="padding: 5px 5px">
	         	社会平均工资：<input  class= "easyui-textbox" name="average_pay"  id="avg_salary"  maxlength="30" style="width:140px">元
	   </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 500px;">
    	<div style='margin:20px'><strong style="font-size:20px;">缴费人员类别</strong></div>
    	<table id="pay_peo_type" class='td'>   
			    <thead>   
			        <tr>   
			           <th >缴费人员类别</th>     
			           <th>开始日期</th>  
			           <th>截止日期</th> 
			        </tr>   
			    </thead>   
			    <tbody>  
			    <%-- <c:forEach items="${ cities}" var="city"> --%>
			        <tr>   
			            <td><input class='easyui-textbox' name='dict_name' width="60px"/></td>
			            <td><input class='easyui-datebox' name='start_time' width="60px" editable="false"/></td>
			            <td><input class='easyui-datebox' name='end_time' width="60px" editable="false"/></td>
			        </tr>   
			     <%-- </c:forEach>  --%>
			    </tbody>   
			</table>  
			
	<div style='margin:20px'><strong style="font-size:20px;">险种基数</strong></div>
       		<table id="socialInsurance" style="width:600px;"  class='td'>   
			    <thead>   
			        <tr>   
			           <th>险种</th>   
			           <th>上限</th>   
			           <th>下限</th>
			           <th>上限基数</th>   
			           <th>下限基数</th> 
			         </tr>   
			    </thead>   
			    <tbody> 
				  <%--   <c:forEach items="${insurance}" var="insType"> --%>
				        <tr>   
				            <td><input class="easyui-textbox" name='dict_name'/></td>
				            <td><input class="easyui-numberbox" name='ceiling' data-options="min:0,precision:2"/></td>
				            <td><input class="easyui-numberbox" name='floor' data-options="min:0,precision:2"/></td>
				            <td><input class="easyui-numberbox" name='ceiling_base' data-options="min:0,precision:2" readonly="true"/></td>
				            <td><input class="easyui-numberbox" name='floor_base' data-options="min:0,precision:2"  readonly="true"/></td> 
				         </tr>   
					<%-- </c:forEach>   --%>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 修改对话框 -->
<div id="editorDlg"   style="padding:10px 10px;display: none">
  <form id="editorParam" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
         	城市：<input class="easyui-combobox" name="city"  id="city" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            	社保年度：<input  class= "easyui-combobox" name="year"  id="year" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input  class= "easyui-datebox" editable='false' name="year" required ="required" id="year1" maxlength="30" style="width:140px">
        	至<input  class= "easyui-datebox" name="year"  id="year2" editable="false" required ="required" maxlength="30" style="width:140px">
        </label>
       <br/><br/>
        <label style="padding: 5px 5px">
        	基数核定月份：<input  class= "easyui-combobox" name="month"  id="month" required ="required" maxlength="30" style="width:140px">
   		</label>
	     <label style="padding: 5px 5px">
	         	社会平均工资：<input  class= "easyui-textbox" name="avg_salary"  id="avg_salary"  maxlength="30" style="width:140px">元
	   </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 500px;">
    	<div style='margin:20px'><strong style="font-size:20px;">缴费人员类别</strong></div>
	         <table id="editorPayPeoType" class="td">   
			  <thead>   
			        <tr>   
			           <th >缴费人员类别</th>     
			           <th>开始日期</th>  
			           <th>截止日期</th> 
			        </tr>   
			    </thead>   
			    <tbody>  
			    <%-- <c:forEach items="${ cities}" var="city"> --%>
			        <tr>   
			            <td><input class='easyui-textbox' name='dict_name' width="60px"/></td>
			            <td><input class='easyui-datebox' name='start_time' width="60px" editable="false"/></td>
			            <td><input class='easyui-datebox' name='end_time' width="60px" editable="false"/></td>
			        </tr>   
			     <%-- </c:forEach>  --%>
			    </tbody>    
			</table>  
	<div style='margin:20px'><strong style="font-size:20px;">险种基数</strong></div>
       		<table id="socialInsurance" style="width:600px;"  class='td'>   
			    <thead>   
			        <tr>   
			           <th>险种</th>   
			           <th>上限</th>   
			           <th>下限</th>
			           <th>上限基数</th>   
			           <th>下限基数</th> 
			         </tr>   
			    </thead>   
			    <tbody> 
				  <%--   <c:forEach items="${insurance}" var="insType"> --%>
				        <tr>   
				            <td><input class="easyui-textbox" name='dict_name'/></td>
				            <td><input class="easyui-numberbox" name='ceiling' value='ceiling' data-options="min:0,precision:2"/></td>
				            <td><input class="easyui-numberbox" name='floor' value='floor' data-options="min:0,precision:2"/></td>
				            <td><input class="easyui-numberbox" name='ceiling_base' value='ceiling_base' data-options="min:0,precision:2" readonly="true"/></td>
				            <td><input class="easyui-numberbox" name='floor_base' value='floor_base' data-options="min:0,precision:2"  readonly="true"/></td> 
				         </tr>   
					<%-- </c:forEach>   --%>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>
<!-- 修改结束 -->


</body>
</html>