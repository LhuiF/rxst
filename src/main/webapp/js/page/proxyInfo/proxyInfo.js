$(function(){
    /**
     * 初始化加载数据
     */
	initcombogrid();
    initDatagrid();
});
/**
 * 初始化代理信息列表
 */
function initDatagrid() {
    $('#datagrid').datagrid({
        url : basePath+'/proxyInfoController/getProxyInfo',
        method : 'post',
        pagination : true,
        queryParams :{},
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        columns : [ [
			{
				field: 'id',
				checkbox:true
			},
            {
                title : '代理名称',
                field : 'proxyName',
                width : '15%'
            }, 
            {
                title : '与特殊企业约定是否可改费用',
                field : 'changeTheCost',
                width : '10%',
                formatter: function(value,row,index){
    				if (row.changeTheCost==0){
    					return '否';
    				} else {
    					return '是';
    				}
    			}
            },
            {
                title : '约定付款日期',
                field : 'appointmentPaymentDate',
                width : '10%'
            },
            {
                title : '创建人',
                field : 'createName',
                width : '10%'
            },
            {
                title : '创建日期',
                field : 'createDate',
                width : '25%'
            },
            {
                title : '备注',
                field : 'remarks',
                width : '20%'
            }
        ] ],
        toolbar : "#tb",
        onClickRow: function (index, row){
        	$.ajax({
         		  type: "get",
         		  url: basePath+'/proxyInfoController/getProxyInfoById/'+row.id,
         		  dataType: "json",
         		  async: false,
         		  success: function(data){
        			 formdisabled(true);
        			 returndata(data)      			 
         		  }
         		}); 
        	$('#ProxyinfoLayout').dialog({
       	        title:"代理信息详情",
       	        closed:false,
       	        modal: true,
       	        buttons:[{
       				text:'取消',
       				handler:function(){
       					 $('#ProxyinfoLayout').dialog('close');
       				}
       			}]
       	    });
			 $('#btn_add_people').hide();
        }
    });
}
/**
 * 初始化查询代理信息下拉框下拉框列表
 */
function initcombogrid(){
	$('#qproxyName').combogrid({    
	    panelWidth:100,    
	    url: basePath+'/proxyInfoController/getProxyInfo', 
	    textField:'proxyName',
        idField:'id',
        value:'',
	    columns:[[    
	        {field:'proxyName',title:'代理名称',width : '100%'}   
	    ]]    
	}); 
}
//新增代理信息
function openAddProxy() {
	    $('#addProxyLayout').dialog({
	        title:"新增代理信息",
	        closed:false,
	        modal: true,
	        buttons:[{
				text:'保存',
				handler:function(){
					 saveProxyInfo();
				}
			},{
				text:'取消',
				handler:function(){
					  $('#datagrid').datagrid("reload");
					 $('#addProxyLayout').dialog('close');
				}
			}]
	    });
	    
	}
//新增代理信息联系人
function openAddProxyUser(table){
	 $('#addProxyUserLayout').dialog({
	        title:"新增联系人信息",
	        width:450,    
	        height:300,
	        closed:false,
	        modal: true,
	        buttons:[{
				text:'保存',
				handler:function(){
					var data={};
					$("#newpeople").serializeArray().map(function(x){data[x.name]=x.value;});
					table.append(
					"<tr><td>"+data.peoName+
					"</td><td>"+data.sex+
					"</td><td>"+data.duty+
					"</td><td>"+data.phone+
					"</td><td>"+data.eamil+
					"</td><td>"+data.qq+
					'</td><td><a href="#" id="updataproxy" onclick="del(this);">删除</a></td></tr>'
					);
					$('#newpeople').form('clear');
					$('#addProxyUserLayout').dialog('close');
				}
			  },{
				text:'取消',
				handler:function(){
					$('#newpeople').form('clear');
					 $('#addProxyUserLayout').dialog('close');
				}
			}]
	});
}

function openAddProxyUser1(table){
	 $('#addProxyUserLayout').dialog({
	        title:"新增联系人信息",
	        width:450,    
	        height:300,
	        closed:false,
	        modal: true,
	        buttons:[{
				text:'保存',
				handler:function(){
					var data={};
					$("#newpeople").serializeArray().map(function(x){data[x.name]=x.value;});
					table.append(
					"<tr><td>"+data.peoName+
					"</td><td>"+data.sex+
					"</td><td>"+data.duty+
					"</td><td>"+data.phone+
					"</td><td>"+data.eamil+
					"</td><td>"+data.qq+
					'</td><td><a href="#" id="updataproxy" onclick="del1(this);">删除</a></td></tr>'
					);
					$('#newpeople').form('clear');
					$('#addProxyUserLayout').dialog('close');
				}
			  },{
				text:'取消',
				handler:function(){
					$('#newpeople').form('clear');
					 $('#addProxyUserLayout').dialog('close');
				}
			}]
	});
}
//保存代理信息及 联系人
function saveProxyInfo(){
	//获取表单数据
	var proxyInfodata=getFormInfo($("#proxyForm"),$('#proxyUserdatagrid'));
	$.ajax({
		  type: "POST",
		  url: basePath+'/proxyInfoController/saveProxyInfo',
		  dataType: "json",
		  data:  JSON.stringify(proxyInfodata),
		  contentType:"application/json",
		  success: function(data){
			  if(data.success){
				  $('#proxyForm').form('clear');
				  $('#proxyUserdatagrid').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th><th>操作</th></tr>");
				  $('#datagrid').datagrid("reload");
				  $('#addProxyLayout').dialog('close');
			  }else{
				  $.messager.alert('警告','保存失败');   
			  }
			}
		});
}
//查询按钮
function queryProxyinfo(){
	var selected=$('#qproxyName').combogrid('grid').datagrid('getSelected');
	var initproxyName='';
	if(selected != null){
		initproxyName=$('#qproxyName').combogrid('grid').datagrid('getSelected').proxyName;
	}
	var queryParams = $('#datagrid').datagrid('options').queryParams;  
	queryParams.proxyName = initproxyName;  
	$('#datagrid').datagrid('options').queryParams=queryParams;        
	$('#datagrid').datagrid("reload");
}

//编辑按钮
function editorProxy(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要修改的行');
    }else{
    	 formdisabled(false);
    	$.ajax({
  		  type: "get",
  		  url: basePath+'/proxyInfoController/getProxyInfoById/'+row.id,
  		  dataType: "json",
  		  async: false,
  		  success: function(data){
 			   returndata(data,"<td> <a href='#'  onclick='del(o);'>删除</a></td>","<th>操作</th>")      			 
  		  }
  		});
    	 $('#btn_add_people').show();
    	 $('#ProxyinfoLayout').dialog({
    	        title:"代理信息详情",
    	        closed:false,
    	        modal: true,
    	        buttons:[{
    				text:'保存',
    				handler:function(){
    					var proxyInfodata=getFormInfo($("#proxyInfoForm"),$('#peopleInfo'));
    					$.ajax({
    						  type: "POST",
    						  url: basePath+'/proxyInfoController/updateProxyInfo',
    						  dataType: "json",
    						  data:  JSON.stringify(proxyInfodata),
    						  contentType:"application/json",
    						  success: function(data){
    							  if(data.success){
    								  $('#proxyInfoForm').form('clear');
    								  $('#datagrid').datagrid("reload");
    								  $('#ProxyinfoLayout').dialog('close');
    							  }else{
    								  $.messager.alert('警告','保存失败');   
    							  }
    							}
    						});
    				}
    			},{
    				text:'取消',
    				handler:function(){
    					 $('#ProxyinfoLayout').dialog('close');
    				}
    			}]
    	    });
    }
}

//表单置灰
function formdisabled(is_no){
	    $('#proxyName').attr("disabled",is_no);
		$('#openBank').attr("disabled",is_no);
		$('#openBankAccount').attr("disabled",is_no);
		$('#openBankUsername').attr("disabled",is_no);
		var  PaymentDateoptions=$('#appointmentPaymentDate').datebox("options");
		PaymentDateoptions.disabled=is_no;
		$('#appointmentPaymentDate').datebox(PaymentDateoptions);
		$('#clientName').attr("disabled",is_no);
		$('#registeredAddress').attr("disabled",is_no);
		$('#officeAddress').attr("disabled",is_no);
		var changeTheCostoptions= $('#changeTheCost').combobox("options");
		changeTheCostoptions.disabled=is_no;
		$('#changeTheCost').combobox(changeTheCostoptions);
		$('#createName').attr("disabled",is_no);
		var createDateoptions=$('#createDate').datebox("options");
		createDateoptions.disabled=is_no;
		$('#createDate').datebox(createDateoptions);
		$('#remarks').attr("disabled",is_no);
}

//数据回显
function returndata(data,edit,editTool){
	     $('#id').val(data.id);
	     $('#proxyName').val(data.proxyName);
		 $('#openBank').val(data.openBank);
		 $('#openBankAccount').val(data.openBankAccount);
		 $('#openBankUsername').val(data.openBankUsername);
		 $('#appointmentPaymentDate').datebox('setValue', data.appointmentPaymentDate);	
		 $('#clientName').val(data.clientName);
		 $('#registeredAddress').val(data.registeredAddress);
		 $('#officeAddress').val(data.officeAddress);
		 $('#changeTheCost').combobox('select',data.changeTheCost);  
		 $('#createName').val(data.createName);
		 $('#createDate').datebox('setValue', data.createDate);
		 $('#remarks').val(data.remarks);
		 $('#peopleInfo').html("<tr><th>联系人姓名 </th><th>性别</th><th>职务</th><th>电话</th><th>邮箱</th><th>QQ</th>"+editTool+"</tr>");
		 for(var i=0;i< data.list.length;i++){
			 if(data.list[i].sex==0){
				 data.list[i].sex='男';
			 }else{
				 data.list[i].sex='女';
			 }
			 $('#peopleInfo').append(
					 "<tr><td>"+data.list[i].peoName+
					 "</td><td>"+data.list[i].sex+
					 "</td><td>"+data.list[i].duty+
					 "</td><td>"+data.list[i].phone+
					 "</td><td>"+data.list[i].eamil+
					 "</td><td>"+data.list[i].qq+
					 "</td>"+edit+" </tr>"
			 );
		 }
}
//获取表单信息
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

function deleteProxy(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要删除的行');
    }else{
    	$.ajax({
  		  type: "get",
  		  url: basePath+'/proxyInfoController/deleteProxyInfoById/'+row.id,
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
function deleteRow1(){
	   var rowIndex = event.srcElement.parentElement.parentElement.rowIndex;
	   var styles = document.getElementById("proxyUserdatagrid");
	   styles.deleteRow(rowIndex);
	}

function del1(o){
	 var   t=document.getElementById("proxyUserdatagrid");
	  t.deleteRow(o.parentNode.parentNode.rowIndex)
}

//删除联系人
function deleteRow(){
	   var rowIndex = event.srcElement.parentElement.parentElement.rowIndex;
	   var styles = document.getElementById("peopleInfo");
	   styles.deleteRow(rowIndex);
	}

function del(o){
	 var   t=document.getElementById("peopleInfo");
	  t.deleteRow(o.parentNode.parentNode.rowIndex)
}
