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
<link rel="stylesheet" type="text/css" href="${CP}/css/canshu.css"/>
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
		/*样式*/
		.qysb {
			padding: 10px;
		}
		.qysb h2 {
			padding: 10px 0 20px 0;
		}
		.qysbtle {
			padding: 10px 0 10px 0;
			font-size: 18px;
			color: #333;
			font-weight: 700;
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
		.qysbTab {
			width: 100%;
			text-align: center;
			border-color: #ccc;
		}
		.qysbTab input {
			max-width: 60px;
		}
		.qysbTab th {
			padding: 10px 0;
		}
		.qysbTab td {
			padding: 10px 5px;
		}
	</style>
<script type="text/javascript">
	$(function(){
		$('#cc1').combobox({
	    url:basePath+'/RsInsuranceProportionController/insurance',
	    valueField:'uuid',    
	    textField:'yearCity',
	    onSelect: function(rec){
	    	var data = rec.uuid;
	    	$('#shebaoCanshuYearcity').attr("value", rec.yearCity);
	    	var baseurl = basePath+'/companyshebaoController/getInsuranceByUuid';
	    	 $.ajax({
	             type: "GET",
	             url: baseurl,
	             data: {id:data},
	             dataType: "json",
	             success: function(data){
	            	 $('#cc2').datebox('setValue', data.enterprisestartTime);	
	            	 $('#cc3').datebox('setValue', data.enterpriseendTime);
	            	 //$('').attr("value", data[0].uuid);
	            	 var list=data.rsInsuranceAccountList;
	            	
	            	if(list.length>0){
	            	   for(i=0;i<list.length;i++){
	            	       	$('#companyEndowment'+i+'').attr("value",list[i].companyEndowment);//
	            	       	$('#personEndowment'+i+'').attr("value",list[i].personEndowment);//
	            	       	$('#companyUnemployment'+i+'').attr("value",list[i].companyUnemployment);//
	            	       	$('#personUnemployment'+i+'').attr("value",list[i].personUnemployment);//
	            	       	$('#companyInjury'+i+'').attr("value",list[i].companyInjury);//
	            	       	$('#personInjury'+i+'').attr("value",list[i].personInjury);//
	            	       	$('#companyMedical'+i+'').attr("value",list[i].companyMedical);//
	            	       	$('#personMedical'+i+'').attr("value",list[i].personMedical);//
	            	       	$('#personMedicalDb'+i+'').attr("value",list[i].personMedicalDb);//
	            	       	$('#companyMaternity'+i+'').attr("value",list[i].companyMaternity);//
	            	       	$('#personMaternity'+i+'').attr("value",list[i].personMaternity);//
	            	       	
	            	   }
	            	 	
	            	 
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
			   	var enterpriseName=$('#enterpriseUUid').combobox('getText');
			   	$('#enterpriseName').attr("value", enterpriseName);
			   	var flag=false;
			   	var shebaoCS=$('#cc1').combobox('getValue');//社保参数
			   	
			   	var enterpriseuuid=$('#enterpriseUUid').combobox('getValue');//社保参数
			   	
			   	if(shebaoCS==""){
					message="社保参数不能为空";
					noty({text:message,timeout: 2000});
					return false;
				}
				
				if(enterpriseuuid==""){
					message="企业名称不能为空";
					noty({text:message,timeout: 2000});
					return false;
				}
				
				flag=$.ajax({
					url:'${CP}/companyshebaoController/validateEnterpriseSB',
					type:'post',
					data:{dictCode:shebaoCS,enterpriseUuid:enterpriseuuid},
					async : false, //默认为true 异步			
				}).responseText;
				
				if(flag=='false'){
					message="本年度的企业缴费比例已设置，不能重复设置！！";
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
	});
	
</script>
</head>
<body>
<div class="qysb">
<form id="formobj" name="formobj" style="width: 100%;margin: 0;padding:0;" 
     action="${CP}/companyshebaoController/saveEnterpriseSB" method="post">
   	<input type="hidden" id="btn_sub" class="btn_sub" />
 	<input type="hidden" id="enterpriseName" name="enterpriseName" />
 	<input type="hidden" id="shebaoCanshuYearcity" name="shebaoCanshuYearcity"/>
	<h2 class="qysbtle">企业社保缴费比例维护</h2>
	<div calss="scadd">
	
		<ul class="scadd-ul">
			<li class="scadd-li">
				<label for="">社保参数</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<select id="cc1" class="easyui-combobox" name="dept"  style="width:140px;" required="required">
					<option value="">请选择</option>
				</select>
			</li>
			<li class="scadd-li">
				<label for="">企业名称</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<select class="easyui-combobox" name="enterpriseUUid" id="enterpriseUUid" style="width:140px;">
					<option value="">请选择或输入</option>
					<c:forEach var="s" items="${enterprise }">
						<option value="${s.id }">${s.name }</option>
					</c:forEach>
				</select>
				
			</li>
			<li class="scadd-li cusli">
				<label for="">政策有效期</label>
				<!-- <input type="text" id="J-xl"> -->
				<input id="cc2" class="easyui-datebox" readonly="true" name="enterprisestartTime" style="width:140px;"/>
			</li>
			<li class="scadd-li">
				<label for="">至</label>
				<!-- <input type="text" id="J-x2"> -->
				<input id="cc3" class="easyui-datebox" readonly="true" name="enterpriseendTime" style="width:140px;"/>
			</li>
		</ul>
	</div>
	<div>
		<table class="qysbTab" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<tH rowspan="2">缴费人员类别</tH>
					<tH colspan="2">养老</tH>
					<tH colspan="2">失业</tH>
					<tH colspan="2">工伤</tH>
					<tH colspan="2">生育</tH>
					<tH colspan="3">医疗</tH>
				</tr>
				<tr>
					<tH>企业</tH>	
					<tH>个人</tH>	
					<tH>企业</tH>	
					<tH>个人</tH>	
					<tH>企业</tH>	
					<tH>个人</tH>	
					<tH>企业</tH>	
					<tH>个人</tH>	
					<tH>企业</tH>	
					<tH>个人基本</tH>	
					<tH>个人大病（元）</tH>	
				</tr>
			</thead>
			<tbody>
			 <c:if test="${fn:length(rsInsuranceAccountList)  > 0 }"> 
			    <c:forEach items="${rsInsuranceAccountList}" var="poVal" varStatus="stuts">
				<tr>
					<td style="width: 100px">
					<input type="hidden" 
									name="rsInsuranceAccountList[${stuts.index }].payPersonName"
									value="${poVal.payPersonName }" readonly="true" style="border:0">
					 <input type="hidden" 
									name="rsInsuranceAccountList[${stuts.index }].payPersonType"
									value="${poVal.payPersonType }">
									${poVal.payPersonName }
					</td>
					<td><input type="text" id="companyEndowment${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].companyEndowment"
									value="${poVal.companyEndowment }" datatype="d"></td>
								<td><input type="text" id="personEndowment${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personEndowment"
									value="${poVal.personEndowment }" datatype="d"></td>
								<td><input type="text" id="companyUnemployment${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].companyUnemployment"
									value="${poVal.companyUnemployment }" datatype="d"></td>
								<td><input type="text" id="personUnemployment${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personUnemployment"
									value="${poVal.personUnemployment }" datatype="d"></td>
								<td><input type="text" id="companyInjury${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].companyInjury"
									value="${poVal.companyInjury }" datatype="d"></td>
								<td><input type="text" id="personInjury${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personInjury"
									value="${poVal.personInjury }" datatype="d"></td>
								<td><input type="text" id="companyMedical${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].companyMedical"
									value="${poVal.companyMedical }" datatype="d"></td>
								<td><input type="text" id="personMedical${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personMedical"
									value="${poVal.personMedical }" datatype="d"></td>
								<td><input type="text" id="companyMaternity${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].companyMaternity"
									value="${poVal.companyMaternity }" datatype="d"></td>
								<td><input type="text" id="personMaternity${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personMaternity"
									value="${poVal.personMaternity }" datatype="d"></td>
								<td><input type="text" id="personMedicalDb${stuts.index }"
									name="rsInsuranceAccountList[${stuts.index }].personMedicalDb"
									value="${poVal.personMedicalDb }" datatype="d"></td>
									<input type="hidden"  name="rsInsuranceAccountList[${stuts.index }].companyUuid" value="${poVal.companyUuid }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].companyName"
									value="${poVal.companyName }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuUuid"
									value="${poVal.shebaoCanshuUuid }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuYearcity"
									value="${poVal.shebaoCanshuYearcity }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuStarttime"
									value="${poVal.shebaoCanshuStarttime }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuEndtime"
									value="${poVal.shebaoCanshuEndtime }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuCelling"
									value="${poVal.shebaoCanshuCelling }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].shebaoCanshuFloor"
									value="${poVal.shebaoCanshuFloor }">
								<input type="hidden"
									name="rsInsuranceAccountList[${stuts.index }].isdel"
									value="${poVal.isdel }">
							</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>
</form>
</div>
</body>
</html>