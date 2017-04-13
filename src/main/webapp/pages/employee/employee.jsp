<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
	<meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <script type="text/javascript" src="${CP}/js/page/employee/employee.js"></script>
    <script src="${CP}/js/page/file/jquery.ui.widget.js"></script>
    <script src="${CP}/js/page/file/jquery.iframe-transport.js"></script>
    <script src="${CP}/js/page/file/jquery.fileupload.js"></script>
    <script type="text/javascript" src="${CP}/js/page/proxyInfo/formToJson.js"></script>
	<title>员工信息</title>
	 <script type="text/javascript">
         parperType = ${dict[1017]};
         level = ${dict[1007]};
         peopleType = ${dict[20003]};
         hukou = ${dict[20005]};
         geren = ${dict[20007]};
         fangshi =${dict[20011]};
         minzu=${dict[1006]};
    </script>
	<style>
	/*初始化*/
		html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img { margin:0; padding:0; }
		img { border: none; display:block; }
		ol,ul { list-style: none; }
		a { text-decoration: none; }
		textarea { resize:none; }
	/*新增员工信息样式*/
	.addei {
		padding: 10px;
	}
	.addei-stitle {
		font-size: 14px;
		font-weight: 700;
		color: #333;
		padding: 0 80px 15px 0;
	 }
		.adbsi {
			border-color: #ccc;
			color: #333;
			font-size: 13px;
			text-align: center;
			
		}
		.adbsi td{
			padding: 8px 5px;

		}
		.adbsi td span {
			color: red;
		}
		.adbsi-li {
			padding-top: 20px;
		}
		.adbsi-li span {
			color: red;
		}
		.adbsi-li label {
			padding-right: 10px;
			font-size: 13px;
			font-weight: 400;
			color: #333;

		}
		.adbsi-li input,.adbsi-li select {
			height: 25px;
			width: 50%;
			line-height: 25px;
			text-align: left;
			padding: 1px;
			margin: 0;
			border: 1px solid #333;
			outline: none;
		}
		/*五险一金信息*/
		.ihouse {
			border-color: #ccc;
			color: #333;
			font-size: 13px;
			text-align: center;
		}
		.ihouse th {
			padding: 5px;
			background-color: #e1e9dc;
		}
		.ihouse td{
			padding: 10px 5px;

		}
		.idphoto-li {
			overflow: hidden;
			padding: 10px 0;
		}
		.idpt-li-left {
			float: left;
			padding-right: 30px;
			min-width: 140px;
		}
		.idpt-li-right {
			float: left;

		}
		.idpt-li-left p {
			padding: 20px 0 20px 0;
			font-size: 16px;
			color: #333;
			font-weight: 400;
		}
		.idpt-li-left input {
			width: 70px;
			height: 36px;
			border-radius: 5px;
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			-ms-border-radius: 5px;
			line-height: 36px;
			font-size: 15px;
			color: #fff;
			text-align: center;
			outline: none;
			border: none;
			padding: 0;
			margin: 0;
			background-color: #217ca6;
		}
		.idpt-li-right {
			border: 1px solid #333;
			height: 250px;
			width: 500px;
		}
		.idpt-li-right img {
			width: 100%;
		}
		/*按钮*/
		.addei-btn {
			overflow: hidden;
			padding: 20px 0 0 200px;
		}
		.addei-btn a {
			float: left;
			display: inline;
			width: 70px;
			height: 36px;
			border-radius: 5px;
			line-height: 36px;
			font-size: 15px;
			color: #fff;
			text-align: center;
			background-color: #217ca6;
			margin-right: 10px;
		}
		.jbha {
			overflow:hidden;
		}
		.jbha h3 {
			float:left;
		}
	</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
     <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
	   <form id="queryEmployee" method="post">
	        <label style="padding: 0 5px">
	            企业名称: <input  name="enterpriseName"  />  
	        </label>
	          <label style="padding: 0 5px">
	            雇员姓名: <input id="employeeName" name="employeeName"  />  
	        </label>
	          <label style="padding: 0 5px">
	            证件号码: <input id="paperWorkCode" name="paperWorkCode"  />  
	        </label>
	        <a href="#" class="easyui-linkbutton" onclick="queryemployeeinfo();">查询</a>
	</div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddemployee()" class="easyui-linkbutton" >新增</a>
            <a id="btn_edit" onclick="editorEmployee()" class="easyui-linkbutton" >修改</a>
            <a id="btn_delete" onclick="deleteemployee()" class="easyui-linkbutton" >删除</a>
        </div>
        <table id="datagrid"></table>
    </div>
    </form>
</div>
<div id="addemployeeLayout" class="addei" data-options="fit:true">
	<!-- 基本信息 -->
	<div class="jbha">
	<h3 class="addei-stitle" > <a id="btn_edit" onclick="showpeople()" class="easyui-linkbutton btn-edit l-btn l-btn-small" >个人信息</a></h3>
	 <h3 class="addei-stitle"> <a id="btn_edit" onclick="showfive()" class="easyui-linkbutton btn-edit l-btn l-btn-small" >五险一金信息</a></h3>
	 <h3 class="addei-stitle"> <a id="btn_edit" onclick="showannex()" class="easyui-linkbutton btn-edit l-btn l-btn-small" >附件信息</a></h3>
	</div>
	
	<div class="adbsi-worp" id="people">
	<input  id ="id" name="id" type="hidden" >
	<input id ="ssFundinfoid" name="ssFundinfo.id" type="hidden" ></td>
		<form id="baseForm">
		<table class="adbsi" border="1" cellspacing="0" cellpadding="0">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>照片 </td>
					<td> <input class="easyui-filebox" id ="logPhoto" name="logPhoto"  type="text" data-options="required:true,
					    buttonText: '选择头像',
					    onClickButton:function(){
					    logoUpload('#filebox_file_id_1');
					    } "> </td>
					<td><span>*</span>雇员姓名</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="employeeName" name="employeeName" type="text"></td>
					<td><span>*</span>性别</td>
					<td><input class="easyui-combobox" id ="sex" name="sex" type="text" data-options="required:true,
					     data:[{
								code: '0',
								name: '男'
							},{
								code: '1',
								name: '女'
							}] ,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     panelHeight:50,
	                     onChange :function(newValue, oldValue){
	                      $('#sex').attr('value',newValue)
	                     } "> 
					</td>
					<td><span>*</span>证件类型</td>
					<td><input class="easyui-combobox" id ="paperWorkType" name="paperWorkType" type="text"data-options="required:true,
					     data:parperType,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#paperWorkType').attr('value',newValue)
	                     } "></td>
				</tr>
				<tr>
					<td><span>*</span>*证件号码</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']"id ="paperWorkCode" name="paperWorkCode" type="text"></td>
					<td><span>*</span>出生日期</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="birthDate" name="birthDate" type="text"></td>
					<td><span>*</span>年龄</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['positiveInt']"id ="age" name="age" type="text"></td>
					<td><span>*</span>民族</td>
					<td><input class="easyui-combobox" id ="nation" name="nation" type="text" data-options="required:true,
					     data:minzu,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#nation').attr('value',newValue)
	                     }"></td>
				</tr>
				<tr>
					<td><span>*</span>籍贯</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="nativePlace" name="nativePlace" type="text"></td>
					<td><span>*</span>文化程度</td>
					<td><input class="easyui-combobox" id ="educationalLevel" name="educationalLevel" type="text"data-options="required:true,
						 data:level,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#educationalLevel').attr('value',newValue)
	                     }"></td>
					<td><span>*</span>个人身份</td>
					<td><input class="easyui-combobox" id ="personalIdentity" name="personalIdentity" type="text" data-options="required:true,
					     data:geren,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#personalIdentity').attr('value',newValue)
	                     }"></td>
					<td><span>*</span>公民身份号码<br>（社会保障号码）</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']"id ="citizenIdCode" name="citizenIdCode" type="text"></td>
				</tr>
				<tr>
					<td><span>*</span>国家/地区</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="countryRegion" name="countryRegion" type="text"></td>
					<td><span>*</span>户口性质</td>
					<td><input class="easyui-combobox" id ="accountNature" name="accountNature" type="text" data-options="required:true,
					     data:hukou,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#accountNature').attr('value',newValue)
	                     }"></td>
					<td><span>*</span>参加工作日期</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="joinWork" name="joinWork" type="text"></td>
					<td><span>*</span>社保缴费人员类别  
					<td><input class="easyui-combobox" id ="ssPeopleType" name="ssFundinfo.ssPeopleType" type="text" data-options="required:true,
					    data:peopleType,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#ssPeopleType').attr('value',newValue)
	                     }"></td>
				</tr>
				<tr>
					<td><span>*</span>医疗参保人员类别</td>
					<td><input class="easyui-combobox" id ="mtPeopleType" name="ssFundinfo.mtPeopleType" type="text" data-options="required:true,
					     data:peopleType,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#mtPeopleType').attr('value',newValue)
	                     }"></td>
					<td><span>*</span>居住地(联系)地址</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="address" name="address" type="text"></td>
					<td><span>*</span>居住地（联系）邮政编码</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['zip']"id ="addressZipCode" name="addressZipCode" type="text"></td>
					<td><span>*</span>户口所在地地址</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="accountAddress" name="accountAddress" type="text"></td>

					
				</tr>
				<tr>
					<td><span>*</span>户口所在地邮政编码</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['zip']"id ="accountZipCode" name="accountZipCode" type="text"></td>
					<td><span>*</span>获取社保对账单方式</td>
					<td><input class="easyui-combobox" id ="obtainSsWay" name="ssFundinfo.obtainSsWay" type="text" data-options="required:true,
					     data:fangshi,
	                     valueField:'code',
	                     textField:'name',
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#obtainSsWay').attr('value',newValue)
	                     }"></td>
					<td><span>*</span>参保人电话</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['mobilePhone']"id ="insuredTele" name="ssFundinfo.insuredTele" type="text"></td>
					<td><span>*</span>邮箱</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['email']"id ="email" name="email" type="text"></td>
				</tr>
				<tr>
					<td><span>*</span>发放社保卡日期</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="issuanceSscardDate" name="ssFundinfo.issuanceSscardDate" type="text"></td>
					<td><span>*</span>发放医保存折日期</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="issuanceMtcardDate" name="ssFundinfo.issuanceMtcardDate" type="text"></td>
					<td><span>*</span>手机号</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['mobilePhone']"id ="tele" name="tele" type="text"></td>
					<td>企业</td>
					<td><input class="easyui-combobox"  id ="enterpriseId" name="enterpriseId" type="text" data-options="required:true,
						url:basePath+'/enterpriseController/getEnterpriseList',  
					    valueField:'id',    
					    textField:'name',
					    required:true,
					    loadFilter: function(data){
							return data.rows;
						},
						onChange :function(newValue, oldValue){
				            $('#enterpriseId').attr('value',newValue);
				        }"></td>
				</tr>
				<tr>
					<td><span>*</span>工号</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="jobNumber" name="jobNumber" type="text"></td>
					<td><span>*</span>委托代发银行名称</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="bankName" name="ssFundinfo.bankName" type="text"></td>
					<td><span>*</span>委托代发银行账号</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="bankCode" name="ssFundinfo.bankCode" type="text"></td>
					<td><span>*</span>是否患有特殊病</td>
					<td><input class="easyui-combobox" id ="isSick" name="ssFundinfo.isSick" type="text"  data-options="required:true,
					     data:[{
								code: '0',
								name: '否'
							},{
								code: '1',
								name: '是'
							}] ,
	                     valueField:'code',
	                     textField:'name',
	                     panelHeight:50,
	                     prompt:'请选择',
	                     onChange :function(newValue, oldValue){
	                      $('#isSick').attr('value',newValue)
	                     }"></td>
				</tr>
				<tr>
					
					<td><span>*</span>申报月均工资收入（元)</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']"id ="averageWage" name="ssFundinfo.averageWage" type="text"></td>
					<td><span>*</span>社保申报工资</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']"id ="ssWage" name="ssFundinfo.ssWage" type="text"></td>
					<td><span>*</span>公积金申报工资</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']"id ="pfWage" name="ssFundinfo.pfWage" type="text"></td>
					<td><span>*</span>社保申报开始时间</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="ssDeclareDate" name="ssFundinfo.ssDeclareDate" type="text"></td>
				</tr>
				<tr>
					
					<td><span>*</span>公积金申报开始时间</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="pfDeclareDate" name="ssFundinfo.pfDeclareDate" type="text"></td>
					<td><span>*</span>社保实际开始时间</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="ssStartDate" name="ssFundinfo.ssStartDate" type="text"></td>
					<td><span>*</span>公积金实际开始时间</td>
					<td><input class="easyui-datetimebox" data-options="required:true"id ="pfStartDate" name="ssFundinfo.pfStartDate" type="text"></td>
					<td><span>*</span>外籍人员护照号码</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="exPassportCode" name="exPassportCode" type="text"></td>
				</tr>
				<tr>
					<td><span>*</span>外国人居留证号码</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="exPermitCode" name="exPermitCode" type="text"></td>
					<td><span>*</span>增员原因</td>
					<td><input class="easyui-textbox" data-options="required:true"id ="addReason" name="ssFundinfo.addReason" type="text"></td>
				</tr>
			</tbody>
		</table>
		<ul class="adbsi-ul" >
			<li class="adbsi-li">
				<label for=""><span>*</span>定点医疗机构1</label>
				<input class="easyui-textbox" data-options="required:true,validType:['chs']"id ="designated1" name="ssFundinfo.designated1" type="text">
			</li>
			<li class="adbsi-li">
				<label for=""><span>*</span>定点医疗机构2</label>
				<input class="easyui-textbox" data-options="required:true,validType:['chs']"id ="designated2" name="ssFundinfo.designated2" type="text">
			</li>
			<li class="adbsi-li">
				<label for=""><span>*</span>定点医疗机构3</label>
				<input class="easyui-textbox" data-options="required:true,validType:['chs']"id ="designated3" name="ssFundinfo.designated3" type="text">
			</li>
			<li class="adbsi-li">
				<label for=""><span>*</span>定点医疗机构4</label>
				<input class="easyui-textbox" data-options="required:true,validType:['chs']"id ="designated4" name="ssFundinfo.designated4" type="text">
			</li>
			<li class="adbsi-li">
				<label for=""><span>*</span>定点医疗机构5</label>
				<input class="easyui-textbox" data-options="required:true,validType:['chs']"id ="designated5" name="ssFundinfo.designated5" type="text">
			</li>
		</ul>
		</form>
	</div>
	<!-- 五险一金信息 -->
	<!-- <h3 class="addei-stitle">五险一金信息</h3> -->
	<div id="five" class="ihouse-worp" style="display: none;">
	   <input id ="fiveRisksid" name="id" type="hidden" class="easyui-textbox" >
		<form id="fiveForm">
		<table class="ihouse" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th></th>
					<th>养老</th>
					<th>失业</th>
					<th>生育</th>
					<th>工伤</th>
					<th>医疗</th>
					<th>公积金</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>是否在缴</td>
					<td><input class="easyui-textbox" data-options="required:true" name="pension.isPayment" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="unemployment.isPayment" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="fertility.isPayment" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="workInjury.isPayment" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="medicalTreatment.isPayment" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="providentFund.isPayment" type="text"></td>
				</tr>
				<tr>
					<td>申报增员日期</td>
					<td><input class="easyui-textbox" data-options="required:true" name="pension.declareDate" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="unemployment.declareDate" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="fertility.declareDate" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="workInjury.declareDate" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="medicalTreatment.declareDate" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true" name="providentFund.declareDate" type="text"></td>
				</tr>
				<tr>
					<td>申报基数（申报工资）</td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="pension.declareWage" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="unemployment.declareWage" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="fertility.declareWage" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="workInjury.declareWage" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="medicalTreatment.declareWage" type="text"></td>
					<td><input class="easyui-textbox" data-options="required:true,validType:['number']" name="providentFund.declareWage" type="text"></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
	<div id="annex" class="ihouse-worp" style="display: none;">
	    <input id ="annexid" name="id" type="hidden" class="easyui-textbox" >
		<form id="annexForm">
		<ul class="idphoto">
			<li class="idphoto-li">
				<div class="idpt-li-left">
					<p>身份证正面：</p>
					<input  type="file" id="idFrontUpload" name="files[]" multiple  onclick="picUpload('#idFront');"/>
				 	<input  id="idFront" name="idFront" type="hidden" >
				</div>
				<div class="idpt-li-right"  id="idFrontimage">
				</div>
			</li>
			<li class="idphoto-li">
				<div class="idpt-li-left">
					<p>身份证背面：</p>
					<input  type="file" id="idBackUpload" name="files[]" multiple  onclick="picUpload('#idBack');"/>
					<input  id="idBack" name="idBack" type="hidden" >
				</div>
				<div  class="idpt-li-right" id="idBackimage">
				</div>
			</li>
			<li class="idphoto-li">
				<div class="idpt-li-left">
					<p>户口薄首页：</p>
					<input  type="file" id="accountHomeUpload" name="files[]" multiple  onclick="picUpload('#accountHome');"/>
					<input  id="accountHome" name="accountHome" type="hidden" >
				</div>
				<div  class="idpt-li-right" id="accountHomeimage">
				</div>
			</li>
			<li class="idphoto-li">
				<div class="idpt-li-left">
					<p>户口薄本人页：</p>
					<input  type="file" id="accountBackUpload" name="files[]" multiple  onclick="picUpload('#accountBack');"/>
					<input  id="accountBack" name="accountBack" type="hidden" >
				</div>
				<div  class="idpt-li-right" id="accountBackimage">
				</div>
			</li>
		</ul>
		</form>
	</div>
</div>
</body>
</html>