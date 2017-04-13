<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>用户管理</title>
    <script type="text/javascript" src="${CP}/js/page/preferences/accumulation.js"></script>
  
    <script type="text/javascript">
        var huo = ${u:getJsonArray("20025")};
       
    </script>
</head>
<body>
<div id="editorAccumulation" style="padding:10px 10px">
    <form id="editorUserData" style="width: 100%;margin: 0;padding:0;" method="post">
    <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
        <tr>
            <td width="100px" class="fm_lable">城市</td>
            <input type="hidden" id="dictName" name="dictName" value="${data[0].dictName}" />
            <input type="hidden" id="id" name="id" value="${data[0].id }"/>
            <input type="hidden" id="uuid" name="uuid" value="${data[0].uuid }"/>
            <td >
             <select class="easyui-combobox" id="dictCode" name="dictCode" style="width: 90%" data-options="
                     required:true,
                     data:huo,
                     valueField:'code',
                     textField:'name',
                     prompt:'请选择',
                     onLoadSuccess: function(rec){    
			            var name = rec.name;    
			            $('#dictCode').combobox('setValue', '${data[0].dictCode }');
			        }
                ">
              </select>
            </td>
            <td width="100px" class="fm_lable">公积金年度</td>
            <td >
                <select class="easyui-combobox" id="fundYear" name="fundYear" style="width: 90%" data-options="
                     required:true,
                     prompt:'请选择',
                     onBeforeLoad: function(rec){    
			            var name = rec.name;    
			            $('#fundYear').combobox('setValue', '${data[0].fundYear }');
			        }
                ">
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                </select>
            </td>
        </tr>
        <tr>
        	<td width="100px" class="fm_lable">政策有效期</td>
            <td>
                <input class="easyui-datebox" name="startTime" value="<fmt:formatDate value="${data[0].startTime }" pattern="yyyy-MM-dd" />" style="width: 90%" data-options="
                	 required:true,
                     editable:false,
                     prompt:'请选择'
                    
                ">
            </td>
            <td style="text-align:center">至</td>
            <td><input class="easyui-datebox" name="endTime" value="<fmt:formatDate value="${data[0].endTime }" pattern="yyyy-MM-dd" />" style="width: 90%" data-options="
                	 required:true,
                     editable:false,
                     prompt:'请选择'
                "></td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">跨年清册月份</td>
            <td>
                <select class="easyui-combobox" name="clearMonth"  style="width: 90%" data-options="required:true,prompt:'请选择'">
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
                <input id="password" type="text" name="averagePay" value="${data[0].averagePay }" class="easyui-textbox"  style="width: 90%" data-options="required:true,">元
            </td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">上线百分比</td>
            <td >
                <input name="ceiling" value="${data[0].ceiling }" type="text" class="easyui-textbox" style="width: 90%" data-options="required:true,">%
            </td>
            <td width="100px"  class="fm_lable">上限基数</td>
            <td >
                <input id="rpassword" type="text" name="ceilingBase" value="${data[0].ceilingBase }" class="easyui-textbox"  style="width: 90%"  >
            </td>
        </tr>  
        <tr>
            <td width="100px"  class="fm_lable">下限基数</td>
            <td >
                <input id="rpassword" type="text" name="floorBase" value="${data[0].floorBase }" class="easyui-textbox"  style="width: 90%"  >
            </td>
            <td colspan="2"></td>
        </tr> 
        <tr>
            <td width="100px" class="fm_lable">备注</td>
            <td  colspan="3">
                <input id="remark" name="comment" value="${data[0].comment }" class="easyui-textbox"  style="width: 100%;height: 60px;"  data-options="
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
    		<!-- <tr style='height:30px;line-height:30px'>
    			<td width="10%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>1.</td>
    			<td width="30%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>非农户</td>
    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
    				<input class="easyui-datebox"  name="start"  style="width: 90%">
    			</td>
    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
    				<input class="easyui-datebox"  name="end"  style="width: 90%">
    			</td>
    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'><a href='#'>编辑</a></td>
    		</tr> -->
    		<c:forEach var="s" items="${data}" varStatus="status">
	  		    <tr style='height:30px;line-height:30px'>
	  		    <input type="hidden" name="fundIds" value="${s.fundId}"/>
	  		    <input type="hidden" name="name" value="${s.fundCodeName}"/>
	  		    <input type="hidden" name="code" value="${s.fundCode}"/>
	    			<td width="10%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>${status.count}</td>
	    			<td width="30%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>${s.fundCodeName}</td>
	    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
	    				<input class="easyui-datebox"  name="start" value="${s.fundStartTime}" style="width: 90%">
	    			</td>
	    			<td width="20%" style='border:solid #eee; border-width:0px 1px 1px 0px;'>
	    				<input class="easyui-datebox"  name="end" value="${s.fundEndTime}" style="width: 90%">
	    			</td>
	    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
    </form>
</div>
</body>
</html>