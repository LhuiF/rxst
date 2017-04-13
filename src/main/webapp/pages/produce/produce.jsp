<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>产品档案</title>
    <script type="text/javascript" src="${CP}/js/page/produce/product.js"></script>
    <%-- 按钮模板--%>
    <script id="optBtns" type="text/html">
        <a  href="javascript:editorProduce('{{id}}')">编辑</a>
     
        <a  href="javascript:deleteProduce('{{id}}')">删除</a>
    </script>
    <script type="text/javascript">
       
        
        var alltype = ${u:getJsonArray("20001")};
        var typeCodeToName = ${u:getJsonMap("20001")};
        var allCity = ${u:getJsonArray("20025")};
        var cityCodeToName = ${u:getJsonMap("20025")};        
        var toBaoYue = ${u:toBaoYue()};
        var toAssign = ${u:toAssign()};
        
        
        
       
    </script>
  
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            城市：<input  id="cityId" name="cityId" class="easyui-combobox"  style="width: 100px" data-options="
                     data:allCity,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
         
        </label>
        <label style="padding: 0 5px">
            业务类型：<input  id="typeId" name="typeId" class="easyui-combobox"  style="width: 100px" data-options="
                     data:alltype,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
        </label>
       
        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddProduce()" class="easyui-linkbutton" >新增</a>
        </div>
        <table id="datagrid"></table>
    </div><div id="dlg" style="padding:10px 10px;display: none">
    <form id="produceData" style="width: 100%;margin: 0;padding:0;" method="post">
    <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">      
         <tr>
         	
         
         
            <td style="width:100px" class="fm_lable">城市</td>
            <td>
            
              <input  id="cityId" name="cityId" class="easyui-combobox"  style="width: 100%" data-options="
              		 required:true,
                     data:allCity,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                "/>
              
            </td>
            
            <td style="width:100px" class="fm_lable">业务类型</td>
            <td>
                <select  id="typeId" name="typeId" class="easyui-combobox"  style="width: 100%" data-options="
                	 required:true,
                     data:alltype,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
                </select>
            </td>
 
        </tr>
   
        <tr>
            <td style="width:100px" class="fm_lable">产品名称</td>
            <td>
                <input id="name" name="name" class="easyui-textbox" style="width: 100%" data-options="required:true,validType:['nameCheck']">
            </td>
            <td style="width:100px" class="fm_lable">标准报价</td>
            <td>
                <input class="easyui-textbox" id="standPrice" name="standPrice" style="width: 100%" data-options="required:true,validType:['numberCheck']">
            </td>
        </tr>
        <tr>
           <td style="width:100px" class="fm_lable">申报截止日期</td>
            <td>               
                <input class="easyui-datebox" name="applyEndTime" id="applyEndTime" style="width:100%" data-options="required:true">
            </td>
            <td style="width:100px" class="fm_lable">反馈截止日期</td>
            <td>

            	<input class="easyui-textbox" id="feedbackEndTime" name="feedbackEndTime" style="width: 100%" data-options="required:true,readonly:true">
            	<!-- <input class="easyui-datebox" name="feedbackEndTime" id="feedbackEndTime" style="width:100px" data-options="required:true">    -->             

            	<!-- <input class="easyui-datebox" name="feedbackEndTime" id="feedbackEndTime" readonly="readonly" style="width:100%" data-options="required:true">                 -->

            </td>
        </tr>
        <tr>
            <td style="width:100px" class="fm_lable">反馈周期(/天)</td>
            <td>
            	<input class="easyui-textbox" id="feedbackLoop" name="feedbackLoop"  style="width: 100%" data-options="required:true,validType:['dayCheck']">
                
            </td>
            <td style="width:100px" class="fm_lable">成本价格</td>
            <td>
                <input id="costPrice" name="costPrice" class="easyui-textbox" style="width: 100%" data-options="required:true,validType:['numberCheck']">
            </td>
        </tr>
        
        
         <tr>
            <td style="width:100px" class="fm_lable">是否包月服务</td>
            <td>
                <select id="setVlaue" class="easyui-combobox" name="mouthService" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </td>
            
            <td style="width:100px" class="fm_lable">对账任务单</td>
            <td>
                <select id="setVlaue" class="easyui-combobox" name="taskList" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="0">社保报增单</option>
                    <option value="1">社保报减单</option>
                </select>
            </td>
            
        </tr>
        
         <tr>
            <!-- <td width="100px" class="fm_lable">创建人</td>
            <td>
                <input id="createUserId" name="createUserId" class="easyui-textbox" style="width: 100%" data-options="required:true">
            </td> -->
            <!-- <td width="100px" class="fm_lable">创建时间</td>
            <td>
                <input class="easyui-datebox" name="createTime" style="width:100px">
            </td> -->
        </tr>
      
        
         <tr>
            <td style="width:100px" class="fm_lable">产品简述</td>
            <td colspan="3">
                <input id="introduction" name="introduction" class="easyui-textbox" style="width: 100%;height: 80px;" data-options="
                multiline:true,
                validType:'maxLength[1550]'
                ">
            </td>
        </tr>
        <tr>
            <td style="width:100px" class="fm_lable">备注</td>
            <td colspan="3">
                <input id="remark" name="remark" class="easyui-textbox" style="width: 100%;height: 80px;" data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">
            </td>
        </tr>
    </table>
    </form>
</div>
</div>

<!-- 新增对话框 -->

<!-- 编辑对话框 -->
<div id="editorDlg" style="padding:10px 10px;display: none">
    <form id="editorProduceData" style="width: 100%;margin: 0;padding:0;" method="post">
        <input name="id" type="hidden">
         <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
         <tr>
            <td style="width:100px" class="fm_lable">城市</td>
            <td>
                
                <input id="editorCityId" name="cityName" class="easyui-textbox" style="width: 100%">
                <input type="hidden" id="cityId" name="cityId" style="width: 100%">
            </td>
            
            <td style="width:100px" class="fm_lable">业务类型</td>
            <td>
         
            	<input id="editorTypeId" name="typeName" class="easyui-textbox" style="width: 100%">
                <input type="hidden" id="typeId" name="typeId" style="width: 100%">                      
            </td>
 
        </tr>
   
        <tr>
            <td style="width:100px" class="fm_lable">产品名称</td>
            <td >
                <input id="name" name="name" class="easyui-textbox"  style="width: 100%" data-options="required:true,validType:['nameCheck']">
            </td>
            <td style="width:100px" class="fm_lable">标准报价</td>
            <td >
                <input class="easyui-textbox" id="standPrice" name="standPrice"  style="width: 100%" data-options="required:true,validType:['numberCheck']">
            </td>
        </tr>
        <tr>
           <td style="width:100px"  class="fm_lable">申报截止日期</td>
            <td >               
                <input class="easyui-datebox" name="applyEndTime" id="applyEndTime" style="width:100%" data-options="required:true">
            </td>
            <td style="width:100px"  class="fm_lable">反馈截止日期</td>
            <td >
            	<input class="easyui-datebox" name="feedbackEndTime" id="feedbackEndTime" style="width:100%" data-options="required:true">
                
            </td>
        </tr>
        <tr>
            <td style="width:100px"  class="fm_lable">反馈周期(/天)</td>
            <td >
                <input class="easyui-textbox" id="feedbackLoop" name="feedbackLoop"  style="width: 100%" data-options="required:true">
            </td>
            <td style="width:100px"  class="fm_lable">成本价格</td>
            <td >
                <input id="costPrice" name="costPrice"  class="easyui-textbox"  style="width: 100%" data-options="required:true,validType:['numberCheck']">
            </td>
        </tr>
        
        
         <tr>
            <td style="width:100px" class="fm_lable">是否包月服务</td>
            <td>
                <select id="setVlaue" class="easyui-combobox" name="mouthService" style="width: 100%"
                        data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </td>
            
            <td style="width:100px" class="fm_lable">对账任务单</td>
            <td>
                <select id="setVlaue" class="easyui-combobox" name="taskList" style="width: 100%"
                        data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="0">社保报增单</option>
                    <option value="1">社保报减单</option>
                </select>
            </td>
            
        </tr>
        
         <tr>
            <!-- <td width="100px" class="fm_lable">创建人</td>
            <td >
                <input id="createUserId"  name="createUserId" class="easyui-textbox"  style="width: 100%" data-options="required:true">
            </td> -->
            <td style="width:100px" class="fm_lable">创建时间</td>
            <td >
                <input class="easyui-datebox" name="createTime" style="width:100%" readonly="readonly">
            </td>
        </tr>
      
        
         <tr>
            <td style="width:100px" class="fm_lable">产品简述</td>
            <td  colspan="3">
                <input id="introduction" name="introduction" class="easyui-textbox"  style="width: 100%;height: 80px;"  data-options="
                multiline:true,
                validType:'maxLength[1550]'
                ">
            </td>
        </tr>
        <tr>
            <td style="width:100px" class="fm_lable">备注</td>
            <td  colspan="3">
                <input id="remark" name="remark" class="easyui-textbox"  style="width: 100%;height: 80px;"  data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">
            </td>
            <td style="display: none;" >
                   <input class="easyui-textbox" id="produceId" name="id"  style="width: 176px">
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
