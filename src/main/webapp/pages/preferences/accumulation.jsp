<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>用户管理</title>
    <script type="text/javascript" src="${CP}/js/page/preferences/accumulation.js"></script>
	
    <script type="text/javascript">
        var organCombotreeData = ${u:getOrganTreeData()};
        var organIdToName = ${u:organIdToNameMap()};
        var allRole = ${u:allRole()};
        var allpost = ${u:getJsonArray("1003")};
        var postCodeToName = ${u:getJsonMap("1003")};
        var huo = ${u:getJsonArray("20025")};
        var userId = '<shiro:principal property="id"/>';
    </script>
    <%-- 按钮模板--%>
    <script id="optBtns" type="text/html">
        <a  href="javascript:editorUser('{{id}}')">编辑</a>
        <a  href="javascript:resetPassword('{{id}}')">重置密码</a>
        <a  href="javascript:deleteUser('{{id}}')">删除</a>
    </script>
    <%-- 按钮模板--%>
    <script id="supOptBtns" type="text/html">
        <a href="javascript:editorUser('{{id}}')">编辑</a>
        <a href="javascript:resetPassword('{{id}}')">重置密码</a>
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
	   <form id="queryAccumulation" action="/AccumulationController/getAccumulationList" style="width: 100%;margin: 0;padding:0;" method="post">
	        <label style="padding: 0 5px">
	            城市：<select class="easyui-combobox" id="dictCode" name="dictCode"  style="width:140px" data-options="
	                     data:huo,
	                     valueField:'code',
	                     textField:'name'
	                ">
	              </select>
	        </label>
	        <label style="padding: 0 5px">
	            公积金年度：<select  id="fundYear" name="fundYear"  style="width:140px">
	            		<option value="">请选择</option>
	                    <option value="2015">2015</option>
	                    <option value="2016">2016</option>
	            </select>
	        </label>
	        <a href="#" class="easyui-linkbutton" onclick="queryAccumulation();">查询</a>
	    </div>
	    
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddUser()" class="easyui-linkbutton" >新增</a>
            <a id="btn_edit" onclick="editorUser()" class="easyui-linkbutton" >修改</a>
            <a id="btn_delete" onclick="deleteUser()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid"></table>
    </div>
    </form>
</div>

 <!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none">
    <form id="userData" style="width: 100%;margin: 0;padding:0;" method="post">
    <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
        <tr>
            <td width="100px" class="fm_lable">城市</td>
            <input type="hidden" id="dictName" name="dictName" />
            <td >
             <select class="easyui-combobox" id="dictCode" name="dictCode"  style="width: 80%" data-options="
                     required:true,
                     data:huo,
                     valueField:'code',
                     textField:'name',
                     prompt:'请选择',
                     onSelect: function(rec){    
			            var name = rec.name;    
			            $('#dictName').attr('value',name); 
			        }
                ">
              </select>
            </td>
            <td width="100px" class="fm_lable">公积金年度</td>
            <td >
                <select class="easyui-combobox" id="fundYear" name="fundYear"  style="width: 80%" data-options="required:true,">
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                </select>
            </td>
        </tr>
        <tr>
        	<td width="100px" class="fm_lable">政策有效期</td>
            <td>
                <input class="easyui-datebox" name="startTime"  style="width: 80%" data-options="
                	 required:true,
                     editable:false,
                     prompt:'请选择'
                ">
            </td>
            <td style="text-align:center">至</td>
            <td><input class="easyui-datebox" name="endTime"  style="width: 80%" data-options="
                	 required:true,
                     editable:false,
                     prompt:'请选择'
                "></td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">跨年清册月份</td>
            <td>
                <select class="easyui-combobox" name="clearMonth"  style="width: 80%" data-options="required:true,prompt:'请选择'">
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
            </td>
            <td width="100px"  class="fm_lable">社会平均工资</td>
            <td>
                <input id="password" type="text" name="averagePay" class="easyui-textbox"  style="width: 80%" data-options="required:true,">元
            </td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">上线百分比</td>
            <td >
                <input name="ceiling" type="text" class="easyui-textbox"   style="width: 80%" data-options="required:true,">%
            </td>
            <td width="100px"  class="fm_lable">上限基数</td>
            <td >
                <input id="rpassword" type="text"  name="ceilingBase" class="easyui-textbox" required="required" style="width: 80%"  >
            </td>
        </tr>  
        <tr>
            <td width="100px"  class="fm_lable">下限基数</td>
            <td >
                <input id="rpassword" type="text" name="floorBase" class="easyui-textbox" required="required" style="width: 80%"  >
            </td>
            <td colspan="2"></td>
        </tr> 
        <tr>
            <td width="100px" class="fm_lable">备注</td>
            <td  colspan="3">
                <input id="remark" name="comment" class="easyui-textbox"  style="width: 100%;height: 60px;"  data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">
            </td>
        </tr> 
    </table>
    <div>
    	<h3 style="font-size:18px;font-weight:blod;color:black">公积金户口类型</h3>
    	<table style="width:100%;height:auto;border:solid #eee;border-width:1px 0px 0px 1px;text-align:center;margin:30px 0;">
    		<tr style='height:30px;line-height:30px'>
    			<th width="10%" style='border:solid #eee; border-width:0px 1px 1px 0px;'></th>
	    		<th width="30%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>户口类型</th>
	    		<th width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>开始日期</th>
	    		<th width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>截至日期</th>
    		</tr>
    		<c:forEach var="s" items="${huokou}" varStatus="status">
	  		    <tr style='height:30px;line-height:30px'>
	  		    <input type="hidden" id="name" name="name" value="${s.name }"/>
	  		    <input type="hidden" id="code" name="code" value="${s.code }"/>
	    			<td width="10%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>${status.count}</td>
	    			<td width="30%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>${s.name}</td>
	    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
	    				<input class="easyui-datebox" required="required" name="start"  style="width: 80%">
	    			</td>
	    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
	    				<input class="easyui-datebox" required="required" name="end" style="width: 80%">
	    			</td>
	    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
    </form>
</div>

<div id="editorDlg"   style="padding:10px 10px;display: none"></div>
</body>
</html>