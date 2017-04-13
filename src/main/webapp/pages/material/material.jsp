<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
  <head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>业务材料档案</title> 
   
    <link rel="stylesheet" href="${CP}/lib/artDialog-master/css/ui-dialog.css">
    <script type="text/javascript" src="${CP}/lib/artDialog-master/dist/dialog-min.js"></script>
    
     <script type="text/javascript" src="${CP}/js/page/material/material.js"></script>
     <script type="text/javascript" src="${CP}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>

     <style type="text/css">
	    #caiLiaoTable td{
	    text-align:center;
	    }
    </style>
  
    
    <script type="text/javascript">       
       
        var cp = '${CP}';
 
    </script>
    
    
    <!-- 导入用的函数 -->
    <script type="text/javascript">

       function importExcel(){
           var d = dialog({
               title: '导入信息',
               content:'<div>'
              + '<form id="importForm" action="#" method="post" enctype="multipart/form-data" class="form-search" style="padding-left:20px;text-align:center;" > <br/>'
             +' <input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>'
               +'<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>',             
               lock: true,
               fixed: true,
               okValue: '确 定',
               ok: function () {
                   var that = this;
                   setTimeout(function () {
                       that.title('提交中..');
                   }, 2000);
                   return false;
               },
               cancelValue: '取消',
               cancel: function () {
               }
           });

           d.show();
       }

    </script>
    
     <script type="text/javascript">
       
       
        var userIdToName = ${u:userIdToName()};
        var toMaterial = ${u:toMaterial()};
        var toApply = ${u:toApply()};
        var alltype = ${u:getJsonArray("20001")};
        var typeCodeToName = ${u:getJsonMap("20001")};
        var allqu = ${u:getJsonArray("20027")};
        var quCodeToName = ${u:getJsonMap("20027")};
        var allProduct = ${u:getAllProductName()};
        var produceIdToName = ${u:produceIdToName()};
       	var allCaiLiao = ${u:allCaiLiao()};        
  
    </script>
    
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            业务类型： <input  id="typeId" name="typeId" class="easyui-combobox"  style="width: 100px" data-options="
                required:true,
                     data:alltype,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
        </label>
      	<label style="padding: 0 5px"> 有无材料： 
      		<select id="isMaterial" class="easyui-combobox" name="isMaterial" style="width: 100px" data-options="required:true,editable:false,panelHeight:'auto'">                   
                    <option value="1">需要</option>
                    <option value="2">不需要</option>
      		</select>
      	</label>
                
         <label style="padding: 0 5px"> 区县： 
         	<select  id="qu" name="qu" class="easyui-combobox"  style="width: 100px" data-options="
		                required:true,
		                     data:allqu,
		                     valueField:'code',
		                     textField:'name',
		                     editable:false,
		                     prompt:'请选择'
		                ">
             </select>
        </label>    

        <label style="padding: 0 5px">
           是否网申： <select id="isApply" class="easyui-combobox" name="isApply" style="width: 100px" data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="1" checked>是</option>
                    <option value="2">否</option>
                </select>
        </label>
        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
         <a href="#" class="easyui-linkbutton btn-search" onclick="clean_onclick();">清空</a>  
     
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddProduce()" class="easyui-linkbutton" >新增</a>
            <a id="btn_edit" onclick="editorProduce()" class="easyui-linkbutton btn-add" >编辑</a>
        
            <a id="btn_delete" onclick="deleteProduce()" class="easyui-linkbutton btn-add" > 删除</a>
             <a href="#" id="btnDown" class="easyui-linkbutton btn-add " onclick="downLoadModule()">下载模板</a>
             <a id="btn_export" href="#" class="easyui-linkbutton" onclick="exportExcel()" >导出</a>                       
            <a href="#" id="btnImport" class="easyui-linkbutton btn-export " onclick="importExcel()">导入</a>
           
        </div>
        <table id="datagrid"></table>
    </div>
    
    <!-- 新增对话框 -->
   <div id="dlg" style="padding:10px 10px;display: none">
    <form id="materialData" style="width: 100%;margin: 0;padding:0;" method="post">
    <div>
    <table class=" fm_table" style="width:100%;height: 100%;table-layout:fixed">      
         <input type="hidden" id="uuid" name="uuid">
         <tr>
            <td style="width:100px" class="fm_lable">区县</td>
            <td>
                
                <input  id="qu" name="qu" class="easyui-combobox"  style="width: 100%" data-options="
                required:true,
                     data:allqu,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'">
            </td>
            
            <td style="width:100px" class="fm_lable">业务类型</td>
            <td>
               
                <input  id="typeId" name="typeId" class="easyui-combobox"  style="width: 100%" data-options="
                required:true,
                     data:alltype,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
            </td>
 
        </tr>
   
        <tr>
            <td style="width:100px" class="fm_lable">产品名称列表</td>
            <td>
                
                <input  id="productId" name="productName" class="easyui-combobox"  style="width: 100%"    data-options="
                required:true,
                     data:allProduct,
                     
                     valueField:'id',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
            </td>
            <td style="width:100px" class="fm_lable">有无材料</td>
            <td>
                <select id="isMaterial" class="easyui-combobox" name="isMaterial" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
                    
                    <option value="1">需要</option>
                    <option value="2">不需要</option>
                </select>
            </td>
        </tr>
       
        <tr>
           <td style="width:100px" class="fm_lable">是否网申</td>
            <td>               
                <select id="setVlaue" class="easyui-combobox" name="isApply" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
                    
                    <option value="1">是</option>
                    <option value="2">否</option>
                </select>
            </td>
           
        </tr>
  
        <tr>
	       	<td colspan="4">符合条件
	   <ul class="fmtb1">
	    
	    </ul></td>
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
	    
    </div>
    </form>
</div>

<!-- 修改对话框 -->
<div id="editorDlg"/>
</div>
<div>
</div>







 <div id="caiLiaoDlg" style="padding:10px 10px;display: none">
    <form id="caiLiaolData" style="width: 100%;margin: 0;padding:0;" method="post">
    
    <table class="fm_table" style="width:50%;height: 50%;table-layout:fixed">      
         <tr>
            <td width="100px" class="fm_lable">所需材料</td>
            <td width="200px">
                <input id="caiLiaoName" name="caiLiaoName" class="easyui-textbox" />
                <input  id="caiLiaouuid" name="caiLiaouuid" class="easyui-combobox"  style="width: 100%" data-options="
                required:true,
                    data:allCaiLiao,
                     valueField:'uuid',
                     textField:'materialName',
                     editable:false,
                     prompt:'请选择',
                      onSelect: function(rec){    
			            var name = rec.materialName;    
			            $('#caiLiaoName').textbox('setValue',name); 
			        }">
            </td>
          </tr>
            
            
            <tr>          
	            <td width="100px" class="fm_lable">份数</td>
	            <td>
	                <select id="fenshu" class="easyui-combobox" name="fenshu" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
	                    <option value="1">1</option>
	                    <option value="2">2</option>
	                    <option value="3">3</option>
	                </select>
	            </td>
 
        </tr>
           
        <tr>
            <td width="100px" class="fm_lable">要求</td>
            <td colspan="3">
                <input id="yaoqiu" name="yaoqiu" class="easyui-textbox" style="width: 100%;height: 80px;" data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">
            </td>
        </tr>
    </table>
    </form>
</div>

</body>
</html>

<div style="display: none;">
    <form id="exportForm"></form>
</div>
