<%@ page import="com.unionx.sys.user.vo.User" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>人事管理系统</title>

    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${CP}/lib/easyui/themes/metro/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${CP}/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${CP}/css/style.css"/>
    <script type="text/javascript" src="${CP}/lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${CP}/lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${CP}/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${CP}/lib/noty/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="${CP}/js/region.js"></script>
    <style type="text/css">
    .panel-title {
    	background: #A7D7EF;
    }
    /* .btn-save,.btn-edit {
    	background: #217ca6!important;
    } */
    </style>
</head>
<script>
    var basePath = '${CP}';
    var id ='<shiro:principal property="id"/>';
</script>
  <script type = "text/javascript" >
  var card = ${u:getJsonArray("1017")};
  var nation = ${u:getJsonArray("1006")};

</script>


<body class="easyui-layout">
<div data-options="region:'north',title:'',split:false,border:0" style="height:50px;position: relative;z-index: 100;" class="yonghuming">
    <h4 style="float: left;">人事管理系统</h4>
    <%
        //获得昵称，如果没有昵称显示登录名字
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String nickName= StringUtils.isNotBlank(user.getNickname())?user.getNickname():user.getLoginName();
    %>
    <em class="admin" style="right: 25px;float:right;display: inline-block;top: 25px;cursor:pointer;"><a id="openPersonal"><span></span> &nbsp;<i>
        <%=nickName%>
    </i></a></em>
</div>
<div id="header" data-options="region:'west',title:'',split:false,collapsible:false" style="width:190px;">
    <div class="hmenu">
        <ul class="first-ul">
            <c:forEach items="${moduleList}" var="menu">
                <li>
                    <c:if test="${menu.children != null && menu.children != ''}">
                        <a><i style="background:url(${CP}/images/menu/${menu.icon}) no-repeat 15px 12px"></i>${menu.name}<span style="float: right;margin-right: 10px;"><img src="${CP}/images/left.png"></span></a>
                        <ul class="two-ul">
                            <c:forEach items="${menu.children}" var="menu1">
                                <li>
                                   <%-- <c:if test="${menu1.url != null && menu1.url != ''}">--%>
                                        <a href="javascript:loadPage('${CP}${menu1.url}','${menu.name}>${menu1.name}')"><em>${menu1.name}</em></a>
                                    <%--</c:if>--%>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                    <c:if test="${menu.url != null && menu.url != ''}">
                        <a style="height: 40px;" href="javascript:loadPage('${CP}${menu.url}','${menu.name}')"><i style="background:url(${CP}/images/menu/${menu.icon}) no-repeat 15px 12px"></i><em>${menu.name}</em></a>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div id="tabs" data-options="region:'center',title:'<b>首页</b>'" style="padding:5px; ">
    <iframe id="mainFrame" scrolling="auto" frameborder="0" src="${CP}/pages/index_bg.jsp" style="width:100%;height:100%;"></iframe>
</div>

<%--修改密码弹出框--%>
<div id="updatePassword" style="padding:10px 10px;display: none">
    <form id="form" style="width:280px;margin: 0;padding:0;" method="post">
        <table style="width:100%;table-layout:fixed">
            <tr>
                <td width="80px">原密码:</td>
                <td>
                    <input id="passWord" name="passWord" class="easyui-textbox" data-options="editable:true,required:true" type="password" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="80px">新密码:</td>
                <td>
                    <input id="newPassWord" name="newPassWord" class="easyui-textbox" data-options="editable:true,required:true,validType:'safepass'" type="password" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="80px">重复密码:</td>
                <td>
                    <input id="newPassWords" name="newPassWords" class="easyui-textbox" data-options="editable:true,required:true,validType:'checkPassWord'" type="password" style="width: 100%">
                </td>
            </tr>
        </table>
    </form>
</div>



<%--个人信息维护--%>
<div id="personDilog" style="padding:10px 10px;display: none">
    <form id="personData" style="width: 100%;margin: 0;padding:0;" method="post">
        <input type="hidden" value="<shiro:principal property="id"/>" name="id">
        <table class="fm_table" style="width:100%;height: 10%;table-layout:fixed" >
            <tr>
                <td width="50px" class="fm_lable">帐号</td>
                <td colspan="3" width="180px">
                    <input class="easyui-textbox" id="loginName" name="loginName" data-options="required:true" style="width: 100%;">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">姓名</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="name" data-options="required:true,validType:['maxLen[30]','codeSpace']" style="width: 100%;">
                </td>

            </tr>
            <tr>
                <td width="50px" class="fm_lable">昵称</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="nickname" data-options="required:true,validType:['maxLen[30]','codeSpace']" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">所属机构</td>
                <td colspan="3">
                    <input id="organId" name="organName" class="easyui-textbox" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">性别</td>
                <td colspan="3">
                    <select class="easyui-combobox" name="sex" style="width: 100%"
                            data-options="required:true,editable:false,prompt:'请选择',panelHeight:'auto'">
                        <option value=""></option>
                        <c:forEach var="sex" items="${sexList}">
                            <option value="${sex}">${sex}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>

                <td width="50px" class="fm_lable">手机号码</td>
                <td colspan="3">
                    <input class="easyui-numberbox" name="phone"  style="width: 100%;" data-options="required:true,validType:'maxLen[11]'" >
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">年龄</td>
                <td colspan="3">
                    <input class="easyui-numberbox" name="age"
                           data-options="prompt:'请输入数字',validType:'length[1,3]',precision:'0'" min="1"
                           style="width: 100%">
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">岗位类型</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="postName" id="post" style="width: 100%" >
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">所属角色</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="roleName" id="role" style="width: 100%" >
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">证件类型</td>
                <td colspan="3">
                    <input class="easyui-combobox" name="paperType" style="width: 100%" data-options="
                    data:card,
                    valueField:'code',
                    textField:'name',
                    editable:false,
                    panelHeight:'auto',
                    prompt:'请选择'
                ">
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">证件号码</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="paperCode" style="width: 100%"
                            data-options="validType:['maxLen[25]','checkType','codeSpace']">
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">出生日期:</td>
                <td colspan="3">
                    <input class="easyui-datebox" name="birthday" style="width: 100%">
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">婚否</td>
                <td>
                    <input type="radio" name="isMarry" value="1">已婚<input type="radio" value="2" name="isMarry">未婚
                </td>
                <td width="50px" class="fm_lable">民族</td>
                <td>
                    <input class="easyui-combobox" name="nation"  style="width: 100%;height:25px;" data-options="
                    data:nation,
                    valueField:'code',
                    textField:'name',
                    editable:false,
                    prompt:'请选择'
                ">
                </td>
            </tr>
            <td width="50px" class="fm_lable">居住地址</td>
            <td colspan="3" width="180px">
                <input id="province" name="province" data-options="editable:false" style="width: 30%;height:25px;">-
                <input id="city" name="city" data-options="editable:false" style="width: 30%;height:25px;">-
                <input id="area" name="area" data-options="editable:false"  style="width: 30%;height:25px;">

            </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">详细地址</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="address" style="width: 100%;height: 40px" data-options="
                           multiline:true,
                            validType:'maxLen[150]'
                           ">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">邮箱</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="email"  style="width: 100%"  data-options="validType:['email','maxLen[50]']">
                </td>
            <tr>
            <tr>
                <td width="50px" class="fm_lable">联系电话</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="tel" data-options="validType:['mpNumber','maxLength[15]']" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">QQ号码</td>
                <td colspan="3">
                    <input class="easyui-numberbox" name="qq" data-options="validType:'maxLen[15]'" style="width: 100%">
                </td>
            </tr>
            <tr>
                <td width="50px" class="fm_lable">个人简介</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="remark" data-options="multiline:true,validType:'maxLen[1000]'" style="width: 100%;height: 60px;">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
<script type="text/javascript" src="${CP}/js/page/index.js"></script>
</html>
<div id="personal" class="personxinxi">
    <ul>
        <li><a onclick="openPersonDialog()">个人信息</a></li>
        <li><a onclick="openUpdatePassword()">修改密码</a></li>
        <li><a onclick="logout()">退出</a></li>
    </ul>
</div>