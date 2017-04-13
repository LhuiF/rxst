<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
	<title>补缴计算器</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/metro/easyui.css"/>

<link rel="stylesheet" type="text/css" href="style.css"/>

<!-- jquery -->
<script type="text/javascript" src="easyui/jquery.min.js"></script>

<!-- easyui js -->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<style>
	  /*初始化*/
		html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img { margin:0; padding:0; }
		img { border: none; display:block; }
		ol,ul { list-style: none; }
		a { text-decoration: none; }
		textarea { resize:none; }
		/* 页面样式 */
		.addsb p,.addznj p {
			padding: 4px 0;
			text-align: center;
		}
		.sbcalculator {
			padding-left: 230px;
		}
		.sbcalculator li {
			height: 32px;
			line-height: 32px;
			overflow: hidden;
		}
		.sbcalculator li label {
			display: inline-block;
			width: 110px;
		}
		.xztype label {
			float: left;
		}
		.xztype div {
			float: left;
		}
		.xztype ul{
			overflow: hidden;
		}
		.xztype ul li {
			float: left;
		}
		.xztype div {
			display: inline-block;
		}
		.calculaBtn {
			display: block;
			width: 50px;
			height: 25px;
			line-height: 25px;
			color: #000;
			background: #ccc;
			text-align: center;
			border: 1px solid #000;
			margin: 0 auto;
		}
</style>
</head>
<body>
	<div id="p" class="easyui-panel addsb" title="社会保险缴费金额模拟计算"   
	        style="width:800px;padding:10px;background:#fafafa;"   
	        data-options="iconCls:'icon-save',border:true">  
	    <ul class="sbcalculator">
	    	<li>
	    		<label for="">缴费方式</label>
	    		<select id="cc" class="easyui-combobox" name="dept" style="width: 150px;">   
				    <option value="aa">aitem1</option>   
				    <option>bitem2</option>   
				    <option>bitem3</option>   
				    <option>ditem4</option>   
				    <option>eitem5</option>   
				</select>  
	    	</li>
	    	<li class="xztype">
	    		<label for="">参加险种</label>
	    		<div>
	    			<ul>
	    				<li><input type="checkbox">养老</li>
	    				<li><input type="checkbox">医疗</li>
	    				<li><input type="checkbox">失业</li>
	    				<li><input type="checkbox">工伤</li>
	    				<li><input type="checkbox">生育</li>
	    			</ul>
	    		</div>
	    	</li>
	    	<li>
	    		<label for="">缴费基数（元）</label>
	    		<input class="easyui-textbox" data-options="iconCls:'icon-search'" style=""> 
	    	</li>
	    	<li>
	    		<label for="">行业费率（%）</label>
	    		<input class="easyui-textbox" data-options="iconCls:'icon-search'" style=""> 
	    	</li>
	    </ul>
	    <a class="calculaBtn" href="javascript:;">计算</a>
	    <p>参考资料：</p>  
	    <p>计算结果仅供参考</p>  
		<table class=""  cellspacing="0" cellpadding="5" border="1" style="border: 1px solid #ccc; text-align: center; width: 100%">
		    <thead>   
		        <tr>   
		            <th rowspan="2" data-options="field:'code'"></th>   
		            <th colspan="3" data-options="field:'name'">养老保险应缴</th>   
		            <th colspan="3" data-options="field:'price'">医疗保险应缴</th>   
		            <th colspan="3" data-options="field:'price'">失业保险应缴</th>   
		            <th data-options="field:'price'">工伤保险应缴</th>   
		            <th data-options="field:'price'">生育保险应缴</th>   
		        </tr> 
		        <tr>
		        	<td>单位</td>
		        	<td>个人</td>
		        	<td>合计</td>
		        	<td>单位</td>
		        	<td>个人</td>
		        	<td>合计</td>
		        	<td>单位</td>
		        	<td>个人</td>
		        	<td>合计</td>
		        	<td>单位</td>
		        	<td>单位</td>
		        </tr>  
		    </thead>   
		    <tbody>   
		        <tr>   
		            <td></td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		            <td>12</td>   
		        </tr>   
		        <tr>   
		            <td>总计</td>
		            <td colspan="11">345</td>
		        </tr>   
		    </tbody>   
		</table>  
	</div> 
	<div id="p" class="easyui-panel addznj" title="滞纳金模拟计算"   
	        style="width:800px;padding:10px;background:#fafafa;"   
	        data-options="iconCls:'icon-save',border:true">
	        <ul class="sbcalculator">
	        	<li>
	        		<label for="">欠缴金额（元）</label>
	        		<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="">
	        	</li>
	        	<li>
	        		<label for="">欠缴年月</label>
	        		<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="">
	        		年
	        		<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="">
	        		月
	        	</li>
	        	<li>
	        		<label for="">预还款日期</label>
	        		<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"> </input>  
	        		<!-- <input class="easyui-textbox" data-options="iconCls:'icon-search'" style=""> -->
	        	</li>
	        </ul>
	        <p>说明：录入的欠缴金额须大于0，保留2位小数，录入的预还款日期须晚于欠缴月份</p>
	        <a class="calculaBtn" href="javascript:;">计算</a>
	        <p>本工具为对“所录入的欠缴月份”的滞纳金进项计算，结果仅供参考。若需计算连续欠费多个月的滞纳金合计，可多次录入、计算后自行累加汇总</p>
	</div>
</body>
</html>