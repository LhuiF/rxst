<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>角色管理</title>
    <%@include file="../resources.jsp"%>
    <script type="text/javascript" src="${CP}/js/page/role/role.js"></script>
    <script id="optBtns" type="text/html">
        <a href="javascript:openEditDialog('{{organId}}')">编辑</a>
        <a href="javascript:deleteRole('{{organId}}')">删除</a>
    </script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <%--<div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <a id="btn_add" onclick="openAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
        <label style="padding: 0 5px">
            角色名称: <input id="srn" class="easyui-searchbox" data-options="searcher:sercheItem"/>
        </label>

        &lt;%&ndash;<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>&ndash;%&gt;
    </div>--%>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <%--<input type="hidden" id="rid" value=""/>--%>
            <a id="btn_add" onclick="openAdd()" class="easyui-linkbutton" >新增</a>
            <label style="padding: 0 5px">
                角色名称：<input id="srn" class="easyui-searchbox" data-options="searcher:sercheItem"/>
            </label>

        </div>
        <table id="datagrid"></table>
        <%--<table id="datagrid" data-options="
                rownumbers:true,singleSelect:true,autoRowHeight:false,pagination:true,pageSize:10">
            <thead>
            <tr>
                <th field="name" width="80">角色名称</th>
                <th field="code" width="80">角色编码</th>
                <th field="remark" width="80">角色描述</th>
                <th field="updateTime" width="80">注册时间</th>
                <th field="_opt" width="80">操作</th>
            </tr>
            </thead>
        </table>--%>
    </div>
</div>
<div id="addUserDialog"></div>
<%--新增弹框--%>

<div id="addDialog"  style="padding:10px 10px;display: none">
    <form id="fm_tb"  style="width: 100%;margin: 0;padding:0;" method="post">
        <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
            <tr>
                <td  width="100px" class="fm_lable">角色名称:</td>
                <td>
                    <input class="easyui-textbox" name="name" id="roleName" data-options="required:true,validType:['nameCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>

                </td>


            </tr>
            <tr>
                <td  width="100px" class="fm_lable">角色编码:</td>
                <td>
                    <input class="easyui-textbox" name="code" id="roleCode" data-options="required:true,validType:['codeCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkCode" style="display: none;"></label>
                </td>
            </tr>
            <tr>
                <td  width="100px" class="fm_lable">备注:</td>
                <td>
                    <input class="easyui-textbox" id="roleRemark" name="remark" data-options="multiline:true,validType:['maxLength[500]','isBlank']"  style="width: 100%;height: 60px;">
                </td>

            </tr>
        </table>
    </form>
</div>

<%--编辑弹框--%>
<div id="editDialog"  style="padding:10px 10px;display: none">
    <form id="fm_etb"  style="width: 100%;margin: 0;padding:0;" method="post">
        <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed" >
            <tr>
                <td  width="100px" class="fm_lable">角色名称:</td>
                <td>
                    <input class="easyui-textbox" name="name" id="roleName_edit" data-options="required:true,validType:['nameCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>

                </td>


            </tr>
            <tr>
                <td  width="100px" class="fm_lable">角色编码:</td>
                <td>
                    <%--<input class="easyui-validatebox"  validType="codeCheck" name="code" id="roleCode_edit" data-options="required:true" style="width: 100%;disabled:true;">--%>
                        <input class="easyui-textbox"  validType="codeCheck" name="code" id="roleCode_edit" data-options="required:true" style="width: 100%;" disabled="trues">
                    <label class="checkCode" style="display: none;"></label>
                </td>
            </tr>
            <tr>
                <td  width="100px" class="fm_lable">备注:</td>
                <td>
                    <input class="easyui-textbox" id="roleRemark_edit" name="remark" data-options="multiline:true,validType:['maxLength[500]','isBlank']"  style="width: 100%;height: 60px;">
                </td>
                <td style="display: none;" >
                    <input class="easyui-textbox" id="roleId" name="id"  style="width: 176px">
                </td>
            </tr>
        </table>
    </form>
</div>
<%--<div id="addUserDialog2" style="display: none;">
    <div>
        &lt;%&ndash;<label id="roleId"></label>&ndash;%&gt;
        <form id="fm_etb">
            <table class="fm_table"  style="margin: 5px auto">

                <tr>
                    <td  class="fm_lable">角色名称2:</td>
                    <td>
                        <input class="easyui-validatebox" validType="nameCheck['0661c442b2064d91a815f526e5a618fc']" name="name" id="roleName_edit" data-options="required:true" style="width: 176px">
                        <label class="checkName" style="display: none;"></label>
                    </td>
                    <td  class="fm_lable">角色编码:</td>
                    <td>
                        <input class="easyui-validatebox" validType="codeCheck" name="code" id="roleCode_edit" data-options="required:true" style="width: 176px">
                        <label class="checkCode" style="display: none;"></label>
                    </td>

                </tr>
                <tr>
                    <td  class="fm_lable">备注:</td>
                    <td colspan="2">
                        <input class="easyui-validatebox" id="roleRemark_edit" name="remark"  style="width: 176px">
                    </td>
                    <td style="display: none;" >
                        <input class="easyui-validatebox" id="roleId" name="id"  style="width: 176px">
                    </td>

                </tr>


            </table>
        </form>
        <div style="text-align: center">
            <a id="btn_edit" onclick="editRole()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a>
            <a id="btn2_edit" onclick="$('#addUserDialog2').dialog('close')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
        </div>
    </div>
</div>--%>


</body>
</html>
