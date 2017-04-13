/**
 * Created by Administrator on 2016/3/18.
 */
$(document).ready(function () {
    loadOperateLogDate();
} );
/**
 * 加载列表数据
 */
function loadOperateLogDate(){
    var param = {
        loginname : $("input[name='loginname']").val(),
        createDateStart : $("input[name='createDateStart']").val(),
        createDateEnd : $("input[name='createDateEnd']").val()
    };
    $("#operateTable").datagrid({
        url:basePath+"/logManage/getSysOptLogListByParam",
        queryParams:param,
        pagination : true,
        fit : true,
        rownumbers:true,
        idField : 'id',
        columns : [[
            {
                title : '登录帐号',
                field : 'loginname',
                width:"14%"
            },
            {
                title : '登录姓名',
                field : 'username',
                width:"14%"
            },
            {
                title : '操作名',
                field : 'optName',
                width:"14%"
            },
            {
                title : '操作内容',
                field : 'details',
                width:"15%",
            },
            {
                title : '操作时间',
                field : 'optDate',
                width:"14%"
            },
            {
                title : '登录IP',
                field : 'ip',
                width:"14%"
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
    $("#operateTable").datagrid({
        url:basePath+"/logManage/getSysOptLogListByParam",
        queryParams:param,
        pageNumber:1
    });
}
/**
 * 导出业务日志Excel表格
 * 带条件查询的
 */
function exportExcel() {
    var param = {
        loginname: $("input[name='loginname']").val(),
        createDateStart: $("input[name='createDateStart']").val(),
        createDateEnd: $("input[name='createDateEnd']").val()
    };
    var url = basePath + "/logManage/exportOptLogOperateExcel";
    $('#exportForm').form("submit", {
        url: url,
        method: "post",
        queryParams: param
    });
    $("#operateTable").datagrid("clearSelections");
};

/**
 * 删除日志
 * @author abner
 * @param id
 */
function removeLog(id) {
    $.messager.confirm('确认','您确认删除吗？',function(r) {
        if (r) {
            var url = basePath + "/logManage/removeOperateLog";
            $.post(url, {id: id}, function (data) {
                if (data.success) {
                    noty({text: data.message, timeout: 2000});
                    $("#operateTable").datagrid("reload");
                    $("#operateTable").datagrid("clearSelections");
                } else {
                    $.messager.alert("错误", data.message, "error");
                }
            }, "json");
        }
    });
}