<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>用户管理</title>
    <script type="text/javascript" src="${CP}/js/page/user/user.js"></script>

    <script type="text/javascript">
        var organCombotreeData = ${u:getOrganTreeData()};
        var organIdToName = ${u:organIdToNameMap()};
        var allRole = ${u:allRole()};
        var allpost = ${u:getJsonArray("1003")};
        var postCodeToName = ${u:getJsonMap("1003")};
        var userId = '<shiro:principal property="id"/>';
    </script>
    <%-- 按钮模板--%>
    <script id="optBtns" type="text/html">
        <a  href="javascript:editorUser('{{id}}')">编辑</a>
        <a  href="javascript:resetPassword('{{id}}')">重置密码</a>
        <a  href="javascript:deleteUser('{{id}}')">删除</a>
    </script>
    <%-- 按钮模板--%>
    <script id="supOptBtns" type="text/html">
        <a href="javascript:editorUser('{{id}}')">编辑</a>
        <a href="javascript:resetPassword('{{id}}')">重置密码</a>
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            姓名：<input class="easyui-textbox" name="name"  id="name" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            帐号：<input class="easyui-textbox" name="loginName" id="loginName" maxlength="30" style="width:140px">
        </label>
        <label style="padding: 0 5px">
            联系方式：<input class="easyui-textbox" name="phone" id="phone"  style="width:140px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="initDatagrid();">查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAddUser()" class="easyui-linkbutton" >新增</a>
        </div>
        <table id="datagrid"></table>
    </div>
</div>

<!-- 新增对话框 -->
<div id="dlg"   style="padding:10px 10px;display: none">
    <form id="userData" style="width: 100%;margin: 0;padding:0;" method="post">
    <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
        <tr>
            <td width="100px" class="fm_lable">姓名</td>
            <td >
                <input id="userName" name="name" class="easyui-textbox"  style="width: 100%" data-options="required:true,validType:['nameSpace','maxLength[15]']">
            </td>
            <td width="100px" class="fm_lable">帐号</td>
            <td >
                <input class="easyui-textbox" id="loginNames" name="loginName"  style="width: 100%" data-options="
                required:true,
                validType:['codeSpace','loginNameCheck','maxLength[30]','loginCheck']

                ">
            </td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">性别</td>
            <td >
                <select class="easyui-combobox" name="sex"  style="width: 100%" data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
                    <option value=""></option>
                    <c:forEach var="sex" items="${user}">
                        <option value="${sex}">${sex}</option>
                    </c:forEach>
                </select>
            </td>
            <td width="100px"  class="fm_lable">密码</td>
            <td >
                <input id="password" type="password" name="password" class="easyui-textbox"  style="width: 100%" data-options="
                required:true,
                validType:['safepass','maxLength[30]']
                ">
            </td>
        </tr>
        <tr>
            <td width="100px"  class="fm_lable">联系方式</td>
            <td >
                <input name="phone"  class="easyui-textbox"   style="width: 100%" data-options="required:true,validType:['mobilePhone']">
            </td>
            <td width="100px"  class="fm_lable">确认密码</td>
            <td >
                <input id="rpassword" name="rpassword" type="password" class="easyui-textbox"  style="width: 100%" data-options="required:true" validType="equalsPwd['#password']">
            </td>
        </tr>

        <tr>
            <td width="100px" class="fm_lable">所属机构</td>
            <td >
                <input id="organId" name="organId" class="easyui-combotree"  style="width: 100%" data-options="
                  required:true,
                  editable:false,
                  prompt:'请选择'
                 ">
            </td>
            <td width="100px" class="fm_lable">岗位</td>
            <td >
                <input  id="postId" name="post" class="easyui-combobox"  style="width: 100%" data-options="
                required:true,
                     data:allpost,
                     valueField:'code',
                     textField:'name',
                     editable:false,
                     prompt:'请选择'
                ">
            </td>
        </tr>
        <tr>
            <td width="100px" class="fm_lable">昵称</td>
            <td >
                <input id="nickname"  name="nickname" class="easyui-textbox"  style="width: 100%" data-options="required:true,validType:['nameSpace','maxLength[15]']">
            </td>
            <td width="100px" class="fm_lable">角色</td>
            <td> <%--multiple :true,--%>
                <input class="easyui-combobox" id="roleId" name="roleIdList" style="width: 100%"  data-options="
                    required:true,
                    data:allRole,
                    valueField:'id',
                    textField:'name',
                    editable:false,
                    prompt:'请选择'
                ">
            </td>
        </tr>
        <tr>
            <td width="100px" class="fm_lable">是否领导</td>
            <td>
                <select id="setVlaue" class="easyui-combobox" name="leader" style="width: 100%"
                        data-options="required:true,editable:false,panelHeight:'auto'">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </td>
            <td width="100px" class="fm_lable">办公电话</td>
            <td >
                <input id="tel"  name="tel" class="easyui-textbox"  style="width: 100%" data-options="required:true">
            </td>
        </tr>
        <tr>
            <td width="100px" class="fm_lable">备注</td>
            <td  colspan="3">
                <input id="remark" name="remark" class="easyui-textbox"  style="width: 100%;height: 80px;"  data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">
            </td>
        </tr>
    </table>
    </form>
</div>
<!-- 编辑对话框 -->
<div id="editorDlg" style="padding:10px 10px;display: none">
    <form id="editorUserData" style="width: 100%;margin: 0;padding:0;" method="post">
        <input name="id" type="hidden">
        <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
            <tr>
                <td width="100px" class="fm_lable">姓名</td>
                <td>
                    <input  name="name" class="easyui-textbox" style="width: 100%"
                           data-options="required:true,validType:['nameSpace','maxLength[15]']">
                </td>
                <td width="100px" class="fm_lable">帐号</td>
                <td>
                    <input type="hidden" id="log" name="loginName" style="width: 100%">
                    <input class="easyui-textbox" id="editorLoginName" name="loginName" style="width: 100%" >

                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">性别</td>
                <td>
                    <select class="easyui-combobox" name="sex" style="width: 100%"
                            data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
                        <option value=""></option>
                        <c:forEach var="sex" items="${user}">
                            <option value="${sex}">${sex}</option>
                        </c:forEach>
                    </select>
                </td>
                <td width="100px" class="fm_lable">所属机构</td>
                <td>
                    <input id="editorOrganId" name="organName" class="easyui-textbox" style="width: 100%">
                    <input type="hidden" id="organIds" name="organId" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">联系方式</td>
                <td>
                    <input name="phone" class="easyui-textbox" style="width: 100%"
                           data-options="required:true,validType:['mobilePhone']">
                </td>
                <td width="100px" class="fm_lable">岗位</td>
                <td>
                    <input id="editorPostId" name="postName" class="easyui-textbox" style="width: 100%">
                    <input type="hidden" id="post" name="post" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">昵称</td>
                <td>
                    <input  name="nickname" class="easyui-textbox" style="width: 100%"
                           data-options="required:true,validType:['nameSpace','maxLength[15]']">
                </td>
                <td width="100px" class="fm_lable">角色</td>
                <td>
                    <input class="easyui-textbox" id="editorRoleId" name="roleName" style="width: 100%" >
                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">是否领导</td>
                <td>
                    <select class="easyui-combobox" name="leader" style="width: 100%"
                            data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="100px" class="fm_lable">备注</td>
                <td colspan="3">
                    <input name="remark" class="easyui-textbox" style="width: 100%;height: 80px;"
                           data-options="
                multiline:true,
                validType:'maxLength[1000]'
                ">
                </td>
            </tr>
        </table>
    </form>
</div>




</body>
</html>