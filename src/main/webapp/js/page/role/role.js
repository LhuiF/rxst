$(function(){
    //initDatagrid();
    //init();
    initDatagrid();
});

//分页
function pagerFilter(data){
    //alert("data:"+data.splice);
    if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage:function(pageNum, pageSize){
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh',{
                pageNumber:pageNum,
                pageSize:pageSize
            });
            dg.datagrid('loadData',data);
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
 * 初始化 跟踪客户列表
 */
function initDatagrid() {
    //var json = {"name":str};
    $("#datagrid").datagrid({
        url : basePath+'/role/getList',
        //data:data,
        //queryParams:json,
        method : 'get',
        pagination:true,//分页控件
        pageSize : 10,//默认条数
        singleSelect:true,//是否单选true是、false否
        fit : true,
//                fitColumns :true,
        idField : 'id',
        rownumbers:true,
        columns : [ [
            {
                title : '角色名称',
                field : 'name',
                width : '25%'
            },
            {
                title : '角色编码',
                field : 'code',
                width : '20%'
            }, {
                title : '角色描述',
                field : 'remark',
                width : '25%'
            },
            {
                title : '注册时间',
                field : 'updateTime',
                width : '20%'
            },
            {
                title : '操作',
                field : '_opt',//不对应数据库或json字段，取的名字
                width : 90,
                formatter:function(value,row,index){   //格式化函数添加一个操作列
                    //var btn = '<a style="color: #00a0e9;" onclick="openEdit('+"\'"+row.id+"\'"+')" class="a_opt">编辑</a>  <a style="color: #dd0000;" onclick="deleteRole('+"\'"+row.id+"\'"+')" class="a_opt">删除</a>';
                    //return btn;
                    var html = template('optBtns', {organId:row.id});
                    return html;
                }
            }
        ] ],
        toolbar : "#tb",
        onLoadSuccess:function(data){  //为格式化列添加样式，变成有图标的按钮
//                    $('.editcls').linkbutton({text:'回访',plain:true,iconCls:'icon-edit'});
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
    $("#roleId").html("");
    openAddDialog();
}
/**
 *  打开新增对话框
 */
function openAddDialog() {
    $('#addDialog').dialog({
        title: '新增',
        width: 400,
        height: 270,
        closed: false,
        cache: false,
        border:'thin',
//                href: '#addUserDialog1',
        modal: true,
        buttons: [{
            text:'确定',
            handler:function(){
                saveRole();
                $("#fm_tb").form("clear");

            }
        },{
            text:'取消',
            handler:function(){
                $('#addDialog').dialog('close');
                $("#fm_tb").form("clear");
            }
        }]
    });
}

/**
 * 编辑
 */
function openEditDialog(str){
    $("#fm_etb").form("clear");
    //$("#roleId").val("");
    //alert(str);
    //var str = "";

    $.ajax({
        type:"POST",
        url:basePath+"/role/getRoleById?id="+str,
        //data:json,
        dataType:"json",
        success:function(result){
            //var obj = $.parseJSON(result);
           if(result.success){
                //alert("success");
               //modifyRole(result.data);
               openEditDialog();
           }else{
               noty({text: "此记录不存在，不能进行编辑！",type:"warning",timeout:2000});
           }
        },
        error:function(){

        }
    });
}


/**
 * 修改角色
 */

/*function modifyRole(obj) {
    //alert("name:"+obj.name);
    $("#fm_etb").form("disableValidation");
    var name = $("#roleName_edit").val(obj.name);
    var code = $("#roleCode_edit").val(obj.code);
    var remark = $("#roleRemark_edit").val(obj.remark);
    $("#roleId").val(obj.id);
    $('#editDialog').dialog({
        title: '修改角色',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        border:'thin',
//                href: '#addUserDialog1',
        modal: true,
        buttons: [{
            text:'修改',
            handler:function(){
                editRole();

            }
        },{
            text:'取消',
            handler:function(){
                $('#editDialog').dialog('close');
            }
        }]
    });
    $("#fm_etb").form("enableValidation");


}*/

//
function openEditDialog(){
    var rows = $("#datagrid").datagrid("getSelections");
    //alert("编辑"+rows.length);
    if(rows.length==0 ||rows.length>1){
        noty({text: "请选择一条记录进行编辑！",type:"warning",timeout:2000});
        return ;
    }
    //$("#opt").val("edit");
   /* $("#editDialog").dialog({
        title:"修改",
        iconCls:"icon-edit"
    });*/
    //$("#rid").val(rows[0].id);
    $.post(basePath+"/role/getRoleById",{id:rows[0].id},function(data){
        $("#fm_etb").form("disableValidation");
        if(data.success){
            $("#fm_etb").form("clear");
            $("#fm_etb").form("load",data.data);
            $("#roleName_edit").val(data.data.name);
            $("#roleCode_edit").val(data.data.code);
            $("#roleRemark_edit").val(data.data.remark);
            $("#roleId").val(data.data.id);
            //$("#editDialog").dialog("open");
            $('#editDialog').dialog({
                title: '修改',
                width: 400,
                height: 270,
                closed: false,
                cache: false,
                border:'thin',
//                href: '#addUserDialog1',
                modal: true,
                buttons: [{
                    text:'修改',
                    handler:function(){
                        editRole();
                        $("#fm_etb").form("clear");

                    }
                },{
                    text:'取消',
                    handler:function(){
                        $('#editDialog').dialog('close');
                        $("#fm_etb").form("clear");
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
var codeMessage = "";
var nameMessage = "";
$.extend($.fn.validatebox.defaults.rules, {
    nameCheck:{
        validator: function (value, param) {
            var json = {"name":value,"id":$("#roleId").val()};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/role/validate",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '【该角色名称已存在，请重新输入】'
    },
    codeCheck:{
        validator: function (value, param) {
            var json = {"code":value,"id":$("#roleId").val()};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/role/validate",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message:'【该角色编码已存在，请重新输入】'
    },
    maxLength: {
        validator: function(value, param){
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 位'
    },
    isBlank: {

        validator: function (value) {
            return $.trim(value) != ''&& $.trim(value.substr(0,1))!=''&& $.trim(value.substr(value.length-1,value.length))!=''
        },
        message: '内容前后不能有空格'
    }
});


//保存信息
function saveRole() {
    //获取页面中输入的值
    var name = $("#roleName").val();
    var code = $("#roleCode").val();
    var remark = $("#roleRemark").val();

    $("#fm_tb").form("submit", {
        //设定地址与传递参数到后台
        url:basePath+"/role/save",
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
        //判断结果是否正确
        success: function (result) {
            result = $.parseJSON(result);
            $.messager.progress("close");
            if(result.success){//操作成功
                $("#addUserDialog1").dialog("close");
                $('#addDialog').dialog('close');
                noty({text:result.message,timeout:3000});
                $("#datagrid").datagrid({
                    url : basePath+'/role/getList'
                });
            }else{//保存失败
                //$.messager.alert("错误","保存数据时出现系统错误!","error");
                //alert(result.message);
                noty({text:result.message,timeout:3000});
            }

        }
    });

}

//编辑信息
function editRole() {
    //获取页面中输入的值
    var name = $("#roleName_edit").val();
    var code = $("#roleCode_edit").val();
    var remark = $("#roleRemark_edit").val();
    var id = $("#roleId").val();
    $("#fm_etb").form("submit", {
        //设定地址与传递参数到后台
        url:basePath+"/role/update",
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
        //判断结果是否正确
        success: function (result) {
            result = $.parseJSON(result);
            $.messager.progress("close");
            if(result.success){//操作成功
                $("#editDialog").dialog("close");
                $('#datagrid').datagrid('reload');
                //init("");
                noty({text:result.message,timeout:3000});
                $("#datagrid").datagrid({
                    url : basePath+'/role/getList'
                });

            }else{//保存失败
                //$.messager.alert("错误","保存数据时出现系统错误!","error");
                noty({text:result.message,timeout:3000});
            }

        }
    });

}

/**
 * 删除角色
 */
function deleteRole(str){
    $.messager.confirm('提醒', '您确认要删除该记录吗？', function (r) {
        if (r) {
            var json = {"id":str};
            //alert("str:"+str);
            $.ajax({
                type:"POST",
                url:basePath+"/role/delete",
                data:json,
                async : false,
                cache : false,
                dataType:"json",
                success:function(result){
                    //alert("result:"+result.success);
                    if(result.success == true){
                        noty({text:"该角色下有用户存在，不允许删除",timeout:3000});
                    }else{
                        //$('#datagrid').datagrid('reload');
                        noty({text:"删除成功",timeout:3000});
                        $("#datagrid").datagrid({
                            url : basePath+'/role/getList'
                        });
                    }
                }
            });
        }

    });

}

/**
 *查询
 */
function sercheItem(value,name){
    //init(value);
    //initDatagrid(value);

    var json = {"name":value};
    $("#datagrid").datagrid({
        url : basePath+'/role/getList',
        queryParams:json,
        method : "post"
    });
}

//初始化
/*
function init(str){
    var json = {"name":str};
    $.ajax({
        type:"POST",
        url:basePath+"/role/getList",
        data:json,
        async : false,
        cache : false,
        dataType:"json",
        success:function(result){

            //initDatagrid(result.rows);
            //initDatagrid(pagerFilter(result.rows));
            //$('#datagrid').datagrid('loadData', result.rows);
            //$('#datagrid').datagrid({loadFilter:pagerFilter}).datagrid('loadData', result);
        }
    });
}*/
