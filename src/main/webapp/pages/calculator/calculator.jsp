<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>计算器</title>
   <script type="text/javascript" src="${CP}/pages/canshu/shebaoProportion.js"></script>
  <style>
	/*初始化*/
		html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img { margin:0; padding:0; }
		img { border: none; display:block; }
		ol,ul { list-style: none; }
		a { text-decoration: none; }
		textarea { resize:none; }
	/*页面效果*/
	    /*样式*/
		.qysb {
			padding: 10px;
		}
		.qysb h2 {
			padding: 10px 0 10px 0;
			font-size: 22px!important;
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
			padding: 0 20px 10px 0;
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
		.scaddtopBtn {
			overflow: hidden;
			padding-bottom: 20px;
		}
		.scaddtopBtn li {
			padding-right: 20px;
			float: left;
		}
		.scaddtopBtn li a {
			display: block;
			width: 70px;
		    height: 36px;
		    border-radius: 5px;
		    line-height: 36px;
		    font-size: 15px;
		    color: #fff;
		    text-align: center;
		    background-color: #217ca6;
		    

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
		.dcbtn {
			display: block;
			width: 100px;
		    height: 36px;
		    border-radius: 5px;
		    line-height: 36px;
		    font-size: 15px;
		    color: #fff;
		    text-align: center;
		    background-color: #217ca6;
		    margin: 10px 0 10px 0;
		}
	</style>
  </head>
<body>
<div class="qysb">
	
	<div calss="scadd">
		<ul class="scadd-ul">
			<li class="scadd-li">
				<label for="">缴费城市</label>
				<input id="cc"  class="easyui-combobox jfcontry" name="dept">
			</li>
			<li class="scadd-li">
				<label for="">缴费日期</label>
				<input  id="dd"  type= "text" class= "easyui-datebox jfDate" required ="required"> </input>  
			</li>
			<li class="scadd-li">
				<label for="">社保申报工资</label>
				<input class="easyui-textbox sbIpt" data-options="iconCls:'icon-search'" style="width:150px"> 
				元
			</li>
			<li class="scadd-li">
				<label for="">公积金申报工资</label>
				<input class="easyui-textbox gjjIpt" data-options="iconCls:'icon-search'" style="width:150px"> 
				元
			</li>
		</ul>
		<ul class="scaddtopBtn">
			<li><a class="ascSubmit" href="javascript:;">计算</a></li>
			<li><a class="ascReset" href="javascript:;">清除</a></li>
		</ul>
	</div>
	<h2 class="qysbtle">社会保险</h2>
	<div>
		<table class="qysbTab" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<tH rowspan="2">缴费人员类别</tH>
					<tH colspan="2">养老</tH>
					<tH colspan="2">失业</tH>
					<tH colspan="2">工伤</tH>
					<tH colspan="2">生育</tH>
					<tH colspan="2">医疗</tH>
					<tH colspan="3">总计</tH>
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
					<tH>个人</tH>	
					<tH>企业</tH>	
					<tH>个人</tH>
					<tH>合计</tH>	
				</tr>
			</thead>
			<tbody class="shbxCon">
			</tbody>
		</table>
		<a class="dcbtn" href="">导出结果</a>
	</div>
	<h2 class="qysbtle">公积金</h2>
	<div>
		<table class="qysbTab" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>户口类型</th>
					<th>企业</th>
					<th>个人</th>
					<th>总计</th>
				</tr>
			</thead>
			<tbody class="gjjCon">
			</tbody>
		</table>
		<a class="dcbtn" href="">导出结果</a>
	</div>

</div>
<script>
$(function(){
	$('#cc').combobox({    
	    url:basePath+"/CalculatorController/getCity",
	    valueField:'code',    
	    textField:'name'   
	});  
	
	$('.ascReset').click(function(){
		$('.sbIpt').textbox('setValue','');
		$('.gjjIpt').textbox('setValue','');
	})
	
	$('.ascSubmit').click(function(){
		$('.shbxCon').html('');
		$('.gjjCon').html('');
		var  jfcontry = $('.jfcontry').combobox('getValue');
		var  jfDate = $('.jfDate').datebox('getValue');
		var  sbIpt = $('.sbIpt').textbox('getValue');
		var  gjjIpt = $('.gjjIpt').textbox('getValue');
		
		var parsJson  = {"cityCode":jfcontry,"paymentDate":jfDate,"insurance":sbIpt,"accumulationFund":gjjIpt};
			$.ajax({
		             type: "POST",
		             url: basePath+"/CalculatorController/calculatorInsurance",
		             data: JSON.stringify(parsJson),
		             dataType : "json",
		             contentType:"application/json",
		             success: function(datal){
							/*社会保险数据回显*/
							var shbxhtl = '';	
							for (var i = 0; i < datal.data.insurance.length; i++) {
								shbxhtl+='<tr>'
											+'<td>'+datal.data.insurance[i].name+'</td>'
											+'<td>'+datal.data.insurance[i].pensionsEnterprise+'</td>'	
											+'<td>'+datal.data.insurance[i].pensionsPersonal+'</td>'	
											+'<td>'+datal.data.insurance[i].unemploymentEnterprise+'</td>'	
											+'<td>'+datal.data.insurance[i].unemploymentPersonal+'</td>'	
											+'<td>'+datal.data.insurance[i].injuriesEnterprise+'</td>'	
											+'<td>'+datal.data.insurance[i].injuriesPersonal+'</td>'	
											+'<td>'+datal.data.insurance[i].birthEnterprise+'</td>'	
											+'<td>'+datal.data.insurance[i].birthPersonal+'</td>'	
											+'<td>'+datal.data.insurance[i].medicalEnterprise+'</td>'	
											+'<td>'+datal.data.insurance[i].medicalPersonal+'</td>'	
											+'<td class="qynum">'+datal.data.insurance[i].enterpriseSum+'</td>'	
											+'<td>'+datal.data.insurance[i].personalSum+'</td>'	
											+'<td class="hjnum">'+datal.data.insurance[i].total+'</td>'	
										+'</tr>';
							};
							$('.shbxCon').append(shbxhtl);
							for (var i = 0; i < $('.shbxCon tr').length; i++) {
								var qynum = $('.shbxCon tr').eq(i).find('.qynum').html();
								var hjnum = $('.shbxCon tr').eq(i).find('.hjnum').html();
								$('.shbxCon tr').eq(i).find('.qynum').html(Math.round(qynum*100)/100);
								$('.shbxCon tr').eq(i).find('.hjnum').html(Math.round(hjnum*100)/100);
							};
							/*公积金数据回显*/
							var gjjhtl = '';
							for (var i = 0; i < datal.data.accumulation.length; i++) {
								gjjhtl +='<tr>'
											+'<td>'+datal.data.accumulation[i].name+'</td>'
											+'<td>'+datal.data.accumulation[i].enterprise+'</td>'
											+'<td>'+datal.data.accumulation[i].personal+'</td>'
											+'<td>'+datal.data.accumulation[i].total+'</td>'
										+'</tr>';
							}
							$('.gjjCon').append(gjjhtl);
		             },
		             error:function(){
		                 	
		            }
		    });
	});

	
	

	



});
</script>
</body>
</html>