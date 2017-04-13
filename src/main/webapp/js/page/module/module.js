/**
 * 功能：
 * @Author: Yanli Yang
 */
// 模块树数据.

$(function() {
    initTreeGrid();
    loadModuleTree();
    $("#moduleForm").form("disableValidation");
    initDialog();
    //$("#moduleComboTree").combotree({"data":moduleTreeData});
});

function loadModuleTree() {
    var url = basePath+"/module/getModuleTree";
    $.post(url,null,function(res) {
        if(res.success) {
            $('#moduleTreeGrid').treegrid({
                loadMsg:"数据加载，请稍后....",
                data:res.data
            });
            $("#moduleComboTree").combotree({"data":res.data});
        }else {
            $.messager.alert('提醒',res.message,'error');
        }
    },"json")
}

/**
 * 初始化模块列表
 */
function initTreeGrid() {
    $('#moduleTreeGrid').treegrid({
        toolbar:'#tb',
        idField: 'code',
        rownumbers: true,
        treeField: 'name',
        fit:true,
        animate:true,
        columns:[[
            {title:'模块名称',field:'name',width:'15%'},
            {title:'模块编码',field:'code',width:'5%'},
            {title:'访问地址',field:'url',width:'18%'},
            {title:'图标',field:'icon',width:'10%'},
            {title:'类型',field:'type',width:'5%',
                formatter:function(val,row,index) {
                    return moduleType[val];
                }
            },
            {title:'排序号',field:'orderNo',width:'5%'},
            {
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : '15%',
                align : 'center',
                formatter:function(value,row,index){   //格式化函数添加一个操作列
                    var html = template('optBtns', {code:row.code});
                    return html;
                }
            }
        ]]
    });
}
/**
 * 初始化对话框
 */
function initDialog() {
    $('#openDialog').dialog({
        width: 700,
        height: 260,
        closed: true,
        cache: false,
        resizable:true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveModule();
            }
        },{
            text:'取消',
            handler:function(){
                $('#openDialog').dialog('close');
            }
        }],
        onClose:function() {
            $("#moduleForm").form("clear");
        }
    });
}
/**
 * 功能：新增页面弹出对话框
 */
function openAddDialog(){
    $('#code').textbox('enable');
    $("#moduleForm").form("enableValidation");
    $('#openDialog').dialog({
        title:"新增",
        closed:false
    });
}

/**
 * 功能：新增模块功能
 */
function saveModule(){
    $('#code').textbox('enable');
    $('#moduleForm').form("submit",{
        url : basePath+"/module/saveModule",
        onSubmit:function(){
            $.messager.progress({title: "处理中，请稍后...."});
            //校验表单
            var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            }
            return isValid;
        },
        success:function(result){
            //result = $.parseJSON(result);
            if(result){
                $.messager.progress("close");
                noty({text:'保存成功！',timeout:3000});
                loadModuleTree();
                $('#openDialog').dialog('close');
            }else{
                noty({text:'保存失败！',timeout:3000});
            }
        }
    });
}
/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
function openEditDialog(code){
    var $form = $("#moduleForm");
    $('#code').textbox('disable');
    var url = basePath+"/module/getModuleByCode";
    $.post(url,{code:code},function(res){
        if(res.success){
            $form.form("disableValidation");
            $form.form("load",res.data);
            $('#openDialog').dialog({
                title:"编辑",
                closed:false
            });
        }else{
            noty({text:res.message,timeout:3000});
        }
    },"json");
}
/**
 * 自定义验证(验证模块編碼的唯一性)
 * @Author xuanYin
 * @Param
 * @Date 2016/5/17 19:08
 */
$.extend($.fn.validatebox.defaults.rules, {
    codeCheck:{
        validator: function (value, param) {
            var resp =$.ajax({
                type:"POST",
                url:basePath+"/module/validateModuleCode",
                data:{"code":value},
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message:'此编码已存在！'
    }
});
/**
 * 删除模块
 */
function deleteModule(code){
    $.messager.confirm("提醒","确认删除所选模块功能吗？",function(r){
        if (r) {
            //提交显示提示信息
            $.messager.progress({
                title:"提醒",
                text:"数据处理中，请稍后...."
            });
            if (validateDelete(code)) {
                $.ajax({
                    url: basePath+"/module/deleteModule",
                    type: 'post',
                    data: {"code":code},
                    dataType: "json",
                    success: function (res) {
                        if (res) {
                            noty({text:'删除成功！',timeout:3000});
                            //重新加载表格数据
                            initTreeGrid();
                            loadModuleTree();
                        } else {
                            $.messager.alert("提醒", '删除失败！');
                        }
                    }
                });
            }
            $.messager.progress("close");
        }
    });
}
/**
 * 验证是否能删除功能模块
 * @Param code
 * @Date 2016/5/18 11:56
 */
function  validateDelete(code){
    var result = $.ajax({
        url: basePath+"/module/validateDelete",
        type: 'post',
        data: {"code":code},
        dataType: "json",
        async:false
    }).responseText;
    result = $.parseJSON(result);//将返回的json字符串转换成json对象
    if(!result.success) {
        $.messager.alert("提醒",result.message,"warning");
        return false;
    }
    return true;
}

