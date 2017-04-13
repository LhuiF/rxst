$(function(){
	initDatagrid();
	initqueryAngency('#queryAngency');
	initarea(quxian,'#accumulationArea');
	initarea(quxian,'#insureanceArea');
	initqueryAngency('#angencyId');
});
function getFormInfo(form,datagrid){
	var proxyInfodata=formToJson(form);
	var peopledatas = [];
	$(datagrid).find('tr').each(function (i,val) {  
		if(i != 0){
		var peopledata={};
			$(this).find('td').each(function (i,val) {
				switch (i) {
				case 0:
					peopledata.peoName=$(val).text();
					break;
				case 1:
					if($(val).text()=='男'){
						peopledata.sex=0;
					}else{
						peopledata.sex=1;
					}
					break;
				case 2:
					peopledata.duty=$(val).text();
					break;
				case 3:
					peopledata.phone=$(val).text();
					break;
				case 4:
					peopledata.eamil=$(val).text();
					break;
				case 5:
					peopledata.qq=$(val).text();
					break;
				}
			})
			peopledatas.push(peopledata);
		}
    });
	proxyInfodata.list=peopledatas;
	return  proxyInfodata;
}
/**
 * 初始化 企业信息列表
 */
function initDatagrid(){
	$("#datagrid").datagrid({
        url : basePath+'/enterpriseController/getEnterpriseList',
        method : 'post',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
        singleSelect:true,//是否单选true是、false否
        fit : true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
			{
				field: 'ck',
				checkbox:true
			},
            {
                title : '代理机构名称',
                field : 'id',
                width : '12%',
                formatter: function(value,row,index){
                	return "<a onclick='message("+row.id+") href='javascript:void(0)'>"+row.angency+"</a>";
    			}
            },
            {
                title : '企业名称',
                field : 'name',
                width : '10%'
            }, {
                title : '社保所在区县',
                field : 'insureanceArea',
                width : '11%', 
                formatter: function(value,row,index){
                	for(var i=0; i<quxian.length;i++){
                		if(quxian[i].code == row.insureanceArea){
                			return quxian[i].name;
                		}
                	}
    			}
            },{
            	title : '公积金所在区县',
                field : 'accumulationArea',
                width : '11%',
                formatter: function(value,row,index){
                	for(var i=0; i<quxian.length;i++){
                		if(quxian[i].code == row.insureanceArea){
                			return quxian[i].name;
                		}
                	}
    			}
            },{
            	title : '社保登记正号',
                field : 'insuranceAccount',
                width : '10%'
            },{
            	title : '组织机构代码证号',
                field : 'orgCode',
                width : '13%'
            },{
            	title : '数字证书办理日期',
                field : 'DCDate',
                width : '12%'
            },{
            	title : '单位注册地',
                field : 'regAddr',
                width : '10%'
            },{
            	title : '单位办公地',
                field : 'workAddr',
                width : '10%'
            }
          ] ],
        toolbar : "#tb",
        onLoadSuccess:function(data){  //为格式化列添加样式，变成有图标的按钮
           $(".tp_source").parents("td").tooltip({
                content:function() {
                    return $(this).find(".tp_source").html();
                },
                onShow: function(){
                    $(this).tooltip('tip').css({});
                }
            });
        },
        onDblClickRow: function (index, row){
        	var Data;
        	$.ajax({
         		  type: "get",
         		  url: basePath+'/enterpriseController/showEnterprise/'+row.id,
         		  dataType: "json",
         		  async: false,
         		  success: function(data){
         			 Data=data;
         			  returndata(data,true);
         			 $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th></tr>");
         			 for(var i=0;i< data.list.length;i++){
         				 if(data.list[i].sex==0){
         					 data.list[i].sex='男';
         				 }else{
         					 data.list[i].sex='女';
         				 }
         				 $('#proxyUserdatagrid').append(
 						 "<tr><td>"+data.list[i].peoName+
 						 "</td><td>"+data.list[i].sex+
 						 "</td><td>"+data.list[i].duty+
 						 "</td><td>"+data.list[i].phone+
 						 "</td><td>"+data.list[i].eamil+
 						 "</td><td>"+data.list[i].qq+
 						 "</td></tr>"
         				 );
         			 }
         		  }
         		}); 
        	$('#btn_add_people').hide();
        	$('#dlg').dialog({
       	        title:"代理信息详情",
       	        closed:false,
       	        modal: true,
	       	    width: 850,    
	            height: 650,
       	        buttons:[{
       				text:'取消',
       				handler:function(){
       				returndata(Data,false);
         			$('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th></tr>");
       				$('#dlg').dialog('close');
       				$('#btn_add_people').show();
       				}
       			}]
       	    });
        }
    });
}
//初始化  下拉
function initSelect(combobox,name,id){
	$(combobox).combobox({    
	    url:basePath+'/enterpriseController/getEnterpriseList',  
	    queryParams: {
	    	id:id
		},
	    valueField:'id',    
	    textField:name,
	    loadFilter: function(data){
			return data.rows;
		},
		onChange:function(newValue,oldValue){
			
		},
		filter: function(q, row){
			   var opts = $(this).combobox('options');  
			    return row[opts.textField].indexOf(q) >-1; 
			} 
	}); 
}
function initarea(data,id){
	$(id).combobox({    
	    valueField:'code',    
	    textField:'name',
	    data:data,
		filter: function(q, row){
			   var opts = $(this).combobox('options');  
			    return row[opts.textField].indexOf(q) >-1; 
			} 
	}); 
}
function initqueryAngency(inputId){
	$(inputId).combobox({    
	    url:basePath+'/proxyInfoController/getProxyInfo',  
	    queryParams: {
	    	
		},
	    valueField:'id',    
	    textField:'proxyName',
	    loadFilter: function(data){
			return data.rows;
		},
		onChange:function(newValue,oldValue){
			if(inputId == '#angencyId'){
				var text = $("#angencyId").numberbox("getText");
				$('#angency').val(text);
			}else{
				initname(newValue);	
			}
		},
		filter: function(q, row){
			   var opts = $(this).combobox('options');  
			    return row[opts.textField].indexOf(q)>-1; 
			} 
	}); 
}
function initname(angencyId){
	$('#queryName').combobox({    
	    url:basePath+'/enterpriseController/getEnterpriseListByOne',  
	    queryParams: {
	    	angencyId:angencyId
		},
	    valueField:'id',    
	    textField:'name',
		onChange:function(newValue,oldValue){
			initSelect('#queryInsuranceAccount','insuranceAccount',newValue);
			initSelect('#queryorgCode','orgCode',newValue);
			initSelect('#queryinsureanceArea','insureanceArea',newValue);
			initSelect('#queryaccumulationArea','cumulationArea',newValue);
			var queryParams=$("#datagrid").datagrid("options").queryParams;
			queryParams.id=newValue;
			$("#datagrid").datagrid("options").queryParams=queryParams;
			$("#datagrid").datagrid("reload");
		},
		filter: function(q, row){
			   var opts = $(this).combobox('options');  
			    return row[opts.textField].indexOf(q) >-1; 
			} 
	}); 
}
/**
 *  打开新增对话框
 */
function openAdd() {
	$('#addEnterprise').form('clear');
	$('#btn_add_people').show();
	 $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th><th>操作</th></tr>");
	$('#dlg').dialog({
        title:"新增企业信息",
        closed:false,
        modal: true,
        width: 800,    
        height: 500,
        buttons:[{
			text:'确定',
			handler:function(){
				$.messager.progress({
	                    title: "处理中,请稍候...."
	                });
				var isValid = $('#addEnterprise').form("validate");
	            if (isValid) {//校验不通过关提示信息
	            	saveEnterprise();
					$("#addEnterprise").form('clear');
	            }else{
	            	 $.messager.progress("close");
	            	 $.messager.alert('警告','请完善信息');  
	            }
			}
		},{
			text:'取消',
			handler:function(){
				$("#addEnterprise").form('clear');
				$('#datagrid').datagrid("reload");
				$('#dlg').dialog('close');
			}
		}] 
    });
}
/**
 *  打开新增联系人
 */
function addPeo(table){
    $('#addPeoDlg').dialog({
        title:"新增联系人信息",
        closed:false,
        buttons:[{
			text:'确定',
			handler:function(){
				var data={};
				$("#newpeople").serializeArray().map(function(x){data[x.name]=x.value;});
				table.append("<tr><td>"+data.peoName+
				"</td><td>"+data.sex+
				"</td><td>"+data.duty+
				"</td><td>"+data.phone+
				"</td><td>"+data.eamil+
				"</td><td>"+data.qq+
				'</td><td><a href="#" id="updataproxy" onclick="del(this);">删除</a></td></tr>'
				);
				$('#newpeople').form('clear');
				$('#addPeoDlg').dialog('close');
			}
		},{
			text:'取消',
			handler:function(){
				$('#addPeoDlg').dialog('close');
			}
		}]
    });
}

//删除联系人
function deleteRow(){
	   var rowIndex = event.srcElement.parentElement.parentElement.rowIndex;
	   var styles = document.getElementById("proxyUserdatagrid");
	   styles.deleteRow(rowIndex);
}

function del(o){
	  var   t=document.getElementById('proxyUserdatagrid');
	  t.deleteRow(o.parentNode.parentNode.rowIndex)
}

function saveEnterprise(){
	var enterpriseInfodata=getFormInfo($("#addEnterprise"),$('#proxyUserdatagrid'));
	$.ajax({
		  type: "POST",
		  url: basePath+'/enterpriseController/saveEnterprise',
		  dataType: "json",
		  data:  JSON.stringify(enterpriseInfodata),
		  contentType:"application/json",
		  success: function(data){
			  if(data.success){
				  $('#addEnterprise').form('clear');
				  $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th><th>操作</th></tr>");
				  $('#datagrid').datagrid("reload");
				  $('#dlg').dialog('close');
			  }else{
				  $.messager.alert('警告','保存失败');   
			  }
			}
		});
}
function openEditor(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要修改的行');
    }else{
    	$('#btn_add_people').show();
    	$.ajax({
   		  type: "get",
   		  url: basePath+'/enterpriseController/showEnterprise/'+row.id,
   		  dataType: "json",
   		  async: false,
   		  success: function(data){
   			 returndata(data,false);
   			 $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th><th>操作</th></tr>");
   			 for(var i=0;i< data.list.length;i++){
   				 if(data.list[i].sex==0){
   					 data.list[i].sex='男';
   				 }else{
   					 data.list[i].sex='女';
   				 }
   				 $('#proxyUserdatagrid').append(
				 "<tr><td>"+data.list[i].peoName+
				 "</td><td>"+data.list[i].sex+
				 "</td><td>"+data.list[i].duty+
				 "</td><td>"+data.list[i].phone+
				 "</td><td>"+data.list[i].eamil+
				 "</td><td>"+data.list[i].qq+
				 "</td><td><td> <a href='#'  onclick='del(this);'>删除</a></td></td></tr>"
   				 );
   			 }
   		  }
   		}); 
	  	$('#dlg').dialog({
	 	        title:"代理信息详情",
	 	        closed:false,
	 	        modal: true,
	     	    width: 850,    
	            height: 650,
	 	        buttons:[{
	 				text:'确定',
	 				handler:function(){
	 					var enterpriseInfodata=getFormInfo($("#addEnterprise"),$('#proxyUserdatagrid'));
	 					$.ajax({
	 						  type: "POST",
	 						  url: basePath+'/enterpriseController/updateEnterprise',
	 						  dataType: "json",
	 						  data:  JSON.stringify(enterpriseInfodata),
	 						  contentType:"application/json",
	 						  success: function(data){
	 							  if(data.success){
	 								  $('#addEnterprise').form('clear');
	 								  $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th><th>操作</th></tr>");
	 								  $('#datagrid').datagrid("reload");
	 								  $('#dlg').dialog('close');
	 							  }else{
	 								  $.messager.alert('警告','修改失败');   
	 							  }
	 							}
	 						});
	 				}
	 			},{
	 				text:'取消',
	 				handler:function(){
	 					$('#dlg').dialog('close');
	 				}
	 			}]
	 	    });
    }
}

function deleteData(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要删除的行');
    }else{
    	$.ajax({
     		  type: "get",
     		  url: basePath+'/enterpriseController/deleteEnterprise/'+row.id,
     		  dataType: "json",
     		  async: false,
     		  success: function(data){
     			 if(data.success){
   				  $('#datagrid').datagrid("reload");
   			  }else{
   				  $.messager.alert('警告','删除失败');   
   			  }
     		  }
     		}); 
    }
}

//设置文本框
function setElement(id,data,is_no){
	$(id).textbox('setValue', data);	
	var  options=$(id).textbox("options");
	options.disabled=is_no;
	$(id).textbox(options);
}
//设置下拉框
function setselect(id,data,is_no){
	$(id).combobox('select', data);	
	var  options=$(id).textbox("options");
	options.disabled=is_no;
	$(id).textbox(options);
}
function returndata(data,is_no){
	setElement('#id',data.id,is_no);
	setElement('#name',data.name,is_no);
	setElement('#insuranceAccount',data.insuranceAccount,is_no);
	setElement('#orgCode',data.orgCode,is_no);
	setElement('#workAddr',data.workAddr,is_no);
	setElement('#regAddr',data.regAddr,is_no);
	setElement('#legalName',data.legalName,is_no);
	setElement('#legalPhone',data.legalPhone,is_no);
	setElement('#agentName',data.agentName,is_no);
	setElement('#agentPhone',data.agentPhone,is_no);
	setselect('#insureanceArea',data.insureanceArea,is_no);
	setselect('#accumulationArea',data.accumulationArea,is_no);
	setElement('#angencyId',data.angency,is_no);
	setselect('#isinsurance',data.isinsurance,is_no);
	setselect('#ishealthinsurance',data.ishealthinsurance,is_no);
	setselect('#isbankfees',data.isbankfees,is_no);
	setElement('#openBank',data.openBank,is_no);
	setElement('#openCode',data.openCode,is_no);
	setElement('#openAccount',data.openAccount,is_no);
}
