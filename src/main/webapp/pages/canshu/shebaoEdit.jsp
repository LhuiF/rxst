<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>社保参数修改</title>
<link rel="stylesheet" href="${CP}/plug-in/Validform/css/style.css" type="text/css" />
<link rel="stylesheet" href="${CP}/plug-in/Validform/css/tablefrom.css" type="text/css" />
<%-- <script type="text/javascript" src="${CP}/plug-in/tools/dataformat.js"></script> --%>
<script type="text/javascript" src="${CP}/plug-in/tools/syUtil.js"></script>
<script type="text/javascript" src="${CP}/plug-in/lhgDialog/lhgdialog.min.js"></script>

<script type="text/javascript" src="${CP}/plug-in/tools/curdtools_zh-cn.js"></script>

<%-- <script type="text/javascript" src="${CP}/plug-in/tools/easyuiextend.js"></script> --%>
<script type="text/javascript" src="${CP}/plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/js/datatype_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
    <script type="text/javascript">
        //城市信息
        var allcity = ${u:getJsonArray("20025")};
        //缴费人员类别
        var allrytype=${u:getJsonArray("20003")};
        //险种信息
        var allsbxz=${u:getJsonArray("20009")};
        
     </script>
     <script type="text/javascript">
     $(function() {
    	$("#startTime").datebox({
		    onSelect: function(date){
		      $("#dataTable").find("input").each(function (i,val) {  
     	  	  var inputclass=$(val).attr("class");
     	  	  if(inputclass=="easyui-datebox datebox-f combo-f textbox-f"){
     	  	     var name= $(val).attr("textboxname");
     	  	      if(name.indexOf("startTime")>=0){
     	  	        var s=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	     	  	     $(val).textbox("setValue",s);
     	  	      }
     	  	  }
     	  	});
		    }
		});
		
		$("#endTime").datebox({
		    onSelect: function(date){
		      $("#dataTable").find("input").each(function (i,val) {  
     	  	  var inputclass=$(val).attr("class");
     	  	  if(inputclass=="easyui-datebox datebox-f combo-f textbox-f"){
     	  	     var name= $(val).attr("textboxname");
     	  	      if(name.indexOf("endTime")>=0){
     	  	        var s=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	     	  	     $(val).textbox("setValue",s);
     	  	      }
     	  	  }
     	  	});
		    }
		}); 
		$("#formobj").Validform({
			tiptype : 1,
			btnSubmit : "#btn_sub",
			btnReset : "#btn_reset",
			ajaxPost : true,
			usePlugin : {
				passwordstrength : {
					minLen : 6,
					maxLen : 18,
					trigger : function(obj, error) {
						if (error) {
							obj.parent().next().find(".Validform_checktip").show();
							obj.find(".passwordStrength").hide();
						} else {
							$(".passwordStrength").show();
							obj.parent().next().find(".Validform_checktip").hide();
						}
					}
				}
			},
			callback : function(data) {
				var win = frameElement.api.opener;
				 if (data.success == true) {
					frameElement.api.close();
					win.tip(data.message);
					
				} else {
					if (data.responseText == ''|| data.responseText == undefined){
						$("#formobj").html(data.message);
					}else{
						$("#formobj").html(data.responseText);
					}
					return false;
				}
				win.reloadTable();
			}
		});
		
		/* $('#addBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addBtn').bind('click', function(){   
	 		 var tr =  $("#add_jeecgOrderProduct_table_template tr").clone();
		 	 $("#add_jeecgOrderProduct_table").append(tr);
		 	 resetTrNum('add_jeecgOrderProduct_table');
	    });  
		$('#delBtn').bind('click', function(){   
	       $("#add_jeecgOrderProduct_table").find("input:checked").parent().parent().remove();   
	        resetTrNum('add_jeecgOrderProduct_table');
	    });
		
		$('#addCustomBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delCustomBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addCustomBtn').bind('click', function(){   
	 		 var tr =  $("#add_jeecgOrderCustom_table_template tr").clone();
		 	 $("#add_jeecgOrderCustom_table").append(tr);
		 	 resetTrNum('add_jeecgOrderCustom_table');
	    });  
		$('#delCustomBtn').bind('click', function(){   
	      	$("#add_jeecgOrderCustom_table").find("input:checked").parent().parent().remove();   
	        resetTrNum('add_jeecgOrderCustom_table'); 
	    });  */
	});
</script>
<style>
	/*初始化*/
		html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img { margin:0; padding:0; }
		img { border: none; display:block; }
		ol,ul { list-style: none; }
		a { text-decoration: none; }
		textarea { resize:none; }
	/*页面效果*/
	    .scbox {
	    	padding: 0 10px;
	    }
		.sctitle {
			padding: 10px 0 10px 0;
			font-size: 18px;
			font-weight: 700;
			color: #333;
		}
		.scadd-ul {
			overflow: hidden;
		}
		.scadd-li {
			float: left;
			padding: 0 20px 22px 0;
			overflow: hidden;
			line-height: 25px;
		}
		.cusli {
			padding-right: 5px;
		}
		.scadd-li label {
			float: left;
			padding-right: 5px;
			font-weight: 400px;
			color: #333;
			font-size: 13px;
			

		}
		 .scadd-li select,.scadd-li input  {
			float: left;

			height: 25px;
			width: 150px;
			padding: 0;
			margin: 0;
			border: 1px solid #999;
			color: #333;
			font-size: 13px;
			font-weight: 400px;
			outline: none;
		}
		.scadd-li select,.scadd-li .textbox {
			
		}
		/*第二部分*/
		 .scclassify table{
			/* width: 100%;*/
			text-align: center; 
			border-color: #ccc;
		}
		.scclassify table th {
			padding: 10px 0;
		}
		.scclassify table td {
			padding: 5px 20px;
		} 
		.scclassify table td input{
			/* width: 80%; */
		}
		.scbtn {

		}
		.scbtn ul {
			overflow: hidden;
			padding: 20px 0 0 0;
		}
		.scbtn li {
			float: left;
			margin-right: 15px;
		}
		.scbtn li a {
			display: block;
			height: 36px;
			width: 80px;
			border-radius: 5px;
			font-size: 16px;
			font-weight: 400px;
			color: #fff;
			line-height: 36px;
			text-align: center;
			background-color: #217ca6;
		}
	</style>
</head>
<body>
<form id="formobj" name="formobj" style="width: 100%;margin: 0;padding:0;" 
     action="${CP}/sheBaoMainListController/updateRsInsurance" method="post">
     <input type="hidden" id="btn_sub" class="btn_sub" />
 	<input type="hidden" id="dictName" name="dictName" value="${rsInsuranceMain.dictName}"/>
 	<input type="hidden" id="id" name="id" value="${rsInsuranceMain.id}"/>
 	<input type="hidden" id="uuid" name="uuid" value="${rsInsuranceMain.uuid}"/>
<div class="scbox">
   <h2 class="sctitle">社保基数修改</h2>
 	<div calss="scadd">
		<ul class="scadd-ul">
			<li class="scadd-li">
				<label for="">城市</label>
				<input class="easyui-combobox" name="dictCode"  id="dictCode" readonly="true" data-options="required:true,
                     data:allcity,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择',
                     onLoadSuccess: function(rec){    
			            var name = rec.name;    
			            $('#dictCode').combobox('setValue', '${rsInsuranceMain.dictCode }');
			        }"
                    >
			</li>
			<li class="scadd-li">
				<label for="">社保年度</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<select class="easyui-combobox" id="insuranceYear" name="insuranceYear" style="width: 90%" readonly="true" data-options="
                     required:true,
                     prompt:'请选择',onBeforeLoad: function(rec){    
			            $('#insuranceYear').combobox('setValue', '${rsInsuranceMain.insuranceYear }');
			        }"
                ">
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                </select>
                   
			</li>
			<li class="scadd-li cusli">
				<label for="">政策有效期</label>
				<!-- <input type="text" id="J-xl"> -->
			<input type= "text" class= "easyui-datebox" editable='false' name="startTime"  
           	 id="startTime" value="  <fmt:formatDate value="${rsInsuranceMain.startTime}" pattern="yyyy-MM-dd" />">
			</li>
			<li class="scadd-li">
				<label for="">至</label>
				<input type= "text" class= "easyui-datebox" editable='false' name="endTime"  
        	id="endTime" data-options="required:true,prompt:'请选择'" maxlength="30" style="width:140px" value="<fmt:formatDate value="${rsInsuranceMain.endTime}" pattern="yyyy-MM-dd" />">
			</li>
			<li class="scadd-li">
				<label for="">基数核定月份</label>
				<select class="easyui-combobox" name="checkMonth" id="checkMonth"  style="width: 90%" data-options="required:true,prompt:'请选择',
				 onBeforeLoad: function(rec){    
			            $('#checkMonth').combobox('setValue', '${rsInsuranceMain.checkMonth }');
			        }">
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
			</li>
			<li class="scadd-li">
				<label for="">社会平均工资</label>
				<input class="saw" type="text" nullmsg="社会平均工资不能空" errormsg="社会平均工资为数字" 
				name="averagePay"  id="averagePay" datatype="n" value="${rsInsuranceMain.averagePay}">&nbsp;元
			</li>
		</ul>
	</div>
	<h2 class="sctitle">缴费人员类型</h2>
    <div class="scclassify">
		<table id= "dataTable" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>序号</th>
					<th>缴费人员类型</th>
					<th>开始日期</th>
					<th>截止日期</th>
				</tr>
			</thead>
			<tbody>
			 <c:if test="${fn:length(rsInsuranceAccountList)  > 0 }"> 
			    <c:forEach items="${rsInsuranceAccountList}" var="poVal" varStatus="stuts">
				<tr>
					<td>${stuts.index +1}</td>
					<td>
					<input name="rsInsuranceAccountList[${stuts.index }].dictName" maxlength="50" type="text" value="${poVal.dictName }"  readonly="true" style="border:0"/>
			         <input name="rsInsuranceAccountList[${stuts.index }].dictCode"  type="hidden" value="${poVal.dictCode }"/>
			         <input name="rsInsuranceAccountList[${stuts.index }].id"  type="hidden" value="${poVal.id }"/>
					</td>
					<td>
					<!-- <input type="text" id="J-x3"> -->
					<input class="easyui-datebox" name="rsInsuranceAccountList[${stuts.index }].startTime" id="rsInsuranceAccountList${stuts.index }startTime"  value="<fmt:formatDate value="${poVal.startTime }" pattern="yyyy-MM-dd" />" data-options="
		                	 required:true,
		                     editable:false,
		                     prompt:'请选择'"/>
					</td>
					<td>
					<!-- <input type="text" id="J-x4"> -->
					<input class="easyui-datebox" name="rsInsuranceAccountList[${stuts.index }].endTime" id="rsInsuranceAccountList${stuts.index }endTime" value="<fmt:formatDate value="${poVal.endTime }" pattern="yyyy-MM-dd" />"  data-options="
		                	 required:true,
		                     editable:false,
		                     prompt:'请选择'"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>   
		</tbody>
		</table>
	</div>
    <h2 class="sctitle">险种基数</h2>
	<div class="scclassify">
		<table border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>序号</th>
					<th>险种</th>
					<th>上限（%）</th>
					<th>下限（%）</th>
					<th>上限基数</th>
					<th>下限基数</th>
				</tr>
			</thead>
			<tbody class="bins">
			 <c:if test="${fn:length(rsInsuranceBaseList)  > 0 }">
			       <c:forEach items="${rsInsuranceBaseList}" var="poVal1" varStatus="state2">  
				<tr>
					<td>${state2.index +1}</td>
					<td>
					 <input name="rsInsuranceBaseList[${state2.index }].id"  
			            type="hidden" value="${poVal1.id }"/>
			         <input name="rsInsuranceBaseList[${state2.index }].insuranceUuid"  
			            type="hidden" value="${poVal1.insuranceUuid }"/>
					<input name="rsInsuranceBaseList[${state2.index }].dictName" maxlength="50" 
			            type="text" value="${poVal1.dictName }"  readonly="true" style="border:0"/>
			            <input name="rsInsuranceBaseList[${state2.index }].dictCode"  
			            type="hidden" value="${poVal1.dictCode }"/>
					</td>
					<td>
					<!-- <input class="trate" type="text" value=""> -->
					<input type="text" name="rsInsuranceBaseList[${state2.index }].ceiling" 
			            class="trate" value="${poVal1.ceiling }" datatype="d" />
					</td>
					<td>
					<!-- <input class="brate" type="text" value=""> -->
					<input type="text" name="rsInsuranceBaseList[${state2.index }].floor" 
			            class="brate" value="${poVal1.floor }" datatype="d"/>
					</td>
					<td>
					<!-- <input class="trNum" type="text" readonly="" value="0"> -->
					<input type="text" name="rsInsuranceBaseList[${state2.index }].ceilingBase" 
			            class="trNum" value="${poVal1.ceilingBase }" datatype="d" readonly="true"/>
					</td>
					<td>
					<!-- <input class="brNum" type="text" readonly="" value="0"> -->
					<input type="text" name="rsInsuranceBaseList[${state2.index }].floorBase" 
			            class="brNum" value="${poVal1.floorBase }" datatype="d" readonly="true"/>
					</td>
				</tr>
				 </c:forEach>
			  </c:if>   
				
			</tbody>
		</table>
	</div>
	<script>
	$(function(){
		// 输入金额时的变化
		$('.saw').bind('input propertychange', function() {	
			for (var i = 0; i < $('.bins tr').length; i++) {	
				var topNum = $('.saw').val()*$(".bins tr").eq(i).find('.trate').val()/100;
				var btmNum = $('.saw').val()*$(".bins tr").eq(i).find('.brate').val()/100;
				$(".bins tr").eq(i).find('.trNum').val(topNum);
				$(".bins tr").eq(i).find('.brNum').val(btmNum);
			};
		});
		// 输入上限和下限的时候的变化
		/*$('.trate').bind('input propertychange', function() {
			var topNum = $('.saw').val()*$(this).val()/100;
			$(this).parents('tr').find('.trNum').val(topNum);
		});
		$('.brate').bind('input propertychange', function() {
			var topNum = $('.saw').val()*$(this).val()/100;
			$(this).parents('tr').find('.brNum').val(topNum);
		});*/

		$('.bins').delegate(".trate","input propertychange",function(){
                var topNum = $('.saw').val()*$(this).val()/100;
				$(this).parents('tr').find('.trNum').val(topNum);
         });
		$('.bins').delegate(".brate","input propertychange",function(){
                var topNum = $('.saw').val()*$(this).val()/100;
				$(this).parents('tr').find('.brNum').val(topNum);
         });
	});
</script>
</div>
</form>

</body>
</html>