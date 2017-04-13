$(function(){
	initDatagrid();
	//初始化表格
	initDialog();
	initEditorDialog();

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
    //alert("start:"+start+"=="+end);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}

/**
 * 初始化 社保参数列表
 */
function initDatagrid(){
	$("#datagrid").datagrid({
        url : basePath+'/insuranceController/getList',
        method : 'get',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
       singleSelect:true,//是否单选true是、false否
        fit : true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
            {
                title : '城市',
                field : 'dict_name',
                width : '13%',
                formatter: function(value,row,index){
               	 return '<a class="city" onclick="message('+row.id+')" href="javascript:void(0)">'+row.dict_name+'</a>';
                }
            },{
                title : '社保年度',
                field : 'year',
                width : '11%'
            },{
            	title : '基数核定月份',
                field : 'month',
                width : '11%'
            },{
            	title : '备注',
                field : 'comment',
                width : '12%'
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

/**
 *  打开新增对话框
 */
function openAddParam() {
	
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
    
    
}
/**
 * 初始化对话框
 */
function initDialog(){
    $('#dlg').dialog({
        title: '新增',
        width:900,
        height:600,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveSheBao();
            }
        },{
            text:'取消',
            handler:function(){
                cancelParam();
            }
        }],
        onClose:function() {
            $("#paramData").form("clear");
        }
    });
}


/**
 * 保存
 */
function saveSheBao(){
	$.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#paramData').form('submit', {
                url: basePath + '/XXController/XX',
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
                            url: basePath + '/XXXController/getXXX'
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
 *  打开修改对话框
 */
function openEditorParam(){
    $('#editorDlg').dialog({
        title:"修改",
        closed:false
    });
}
/**
 * 初始化编辑对话框
 */
function initEditorDialog() {
    $('#editorDlg').dialog({
        title: '编辑',
        width: 900,
        height: 600,
        closed: true,
        cache: false,
        resizable: true,
        modal: true,
        buttons: [{
            text: '确定',
            handler: function () {
                updateParam();
            }
        }, {
            text: '取消',
            handler: function () {
                cancelEditorParam();
            }
        }],
        onClose: function () {
            $("#editorParam").form("clear");
        }
    });
}

/**
 * 保存修改社保信息
 */
function updateParam() {
 $('#editorParam').form('submit', {
        url: basePath + '/shebaoController/saveParamOrUpdate',
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
                    url: basePath + '/shebaoController/getShebaoList'
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
function cancelParam(){
    $('#paramData').form('clear');
    $('#dlg').dialog('close');
}
function cancelEditorParam() {
    $('#editorParam').form('clear');
    $('#editorDlg').dialog('close');
}
