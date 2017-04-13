<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>代理信息</title>
    <script type="text/javascript" src="${CP}/js/page/proxyInfo/proxyInfo.js"></script>
    <script type="text/javascript" src="${CP}/js/page/proxyInfo/formToJson.js"></script>
    <style type="text/css">
    #proxyUserdatagrid td{
    text-align:center;
    }
    #peopleInfo td{
    text-align:center;
    }
    </style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
     
     <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
	   <form id="queryAccumulation"  method="post">
	        <label style="padding: 0 5px">
	            代理机构名称: <input id="qproxyName" name="proxyName"  />  
	        </label>
	        <a href="#" class="easyui-linkbutton" onclick="queryProxyinfo();">查询</a>
	</div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddProxy()" class="easyui-linkbutton" >新增</a>
            <a id="btn_edit" onclick="editorProxy()" class="easyui-linkbutton" >修改</a>
            <a id="btn_delete" onclick="deleteProxy()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid"></table>
    </div>
    </form>
</div>

<%--新增 功能弹窗 --%>
<div id="addProxyLayout"   data-options="fit:true" >
<form id="proxyForm">
<div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
  <table  style="border-collapse:separate; border-spacing:0px 10px; padding:  20px ">
	<tr>
		<td >
		*代理名称
		</td>
		<td>
		
		<input  name="proxyName" class="easyui-textbox"  required ="required"type="text"/>  
		</td>
		<td>
		*开户银行
		</td>
		<td>
		<input  name="openBank" class="easyui-textbox"  required ="required" type="text"/>  
		</td>
		<td>
		开户银行账号
		</td>
		<td>
		<input  name="openBankAccount" type="text" />  
		</td>
		<td>
		开户户名
		</td>
		<td>
		<input  name="openBankUsername"  type="text"/>  
		</td>
	</tr>
	<tr>
		<td>
		*约定付款日期
		</td>
		<td>
		<input  name="appointmentPaymentString" type="text" class= "easyui-datebox" required ="required" editable="false"/>  
		</td>
		<td>
		客户姓名
		</td>
		<td colspan="1">
		<input  name="clientName" type="text" />
		</td>
	</tr>
	<tr>
		<td>
		注册地址
		</td>
		<td  colspan="7">
		<input  name="registeredAddress" type="text" style="width:100%;"/>
		</td>
	</tr>
	<tr>
		<td>
		办公地址
		</td>
		<td  colspan="7">
		<input  name="officeAddress" type="text" style="width:100%;"/>
		</td>
	</tr>
	<tr>
		<td  style="width:80px;">
		*与特殊企业约定是否可改费用
		</td>
		<td>
		 <select  class="easyui-combobox" name="changeTheCost" style="width:100px;"   required ="required">   
		    <option value=0>否</option>   
		    <option value=1>是</option>   
		</select>  
		</td>
		<td>
		创建人
		</td>
		<td>
		<input name="createName" type="text" lass= "easyui-textbox" readonly="true"  value="${username}" />
		</td>
		<td>
		创建时间
		</td>
		<td  colspan="3">
		<input  name="createString"  type="text" class= "easyui-datebox" disabled="true" value="javascript:new Date();"/>
		</td>
	</tr>
	<tr>
		<td>
		备注
		</td>
		<td  colspan="7">
		<input  name="remarks" type="text" style="width:100%;"/>
		</td>
	</tr>
</table>
</form>

</div>
  <div data-options="region:'center',border:0">
    <div id="tb" >
         联系人信息<a id="btn_add" onclick="openAddProxyUser1($('#proxyUserdatagrid'))" class="easyui-linkbutton" >新增</a>
     </div>
      <table  id="proxyUserdatagrid" style="width:50%; ">
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
</div>
<%--新增联系人弹窗 --%>
<div id="addProxyUserLayout"  style="display: none;">
<form id="newpeople">
	<table>
	    <tr>
	     <td>联系人：<input id="lianxiren" name="peoName" /> 
	                   性别 ：<select id="lianxiren1" class="easyui-combobox" name="sex" >   
			    <option value="男">男</option>   
			    <option value="女">女</option>   
			</select>
	    </td>
	    </tr>
	    <tr>
	    <td>职务：<input id="lianxiren2" name="duty"  style="width:100%;"/> </td>
	    </tr>
	    <tr>
	    <td>电话：<input id="lianxiren3" name="phone"  style="width:100%;"/> </td>
	    </tr>
	    <tr>
	    <td>邮箱：<input id="lianxiren4" name="eamil"  style="width:100%;"/> </td>
	    </tr>
	    <tr>
	    <td>QQ：<input id="lianxiren5" name="qq"  style="width:100%;"/> </td>
	    </tr>
	</table>
</form>
</div>
<%--详情弹窗 --%>
<div id="ProxyinfoLayout"   data-options="fit:true" >
<div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
<form id="proxyInfoForm">
  <table  style="border-collapse:separate; border-spacing:0px 10px; padding:  20px ">
	<tr>
		<td >
		*代理名称
		</td>
		<td>
		<input id="id" name="id"    type="hidden"/>  
		<input id="proxyName" name="proxyName"    type="text"/>  
		</td>
		<td>
		*开户银行
		</td>
		<td>
		<input id="openBank" name="openBank"   type="text"/>  
		</td>
		<td>
		开户银行账号
		</td>
		<td>
		<input id="openBankAccount" name="openBankAccount" type="text" />  
		</td>
		<td>
		开户户名
		</td>
		<td>
		<input id="openBankUsername" name="openBankUsername"  type="text" />  
		</td>
	</tr>
	<tr>
		<td>
		*约定付款日期
		</td>
		<td>
		<input id="appointmentPaymentDate" name="appointmentPaymentString" type="text" class= "easyui-datebox" />  
		</td>
		<td>
		客户姓名
		</td>
		<td colspan="1">
		<input id="clientName" name="clientName" type="text" />
		</td>
	</tr>
	<tr>
		<td>
		注册地址
		</td>
		<td  colspan="7">
		<input id="registeredAddress" name="registeredAddress" type="text" style="width:100%;" />
		</td>
	</tr>
	<tr>
		<td>
		办公地址
		</td>
		<td  colspan="7">
		<input id="officeAddress" name="officeAddress" type="text" style="width:100%;" />
		</td>
	</tr>
	<tr>
		<td  style="width:80px;">
		*与特殊企业约定是否可改费用
		</td>
		<td>
		 <select id="changeTheCost" class="easyui-combobox" name="changeTheCost" style="width:100px;"   >   
		    <option value=0>否</option>   
		    <option value=1>是</option>   
		</select>  
		</td>
		<td>
		创建人
		</td>
		<td>
		<input id="createName" name="createName" type="text" lass= "easyui-textbox"   />
		</td>
		<td>
		创建时间
		</td>
		<td  colspan="3">
		<input id="createDate" name="createString"  type="text" class= "easyui-datebox"  />
		</td>
	</tr>
	<tr>
		<td>
		备注
		</td>
		<td  colspan="7">
		<input id="remarks" name="remarks" type="text" style="width:100%;"  />
		</td>
	</tr>
</table>
</form>
</div>
  <div data-options="region:'center',border:0">
    <div id="tbedit" >
                  联系人信息 <a id='btn_add_people' onclick="openAddProxyUser($('#peopleInfo'))" class='easyui-linkbutton'>新增</a>
     </div>
      <table  id="peopleInfo" style="width:50%; " >
      </table>
  </div>
</div>
</body>
</html>