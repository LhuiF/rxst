<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录日志</title>
    <%@include file="../resources.jsp"%>
    <!-- 本页面用到的js和css -->
    <style type="text/css">
        .btn-import {
            background: #7AE8D2 !important;
            border: 0 none !important;
            padding: 3px 10px !important;
            letter-spacing: 5px;
        }

    </style>
    <script type="text/javascript" src="${CP}/js/page/log/LoginLogYw.js"></script>
    <script type="text/javascript">
        var statusEnum = ${statusEnum};
        var cp = '${CP}';
    </script>
    <script id="tp" type="text/html">
        <div style="text-align: center">
            <a href="javascript:;" onclick="removeLog('{{id}}')">删除</a>
        </div>
    </script>

    <link rel="stylesheet" href="${CP}/lib/artDialog-master/css/ui-dialog.css">
    <script type="text/javascript" src="${CP}/lib/artDialog-master/dist/dialog-min.js"></script>



    <script type="text/javascript">

       function importExcel(){
           var d = dialog({
               title: '导入信息',
               content:'<div>'
              + '<form id="importForm" action="#" method="post" enctype="multipart/form-data" class="form-search" style="padding-left:20px;text-align:center;" > <br/>'
             +' <input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>'
               +'<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>'
                +'<a href="#">下载模板</a>',
               lock: true,
               fixed: true,
               okValue: '确 定',
               ok: function () {
                   var that = this;
                   setTimeout(function () {
                       that.title('提交中..');
                   }, 2000);
                   return false;
               },
               cancelValue: '取消',
               cancel: function () {
               }
           });

           d.show();
       }



    </script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            用户账号： <input type="text" name="loginname" id="loginname" class="easyui-textbox">
        </label>
        <label style="padding: 0 5px">
            时间： <input class="easyui-datebox" name="createDateStart" id="createDateStart" style="width:100px">
            - <input class="easyui-datebox" name="createDateEnd" id="createDateEnd" style="width:100px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="selectMore()">查询</a>
    </div>
    <div data-options="region:'center',border:0">

        <div id="tb" style="padding:5px;height:auto">
            <div style="margin-bottom:5px">
                <a href="#" class="easyui-linkbutton" onclick="exportExcel()">导出</a>
              <%--  新增导入--%>
                <a href="#" id="btnImport" class="easyui-linkbutton btn-import" onclick="importExcel()">导入</a>
     <%--          <input id="btnImport" class="btn btn-import" type="button" value="导入"/>--%>
            </div>
        </div>
        <table id="logTable" class="easyui-datagrid">
        </table>
    </div>
</div>
</body>
</html>
<div style="display: none;">
    <form id="exportForm"></form>
</div>



<%--<div id="importBox" class="hide">
    <form id="importForm" action="#" method="post" enctype="multipart/form-data"
          class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
        <input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
        <input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
        <a href="#">下载模板</a>
    </form>
</div>--%>
