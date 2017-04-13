$(function(){
    initDatagrid();
});
/**
 * 初始化 跟踪客户列表
 */
function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/prompt/getAllPrompt',
        method : 'post',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
        singleSelect:true,//是否单选true是、false否
        fit : true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
            {
                title : '消息名称',
                field : 'name',
                width : '25%'
            },
            {
                title : '消息编码',
                field : 'code',
                width : '20%'
            }, {
                title : '消息描述',
                field : 'content',
                width : '25%'
            },
            {
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : 90,
                formatter:function(value,row,index){   //格式化函数添加一个操作列
                    var html = template('optBtns', {promptId:row.id});
                    return html;
                }
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
 * 新增
 */
function openAdd(){
    $("#fm_tb").form("clear");
    openAddDialog();
}
/**
 *  打开新增对话框
 */
function openAddDialog() {
    $("#promptId").html("");
    $("#flgValid").val("xz");
    $('#addDialog').dialog({
        title: '新增消息提醒',
        width: 600,
        height: 250,
        closed: false,
        cache: false,
        border:'thin',
        modal: true,
        buttons: [{
            text:'保存',
            handler:function(){
                savePrompt();

            }
        },{
            text:'取消',
            handler:function(){
                $('#addDialog').dialog('close');
            }
        }]
    });
}
/**
 * 打开编辑对话框
 */
function openEditDialog(){
    $("#flgValid").val("bj");
    var rows = $("#datagrid").datagrid("getSelections");
    $.post(basePath+"/prompt/getPromptById",{id:rows[0].id},function(data){
        $("#fm_etb").form("disableValidation");
        if(data.success){
            $("#fm_etb").form("clear");
            $("#fm_etb").form("load",data.data);

            $('#editDialog').dialog({
                title: '修改消息提醒',
                width: 600,
                height: 250,
                closed: false,
                cache: false,
                iconCls:"icon-edit",
                border:'thin',
                modal: true,
                buttons: [{
                    text:'修改',
                    handler:function(){
                        editPrompt();
                    }
                },{
                    text:'取消',
                    handler:function(){
                        $('#editDialog').dialog('close');
                    }
                }]
            });

        }else{
            $.messager.alert("错误","加载时出现系统错误!","error");
        }
        $("#fm_etb").form("enableValidation");
    },"json");
}

/**
 * 验证
 */
$.extend($.fn.validatebox.defaults.rules, {
    nameCheck:{
        validator: function (value, param) {
            var json = {"name":value,"id":$("#promptId").val(),"flg":$("#flgValid").val()};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/prompt/validate",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '【该消息名称已存在，请重新输入】'
    },
    codeCheck:{
        validator: function (value, param) {
            var json = {"code":value,"id":$("#promptId").val()};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/prompt/validate.do",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message:'【该消息编码已存在，请重新输入】'
    },
    maxLength: {
        validator: function (value, param) {
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 字符'
    }
});


/**
 * 保存
 */
function savePrompt() {
    $("#fm_tb").form("submit", {
        url:basePath+"/prompt/save",
        onSubmit: function () {
            $.messager.progress({
                title:"提示",
                text:"数据处理中，请稍后...."
            });
            var isValid = $(this).form("validate");
            if (!isValid) {
                $.messager.progress("close");
            }
            return isValid;
        },
        success: function (result) {
            result = $.parseJSON(result);
            $.messager.progress("close");
            if(result.success){//操作成功
                $('#addDialog').dialog('close');
                noty({text:result.message,timeout:3000});
                $("#datagrid").datagrid({
                    url : basePath+'/prompt/getAllPrompt.do'
                });
            }else{//保存失败
                noty({text:result.message,timeout:3000});
            }
        }
    });
}

/**
 * 编辑
 */
function editPrompt() {
    $("#fm_etb").form("submit", {
        url:basePath+"/prompt/update",
        onSubmit: function () {
            $.messager.progress({
                title:"提示",
                text:"数据处理中，请稍后...."
            });
            var isValid = $(this).form("validate");
            if (!isValid) {
                $.messager.progress("close");
            }
            return isValid;
        },
        success: function (result) {
            result = $.parseJSON(result);
            $.messager.progress("close");
            if(result.success){//操作成功
                $("#editDialog").dialog("close");
                $('#datagrid').datagrid('reload');
                noty({text:result.message,timeout:3000});
                $("#datagrid").datagrid({
                    url : basePath+'/prompt/getAllPrompt.do'
                });

            }else{//保存失败
                noty({text:result.message,timeout:3000});
            }
        }
    });
}


/**
 *查询
 */
function searchData(){
    var json = {"name":$("#searchName").val(),"code":$("#searchCode").val()};
    $("#datagrid").datagrid({
        url : basePath+'/prompt/getAllPrompt',
        queryParams:json,
        method : "post"
    });
}
