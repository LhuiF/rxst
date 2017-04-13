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

<!-- 修改对话框 -->
<div id="editorDlg"   style="padding:10px 10px;">
  <form id="editorShebaoProportion" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	社保参数：<input class= "easyui-combobox" name="shebaoParam" value="${Insurance[0].yearCity }" id="shebaoParam" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input class= "easyui-datebox" editable="false" required ="required"  name="year" value="${Insurance[0].startTime }" id="year1" maxlength="30" style="width:140px">
        	至<input type= "text" class= "easyui-datebox" name="year" value="${Insurance[0].endTime }"  id="year2" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 95%;padding-top: 30px">
	        <table id="editorShebaoProptData" class="td">   
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
			    <c:forEach items="${data}" var="s" varStatus="stuts"> 
    <tr>   
         <td style="width: 100px">${s.name }</td>
         <input type="hidden" name="id" value="${s.id }"/>
         <input type="hidden" name="uuid" value="${s.uuid }"/>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].pensionsEnterprise' value="${s.detail.pensionsEnterprise }" required="required" style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].pensionsPersonal' value="${s.detail.pensionsPersonal }" required="required"  style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].unemploymentEnterprise' value="${s.detail.unemploymentEnterprise }" required="required" style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].unemploymentPersonal' value="${s.detail.unemploymentPersonal } required="required" style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].injuriesEnterprise' value="${s.detail.injuriesEnterprise } required="required" style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].injuriesPersonal' value="${s.detail.injuriesPersonal } required="required"  style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].birthEnterprise' value="${s.detail.birthEnterprise } required="required" style="width: 50px;"/></td>
         <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].birthPersonal' value="${s.detail.birthPersonal } required="required" style="width: 50px;"/></td>
		 <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].medicalEnterprise' value="${s.detail.medicalEnterprise } required="required" style="width: 50px;"/></td>
		 <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].medicalPersonal' value="${s.detail.medicalPersonal } required="required" style="width: 50px;"/></td>
		 <td><input class="easyui-numberbox" data-options="min:0,precision:1" name='list[${stuts.index}].personalIllness' value="${s.detail.personalIllness } required="required" style="width: 55px;"/></td>
     </tr>    
			 	</c:forEach>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<!-- 修改结束 -->


</body>
</html>