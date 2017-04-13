// 机构树数据.
var organData;
var organCombotreeData;
$(function() {
    initTreeGrid();
    findOrganTree();
    findComboOrganTree();
    /*$("#organ_combotree").combotree({
        "data":organCombotreeData
    });*/

});
/**
 * 初始化treeGrid
 * @Author xuanYin
 * @Param
 * @Date 2016/5/19 16:50
 */
function initTreeGrid() {
    $('#organTreeGrid').treegrid({
        toolbar:'#tb',
        idField: 'id',
        rownumbers: true,
        treeField: 'name',
        loadMsg:"数据处理中，请稍后....",
        fit:true,
        columns:[[
            {title:'机构名称',field:'name',width:'15%'},
            {title:'机构编码',field:'code',align:'left',width:'15%'},
            {title:'联系人',field:'contactPerson',align:"left",width:'10%'},
            {title:'联系方式',field:'tel',align:"left",width:'15%'},
            {title:'地址',field:'address',align:"left",width:'15%'},
            {title:'注册时间',field:'createDatatime',align:"left",width:'15%'},
            {
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : '15%',
                formatter:function(value,row){   //格式化函数添加一个操作列
                    var rowData={
                        id:row.id,
                        tierCode:row.tierCode
                    };
                    var html = template('optBtns', rowData);
                    return html;
                }
            }
        ]]

    });
}
/**
 * 初始化编辑框
 * @Author xuanYin
 * @Param
 * @Date 2016/5/19 15:40
 */
function initDialog(title) {
    $('#editDialog').dialog({
        title:title,
        width: 700,
        height: 260,
        closed: false,
        cache: false,
        resizable:true,
        buttons: [{
            text:'保存',
            handler:function(){
                saveOrgan();
            }
        },{
            text:'取消',
            handler:function(){
                $('#editDialog').dialog('close');
            }
        }]
    });
}

/**
 * @author xuanYin
 * @date 201/05/16
 *根据机构名称查询机构树形列表
 */
function findOrganTree(){
    var url = CP+"/organ/findOrganTree";
    var param = {
        "name":$("#organName").val(),
        "contactPerson":$("#contactPerson").val(),
        "tel":$("#tel").val()
    };
    $.post(url, param, function (result) {
        if(result.success) {
           organData=result.data;
           $("#organTreeGrid").treegrid({"data":result.data});

        }else {
            $.messager.alert("错误",result.message,"error");
        }
    },"json");
}

/**
 * @author xuanYin
 * @date 201/05/17
 *  打开新增对话框
 */
function openAddDialog() {
    $("#editForm").form("clear");
    $("#editForm").form("enableValidation");
    var rowData=$('#organTreeGrid').treegrid('getSelected');
    if(rowData){
        $('#organ_combotree').combotree('setValue',rowData.id);
    }else{
        var da=$("#organ_combotree").combotree('tree').tree("getRoot");
        $('#organ_combotree').combotree('setValue',da.id);
    }
    initDialog("新增");
}

/**
 * @author xuanYin
 * @date 201/05/17
 *  打开编辑对话框
 */
function openEditDialog(organId) {
    $("#editForm").form("disableValidation");
    $("#editForm").form("clear");
    var url = CP+"/organ/findOrganById";
    var param = {"id":organId};
    $.post(url, param, function (result) {
        if(result.success) {
            var organData=result.data;
            $("#editForm").form("load",organData);
            if($('#organ_combotree').combotree('getText')==0){
                $('#organ_combotree').combotree('setText',"");
            }
            initDialog("编辑");
        }else {
            $.messager.alert("错误",result.message,"error");
        }
        $("#editForm").form("enableValidation");
    },"json");
}
/**
 * 自定义验证(验证組織機構名稱和組織機構編碼的唯一性)
 * @Author xuanYin
 * @Param
 * @Date 2016/5/17 19:08
 */
$.extend($.fn.validatebox.defaults.rules, {
    nameCheck:{
        validator: function (value) {
            var json = {
                "name":value,
                "id":$("#organId").val()
            };
            var resp = $.ajax({
                type:"POST",
                url:CP+"/organ/validateOrgan",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '此名称已存在！'
    },
    codeCheck:{
        validator: function (value) {
            var json = {
                "code":value,
                "id":$("#organId").val()
            };
            var resp =$.ajax({
                type:"POST",
                url:CP+"/organ/validateOrgan",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message:'此编码已存在！'
    },
    maxLength: {
        validator: function(value, param){
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 个字符'
    },
    personOrgan:{
        validator: function(value){
            var codeEdit=$("#codeEdit").val();
            var json = {
                "name":value,
                "code":codeEdit,
                "id":$("#organId").val()
            };
            var resp =$.ajax({
                type:"POST",
                url:CP+"/organ/validateOrganTree",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '不能指定自身或者自己的下级机构为上级机构'
    },
    isBlank: {
        validator: function (value) {
            return $.trim(value) != ''&& $.trim(value.substr(0,1))!=''&& $.trim(value.substr(value.length-1,value.length))!=''
        },
        message: '内容前后不能有空格'
    }
});

/**
 * 保存组织机构方法
 * @Author xuanYin
 * @Param
 * @Date 2016/5/17 19:16
 */
function saveOrgan(){
    $("#editForm").form("submit",{
        url: CP+"/organ/saveOrgan",
        //提交前验证
        onSubmit:function(){
            //提交显示提示信息
            $.messager.progress({
                title:"提示",
                text:"数据处理中，请稍后...."
            });
            //校验表单
            var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            }
            return isValid;
        },
        //提交成功
        success:function(result){
            result = $.parseJSON(result);//将返回的json字符串转换成json对象
            $.messager.progress("close");//关闭在提交表单前显示的提示信息
            if(result.success){//操作成功
                $("#editDialog").dialog("close");//关闭打开的新增窗口
                //显示成功提示信息
                noty({text:result.message,timeout:3000});
                //重新加载表格数据
                findOrganTree();
                //加载comboTree的数据
                findComboOrganTree();
            }else{//保存失败
                $.messager.alert("错误","保存数据时出现系统错误!","error");
            }
        }
    });
}
/**
 * 删除组织机构
 * @Author xuanYin
 * @Param
 * @Date 2016/5/18 10:05
 */
function  deleteOrgan(id,tierCode){
    if (validateDelete(id,tierCode)) {
        $.messager.confirm("警告","确认删除所选机构吗？",function(r){
            if (r) {
            //提交显示提示信息
            $.messager.progress({
                title:"提示",
                text:"数据处理中，请稍后...."
            });
                $.ajax({
                    url: CP+"/organ/deleteOrgan",
                    type: 'post',
                    data: "id=" + id,
                    dataType: "json",
                    success: function (res) {
                        if (res.success) {
                            noty({text:res.message,timeout:3000});
                            //重新加载表格数据
                            findOrganTree();
                            //$('#organTreeGrid').datagrid('reload');
                            $('#organTreeGrid').datagrid('clearSelections');
                            //加载comboTree的数据
                            findComboOrganTree();
                        } else {
                            $.messager.alert("错误", res.message);
                        }
                    }
                });
            $.messager.progress("close");
            }
        });
    }
}

/**
 * 验证是否能删除组织机构
 * @Author xuanYin
 * @Param id
 * @Date 2016/5/18 11:56
 */
function  validateDelete(id,tierCode){
    if(tierCode=="103"){
        $.messager.alert("提示","顶层机构不能删除","warning");
        return false;
    }
    var result = $.ajax({
        url: CP+"/organ/validateDelete",
        type: 'post',
        data: "id=" + id,
        dataType: "json",
        async:false
    }).responseText;
    result = $.parseJSON(result);//将返回的json字符串转换成json对象
    if(!result.success) {
        $.messager.alert("提示",result.message,"warning");
        return false;
    }
    return true;
}

/**
 * 查询组织机构树形结构
 * @Author xuanYin
 * @Param
 * @Date 2016/6/17 17:12
 */
function findComboOrganTree(){
    var url = CP+"/organ/findComboOrganTree";
    $.post(url, function (result) {
            organCombotreeData=result;
            console.log(organCombotreeData);
            $("#organ_combotree").combotree({
                "data":organCombotreeData
            });
    },"json");
}