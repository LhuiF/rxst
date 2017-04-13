$(function(){
//	initDatagrid();
	initCmpSheBaoProptDialog();
	initEditorDialog();
});

/**
 * 初始化 社保参数比例列表
 */


/**
 *  打开新增对话框
 */
function openAddCompanyShebao() {
    $('#dlg').dialog({
        title:"新增",
        closed:false
    });
}
/**
 * 初始新增化对话框
 */
function initCmpSheBaoProptDialog(){
	
    $('#dlg').dialog({
        title: '新增',
        width:1000,
        height:600,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
            	saveCmpSheBaoProportion();
            }
        },{
            text:'取消',
            handler:function(){
            	cancelCmpShebaoPropt();
            }
        }],
        onClose:function() {
            $("#cmpShebaoProptData").form("clear");
        }
    });
}


/**
 * 保存
 */
function saveCmpSheBaoProportion(){
    $.messager.confirm('提醒', '请您确定保存该信息', function (r) {
        if (r) {
            $('#cmpShebaoProptData').form('submit', {
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
function openEditorCompanyShebao(){
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
        width: 1000,
        height: 600,
        closed: true,
        cache: false,
        resizable: true,
        modal: true,
        buttons: [{
            text: '确定',
            handler: function () {
            	updateCmpShebaoPropt();
            }
        }, {
            text: '取消',
            handler: function () {
            	cancelEditorCmpShebaoPropt();
            }
        }],
        onClose: function () {
            $("#editorCmpShebaoProportion").form("clear");
        }
    });
}

/**
 * 保存修改社保信息
 */
function updateCmpShebaoPropt() {
 $('#editorCmpShebaoProportion').form('submit', {
        url: basePath + '/shebaoController/saveShebaoProptOrUpdate',
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
                    url: basePath + '/shebaoController/XXXXList'
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
function cancelCmpShebaoPropt(){
    $('#cmpShebaoProptData').form('clear');
    $('#dlg').dialog('close');
}
function cancelEditorCmpShebaoPropt() {
    $('#editorCmpShebaoProportion').form('clear');
    $('#editorDlg').dialog('close');
}
