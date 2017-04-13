<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>社保缴费比例</title>
   <script type="text/javascript" src="${CP}/pages/canshu/shebaoProportion.js"></script>
  <link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
    <form id="queryInsurance" action="/RsInsuranceProportionController/getInsuranceByProp" style="width: 100%;margin: 0;padding:0;" method="post">
        <label style="padding: 0 5px">
           社保参数：<select id="cc" class="easyui-combobox" name="uuid" style="width:140px;">
				<option value="">请选择</option>
				<c:forEach var="s" items="${insurance }">
					<option value="${s.uuid }">${s.yearCity }</option>
				</c:forEach>
			</select>
        </label>
        <a href="#" class="easyui-linkbutton" onclick="query();">查询</a>
      </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddShebaoProportion()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="editorShebaoProportion()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="deleteShebaoProportion()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid">
        
        </table>
    </div>
    </form>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none">
  <form id="shebaoProptData" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	社保参数：
            	<select id="cc1" class="easyui-combobox" name="dept" style="width:140px;" required="required">
					<option value="">请选择</option>
				</select>
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input id="cc2" class="easyui-datebox" style="width:140px;"/>
        	至<input id="cc3" class="easyui-datebox" style="width:140px;"/>
        </label>
    </div>
    <div data-options="region:'center',border:0" style="width: 95%;padding-top: 30px">
	        <table id="addShebaoProportion" class="td" >   
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
			    <input type="hidden" id="insuranceUuid" name="uuid"/>
			    <c:forEach items="${category}" var="s" varStatus="stuts">
			        <tr>   
			            <td style="width: 100px">${s.name }</td>
			            <input type="hidden" name="names" value="${s.name }"/>
			            <input type="hidden" name="codes" value="${s.code }"/>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].pensionsEnterprise' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].pensionsPersonal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].unemploymentEnterprise'  required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].unemploymentPersonal' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].injuriesEnterprise' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].injuriesPersonal' required="required"  style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].birthEnterprise' required="required" style="width: 50px;"/></td>
			            <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].birthPersonal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].medicalEnterprise' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].medicalPersonal' required="required" style="width: 50px;"/></td>
			 		  	<td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].personalIllness' required="required" style="width: 55px;"/></td>
			        </tr>    
			 	</c:forEach>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 修改对话框 -->
<div id="editorDlg"/>


<!-- 修改结束 -->


</body>
</html>