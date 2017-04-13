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

<!-- 编辑对话框 -->
<div id="editorDlg"   style="padding:10px 10px;">
  <form id="updateGongjjPropt" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	公积金参数：
            	<select id="fund" name="uuid" style="width:120px;" onchange="editFund()">
					<c:forEach var="s" items="${fund }">
						<option value="${s.uuid}" <c:if test="${s.yearCity == proportion[0].yearCity}">selected="selected"</c:if>>${s.yearCity }</option>
					</c:forEach>
				</select>
        </label>
        <label style="padding: 0 5px">
            	企业名称：
            	<select id="enterprise" name="enterpriseId" style="width:140px;" onchange="editEnterprise()">
					<c:forEach var="s" items="${enterprise }">
						<option value="${s.id }" <c:if test="${s.name == proportion[0].enterpriseName}">selected="selected"</c:if>>${s.name }</option>
					</c:forEach>
				</select>
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input type= "text" id="cc2" class= "easyui-datebox" editable="false" required ="required"  name="startTime" value="${proportion[0].startTime }"  maxlength="30" style="width:100px">
        	至<input type= "text" id="cc3" class= "easyui-datebox" name="endTime" value="${proportion[0].endTime }" editable="false" required ="required"  maxlength="30" style="width:100px">
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 100%;padding-top: 30px;">
    		<input type="hidden" id="enterpriseName" name="enterpriseName" value="${proportion[0].enterpriseName}">
    		<input type="hidden" id="yearCity" name="yearCity" value="${proportion[0].yearCity}">
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
			    <c:forEach var="s" items="${proportion }">
			        <tr>   
			            <input type="hidden" name="codes" value="${s.code }">
			            <input type="hidden" name="names" value="${s.name }">
			            <input type="hidden" name="ids" value="${s.id}">
			            <td >${s.name }</td>
			            <td><input id="qy" class="easyui-numberbox" name='enterprises' value="${s.enterprise }" required="required" style="width: 80px;"/></td>
			            <td><input id="gfx" class="easyui-numberbox" name='personalNotFloors' value="${s.personalNotFloor }" required="required" style="width: 80px;"/></td>
			            <td><input id="gx" class="easyui-numberbox" name='personalFloors' value="${s.personalFloor }" required="required" style="width: 80px;"/></td>
			        </tr>  
			    </c:forEach>
			    </tbody>   
			</table>  
        </div>
  </form>
</div>


</body>
</html>