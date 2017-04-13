<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>企业社保缴费比例</title>
   <script type="text/javascript" src="${CP}/pages/canshu/companyShebaoPropt.js"></script>
  <link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
          企业名称：<input class="easyui-combobox" name="company_name"  id="company_name" maxlength="30" style="width:140px">
        </label>
           <label style="padding: 0 5px">
           社保参数：<input class="easyui-combobox" name="shebaoParam"  id="shebaoParam" maxlength="30" style="width:140px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
      </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddCompanyShebao()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="openEditorCompanyShebao()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="opendeleteCompanyShebao()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid">
        
        </table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none">
  <form id="cmpShebaoProptData" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	社保参数：<input class= "easyui-combobox" name="shebaoParam"  id="shebaoParam" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            	企业名称：<input class= "easyui-combobox" name="shebaoParam"  id="shebaoParam" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input class= "easyui-datebox" editable="false" required ="required"  name="year"  id="year1" maxlength="30" style="width:140px">
        	至<input type= "text" class= "easyui-datebox" name="year"  id="year2" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
    </div>
    <div data-options="region:'center',border:0" style="width: 600px;padding-top: 30px">
	        <table id="addCmpShebaoProportion" class="td" >   
			    <thead>   
			        <tr>   
			           <th rowspan="2" >缴费人员类别</th>  
			           <th colspan="2">养老</th>  
			           <th colspan="2">失业</th> 
			           <th colspan="2">工伤</th>  
			           <th colspan="2">生育</th> 
			           <th colspan="3">医疗</th> 			        
			        </tr>  
			        <tr>
						<th>企业</th>
						<th>个人</th>
						<th >企业</th>
						<th>个人</th>
						<th >企业</th>
						<th>个人</th>
						<th>企业</th>
						<th >个人</th>
						<th >企业</th>
						<th>个人</th>
						<th>个人大病（元）</th>
					</tr>
			    </thead>   
			    <tbody>   
			    <%-- <c:forEach items="${payTypes}" var="payType"> --%>
			        <tr>   
			            <td><input class="easyui-textbox" name='dict_name' value="本市城镇职工" style="width: 100px;text-align:center;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company'  required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='presonalIll' required="required" style="width: 50px;"/></td>
			           
			           </tr>    
			 <%-- 	</c:forEach> --%>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 修改对话框 -->
<div id="editorDlg"   style="padding:10px 10px;display: none">
  <form id="editorCmpShebaoProportion" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	社保参数：<input type= "text" class= "easyui-combobox" name="shebaoParam"  id="shebaoParam" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input type= "text" class= "easyui-datebox" editable="false" required ="required"  name="year"  id="year1" maxlength="30" style="width:140px">
        	至<input type= "text" class= "easyui-datebox" name="year"  id="year2" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 750px;padding-top: 30px">
	        <table id="editorCmpShebaoProptData" class="td">   
			    <thead>   
			        <tr>   
			           <th rowspan="2" >缴费人员类别</th>  
			           <th colspan="2">养老</th>  
			           <th colspan="2">失业</th> 
			           <th colspan="2">工伤</th>  
			           <th colspan="2">生育</th> 
			           <th colspan="3">医疗</th> 			        
			        </tr>  
			        <tr>
						<th>企业</th>
						<th>个人</th>
						<th >企业</th>
						<th>个人</th>
						<th >企业</th>
						<th>个人</th>
						<th>企业</th>
						<th >个人</th>
						<th >企业</th>
						<th>个人</th>
						<th>个人大病（元）</th>
					</tr>
			    </thead>   
			    <tbody>   
			    <%-- <c:forEach items="${payTypes}" var="payType"> --%>
			        <tr>   
			            <td><input class="easyui-textbox" name='dict_name' value="本市城镇职工" style="width: 100px;text-align:center;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company'  required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='company' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='personal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" name='presonalIll' required="required" style="width: 50px;"/></td>
			           
			           </tr>    
			 <%-- 	</c:forEach> --%>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 修改结束 -->


</body>
</html>