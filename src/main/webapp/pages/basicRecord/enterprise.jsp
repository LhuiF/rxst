<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>企业信息</title>
   <script type="text/javascript" src="${CP}/js/page/basicRecord/enterprise.js"></script>
     <script type="text/javascript" src="${CP}/js/page/proxyInfo/formToJson.js"></script>
   <script type="text/javascript">
         quxian =${dict[20027]};
    </script>
	<style type="text/css">
	.peo_td{
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		.peo_td th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #eee;
		}
		.peo_td td{
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
		}
	</style>


  </head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="searchBox" data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
         <label style="padding: 0 5px">
        	 代理机构名称：
        	 <input id="queryAngency" /> 
        </label>
        <label style="padding: 0 5px">
                              企业名称：<select id="queryName" style="width: 150px"></select>
        </label>
            <label style="padding: 0 5px">
        	社保登记证号：
        		<select id="queryInsuranceAccount" style="width: 150px"></select>
         </label>
         <br/><br/>
         <label style="padding: 0 5px">
        	组织机构代码证：<select id="queryorgCode" style="width: 150px"></select>	
        </label>
        <label style="padding: 0 5px">
         	社保所在区县：<select id="queryinsureanceArea" style="width: 150px"></select>
        </label>
            <label style="padding: 0 5px">
        	公积金所在区县：<select id="queryaccumulationArea" style="width: 150px"></select>
         </label>
         <br/><br/>
        <a href="#" class="easyui-linkbutton" onclick="searchList();">查询</a>
        <a href="#" class="easyui-linkbutton btn-search" onclick="clearData();">清除</a>
      </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAdd()" class="easyui-linkbutton" >新增</a>
             <a id="btn_edit" onclick="openEditor()" class="easyui-linkbutton" >修改</a>
        	<a id="btn_delete" onclick="deleteData()" class="easyui-linkbutton" >删除</a>
        </div>
        
        <table id="datagrid"></table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none;">
  <form id="addEnterprise" style="width: 100%;margin: 0;padding:0;" method="post">
    <div data-options="region:'north'" style="margin-bottom: 10px;padding:10px;">
        <label style="padding: 0 5px">
         <input id="id" class="easyui-textbox" name="id" type="hidden"/> 
                    企业名称&nbsp;&nbsp;&nbsp;： <input id="name" class="easyui-textbox" name="name" /> 
        </label>
        <label style="padding: 0 5px">
       	社保登记证号&nbsp;&nbsp;：
       	<input class="easyui-textbox" name="insuranceAccount"   id="insuranceAccount"  maxlength="30" style="width:140px">
        </label>
         <label style="padding: 0 5px">
       		 组织机构代码证号：
       	<input class="easyui-textbox" name="orgCode" id="orgCode"  maxlength="30" style="width:140px">
        </label>
        <br/><br/>
         <label style="padding: 0 5px">
       		办公地址&nbsp;&nbsp;&nbsp;：
       		<input class="easyui-textbox" name="workAddr"  id="workAddr"  maxlength="30" style="width:140px">
        </label>
          <label style="padding: 0 5px">
       		注&nbsp;册&nbsp;地&nbsp;址&nbsp;：
       	<input class="easyui-textbox" name="regAddr"   id="regAddr" maxlength="30" style="width:140px">
        </label>
         <label style="padding: 0 5px">
       		法&nbsp;人&nbsp;姓&nbsp;名&nbsp;：
       		<input class="easyui-textbox" name="legalName"  id="legalName"  maxlength="30" style="width:140px">
        </label>
        <br/><br/>
           <label style="padding: 0 5px">
           法人联系方式&nbsp;：
           <input class="easyui-textbox" name="legalPhone" id="legalPhone"  style="width:140px">
        </label>
           <label style="padding: 0 5px">
           经&nbsp;办&nbsp;人&nbsp;&nbsp;&nbsp;：
           <input class="easyui-textbox" name="agentName" id="agentName"  style="width:140px">
        </label>
           <label style="padding: 0 5px">
            经办人联系方式&nbsp;：
            <input class="easyui-textbox" name="agentPhone" id="agentPhone"  style="width:140px">
        </label>
        <br/><br/>
            <label style="padding: 0 5px">
        	社保所在区县&nbsp;：
        	<select id="insureanceArea" name="insureanceArea"  class="easyui-combobox" style="width: 140px"></select>
         </label>
         <label style="padding: 0 5px">
        	公积金所在区县&nbsp;：
        	<select id="accumulationArea" name="accumulationArea"  class="easyui-combobox" style="width: 140px"></select>
         </label>
         <label style="padding: 0 5px">
        	代理机构名称&nbsp;&nbsp;：<select  class="easyui-combobox" id="angencyId" name="angencyId" style="width: 140px">
             </select>
             <input type="hidden" id="angency" name="angency" /> 
         </label>
         <br/><br/>
         <label style="padding: 0 5px">
        	社保卡是否代领：
        	<select class="easyui-combobox" name="isinsurance" id="isinsurance" style="width:140px"
             	data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
            	<option value="1">是</option>
            	<option value="0">否</option>
             </select>
         </label>
          <label style="padding: 0 5px">
        	医保存折是否代领：
        	<select class="easyui-combobox" name="ishealthinsurance" id="ishealthinsurance" style="width:140px"
             	data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
            	<option value="0">是</option>
            	<option value="1">否</option>
             </select>
         </label>
          <label style="padding: 0 5px">
        	是否为银行缴费&nbsp;：
        	<select class="easyui-combobox" name="isbankfees" id="isbankfees" style="width:140px"
             	data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
            	<option value="0">是</option>
            	<option value="1">否</option>
             </select>
         </label>
         <br/><br/>
       <label style="padding: 0 5px">
       		开户银行名称&nbsp;：<input class="easyui-textbox" name="openBank"  id="openBank"   maxlength="30" style="width:140px">
        </label>
          <label style="padding: 0 5px">
       		开户银行账号&nbsp;&nbsp;：<input class="easyui-textbox" name="openCode"  id="openCode"  maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
       		开户户名&nbsp;&nbsp;&nbsp;&nbsp;：
       		<input class="easyui-textbox" name="openAccount" id="openAccount"  maxlength="30" style="width:140px">
        </label>
     </div> 
      </form>
     <div data-options="region:'center',border:0"style="width: 500px;">
	     <div style="padding-bottom: 15px;">
		     <strong style="padding-right: 10px; font-size:14px;">联系人信息</strong><a id="btn_add_people" onclick="addPeo($('#proxyUserdatagrid'))" class="easyui-linkbutton" >新增</a>
	     </div>
	   </div>
   <table  id="proxyUserdatagrid" style="width:50%; " >
	  	<tr>
	  	   <th>
	  	        联系人姓名
	       </th>
	       <th>
	                    性别
	       </th>
	       <th>
	                    职务
	       </th>
	       <th>
	                   电话
	       </th>
	       <th>
	                  邮箱
	       </th>
	       <th>
	       QQ
	       </th>
	       <th>
	                操作
	       </th>
	  	</tr>
      </table>
</div>

<!-- 新增联系人信息 -->
<div id="addPeoDlg"  style="width: 400px;margin: 0;padding:0;">
	 <form id="newpeople"  method="post">
    <table class="fm_table" >

        <tr>
            <td width="60px" class="fm_lable">姓名:</td>
            <td >
                <input  name="peoName" class="easyui-textbox"   data-options="required:true,validType:['nameSpace','maxLength[15]']">
            </td>
         </tr>
        <tr><td width="60px"  class="fm_lable">性别:</td>
            <td><select class="easyui-combobox" name="sex" style="width: 150px;"   data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr><td width="60px" class="fm_lable">职务:</td>
            <td ><input  name="duty" class="easyui-textbox"   data-options="required:true,validType:['nameSpace','maxLength[15]']"></td>
         </tr>
         <tr><td width="60px" class="fm_lable">电话:</td>
            <td><input  name="phone" class="easyui-textbox"   data-options="required:true,validType:['mobilePhone']"></td>
         </tr>
        <tr><td width="60px"  class="fm_lable">邮箱:</td>
            <td><input name="eamil"  class="easyui-textbox"   data-options="required:true"></td>
        </tr>
        <tr><td width="60px"  class="fm_lable">QQ:</td>
            <td><input name="qq"  class="easyui-textbox"    data-options="required:true"></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>