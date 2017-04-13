$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    initDialog();
    initEditorDialog();
   

});

/**
 * 初始化 用户管理列表
 */


  
function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/sysProductController/getProduceList',
        method : 'post',
        pagination : true,
        queryParams :{       	
        	cityId:$('#cityId').combobox('getValue'),
        	typeId:$('#typeId').combobox('getValue'),
           
        },
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        rownumbers:true,
        columns : [ [

            {
                title : '城市',
                field : 'cityId',
                width : '5%',
                formatter:function(val,row,index){
                    return cityCodeToName[val];
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
                field : 'name',
                width : '15%'
            }, {
                title : '申报截止时间',
                field : 'applyEndTime',
                width : '11%'
  
            },{
                title : '反馈截止时间',
                field : 'feedbackEndTime',
                width : '11%'
            },{
                title : '反馈周期',
                field : 'feedbackLoop',
                width : '5%'
            },{
                title : '标准报价',
                field : 'standPrice',
                width : '5%'
            },{
                title : '成本价格',
                field : 'costPrice',
                width : '5%'
            },
            {
                title : '是否包月服务',
                field : 'mouthService',
                width : '15%',
                formatter:function(val,row,index){
                    return toBaoYue[val];
                }
            },
            {
                title : '对任务单',
                field : 'taskList',
                width : '15%',
                formatter:function(val,row,index){
                    return toAssign[val];
                }
            },
            
            
           {
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
            },{
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : 80,
                formatter:function(val,row,index){
                    var html = "";
                    html = template('optBtns', {"id": row.id});
                    return html;
                }
            }
        ] ],
        toolbar : "#tb"
    });
}



function saveProduce(){
    $.messager.confirm('提醒', '是否确定保存该产品信息，确认无法修改城市和业务类型!', function (r) {
        if (r) {
            $('#produceData').form('submit',{
                url: basePath + '/sysProductController/saveProduceOrUpdate',
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
                    $('#feedbackEndTime').datetimebox('setValue', '6/1/2012');    
                    var data = eval('(' + result + ')');
                  
                    if (data.success) {
                        $('#dlg').dialog('close');

                        $("#datagrid").datagrid({
                            url: basePath + '/sysProductController/getProduceList'
                        });
                        noty({text: data.message, timeout: 2000});
                    } else {
                        $.messager.alert("错误", data.message, "error");
                    }
                }
            });
        }
        });

}

/**
 * 保存修改用户信息
 */
function updateProduce() {
 $('#editorProduceData').form('submit', {
        url: basePath + "/sysProductController/saveProduceOrUpdate",
        method: "post",
        onSubmit: function () {
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
            	
                $('#editorDlg').dialog('close');
                $("#datagrid").datagrid({
                    url: basePath + "/sysProductController/getProduceList"
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
    $('#produceData').form('clear');
    $('#dlg').dialog('close');
}
/**
 * 取消
 */
function cancelEditorProduce() {
    $('#editorProduceData').form('clear');
    $('#editorDlg').dialog('close');
}
/**
 *  打开新增对话框
 */
function openAddProduce() {
//    $('#name').textbox('enable');
//    $('#cityId').combobox('enable');
//    $('#typeId').combobox('enable');
//    $('#taskList').combobox('setValue', '0');
//    $('#mouthService').combobox('setValue', '0');
//	$('#setVlaue').combobox('setValue', '0');
  //  $("#produceData").form("enableValidation");
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
    
   
    /*$("input",$("#feedbackLoop").next("span")).blur(function(){
        alert("ok");  
    });*/
    $('#feedbackLoop').textbox('setValue',0);
    $("#feedbackLoop").textbox({
    	onChange: function(newValue, oldValue){
    		var jzdate = $('#applyEndTime').datebox('getValue');
        	var zqdays = $('#feedbackLoop').textbox('getValue');
        	zqdays = parseInt(zqdays);
        	var rstdate = fun_submit(jzdate,zqdays);
           $('#feedbackEndTime').textbox('setValue',rstdate);
    	}
    })
    
    $('#applyEndTime').datebox({
        onSelect: function(date){
        	var jzdate = $('#applyEndTime').datebox('getValue');
        	var zqdays = $('#feedbackLoop').textbox('getValue');
        	zqdays = parseInt(zqdays);
        	var rstdate = fun_submit(jzdate,zqdays);
           $('#feedbackEndTime').textbox('setValue',rstdate);
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
            }
        }],
        onClose:function() {
            $("#produceData").form("clear");
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
            $("#editorProduceData").form("clear");
        }
    });
}

/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function editorProduce(id){
    var $form = $("#editorProduceData");

    var url = basePath+"/sysProductController/getProduceById";
    $.post(url,{id:id},function(res){
        $form.form("disableValidation");
        if(res.success){
            $form.form("load",res.data);
            $("#log").val(res.data.loginName);
            $('#editorDlg').dialog({
                title:"编辑",
                closed:false
            });
        }else{
            $.messager.alert("错误",res.message,"error");
        }
        $form.form("enableValidation");
    },"json");

}

/**
 * 删除用户信息
 * @param id
 */
function deleteProduce(id){
    var url = basePath+"/sysProductController/deleteById";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/sysProductController/getProduceList'
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}

	


	function fun_submit(timer,days){
 		var atimer = timer.split("-");
	    var date1 = new Date();
	    date1.setFullYear(atimer[0]);
	    date1.setMonth(atimer[1]-1);
		date1.setDate(atimer[2]);
	    var date2 = new Date(date1);
	    date2.setDate(date1.getDate()+days);
	    var times = date2.getFullYear()+"-"+(date2.getMonth()+1)+"-"+date2.getDate();
	    return times;
	}
	
	
	

  

	
/**
 * 自定义验证
 */
$.extend($.fn.validatebox.defaults.rules, {
	nameCheck:{
        validator: function (value, param) {
            var json = {"name":value,"id":$("#produceId").val()};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/sysProductController/validName",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '此帐号已存在！'
    },
    
    
    dayCheck: {
        validator: function(value, param){
            return /(^\+\d+$)/g.test(value);
        },
        message: '只能输入数字'
    },
	
	maxLength: {
        validator: function(value, param){
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 字符'
    },
    
    numberCheck: {
        validator: function (value, param) {
            
            return /(^[0-9]+([.][0-9]{1}){0,1}$)/g.test(value);
        },
        message: '只能输入数字或者带小数的数字'
    }
   
  
    
});


