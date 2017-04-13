<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>企业社保缴费比例修改</title>
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
			   	/* var enterpriseName=$('#enterpriseUUid').combobox('getText');
			   	$('#enterpriseName').attr("value", enterpriseName); */
				
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
     action="${CP}/companyshebaoController/updateCompanysb" method="post">
   	<input type="hidden" id="btn_sub" class="btn_sub" />
 	<input type="hidden" id="enterpriseUUid" name="enterpriseUUid" value="${mainBili.companyUuid}" />
 	<input type="hidden" id="shebaoCanshuUuid" name="shebaoCanshuUuid" value="${mainBili.shebaoCanshuUuid }"/>
	<h2 class="qysbtle">企业社保缴费比例维护</h2>
	<div calss="scadd">
	
		<ul class="scadd-ul">
			<li class="scadd-li">
				<label for="">社保参数</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<input class= "easyui-combobox" editable="false" id="cc1" name="shebaoCanshuYearcity" value="${mainBili.shebaoCanshuYearcity }" style="width:140px;" required="required">
					
			</li>
			<li class="scadd-li">
				<label for="">企业名称</label>
				<!-- <select name="" id="">
					<option value="">1</option>
				</select> -->
				<input class="easyui-combobox" editable="false" name="enterpriseName" id="enterpriseName" value="${mainBili.companyName }" style="width:140px;">
					
				
			</li>
			<li class="scadd-li cusli">
				<label for="">政策有效期</label>
				<!-- <input type="text" id="J-xl"> -->
				<input id="cc2" class="easyui-datebox" readonly="true" name="enterprisestartTime"  value="<fmt:formatDate value="${mainBili.shebaoCanshuStarttime }" pattern="yyyy-MM-dd" />" style="width:140px;"/>
			</li>
			<li class="scadd-li">
				<label for="">至</label>
				<input id="cc3" class="easyui-datebox" readonly="true" name="enterpriseendTime"  value="<fmt:formatDate value="${mainBili.shebaoCanshuEndtime }" pattern="yyyy-MM-dd" />" style="width:140px;"/>
			</li>
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
				     <input type="hidden" 
									name="rsInsuranceAccountList[${stuts.index }].id"
									value="${poVal.id }">
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