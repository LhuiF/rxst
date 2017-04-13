<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>业务日志</title>
    <jsp:include page="../resources.jsp"/>
    <!-- 本页面用到的js和css -->
    <script type="text/javascript" src="${CP}/js/page/log/operateLog.js"></script>
    <script type="text/javascript">
        var cp = '${CP}';
    </script>
    <script id="tp" type="text/html">
        <div style="text-align: center">
            <a href="javascript:;" onclick="removeLog('{{id}}')">删除</a>
        </div>
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            用户账号：<input type="text" name="loginname" class="easyui-textbox">
        </label>
        <label style="padding: 0 5px">
            时间：<input class="easyui-datebox" name="createDateStart" style="width:100px">
            - <input class="easyui-datebox" name="createDateEnd" style="width:100px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="selectMore()">查询</a>
    </div>
    <div data-options="region:'center',border:0">

        <div id="tb" style="padding:5px;height:auto">
            <div style="margin-bottom:5px">
                <a href="#" class="easyui-linkbutton" onclick="exportExcel()">导出</a>
            </div>
        </div>
        <table id="operateTable" class="easyui-datagrid">
        </table>
    </div>
</div>
</body>
</html>
<div style="display: none;">
    <form id="exportForm"></form>
</div>