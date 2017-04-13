<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>新增社保参数</title>
<link rel="stylesheet" href="${CP}/plug-in/Validform/css/style.css" type="text/css" />
<link rel="stylesheet" href="${CP}/plug-in/Validform/css/tablefrom.css" type="text/css" />
<script type="text/javascript" src="${CP}/plug-in/tools/dataformat.js"></script>
<script type="text/javascript" src="${CP}/plug-in/tools/syUtil.js"></script>
<script type="text/javascript" src="${CP}/plug-in/lhgDialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="${CP}/lib/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${CP}/plug-in/tools/curdtools_zh-cn.js"></script>

<script type="text/javascript" src="${CP}/plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/js/datatype_zh-cn.js"></script>
<script type="text/javascript" src="${CP}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
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
				},
				
			},
			beforeSubmit:function(formobj){
			   var cityCode=$('#dictCode').combobox('getValue');//获取选择城市的值
				var starttime = $('#startTime').datebox('getValue');//政策有效期的开始时间
				var endtime= $('#endTime').datebox('getValue');//政策 有效期的结束时间
				var shebaoNd=$('#insuranceYear').combobox('getValue');//社保年度
				
				var message="";
				var flag=false;
				var rytypenumber="${rytypenumber}";
				var xzbasenumber="${xzbasenumber}";
				
				
				if(cityCode==""){
					message="城市不能为空";
					noty({text:message,timeout: 2000});
					return false;
				}
				if(starttime=="" || endtime=="" || starttime>endtime){
					message="政策有效期的开始时间或结束时间不能为空且开始时间不能大于结束时间";
					noty({text:message,timeout: 2000});
					return false;
				}
				
				flag=$.ajax({
					url:'${CP}/sheBaoMainListController/validateCityyear',
					type:'post',
					data:{dictCode:cityCode,year:shebaoNd},
					async : false, //默认为true 异步			
				}).responseText;
				if(flag=='false'){
					message="本年度的社保参数已设置，不能重复设置！！";
					noty({text:message,timeout: 2000});
				 return false;
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
</head>
<body>
<form id="formobj" name="formobj" style="width: 100%;margin: 0;padding:0;" 
     action="${CP}/sheBaoMainListController/saveRsInsurance" method="post">
   	<input type="hidden" id="btn_sub" class="btn_sub" />
 	<input type="hidden" id="dictName" name="dictName" />
<div class="scbox">
 <h2 class="sctitle">新增社保基数</h2>
 	<div calss="scadd">
		<ul class="scadd-ul">
			<li class="scadd-li">
				<label for="">城市</label>
				<input class="easyui-combobox" name="dictCode"  id="dictCode"  data-options="required:true,
                     data:allcity,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择',
                     onSelect: function(rec){    
			            var name = rec.name;    
			            $('#dictName').attr('value',name); 
			        }"
                    >
			</li>
			<li class="scadd-li">
				<label for="">社保年度</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<select class="easyui-combobox" id="insuranceYear" name="insuranceYear" style="width: 90%" data-options="
                     required:true,
                     prompt:'请选择',
                     onBeforeLoad: function(rec){    
			            var name = rec.name;    
			            $('insuranceYear').combobox('setValue', '${data[0].insuranceYear }');
			        }
                ">
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                </select>
			</li>
			<li class="scadd-li cusli">
				<label for="">政策有效期</label>
				<!-- <input type="text" id="J-xl"> -->
			<input type= "text" class= "easyui-datebox" editable='false' name="startTime"  
           		id="startTime" data-options="required:true,prompt:'请选择'" maxlength="30" style="width:140px">
			</li>
			<li class="scadd-li">
				<label for="">至</label>
				<input type= "text" class= "easyui-datebox" editable='false' name="endTime"  
        	id="endTime" data-options="required:true,prompt:'请选择'" maxlength="30" style="width:140px">
			</li>
			<li class="scadd-li">
				<label for="">基数核定月份</label>
				<select class="easyui-combobox" name="checkMonth"  style="width: 90%" data-options="required:true,prompt:'请选择'">
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
				<input class="saw" type="text" nullmsg="社会平均工资不能空" errormsg="社会平均工资为数字" name="averagePay"  id="averagePay" datatype="n" value="">&nbsp;元
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
					<input name="rsInsuranceAccountList[${stuts.index }].dictName" maxlength="50" type="text" value="${poVal.dictName }" readonly="true" style="border:0"/>
			         <input name="rsInsuranceAccountList[${stuts.index }].dictCode"  type="hidden" value="${poVal.dictCode }"/>
					</td>
					<td>
					<!-- <input type="text" id="J-x3"> -->
					<input class="easyui-datebox" name="rsInsuranceAccountList[${stuts.index }].startTime" id="rsInsuranceAccountList${stuts.index }startTime" data-options="
		                	 required:true,
		                     prompt:'请选择'"/>
					</td>
					<td>
					<!-- <input type="text" id="J-x4"> -->
					<input class="easyui-datebox" name="rsInsuranceAccountList[${stuts.index }].endTime" id="rsInsuranceAccountList${stuts.index }endTime" data-options="
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
					<input name="rsInsuranceBaseList[${state2.index }].dictName" maxlength="50" 
			            type="text" value="${poVal1.dictName }"  readonly="true" style="border:0"/>
			            <input name="rsInsuranceBaseList[${state2.index }].dictCode"  
			            type="hidden" value="${poVal1.dictCode }"/>
					</td>
					<td>
					<!-- <input class="trate" type="text" value=""> -->
					<input type="text" name="rsInsuranceBaseList[${state2.index }].ceiling" 
			            class="trate" value="${poVal1.ceiling }" datatype="d"/>
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
			            class="brNum" value="${poVal1.floorBase }"datatype="d" readonly="true"/>
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