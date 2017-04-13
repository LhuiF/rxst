/*$(function(){
	$('.fmtb1').delegate(".abew","click",function(){
    		alert();
		 var liIdx = $(this).parents('li').index();
		 var trIdx = $(this).parents('li').find('.tjsj tr').length - 1;
		 openAddCaiLiao(liIdx,trIdx);
	});	
})*/

function addCL(cgliIdx,cgtrIdx){
	    $('#caiLiaoDlg').dialog({
	        title:"新增联系人信息",
	        closed:false,
	        buttons:[{
				text:'保存',
				handler:function(){
					var data={};
					$("#caiLiaolData").serializeArray().map(function(x){data[x.name]=x.value;});
					var nhtml ="<tr class='fnltr'>" 
						+"<td >"  + "<input id='cailiao' name='TJ["+cgliIdx+"].CL["+cgtrIdx+"].clName' class='easyui-textbox' value='"+data.caiLiaoName+"'  style='width: 100%' data-options='required:true'>" +"</td>" 
						+"<td >" + "<input id='marerialRequests' name='TJ["+cgliIdx+"].CL["+cgtrIdx+"].clRqst' class='easyui-textbox' value='"+data.yaoqiu+"' style='width: 100%' data-options='required:true'>"+"</td>" 
						+"<td >" + "<input id='fenshus' name='TJ["+cgliIdx+"].CL["+cgtrIdx+"].clNum' class='easyui-textbox' value='"+data.fenshu +"' style='width: 100%' >"+"</td>"
						+"<td>"+"<a href='#' id='updateCaiLiao' onclick='del($(this));'>删除</a>"+ "</td>"
						+"</tr>";
					$('.fmtb1 li').eq(cgliIdx).find('.tjsj').append(nhtml);
					
					$('#caiLiaolData').form('clear');
					$('#caiLiaoDlg').dialog('close');
			}},{
				text:'取消',
				handler:function(){
					$('#caiLiaoDlg').dialog('close');
				}
			}]
	    });
	}
	
	
	function del(o){
		  o.parents('.fnltr').remove();
	}
	
	/*table.append("<tr>" 
	+"<td >"  + "<input id='cailiao' name='TJ["+partli+"].CL["+parttr+"].clName' class='easyui-textbox' value='"+data.caiLiaoName+"'  style='width: 100%' data-options='required:true'>" +"</td>" 
	+"<td >" + "<input id='marerialRequests' name='TJ["+partli+"].CL["+parttr+"].clRqst' class='easyui-textbox' value='"+data.yaoqiu+"' style='width: 100%' data-options='required:true'>"+"</td>" 
	+"<td >" + "<input id='fenshus' name='TJ["+partli+"].CL["+parttr+"].clNum' class='easyui-textbox' value='"+data.fenshu +"' style='width: 100%' >"+"</td>"
	+"<td>"+"<a href='#' id='updateCaiLiao' onclick='del(this);'>删除</a>"+ "</td>"
	+"</tr>"

);*/
	// TJ["+partli+"].CL["+parttr+"].clName
	//TJ["+partli+"].CL["+parttr+"].clRqst
	//TJ["+partli+"].CL["+parttr+"].clNum
	