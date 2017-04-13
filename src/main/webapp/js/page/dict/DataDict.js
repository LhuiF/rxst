/**
 * 功能：数据字典管理
 * @Author: Yanli Yang
 */
$(function(){
    initDictDatagrid();
    initItemDatagrid();
    //$("#form").form("disableValidation");
    initDialog();
});

/**
* 初始化对话框
*/
function initDialog() {
    $('#dialog').dialog({
        width: 400,
        height: 300,
        closed: true,
        resizable:true,
        cache: false,
        border:'thin',
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveDictItem();
            }
        },{
            text:'取消',
            handler:function(){
                $('#dialog').dialog('close');
            }
        }],
        onClose:function() {
            $("#form").form("clear");
        }
    });
}

//当前选中的字典代码
var dictCode ;
/**
 * 初始化字典类型列表
 */
function initDictDatagrid(){
    $("#dictTypeList").datalist({
        url: basePath+'/dictController/getDictList',
        checkbox: false,
        lines: true,
        border:0,
        valueField:"dictCode",
        textField:"name",
        textFormatter:function(value,row,index) {
            return "<div style='text-align: center'>"+value+"</div>";
        },
        onClickRow:function(index, row) {
            dictCode = row.dictCode;
            $("#dictDataTable").datagrid({
                url : basePath+'/dictController/findDictItem',
                queryParams: {dictCode: row.dictCode}
            });
            $("#addBtn").linkbutton({disabled:false});
        }
    });
}

function searchDictItem(value,name) {
    //name为查询的name，value为输入框的值
    $("#dictDataTable").datagrid({
        pageNumber: 1,
        url : basePath+'/dictController/findDictItem',
        queryParams: {dictCode: dictCode,name:value}
     });
    $("#dictItemName").searchbox("setValue","");//清空输入值
}
/**
*初始化数据字典列表
*/
function initItemDatagrid(dictCode){
    var dictItemName = $("#dictItemName");
    $("#dictCode").val(dictCode);
    $("#dictDataTable").datagrid({
        method : 'post',
        data:[],
        fit : true,
        idField : 'id',
        singleSelect:true,
        rownumbers:true,
        columns : [[
             {title : '字典编码', field : 'code', width : '10%'},
             {title : '字典名称', field : 'name', width : '15%'},
             {title : '字典描述', field : 'remark', width : '30%'},
             {title : '排序', field : 'orderNo', width : '5%'},
             {title : '操作',
              field : '_opt',
              align :'center',
              width : '15%',
                formatter:function(val,row,index) {
                    return template("tp",{"dictItemId":row.id});
                }

             }
        ]],
        toolbar : "#tb"
    });
}
/**
 * 功能：新增页面弹出对话框
 */
function openAddDialog(){
    //123行和124行数据位置不能变
    $('#code').textbox('enable');
    $("#form").form("enableValidation");
    $('#dialog').dialog({
        title:"新增",
        closed:false
    });
}

/**
 * 功能：编辑页面弹出对话框,并加载数据
 */
var itemDictCode = "";
var id = "";
function openEditDialog(itemId){
    var $form = $("#form");
    $('#code').textbox('disable');
    var url = basePath+"/dictController/getDictItemById";
    $.post(url,{itemId:itemId},function(res){
        if(res.success){
            $form.form("disableValidation");
            $form.form("load",res.data);
            console.log(res.data);
            itemDictCode = res.data.code;
            id = res.data.id;
            $form.form("enableValidation");
            $('#dialog').dialog({
                title:"编辑",
                closed:false
            });
        }else{
            noty({text:res.message,timeout:3000});
        }
    },"json");
}
/**
 * 功能：新增字典项
 */
function saveDictItem(){
    $("#dictCode").val(dictCode);
    $('#form').form("submit",{
        url : basePath+"/dictController/saveDictItem",
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
            result = $.parseJSON(result);
            if(result.success){
                $.messager.progress("close");
                noty({text:result.message,timeout:3000});
                $("#dictDataTable").datagrid({
                    url : basePath+'/dictController/findDictItem',
                    queryParams : {dictCode:$("#dictCode").val()}
                });
                initItemDatagrid();
                $('#dialog').dialog('close');
            }else{
                noty({text:result.message,timeout:3000});
            }
        }
    });
}
/**
 * 扩展校验框架，增加字典项编码校验。字典项编码应该唯一。
 */
$.extend($.fn.validatebox.defaults.rules, {
    //value为输入框的值，param为其他参数值e.g.checkItemCode[param]
    checkItemCode : {
        validator : function(value, param) {
            var resp = $.ajax({
                url : basePath+"/dictController/validateItemCode",
                data : {
                    dictCode : dictCode,
                    code : value
                },
                async : false,//必写
                cache : false,
                type : "post"
            }).responseText;
            return resp == "true";
        },
        message : "此编码已经存在！"
    },
    checkItemName:{
        validator: function (value, param) {
            var resp = $.ajax({
                type:"POST",
                data : {
                    id : id,
                    dictCode : dictCode,
                    name : value
                },
                url:basePath+"/dictController/validateItemName",
                async : false,
                cache : false
            }).responseText;
            return resp == "true";
        },
        message: '此名称已存在！'
    }
});
