<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="u" uri="http://www.unionx.cn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../resources.jsp" />
<title>业务材料档案</title>




<script type="text/javascript" src="${CP}/js/page/material/material.js"></script>
<script type="text/javascript" src="${CP}/js/page/material/materialEdit.js"></script>

<style type="text/css">
#caiLiaoTable td {
	text-align: center;
}
</style>


<script type="text/javascript">       
       
        var cp = '${CP}';
 
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

	<!-- 编辑对话框 -->
	<div id="editorDlg">
		<form id="editorMaterialData" method="post">
		<div>
	    <table class=" fm_table" style="width:100%;height: 100%;table-layout:fixed">      
	        
	         
	          <input type="hidden" name="id" value="${id }"/>
              <input type="hidden" name="uuid" value="${uuid }"/>
	         <tr>
	            <td width="100px" class="fm_lable">区县</td>
	            <td>
	                
	                <input  id="qu" name="qu" class="easyui-combobox"  value="${materialVo.qu }"  style="width: 100%" data-options="
	                required:true,
	                     data:allqu,
	                     valueField:'code',
	                     textField:'name',
	                     editable:false,
	                     prompt:'请选择'">
	               
	            </td>
	            
	            <td width="100px" class="fm_lable">业务类型</td>
	            <td>
	               
	                <input  id="typeId" name="typeId" class="easyui-combobox"  value="${materialVo.typeId }" style="width: 100%" data-options="
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
	            <td width="100px" class="fm_lable">产品名称列表</td>
	            <td>
	                
	               <%--  <input  id="productId" name="productName" class="easyui-combobox" value="${materialVo.productName }" style="width: 100%"    data-options="
	                required:true,
	                     data:allProduct,                     
	                     valueField:'id',
	                     textField:'name',
	                     editable:false,
	                     prompt:'请选择'
	                "> --%>
	                 
	                <input id="editorProId" name="proName" class="easyui-textbox" value="${productName }" style="width: 100% " data-options="readonly:true">
                    <input type="hidden" id="productName" name="productName" value="${materialVo.productName }" style="width: 100%">
	                
	               <%--  <input type="text-box" name="productName" id="productId" value="${materialVo.productName }"> --%>
	           		
	            </td>
	            <td width="100px" class="fm_lable">有无材料</td>
	            <td>
	                <select id="isMaterial" class="easyui-combobox" name="isMaterial" value="${materialVo.isMaterial }" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
	                    
	                    <option value="1">需要</option>
	                    <option value="2">不需要</option>
	                </select>
	            </td>
	        </tr>
	       
	        <tr>
	           <td width="100px" class="fm_lable">是否网申</td>
	            <td>               
	                <select id="setVlaue" class="easyui-combobox" name="isApply" value="${materialVo.isApply }" style="width: 100%" data-options="required:true,editable:false,panelHeight:'auto'">
	                    
	                    <option value="1">是</option>
	                    <option value="2">否</option>
	                </select>
	            </td>
	           
	        </tr>
	  
	        <tr>
		       	<td colspan="4">符合条件
			   <ul class="fmtb1">
			   	  <c:forEach items="${tjList}" var="caList" varStatus="stuts">
				   <li >
					   <table class="fm_table" style="table-layout:fixed">
						   <input type="hidden" name="TJ[${stuts.index }].id" value="${caList.id }"/>
						   <tr>
						   		<td>条件：</td>
						   		<td colspan="2">
						   			<input id="TJ[i].condition01s" name="TJ[${stuts.index }].condition01s" class="tjipt" style="width=100%;" value="${caList.condition01s}">
						   		</td>
						   		<td>
					   				<a id="btn_add" class="abew easyui-linkbutton btn-add" onclick="aaa($(this))">选择材料</a>
					   			</td>
					   		</tr>
				   		</table>
				   		<div id=""></div>
				   		<table class="tjsj"  border="1" cellspacing="0" cellpadding="0" style="width:100%;height: 100%; table-layout:fixed" id="caiLiaoTable01">
					   		<tr>
						   		<th width="100px">所需材料</th>
						   		<th>材料要求</th>
						   		<th width="100px">份数</th>
					   			<th>删除</th>
					   		</tr>
					   	<c:forEach items="${caList.CL}" var="caiLiaoVo" varStatus="stuts1">
					   		<input type="hidden" name="TJ[${stuts.index }].CL[${stuts1.index }].uuid" value="${caiLiaoVo.uuid }"/>
					   		<tr class='fnltr'> 
								<td >   
									<input id='cailiao' name='TJ[${stuts.index }].CL[${stuts1.index }].clName' class='easyui-textbox'  value="${caiLiaoVo.clName}" style='width: 100%' data-options='required:true'> 
								</td> 
								<td >  
									<input id='marerialRequests' name='TJ[${stuts.index }].CL[${stuts1.index }].clRqst' class='easyui-textbox'  value='${caiLiaoVo.clRqst}'  style='width: 100%' data-options='required:true'>
								</td> 
								<td >  
									<input id='fenshus' name='TJ[${stuts.index }].CL[${stuts1.index }].clNum' class='easyui-textbox'  value='${caiLiaoVo.clNum}'  style='width: 100%' >
								</td>
								<td>
									<div class='tjsedel' onclick="del($(this));">删除</div>
							 	</td>
							</tr>
							</c:forEach>
				   		</table>
				   </li>
				
			 
			    </c:forEach>
			    
			    </ul>
		    </td>
		    </tr>
		  
	    
	    
        <tr>
            <td width="100px" class="fm_lable">备注</td>
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

<script type="text/javascript">

    function aaa(part){
    	var liIdx = part.parents("li").index();
		var trIdx = part.parents("li").find(".tjsj tr").length - 1;
		addCL(liIdx,trIdx);
    };
</script>

</body>
</html>


