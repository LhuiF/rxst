<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>公积金缴费比例</title>
   <script type="text/javascript" src="${CP}/pages/canshu/gongjijinPropt.js"></script>
   <link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
  </head>

<body>

<!-- 修改对话框 -->
<div id="editorDlg"   style="padding:10px 10px">
  <form id="editorGongjjPropt" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	公积金参数：<input class= "easyui-combobox" name="gongjjParam" value="${Proportion[0].fundYear }" id="gongjjParam" required ="required" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input  class= "easyui-datebox" editable="false" required ="required"  name="year" value="${Proportion[0].startTime }" id="year1" maxlength="30" style="width:140px">
        	至<input class= "easyui-datebox" name="year" value="${Proportion[0].endTime }" id="year2" editable="false" required ="required"  maxlength="30" style="width:140px">
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 500px;padding-top: 30px;">
	        <table  id="editorGongjjData" class='td'>   
			     <thead>   
			        <tr>   
			           <th>户口类型</th>  
			            <th>企业</th>  
			           <th >个人(非下限)</th>  
			           <th>个人(下限)</th> 
			         </tr> 
			    </thead>   
			    <tbody>   
			   <c:forEach items="${Proportion}" var="s"> 
			        <tr>   
			            <td style="width:80px;">${s.name }</td>
			            <input type="hidden" name="ids" value="${s.id }"/>
			            <input type="hidden" name="accumulationFundUuid" value="${s.accumulationFundUuid }"/>
			            <td><input class="easyui-numberbox" name='company' value="${s.enterprise }" required="required" style="width: 80px;"/></td>
			            <td><input class="easyui-numberbox" name='notFloor' value="${s.personalNotFloor }" required="required" style="width: 80px;"/></td>
			            <td><input class="easyui-numberbox" name='floor' value="${s.personalFloor }" required="required" style="width: 80px;"/></td>
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