/**
 * Created by Administrator on 2016/3/18.
 */
$(document).ready(function () {
    loadLoginLogDate();
} );

/**
 * 删除日志
 * @author abner
 * @param id
 */
function removeLog(id) {
    $.messager.confirm('确认','您确认删除吗？',function(r) {
        if (r) {
            var url = basePath + "/logManage/removeLoginLog";
            $.post(url, {id: id}, function (data) {
                if (data.success) {
                    noty({text: data.message, timeout: 2000});
                    $("#logTable").datagrid("reload");
                    $("#logTable").datagrid("clearSelections");
                } else {
                    $.messager.alert("错误", data.message, "error");
                }
            }, "json");
        }
    });
};

/**
 * 加载列表数据
 */
function loadLoginLogDate(){
    var param = {
        loginname : $("input[name='loginname']").val(),
        createDateStart : $("input[name='createDateStart']").val(),
        createDateEnd : $("input[name='createDateEnd']").val()
    };
    $("#logTable").datagrid({
        url:basePath+"/logManage/getSysLoginLogListByParam",
        queryParams:param,
        pagination : true,
        fit : true,
        rownumbers:true,
        idField : 'id',
        columns : [[
            {
                title : '登录帐号',
                field : 'loginname',
                width:"15%"
            },
            {
                title : '登录姓名',
                field : 'name',
                width:"15%"
            },
            {
                title : '登录状态',
                field : 'status',
                width:"15%",
                formatter:function(val,row,index) {
                    return statusEnum[val];
                }
            },
            {
                title : '登录时间',
                field : 'loginDatatime',
                width:"15%"
            },
            {
                title : '登录IP',
                field : 'ip',
                width:"15%"
            },
            {
                title: '操作',
                field: '_opt',
                align: 'center',
                width: '15%',
                formatter: function (val, row, index) {
                    return template("tp", row);
                }
            }
        ]],
        toolbar : "#tb"
    })
}


function selectMore(){
    var param = {
        loginname : $("input[name='loginname']").val(),
        createDateStart : $("input[name='createDateStart']").val(),
        createDateEnd : $("input[name='createDateEnd']").val()
    };
    $("#logTable").datagrid({
        url:basePath+"/logManage/getSysLoginLogListByParam",
        queryParams:param,
        pageNumber:1
    });
}
/**
 * 导出登录日志Excel表格
 * 带条件查询的导出
 */
function exportExcel() {
    var param = {
        loginname: $("input[name='loginname']").val(),
        createDateStart: $("input[name='createDateStart']").val(),
        createDateEnd: $("input[name='createDateEnd']").val()
    };
    var url = basePath + "/logManage/exportLoginLogOperateExcel";
    $('#exportForm').form("submit", {
        url: url,
        method: "post",
        queryParams: param
    });
    $("#logTable").datagrid("clearSelections");
};



/*
function importExcel(){
    $.jBox($("#importBox").html(), {
        title: "导入数据", buttons: {"关闭": true},
        bottomText: "导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"
    });
};*/
