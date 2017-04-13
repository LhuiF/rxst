<%@ page import="com.unionx.core.enums.ModuleTypeEnum" %>
<%@ page import="com.unionx.core.enums.SystemEnum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<html>
<head>
    <title>模块管理</title>
    <jsp:include page="../resources.jsp"/>
    <script type="text/javascript" src="${CP}/js/page/module/module.js"></script>
    <script type="text/javascript">
        var basePath="${CP}";
        var moduleType = <%=ModuleTypeEnum.toJson()%>;
        var moduleTypeList = <%=ModuleTypeEnum.toListJson()%>;
        var systemList = <%=SystemEnum.toListJson()%>;
        <%--var moduleTreeData = ${u:getModuleTreeData()};--%>
    </script>
    <%--模板--%>
    <script id="optBtns" type="text/html">
        <a href="javascript:;" onclick="openEditDialog('{{code}}')">编辑</a>
        <a href="javascript:;" onclick="deleteModule('{{code}}')">删除</a>
    </script>
</head>
<body>
    <div id="tb">
        <a class="easyui-linkbutton" onclick="openAddDialog()">新增</a>
    </div>
    <table id="moduleTreeGrid"  class="easyui-treegrid">

    </table>
    <div id="openDialog"  style="padding:10px 10px;display: none">
        <form id="moduleForm" style="width: 100%;margin: 0;padding:0;" class="easyui-form" method="post">
            <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
                <tr>
                    <td width="100px" class="fm_lable">模块编码:</td>
                    <td>
                        <input class="easyui-textbox" name="code" id="code" style="width: 100%" data-options="
                            required:true,
                            validType:'codeCheck'">
                    </td>
                    <td width="100px" class="fm_lable">模块名称:</td>
                    <td>
                        <input class="easyui-textbox" name="name" id="name"  style="width: 100%" data-options="required:true" >
                    </td>
                </tr>
                <tr>
                    <td width="100px" class="fm_lable">上级模块:</td>
                    <td>
                        <input id="moduleComboTree" name="parentCode" style="width: 100%" data-options="
                            valueField:'code',
                            textField:'name'
                        ">
                    </td>
                    <td width="100px" class="fm_lable">类型:</td>
                    <td>
                        <input class="easyui-combobox" id="type" style="width: 100%" name="type" data-options="
                            required:true,
                            data:moduleTypeList,
                            valueField:'code',
                            textField:'name'
                        ">
                    </td>
                </tr>
                <tr>
                    <td width="100px" class="fm_lable">所属系统:</td>
                    <td>
                        <input class="easyui-combobox" id="sysType" style="width: 100%" name="sysType" data-options="
                            required:true,
                            data:systemList,
                            valueField:'code',
                            textField:'name'
                        ">
                    </td>
                    <td class="fm_lable">排序号:</td>
                    <td>
                        <input class="easyui-numberspinner" id="orderNo" name="orderNo" style="width: 100%" data-options="
                            value:'1',
                            min:1">
                    </td>
                </tr>
                <tr>
                    <td width="100px" class="fm_lable">访问地址:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" id="url" style="width: 100%" name="url">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
