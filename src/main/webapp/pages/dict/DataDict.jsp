<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<jsp:include page="../resources.jsp"/>
<html>
<style>
    .panel-header{
        border:1px solid #ddd;
    }
</style>
<head>
    <title>数据字典管理</title>
    <script type="text/javascript" src="${CP}/js/page/dict/DataDict.js"></script>
    <script type="text/javascript">
        var basePath = '${CP}';
    </script>
    <script id="tp" type="text/html">
        <div style="text-align: center">
            <a href="javascript:;" onclick="openEditDialog('{{dictItemId}}')">编辑</a>
        </div>
    </script>
</head>
<body class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'<div style=\'text-align: center\'>数据字典</div>',split:false,collapsible:false" style="width:280px;">
        <div id="dictTypeList"></div>
    </div>
    <div data-options="region:'center',title:'字典项'" style="padding:5px;">
        <div id="tb" style="padding:5px;height:auto">
            <div style="margin-bottom:5px">
                <a id="addBtn" onclick="openAddDialog()" class="easyui-linkbutton" data-options="disabled:true">新增</a>
                <label style="padding: 0 5px">
                    字典名称：<input id="dictItemName" class="easyui-searchbox" name="name" data-options="
                        searcher:searchDictItem">
                </label>

            </div>
        </div>
        <table id="dictDataTable" class="easyui-datagrid">
        </table>
    </div>

    <!-- 对话框 -->
    <div id="dialog" style="padding:10px 10px;display: none">
        <form id="form" style="width: 100%;margin: 0;padding:0;" method="post">
            <input name="id" type="hidden">
            <input id="dictCode" name="dataDictCode" type="hidden">
            <table class="fm_table" style="width:100%;table-layout:fixed">
                <tr>
                    <td class="fm_lable" width="80px">字典编码:</td>
                    <td>
                        <input id="code" name="code" class="easyui-textbox" style="width: 100%" data-options="
                            editable:true,
                            required:true,
                            validType:['specialChart','length[1,6]','codeSpace','number','checkItemCode']">
                    </td>
                </tr>
                <tr>
                    <td class="fm_lable" width="80px">字典名称:</td>
                    <td>
                        <input id="name" name="name" class="easyui-textbox" style="width: 100%" data-options="
                            editable:true,
                            required:true,
                            validType:['checkItemName','specialChart','nameSpace','length[1,20]']">
                    </td>
                </tr>
                <tr>
                    <td class="fm_lable" width="80px">排序号:</td>
                    <td>
                        <input id="orderNo" name="orderNo" class="easyui-numberspinner" style="width: 100%" data-options="
                            editable:true,
                            min:1">
                    </td>
                </tr>
                 <tr>
                    <td class="fm_lable" width="80px">描述:</td>
                    <td>
                        <input id="remark" name="remark" class="easyui-textbox" style="width: 100%" data-options="
                            editable:true,
                            multiline:true,
                            height:80,
                            validType:'length[0,1000]'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
