$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    initDialog();
    clean_onclick();
    
   
    
   
    $('.fmtb1').delegate(".abew","click",function(){
    	
		 var liIdx = $(this).parents('li').index();
		 var trIdx = $(this).parents('li').find('.tjsj tr').length - 1;
		
		
		 openAddCaiLiao(liIdx,trIdx);
	});
    
    $('.fmtb1').delegate(".tjsedel","click",function(){
    	$(this).parents('.fnltr').remove();
    	
    });
    
    
});

function aagga(aaa){

	pathis.parents('tr').remove();
};


/**
 * 初始化 用户管理列表
 */
function initDatagrid() {
    $("#datagrid").datagrid({
    	url :basePath+'/materialController/getMaterialList',     
        method : 'post',
        pagination : true,        
        queryParams :{

        	isMaterial:$('#isMaterial').combobox('getValue'),
        	typeId:$('#typeId').combobox('getValue'),
        	isApply:$('#isApply').combobox('getValue'),
        	qu:$('#qu').combobox('getValue'),
  
        },
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        rownumbers:true,
        columns : [ [

            {
                title : '区县',
                field : 'qu',
                width : '5%',
                formatter:function(val,row,index){
                    return quCodeToName[val];
                }
                
          },{
                title : '业务类型',
                field : 'typeId',
                width : '5%',
                formatter:function(val,row,index){
                    return typeCodeToName[val];
                }
                
              },{
                title : '产品名称',
                field : 'productName',
                width : '15%',
                formatter:function(val,row,index){
                    return produceIdToName[val];
                }
                
            }, {
                title : '有无材料',
                field : 'isMaterial',
                width : '5%',
                formatter:function(val,row,index){
                    return toMaterial[val];
                }
            },{
                title : '是否网申',
                field : 'isApply',
                width : '5%',
                formatter:function(val,row,index){
                    return toApply[val];
                }
            },{
                title : '符合条件',
                field : 'condition01',
                width : '25%'
            },{
                title : '所需材料',
                field : 'conditon01',
                width : '15%'
               
                
            },{
                title : '创建人',
                field : 'createUserId',
                width : '5%'
            },{
                title : '创建时间',
                field : 'createTime',
                width : '11%'
                	
            },{
                title : '备注',
                field : 'remark',
                width : '15%'
            }
        ] ],
        toolbar : "#tb"
    });
}



function saveProduce(){
    $.messager.confirm('提醒', '是否确定保存!', function (r) {
        if (r) {
            $('#materialData').form('submit',{
                url: basePath + '/materialController/saveMaterialOrUpdate',
                method: "post",
                onSubmit: function() {
                    $.messager.progress({
                        title: "处理中,请稍候...."
                    });
                    //校验表单
                    var isValid = $(this).form("validate");
                    if (!isValid) {//校验不通过关提示信息
                        $.messager.progress("close");
                    }
                    return isValid;
                },
                success: function (result) {
                    $.messager.progress("close");
                     
                    var data = eval('(' + result + ')');
                    
                    if (data.success) {
                    	
                    
                        $('#dlg').dialog('close');

                        $("#datagrid").datagrid({
                            url: basePath + '/materialController/getMaterialList'
                        });
                        noty({text: data.message, timeout: 2000});
                        
                        
                        
                    } else {
                        $.messager.alert("错误", data.message, "error");
                    }
                }
            });
            $('.fmtb1 li').remove();
        }
        });

}

/**
 * 保存修改用户信息
 */

function updateProduce() {
	
	var ss= $(window.frames["iframeName"].document).find("#editorMaterialData");
	
	ss.form('submit',{

        url: basePath + "/materialController/saveMaterialOrUpdate",
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
            //校验表单
//            var isValid = $(this).form("validate");
//            if (!isValid) {//校验不通过关提示信息
//                $.messager.progress("close");
//            }
//            return isValid;
        },
        success: function (result) {
            $.messager.progress("close");
            var data = eval('(' + result + ')');         
            if (data.success) {
            	
                $('#editorDlg').dialog('close');
                $("#datagrid").datagrid({
                    url: basePath + "/materialController/getMaterialList"
                });
                noty({text: data.message, timeout: 2000});
            } else {
                $.messager.alert("错误", data.message, "error");
            }
        }
    
		
	});
	
}



/**
 * 取消
 */
function cancelUser(){
	$('.fmtb1 li').remove();
    $('#materialData').form('clear');
    $('#dlg').dialog('close');
    
}
/**
 * 取消
 */
function cancelEditorProduce() {
    $('#editorMaterialData').form('clear');
    $('#editorDlg').dialog('close');
}

/**
 * 取消
 */
function cancelCaiLiaoProduce() {
    $('#caiLiaolData').form('clear');
    $('#caiLiaoDlg').dialog('close');
}



/**
 *  打开新增对话框
 */
function openAddProduce() {
	
	
    $("#materialData").form("enableValidation");
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
	 $('#productId').combobox({
	    	onSelect:function(rec){
	    		$('#uuid').attr("value", rec.id);//给uuid赋值  		
	    		         $.ajax({
	    		            type: "POST",
	    		             url: basePath+'/materialController/getConditions',
	   		                 data: {productId:rec.id},
	   		                 dataType: "json",
		   		             success: function(datan){
		   		            	 
		   		            	
		   		            	var  htl = '';
		   		            	for(var i=0; i<datan.data.length; i++){
		   		            		htl+= 
		   		            			'<li >'
		   		            		+'<table class="fm_table" style="table-layout:fixed">'
		   		            			+'<tr>'
	   		            			+'<td>条件：</td>'
	   		            			+'<td colspan="2">'
	   		            			+'<input id="TJ['+i+'].condition01s" name="TJ['+i+'].condition01s" class="tjipt" style="width=100%;" value="'+datan.data[i]+'">'
	   		            			+'</td>'
	   		            			+'<td>'
	   		            			+'<a id="btn_add" class="abew easyui-linkbutton btn-add" >选择材料</a>'
	   		            			+'</td>'
	   		            			+'</tr>'
	   		            			+'</table>'
	   		            			+'<div id=""></div>'
	   		            			+'<table class="tjsj"  border="1" cellspacing="0" cellpadding="0"'
	   		            			+'style="width:100%;height: 100%; display:none; table-layout:fixed" id="caiLiaoTable01">'
	   		            			+'<tr>'
	   		            			+'<th width="100px">所需材料</th>'
	   		            			+'<th>材料要求</th>'
	   		            			+'<th width="100px">份数</th>'
	   		            			+'<th>删除</th>'
	   		            			+'</tr>'
	   		            			+'</table>'
	   		            			+'</li>';
	
		   		            	}
		   		            	$('.fmtb1').append(htl);
	 
		   		             }
	   	
	    		         });
	         }
	    });
}
/**
 * 初始化对话框
 */
function initDialog(){
    $('#dlg').dialog({
        title: '新增',
        width: 700,
        height: 400,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveProduce();
            	
            }
        },{
            text:'取消',
            handler:function(){
                cancelUser();
                $('.tjsj tr').eq(0).siblings().remove();
                $('.tjsj').hide();
                
            }
        }],
        onClose:function() {
            $("#materialData").form("clear");
        }
    });
}

/**
 * 初始化对话框
 */

function initEditorDialog() {
    $('#editorDlg').dialog({
        title: '编辑',
        width: 700,
        height: 400,
        closed: true,
        cache: false,
        resizable: true,
        modal: true,
        buttons: [{
            text: '确定',
            handler: function () {
                updateProduce();
            }
        }, {
            text: '取消',
            handler: function () {
                cancelEditorProduce();  
            }
        }],
        onClose: function () {
            $("#editorMaterialData").form("clear");
        }
    });
}

/**
 * 功能：编辑页面弹出对话框,并加载数据
 */


function editorProduce(){
	   var $form = $("#editorMaterialData");
	    
	    var id = 0;//选择记录的序号
		var rows = $('#datagrid').datagrid('getSelections');
		if(rows.length>1){
			alert_warn("请确认单选");
			return;
		}else if(rows.length==0){
			alert_warn("请选择一条记录在进行操作");
			return;
		}
		for(var i=0;i<rows.length;i++){
			id = rows[i].id;
			
		}
	  
	    var url = basePath+"/materialController/getMaterialById?id="+id;
	    $('#editorDlg').dialog({
	    	title: '编辑',
	        width: 1000,
	        height: 600,
			modal: true,
	        /*top:25, */ 
			shadow: false,
			minimizable:false,
			collapsible:false,
			closed: true,
			content: '<iframe id="editAccumula" name="iframeName" width="100%" height="100%" frameborder="0" style="width:100%;height:100%;"></iframe>',
	        buttons: [{
	            text: '确定',
	            handler: function () {
	            	updateProduce();
	            }
	        }, {
	            text: '取消',
	            handler: function () {
	            	$('#editorMaterialData').form('reset');
	                $('#editorDlg').dialog('close');
	                $('#datagrid').datagrid('unselectAll');
	            }
	        }],
	        onClose: function () {
	            $("#editorMaterialData").form("clear");
	        }
	    });
	    
	    
		//为了保障只发送一次请求，在窗口创建完之后再对iframe的src属性进行赋值
		$('#editAccumula').attr('src',url);
		$('#editorDlg').window('open'); 

	}


//	打开选择材料对话框
	function openAddCaiLiao(partli,parttr){
		$("#caiLiaolData").form("enableValidation");
	    $('#caiLiaoDlg').dialog({
	        title:"选择材料",
	        closed:false,
	        cache: false,
	        resizable: true,
	        modal: true,
	        width: 400,
	        height: 300,
	        buttons: [{
	            text: '确定',
	            handler: function () {
	            	$('.fmtb1 li').eq(partli).find('.tjsj').show();
	            	var data={};
					$("#caiLiaolData").serializeArray().map(function(x){data[x.name]=x.value;});
					var nhtml = "<tr class='fnltr'>" 
						+"<td >"  + "<input id='cailiao' name='TJ["+partli+"].CL["+parttr+"].clName' class='easyui-textbox' value='"+data.caiLiaoName+"'  style='width: 100%' data-options='required:true'>" +"</td>" +
					"<td >" + "<input id='marerialRequests' name='TJ["+partli+"].CL["+parttr+"].clRqst' class='easyui-textbox' value='"+data.yaoqiu+"' style='width: 100%' data-options='required:true'>"+"</td>" +
					"<td >" + "<input id='fenshus' name='TJ["+partli+"].CL["+parttr+"].clNum' class='easyui-textbox' value='"+data.fenshu +"' style='width: 100%' >"
					+"</td>"
					+"<td>"
					+"<div class='tjsedel'>删除</div>"
					+ "</td>"
					+"</tr>";
					$('.fmtb1 li').eq(partli).find('.tjsj').append(nhtml);
					$('#caiLiaoDlg').dialog('close');
	                
	            }
	        }, {
	            text: '取消',
	            handler: function () {
            	cancelCaiLiaoProduce();  
	            	 $('#caiLiaoDlg').dialog('close');
	            }
	        }]
	        
	    });
	
	}
	

/**
 * 删除用户信息
 * @param id
 */
function deleteProduce(id){
	var id = 0;//选择记录的序号
	var rows = $('#datagrid').datagrid('getSelections');
	if(rows.length>1){
		alert_warn("请确认单选");
		return;
	}else if(rows.length==0){
		alert_warn("请选择一条记录在进行操作");
		return;
	}
	for(var i=0;i<rows.length;i++){

		id = rows[i].id;
	}
    var url = basePath+"/materialController/deleteMaterial";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                    	url: basePath + "/materialController/getMaterialList"
                      
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

/**
 * 导出登录日志Excel表格
 * 带条件查询的导出
 */
function exportExcel() {
    var param = {
    		typeId:$("select[name=typeId]").find("option:selected").text(),
    		isMaterial:$("select[name=isMaterial]").find("option:selected").text(),
    		qu:$("select[name=qu]").find("option:selected").text(),
    		isApply:$("select[name=isApply]").find("option:selected").text()
   
    };
    
    var url = basePath + "/materialController/exportMaterialExcel";
    $('#exportForm').form("submit", {
        url: url,
        method: "post",
        queryParams: param
    });
    $("#datagrid").datagrid("clearSelections");
}
	function clean_onclick(){
//   		clearCond(["typeId","isMaterial","qu","isApply"]);
//   		initDatagrid();
		$("#typeId").combobox('select','');
		$("#qu").combobox('select','');
		$("#isMaterial").combobox('select','');
		$("#isApply").combobox('select','');

	}
	
	function clearCond(cond) {
		$.each(cond, function(key, val) {			
			$('#' + val).combobox('setValue', '');
		});
	}
	
	
	
	function alert_warn(mes){
		$.messager.alert('警告',mes); 
	}
	
	
	
	




