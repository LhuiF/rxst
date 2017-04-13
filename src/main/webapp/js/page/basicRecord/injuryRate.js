$(function(){
	initInjuryRateDatagrid();
	initInjuryDialog();
	//initEditorInjuryDialog();
});

//分页
function pagerFilter(data){
    if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
        data = {
            total: data.length,
            rows: data
        }
    }
    var datagrid = $(this);
    var opts = datagrid.datagrid('options');
    var pager = datagrid.datagrid('getPager');
    pager.pagination({
        onSelectPage:function(pageNum, pageSize){
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh',{
                pageNumber:pageNum,
                pageSize:pageSize
            });
            datagrid.datagrid('loadData',data);
        }
    });
    if (!data.originalRows){
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}



/**
 * 初始化 公积金缴费比例参数列表
 */
function initInjuryRateDatagrid(){
	$("#datagrid").datagrid({
        url : basePath+'/rsInjuryrateController/getInjuryList',
        method : 'post',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
       singleSelect:true,//是否单选true是、false否
        fit : true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
           {
                title : '企业名称',
                field : 'company',
                width : '25%'
            },
            {
                title : '年度',
                field : 'year',
                width : '20%'
            }, {
                title : '费率',
                field : 'rate',
                width : '20%'
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
        }
    });
}

function Listsearch(){
	var queryParams=$('#datagrid').datagrid('options').queryParams;
	$('#searchBox').find('*').each(function(){
		queryParams[$(this).attr('name')]=$(this).val();
	});
	$('#datagrid').datagrid({
		url:basePath+'/rsInjuryrateController/getInjuryList',
		pageNumber:1
		}
	);
	}

/**
 *  打开新增对话框
 */
function openAddInjuryRate() {
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
}
/**
 * 初始化对话框
 */
function initInjuryDialog(){
    $('#dlg').dialog({
        title: '新增',
        width:600,
        height:400,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveInjuryRate();
            }
        },{
            text:'取消',
            handler:function(){
            	 $('#addInjuryRate').form('clear');
            	 $('#dlg').dialog('close');
            }
        }],
        onClose:function() {
            $("#addInjuryRate").form("clear");
        }
    });
}


/**
 * 保存
 */
function saveInjuryRate(){
    $.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#addInjuryRate').form('submit', {
                url: basePath + '/rsInjuryrateController/saveInjuryrate',
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
                        $('#dlg').dialog('close');

                        $("#datagrid").datagrid({
                            url: basePath + '/rsInjuryrateController/getInjuryList'
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
 * 保存修改信息
 */
function openEditorInjuryRate(){
	
	  var rows = $("#datagrid").datagrid("getSelections");
	     if(rows.length>1 || rows.length==0){
	         $.messager.alert("提示框","请正确选择修改的内容",'info');
	         return ;
	     }
	     
         
 $("#editorInjuryRate").show();
	    
  $('#editorInjuryRate').form('load', basePath + '/rsInjuryrateController/showInjuryrate/?id='+rows[0].id); 
	
  $("#editorDlg").dialog({
      title:"修改",
      width:600,
      height:400,
      modal:true,
      buttons:[{
           text:"确定",
           iconCls:'icon-ok',
           plain:true,
           handler:function(){
        	  $("#editorInjuryRate").form("submit",{
                   url: basePath + '/rsInjuryrateController/update?id='+rows[0].id,
                   success:function(data){
                	 $("#editorDlg").dialog("close");
                	   $.messager.show({
                           title:"提示框",
                           msg:"修改成功",
                        });
                       $("#datagrid").datagrid("reload");
                   }
                });
           }  
         },{
           text:"取消",
           plain:true,
           iconCls:'icon-cancel',
           handler:function(){
             $("#editorInjuryRate").form("reset");
             $("#editorDlg").dialog("close");
           }  
        }] ,
 });

}

/*
 * 删除
 * */
function deleteInjuryrate(){
	  var rows = $("#datagrid").datagrid("getSelections");
    if(rows.length>1 || rows.length==0 ){
        $.messager.alert("提示框","请正确选择删除的内容",'info');
        return ;
    }
  //for(var i=0;i<rows.length;i++){
     $.ajax({
	           url:basePath + '/rsInjuryrateController/deleteInjuryRate?isdel=n',
	           type:"POST",
	           dataType:"text",
	           //data:"ids="+rows[i].id,
	          data:'id='+rows[0].id,
	           beforeSend:function(){
	              return true;
	           },
	           success:function(data){
	             $("#datagrid").datagrid("loaded");
	              $.messager.show({
	                title:"提示框",
	                msg:"删除成功",
	            });
	            $("#datagrid").datagrid("reload");
	         }
     	});
   //}
}
















