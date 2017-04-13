$(function(){
    /**
     * 初始化加载数据
     */
    initDatagrid();
    $("#organId").combotree({"data":organCombotreeData});
    initDialog();
    initEditorDialog();

});

/**
 * 初始化 用户管理列表
 */

function initDatagrid() {
    $("#datagrid").datagrid({
        url : basePath+'/userController/getUserList',
        method : 'post',
        pagination : true,
        queryParams :{
            name:$("#name").val(),
            loginName:$("#loginName").val(),
            phone : $("#phone").val()
        },
        pageSize : 10,
        fit : true,
        fitColumns :true,
        idField : 'id',
        singleSelect:true,
        rownumbers:true,
        columns : [ [

            {
                title : '所属机构',
                field : 'organId',
                width : '15%',
                formatter:function(val,row,index){
                    return organIdToName[val];
                }
            }, {
                title : '姓名',
                field : 'name',
                width : '15%'
            }, {
                title : '帐号',
                field : 'loginName',
                width : '15%'
            },
            {
                title : '联系方式',
                field : 'phone',
                width : '15%'
            },
            {
                title : '岗位',
                field : 'post',
                width : '10%',
                formatter:function(val,row,index){
                    return postCodeToName[val];
                }
            },
            {
                title : '注册时间',
                field : 'updateDatatime',
                width : '15%'
            },
            {
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : 80,
                formatter:function(val,row,index){
                    var html = "";
                    if(row.name =="admin"){
                        html = template('supOptBtns', {"id": row.id});
                    }else if(userId == row.id){
                        html = template('supOptBtns', {"id": row.id});
                    } else{
                        html = template('optBtns', {"id": row.id});
                    }
                    return html;
                }
            }
        ] ],
        toolbar : "#tb"
    });
}

/**
 * 保存用户管理
 */
function saveUser(){
    $.messager.confirm('提醒', '是否确定保存该用户，确认后所属机构、用户岗位及角色无法修改!', function (r) {
        if (r) {
            $('#userData').form('submit', {
                url: basePath + '/userController/saveUserOrUpdate',
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
                        var aa = $("input[name='name']").val();
                        alert("aaaa===" + aa);
                        var item = $("select[name=post]").find("option:selected").text();
                        alert("==========" + item);
                        

                        $("#datagrid").datagrid({
                            url: basePath + '/userController/getUserList'
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
function updateUser() {
 $('#editorUserData').form('submit', {
        url: basePath + '/userController/saveUserOrUpdate',
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
                
                var aa = $("input[name='name']").val();
                alert("aaaa===" + aa);
                var item = $("select[name=post]").find("option:selected").text();
                alert("==========" + item);
                
                
                

                $("#datagrid").datagrid({
                    url: basePath + '/userController/getUserList'
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
    $('#userData').form('clear');
    $('#dlg').dialog('close');
}
/**
 * 取消
 */
function cancelEditorUser() {
    $('#editorUserData').form('clear');
    $('#editorDlg').dialog('close');
}
/**
 *  打开新增对话框
 */
function openAddUser() {
    $('#loginNames').textbox('enable');
    $('#password').textbox('enable');
    $('#rpassword').textbox('enable');
    $('#organId').combobox('enable');
    $('#postId').combobox('enable');
    $('#roleId').combobox('enable');
    $('#setVlaue').combobox('setValue', '0');
    $("#userData").form("enableValidation");
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
        width: 700,
        height: 400,
        closed: true,
        cache: false,
        resizable:true,
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveUser();
            }
        },{
            text:'取消',
            handler:function(){
                cancelUser();
            }
        }],
        onClose:function() {
            $("#userData").form("clear");
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
                updateUser();
            }
        }, {
            text: '取消',
            handler: function () {
                cancelEditorUser();
            }
        }],
        onClose: function () {
            $("#editorUserData").form("clear");
        }
    });
}
/**
 * 自定义验证
 */
$.extend($.fn.validatebox.defaults.rules, {
    loginNameCheck:{
        validator: function (value, param) {
            var json = {"loginName":value};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/userController/validLoginName",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '此帐号已存在！'
    },
    equalsPwd: {
        validator: function(value,param){
            return value == $(param[0]).val();
        },
        message: '密码不匹配'
    },
    maxLength: {
        validator: function(value, param){
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 字符'
    },
    loginCheck: {  // param 参数集合
        validator: function (value, param) {
            var reg = /^[0-9a-zA-Z]+$/;
            if (reg.test(value)) {
                return true;
            }
        },
        message: '帐号只能英文字母、数字的组合！'
    },
    pwd:{
    validator: function (value, param) {
        var reg =/^[\D0-9a-zA-Z\w]*$/;
        if (reg.test(value)) {
        return true;
        }
     },
        message: '密码只能字母、数字、符号或字母数字的组合！'
    },
    mpNumber: {
        validator: function (value, param) {
            //return /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[6|8|9])\d{8}$)/.test(value);
            // return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(1\d{10})/.test(value);
            return /(^\d{3,4}\-\d{7,8}$)|(^1\d{10}$)/g.test(value);
        },
        message: '请输入正确的电话号码,如：0591-6487256，15005059587'
    }
});
/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function editorUser(id){
    var $form = $("#editorUserData");
 /*   $('#editorLoginName').textbox('disable');
    $('#editorOrganId').combobox('disable');
    $('#editorPostId').combobox('disable');
    $('#editorRoleId').combobox('disable');*/
    var url = basePath+"/userController/getUserById";
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
 * 重置密码
 * @param id
 */
function resetPassword(id){
    var url = basePath+"/account/resetPassword";
    $.post(url,{id:id},function(res){
        if(res.success){
            noty({text:res.message, layout: 'center',timeout:2000});
        }else{
            $.messager.alert("错误",res.message,"error");
        }

    },"json");
}
/**
 * 删除用户信息
 * @param id
 */
function deleteUser(id){
    var url = basePath+"/userController/deleteUser";
    $.messager.confirm('提醒', '您确认删除该记录吗?', function(r){
        if (r){
            $.post(url,{id:id},function(res){
                if(res.success){
                    noty({text:res.message,timeout:2000});
                    $("#datagrid").datagrid({
                        url: basePath + '/userController/getUserList'
                    });
                }else{
                        $.messager.alert("错误",res.message,"error");
                }

            },"json");
        }
    });

}
