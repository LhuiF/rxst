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
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
		<form id="queryAccumulation" action="/ProportionController/getAccumByProp" style="width: 100%;margin: 0;padding:0;" method="post">
	        <label style="padding: 0 5px"> 公积金参数： 
			<select id="cc" class="easyui-combobox" name="dept" style="width:140px;">
				<option value="">请选择</option>
				<c:forEach var="s" items="${proportion }">
					<option value="${s.uuid }">${s.yearCity }</option>
				</c:forEach>
			</select>
				</label>
	        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
	      </div>
	    <div data-options="region:'center',border:0">
	        <div id="tb">
	            <a id="btn_add" onclick="openAddGongjjPropt()" class="easyui-linkbutton" >新增</a>
	             <a id="btn_edit" onclick="editorProportion()" class="easyui-linkbutton" >修改</a>
	        	<a id="btn_delete" onclick="deleteProportion()" class="easyui-linkbutton" >删除</a>
	        </div>
	        <table id="datagrid">
	        
	        </table>
	    </div>
	</form>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none;">
  <form id="gongjjPropt" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
            	公积金参数：
         <select id="cc1" class="easyui-combobox" name="dept" style="width:140px;">
			<option value="">请选择</option>
		</select>
        </label>
        <label style="padding: 0 5px">
           	 政策有效期：<input id="cc2" class="easyui-datebox" style="width:140px;"/> 
        	至<input id="cc3" class="easyui-datebox" style="width:140px;"/> 
        </label>
    </div>
    <div data-options="region:'center',border:0"style="width: 500px;padding-top: 30px;">
	        <table id="addGongjjPropt" class="td">   
			    <thead>   
			        <tr>   
			           <th >户口类型</th>  
			            <th>企业</th>  
			           <th>个人非下限</th>  
			           <th>个人下限</th> 
			         </tr> 
			    </thead>
			    <input type="hidden" id="accumulationFundUuid" name="accumulationFundUuid">   
			    <tbody>   
			    <c:forEach items="${huokou }" var="s">
			        <tr>   
			        <input type="hidden" name="codes" value="${s.code }"/>
			        <input type="hidden" name="names" value="${s.name }"/>
			        <td width="25%" >${s.name }</td>
			            <td width="25%" ><input class="easyui-numberbox" id="company" name='company' required="required" style="width: 80px;"/></td>
			            <td width="25%" ><input class="easyui-numberbox" name='notFloor' required="required" style="width: 80px;"/></td>
			            <td width="25%" ><input class="easyui-numberbox" name='floor' required="required" style="width: 80px;"/></td>
			           </tr>  
			     </c:forEach>  
			    </tbody>   
			</table>  
        </div>
  </form>
</div>

<div id="editorDlg"   style="padding:10px 10px;display: none;"/>

</body>
</html>