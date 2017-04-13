<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>消息提醒管理</title>
    <%@include file="../resources.jsp"%>
    <script type="text/javascript" src="${CP}/js/page/prompt/prompt.js"></script>
    <script id="optBtns" type="text/html">
        <a href="javascript:openEditDialog('{{promptId}}')">编辑</a>
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'',split:false,border:1" style="margin-bottom: 10px;padding:10px">
        <label style="padding: 0 5px">
            消息名称：<input class="easyui-textbox" name="name"  id="searchName" style="width:100px">
        </label>
        <label style="padding: 0 5px">
            编码：<input class="easyui-textbox" name="loginName" id="searchCode"  style="width:100px">
        </label>
        <a href="#" class="easyui-linkbutton" onclick="searchData();" >查询</a>
    </div>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="openAdd()" class="easyui-linkbutton" >新增</a>
        </div>
        <table id="datagrid"></table>
    </div>
</div>
<%--新增弹框--%>
<div id="addDialog"  style="padding:10px 10px;display: none">
    <form id="fm_tb"  style="width: 100%;margin: 0;padding:0;" method="post">
        <table class="fm_table" style="width:100%;height: 100%;table-layout:fixed">
            <tr>
                <td  width="100px" class="fm_lable">消息名称:</td>
                <td>
                    <input name="name" id="promptName"  class="easyui-textbox" style="width: 100%" data-options="required:true,validType:['maxLength[30]','nameCheck','nameSpace']"  >
                    <label class="checkName" style="display: none;"></label>
                </td>
                <td  width="100px" class="fm_lable">消息编码:</td>
                <td>
                    <input class="easyui-textbox"  name="code" id="promptCode" data-options="required:true,validType:['maxLength[30]','codeCheck','codeSpace']" style="width: 100%">
                    <label class="checkCode" style="display: none;"></label>
                </td>
            </tr>
            <tr>
                <td  width="100px" class="fm_lable">消息描述:</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true,validType:['maxLength[300]']" id="promptContent" name="content" style="width:100%;height: 80px;">
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
                <td  width="100px" class="fm_lable">消息名称:</td>
                <td>
                    <input class="easyui-textbox" validType="nameCheck" name="name" id="promptName_edit" data-options="required:true,validType:['maxLength[30]','nameCheck','nameSpace']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>
                <td  width="100px" class="fm_lable">消息编码:</td>
                <td>
                    <input class="easyui-textbox"  validType="codeCheck" name="code" id="promptCode_edit" data-options="required:true" style="width: 100%;" disabled="trues">
                    <label class="checkCode" style="display: none;"></label>
                </td>
            </tr>
            <tr>
                <td  width="100px" class="fm_lable">消息描述:</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true,validType:'maxLength[300]'" id="promptContent_edit" name="content"  style="width: 100%;height: 80px;">
                </td>
                <td style="display: none;" >
                    <input class="easyui-validatebox" id="promptId" name="id"  style="width: 176px">
                </td>
                
            </tr>
        </table>
    </form>
</div>
<input type="hidden" id="flgValid">
</body>
</html>
