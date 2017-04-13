$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
   // upload('#fileupload');
});
/**
 * 初始化员工信息列表
 */
function initDatagrid() {
    $('#datagrid').datagrid({
        url : basePath+'/employeeController/getEmployee',
        method : 'post',
        pagination : true,
        queryParams :{},
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        striped: true,
        columns : [ [
			{
				field: 'id',
				checkbox:true
			},
            {
                title : '企业名称',
                field : 'enterpriseName',
                width : '8%'
            }, 
            {
                title : '雇员名称',
                field : 'employeeName',
                width : '5%'
            },
            {
                title : '证件号码',
                field : 'paperWorkCode',
                width : '8%'
            },
            {
                title : '社保报增日期',
                field : 'ssDeclareDate',
                width : '8%'
            },
            {
                title : '社保入月报日期',
                field : 'ssStartDate',
                width : '8%'
            },
            {
                title : '社保缴费人员类别',
                field : 'ssPeopleType',
                width : '7%'
            },
            {
                title : '公积金报增日期',
                field : 'pfDeclareDate',
                width : '8%'
            },
            {
                title : '公积金入月报日期',
                field : 'pfStartDate',
                width : '8%'
            }/*,
            {
                title : '公积金缴费人员类别',
                field : 'mtPeopleType',
                width : '7%'
            }*/,
            {
                title : '申报工资',
                field : 'averageWage',
                width : '5%'
            },
            {
                title : '社保基数',
                field : 'ssWage',
                width : '5%'
            },
            {
                title : '公积金基数',
                field : 'pfWage',
                width : '5%'
            },
            {
                title : '养老是否在缴',
                field : 'pension',
                width : '5%',
                formatter: function(value,row,index){
                	if( row.pension !=null){
                	 return	eval('(' +  row.pension + ')').isPayment;
		            }
		            else{
		            	return '';
		            } 
    			}
            },
            {
                title : '生育是否在缴',
                field : 'fertility',
                width : '5%',
                formatter: function(value,row,index){
                	if( row.fertility !=null){
                	   return	eval('(' +  row.fertility + ')').isPayment;
		            }
		            else{
		            	return '';
		            } 
    			}
            },
            {
                title : '工伤是否在缴',
                field : 'workInjury',
                width : '5%',
                formatter: function(value,row,index){
                	if( row.workInjury !=null){
                    	return	eval('(' +  row.workInjury + ')').isPayment;
		            }
		            else{
		            	return '';
		            } 
    			}
            },
            {
                title : '失业是否在缴',
                field : 'unemployment',
                width : '5%',
                formatter: function(value,row,index){
                	if( row.unemployment !=null){
                		return	eval('(' +  row.unemployment + ')').isPayment;
                	}
                    else{
                    	return '';
                    } 
                    	
                }
            },
            {
                title : '医疗是否在缴',
                field : 'medicalTreatment',
                width : '5%',
                formatter: function(value,row,index){
                	if( row.medicalTreatment !=null){
                    	return	eval('(' +  row.medicalTreatment + ')').isPayment;
		            }
		            else{
		            	return '';
		            } 
    			}
            },
            {
                title : '公积金是否在缴',
                field : 'providentFund',
                width : '7%',
                formatter: function(value,row,index){
                	if( row.providentFund !=null){
                    	return	eval('(' +  row.providentFund + ')').isPayment;
		            }
		            else{
		            	return '';
		            } 
    			}
            }
        ] ],
        toolbar : "#tb",
        onDblClickRow: function (index, row){
        	removeData();
        	var data;
        	$('#addemployeeLayout').dialog({
     	        title:"员工信息详情",
     	        closed:false,
     	        modal: true,
     	        buttons:[{
     				text:'关闭',
     				handler:function(){
     					queryemployee(data,false);
     					 $('#addemployeeLayout').dialog('close');
     				}
     			}]
     	    });
        	$.ajax({
      		  type: "GET",
      		  url: basePath+'/employeeController/getEmployeeById/'+row.id,
      		  dataType: "json",
      		  async: false,
      		  contentType:"application/json",
      		  success: function(Data){
      			 data=Data;
      			queryemployee(data,true);
      			}
      		});
        }
    });
}
/**
 * 初始化查询代理信息下拉框下拉框列表
 */

//打开新增页面
function openAddemployee() {
		removeData();
	    $('#addemployeeLayout').dialog({
	        title:"新增员工信息",
	        closed:false,
	        modal: true,
	        buttons:[{
				text:'保存',
				handler:function(){
					 $.messager.progress({
	                        title: "处理中,请稍候...."
	                    });
					var isValid = $('#baseForm').form("validate");
					var isValid1 = $('#fiveForm').form("validate");
                    if (isValid && isValid1) {//校验不通过关提示信息
                        $.messager.progress("close");
                        saveEmployee();
                        $('#datagrid').datagrid("reload");
    					$('#addemployeeLayout').dialog('close');
                    }else{
                    	 $.messager.progress("close");
                    	 $.messager.alert('警告','请完善信息');  
                    }
				}
			},{
				text:'关闭',
				handler:function(){
					 $('#datagrid').datagrid("reload");
					 $('#addemployeeLayout').dialog('close');
				}
			}]
	    });
	}

function showpeople(){
	$('#people').show();
	$('#five').hide();
	$('#annex').hide();
}
function showfive(){
	$('#people').hide();
	$('#five').show();
	$('#annex').hide();
}
function showannex(){
	$('#people').hide();
	$('#five').hide();
	$('#annex').show();
}

function getAllForminfo(){
	var beasdata={};
	var ssFundinfo={};
	$("#baseForm").find('input').each(function (i,val) {  
		var inputclass=$(val).attr("class");
		var key=$(val).attr("textboxname");
		switch (inputclass) {
		case 'easyui-combobox combobox-f combo-f textbox-f':
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
			if(strs.length>1){
				ssFundinfo[strs[1]]=$(val).attr("value")
			}else{
				beasdata[strs[0]]=$(val).attr("value")
			}
			break;
		case 'easyui-datetimebox combo-f textbox-f datetimebox-f':
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
			if(strs.length>1){
				ssFundinfo[strs[1]]=$(val).datebox('getText');
			}else{
				beasdata[strs[0]]=$(val).datebox('getText');
			}
			break;
		case 'easyui-textbox textbox-f':
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
			if(strs.length>1){
				ssFundinfo[strs[1]]=$(val).val();
			}else{
				beasdata[strs[0]]=$(val).val();
			}
			break;
		}
    });
	beasdata.enterpriseName=$('#enterpriseId').combobox("getText");
	beasdata.logPhoto=$('#filebox_file_id_1').attr('value');
	beasdata.ssFundinfo=ssFundinfo;
	var fivedata={};
	var returndata={};
	var pension={};
	var unemployment={};
	var fertility={};
	var workInjury={};
	var medicalTreatment={};
	var providentFund={};
	$("#fiveForm").find('input').each(function (i,val) {  
		var inputclass=$(val).attr("class");
		var key=$(val).attr("textboxname");
		if(inputclass== 'easyui-textbox textbox-f'){
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
		    switch (strs[0]) {
			case 'pension':
				pension[strs[1]]=$(val).val();
				break;
			case 'unemployment':
				unemployment[strs[1]]=$(val).val();
				break;
			case 'fertility':
				fertility[strs[1]]=$(val).val();
				break;
			case 'workInjury':
				workInjury[strs[1]]=$(val).val();;
				break;
			case 'medicalTreatment':
				medicalTreatment[strs[1]]=$(val).val();
				break;
			case 'providentFund':
				providentFund[strs[1]]=$(val).val();
				break;
			}
		}
    });
	fivedata['pension']=JSON.stringify(pension);
	fivedata['unemployment']=JSON.stringify(unemployment);
	fivedata['fertility']=JSON.stringify(fertility);
	fivedata['workInjury']=JSON.stringify(workInjury);
	fivedata['medicalTreatment']=JSON.stringify(medicalTreatment);
	fivedata['providentFund']=JSON.stringify(providentFund);
	beasdata.fiveRisks=fivedata;
	var annexdata={};
	 $("#annexForm").serializeArray().map(function(x){annexdata[x.name]=x.value;});
	beasdata.annex=annexdata;
	return beasdata;
}
//保存员工信息
function saveEmployee(){
	//获取表单数据
	var beasdata=getAllForminfo();
	console.log(beasdata);
	$.ajax({
		  type: "POST",
		  url: basePath+'/employeeController/saveEmployee',
		  dataType: "json",
		  data:  JSON.stringify(beasdata),
		  contentType:"application/json",
		  async: false,
		  success: function(data){
			  if(data.success){
				  $.messager.alert('提示','保存成功');   
			  }else{
				  $.messager.alert('警告','保存失败');   
			  }
			}
		});
}
//查询按钮
function queryemployee(data,is_no){
	returndata(data,'#baseForm',is_no);
	returnfive(data,'#fiveForm',is_no);
	returnAnnex(data,'#annexForm',is_no)
}
//编辑按钮
function editorEmployee(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要修改的行');
    }else{
    	removeData();
    	$.ajax({
    		  type: "GET",
    		  url: basePath+'/employeeController/getEmployeeById/'+row.id,
    		  dataType: "json",
    		  async: false,
    		  contentType:"application/json",
    		  success: function(data){
    			queryemployee(data,false);
    			$('#annexid').val(data.annex.id);
    			$('#fiveRisksid').val(data.fiveRisks.id);
    			$('#id').val(data.id);
  			    $('#ssFundinfoid').val(data.ssFundinfo.id);
    			}
    		});
    	$('#addemployeeLayout').dialog({
 	        title:"员工信息详情",
 	        closed:false,
 	        modal: true,
 	        buttons:[{
 				text:'关闭',
 				handler:function(){
 					 $('#addemployeeLayout').dialog('close');
 				}
 			},{
 				text:'保存',
 				handler:function(){
 					 $.messager.progress({
	                        title: "处理中,请稍候...."
	                    });
					var isValid = $('#baseForm').form("validate");
					var isValid1 = $('#fiveForm').form("validate");
                 if (isValid && isValid1) {//校验不通过关提示信息
                     $.messager.progress("close");
                     var beasdata=getAllForminfo();
  					beasdata.id=$('#id').val();
  					beasdata.ssFundinfo.id=$('#ssFundinfoid').val();
  					beasdata.annex.id=$('#annexid').val();
  					beasdata.fiveRisks.id=$('#fiveRisksid').val();
  					console.log(beasdata);
  					$.ajax({
  						  type: "POST",
  						  url: basePath+'/employeeController/updateEmployee',
  						  dataType: "json",
  						 async: false,
  						  data:  JSON.stringify(beasdata),
  						  contentType:"application/json",
  						  success: function(data){
  							  if(data.success){
  								 $.messager.alert('提示','修改成功');
  								 removeData();
  								 $('#datagrid').datagrid("reload");
  								 $('#addemployeeLayout').dialog('close');
  							  }else{
  								  $.messager.alert('警告','修改失败');   
  							  }
  							}
  						});
                 }else{
                 	 $.messager.progress("close");
                 	 $.messager.alert('警告','请完善信息');  
                 }
 				}
 			}]
 	    });
    }
}
function deleteemployee(){
	var row=$('#datagrid').datagrid('getSelected');
    if(row == null){
    	 $.messager.alert('提示','请选择要修改的行');
    }else{
    	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
    	    if (r){    
    	    	$.ajax({
    				  type: "get",
    				  url: basePath+'/employeeController/deleteEmployeeById/'+row.id,
    				  dataType: "json",
    				  async: false,
    				  success: function(data){
    					  if(data.success){
    						 $.messager.alert('提示','删除成功');
    						 $('#datagrid').datagrid("reload");
    					  }else{
    						  $.messager.alert('警告','删除失败');   
    					  }
    					}
    			  }); 
    	      }    
    	});
    }
}
//数据回显
function returndata(data,formid,is_no){
	$(formid).find('input').each(function (i,val) {  
		var inputclass=$(val).attr("class");
		var key=$(val).attr("textboxname");
		switch (inputclass) {
		case 'easyui-combobox combobox-f combo-f textbox-f':
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
			if(strs.length>1){
				setselect(val,data[strs[0]][strs[1]],is_no);
				$('#'+key).attr('value',data[key]); 
			}else{
				setselect(val,data[key],is_no);
				$('#'+key).attr('value',data[key]); 
			}
			break;
		case 'easyui-textbox textbox-f':
		case 'easyui-datetimebox combo-f textbox-f datetimebox-f':
			var strs= new Array(); //定义一数组
			strs=key.split("."); //字符分割 
			if(strs.length>1){
				 setElement(val,data[strs[0]][strs[1]],is_no);
			}else{
				setElement(val,data[key],is_no);
			}
			break;
		}
    });
	$('#filebox_file_id_1').attr('value',data.logPhoto);
	$('#logPhoto').filebox('setText',data.logPhoto);
}
function returnfive(data,formid,is_no){
	$(formid).find('input').each(function (i,val) {
		var inputclass=$(val).attr("class");
		var key=$(val).attr("textboxname");
		if(inputclass == 'easyui-textbox textbox-f'){
			strs=key.split("."); //字符分割 
		    setElement(val,eval('(' +  data.fiveRisks[strs[0]] + ')')[strs[1]],is_no);
		}
   })
}
function returnAnnex(data,formid,is_no){
	$(formid).find('input').each(function (i,val) {  
		var key=$(val).attr("type");
		if(key =='hidden'){
			var name=$(val).attr("name");
			$(val).val(data.annex[name]);
			$('#'+name+'image').html("<img src='"+data.annex[name]+"' alt=''>");
		}
    });
}
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
function removeData(){
	$("#baseForm").form('clear');
    $("#fiveForm").form('clear');
	$("#annexForm").form('clear');
	$("#annexForm").find('input').each(function (i,val) {  
		var key=$(val).attr("type");
		if(key =='hidden'){
			var name=$(val).attr("name");
			$(val).val('');
			$('#'+name+'image').html('');
		}
    });
}
function queryemployeeinfo(){
	var data=formToJson($('#queryEmployee'))
	var queryParams = $('#datagrid').datagrid('options').queryParams;  
	queryParams= data;  
	$('#datagrid').datagrid('options').queryParams=queryParams;        
	$('#datagrid').datagrid("reload");
}
function picUpload(id){
	var enterpriseName=$('#enterpriseId').combobox("getText");
	alert(enterpriseName);
	if(enterpriseName == ''){
		 $.messager.alert('警告','请先选择企业所在企业'); 
		 showpeople();
		return false;
	}else{
		$(id+"Upload").fileupload({
	        url: basePath+'/fileController/pictureUploadBydb',
	        dataType: 'json',
	    	formData:{'topDirectory':enterpriseName,'twoDirectory':'info'},
	    	acceptFileTypes: '/(\.|\/)(gif|jpe?g|png)$/i',
	        maxFileSize: 999000,
	        done: function (e, result) {
		        if(result.result.success){
		        	$(id).val(basePath+"/fileController/returnFile/"+result.result.data);
		        	$(id+'image').html("<img src="+basePath+"'/fileController/returnFile/"+result.result.data+"' alt=''>");
		        }else{
		        	 $.messager.alert('警告',result.result.message); 
		        }	
	        }
	    });
	}
}
function logoUpload(id){
	var enterpriseName=$('#enterpriseId').combobox("getText");
	if(enterpriseName == ''){
		 $.messager.alert('警告','请先选择企业所在企业'); 
		 showpeople();
		return false;
	}else{
		$(id).fileupload({
	        url: basePath+'/fileController/pictureUploadBydb',
	        dataType: 'json',
	    	formData:{'topDirectory':enterpriseName,'twoDirectory':'info'},
	    	acceptFileTypes: '/(\.|\/)(gif|jpe?g|png)$/i',
	        maxFileSize: 999000,
	        done: function (e, result) {
		        if(result.result.success){
		        	$(id).attr('value',result.result.data);
		        	$('#logPhoto').filebox('setText',result.result.data);
		        }else{
		        	 $.messager.alert('警告',result.result.message); 
		        }	
	        }
	    });
	}
}