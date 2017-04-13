<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<html>
<head>
    <title>组织机构</title>
    <jsp:include page="../resources.jsp"/>
    <script type="text/javascript" src="${CP}/js/page/organ/organ.js"></script>
    <script type="text/javascript">
        var CP="${CP}";
        /*var organCombotreeData = ${u:getOrganTreeData()};*/
    </script>
    <%--模板--%>
    <script id="optBtns" type="text/html">
        <a href="javascript:openEditDialog('{{id}}')">编辑</a>
        {{if tierCode!=103}}
        <a href="javascript:deleteOrgan('{{id}}','{{tierCode}}')">删除</a>
        {{/if}}
    </script>
</head>
<body>
<!-- 编辑弹出框-->
<div id="editDialog"  style="padding:10px 10px;display: none">
    <form id="editForm" style="width: 100%;margin: 0;padding:0;" class="easyui-form" method="post">
        <input type="hidden" value="" id="organId" name="id">
        <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
            <tr>
                <td width="100px" class="fm_lable">机构名称:</td>
                <td>
                    <input class="easyui-textbox" name="name" id="nameEdit"  style="width: 100%" data-options="required:true,validType:['nameCheck','maxLength[20]','isBlank']" >
                </td>
                <td width="100px" class="fm_lable">机构编码:</td>
                <td>
                    <input class="easyui-textbox" name="code" id="codeEdit" style="width: 100%" data-options="required:true,validType:['codeCheck','maxLength[20]','isBlank']">
                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">联系人:</td>
                <td>
                    <input class="easyui-textbox" id="contactPersonEdit" style="width: 100%" name="contactPerson" data-options="validType:['maxLength[20]','isBlank']">
                </td>
                <td width="100px" class="fm_lable">联系方式:</td>
                <td>
                    <input class="easyui-textbox" id="telEdit" style="width: 100%" name="tel" data-options="validType:['maxLength[20]','isBlank']">
                </td>
            </tr>
            <tr>
                <td class="fm_lable" width="100px">所属机构:</td>
                <td>
                    <input id="organ_combotree" style="width: 100%" name="parentId" class="" data-options="required:true,validType:'personOrgan'">
                </td>
                <td class="fm_lable">排序号:</td>
                <td>
                    <input class="easyui-numberspinner" data-options="value:'1',min:1" id="orderNoEdit" style="width: 100%" name="orderNo">
                </td>
            </tr>
            <tr>
                <td class="fm_lable" width="100px">地址:</td>
                <td>
                    <input class="easyui-textbox" name="address" style="width: 100%" data-options="validType:'maxLength[100]'">
                </td>
                <td class="fm_lable" width="100px">备注:</td>
                <td>
                    <input class="easyui-textbox" name="remark" id="remarkEdit" data-options="multiline:true,validType:'maxLength[200]'" style="width:100%;height: 50px;">
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            机构名称：<input class="easyui-textbox" name="organName"  id="organName"  style="width:140px">
        </label>
        <label style="padding: 0 5px">
            联系人：<input class="easyui-textbox" name="contactPerson" id="contactPerson"  style="width:140px">
        </label>
        <label style="padding: 0 5px">
            联系方式：<input class="easyui-textbox" name="tel" id="tel" style="width:140px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="findOrganTree();">查询</a>
    </div>
    <div data-options="region:'center',border:0">
    <div id="tb">
        <a class="easyui-linkbutton" onclick="openAddDialog()">新增</a>
    </div>
    <table id="organTreeGrid" class="easyui-treegrid"/>
    </div>
</div>
</body>
</html>
