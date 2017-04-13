<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2016/10/31
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="../resources.jsp"/>
    <title>公司信息</title>
    <script type="text/javascript" src="${CP}/js/page/company/company.js"></script>
</head>
<body>
<div style="padding:50px 300px;">
    <form style="width: 100%;margin: 0;padding:0;" method="post" id="myForm">
        <table style="width:100%;height: 400px;table-layout: fixed">
            <tr>
                <td style="width:56px;" >
                    <lable>
                        <span style="font-family:'', '', '应用字体';color:#FF0000;">*</span><span style="font-family:'', '', '应用字体';color:#333333;">公司名称</span>
                    </lable>
                </td>
                <td width="400px;">
                    <input class="easyui-textbox" name="name" id="name" data-options="required:true,validType:['nameCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>
            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';color:#FF0000;">*</span><span style="font-family:'', '', '应用字体';color:#333333;">联系人</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="connection_user" id="connection_user" data-options="required:true,validType:['maxLength[100]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>
            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';color:#FF0000;">*</span><span style="font-family:'', '', '应用字体';color:#333333;">手机号</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="phone" id="phone" data-options="required:true,validType:['phoneCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>
            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';color:#FF0000;">*</span><span style="font-family:'', '', '应用字体';color:#333333;">邮箱</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="email" id="email" data-options="required:true,validType:['emailCheck','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>
            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';color:#FF0000;">*</span><span style="font-family:'', '', '应用字体';color:#333333;">QQ</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="qq" id="qq" data-options="required:true,validType:['qqCheck','maxLength[20]','isBlank']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>


            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';">办公电话</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="tel" id="tel" data-options="required:true,validType:['mpNumber']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>

            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';">详</span><span style="font-family:'', '', '应用字体';">细地址</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="address" id="address" data-options="required:true,validType:['maxLength[500]']" style="width: 100%">
                    <label class="checkName" style="display: none;"></label>
                </td>

            </tr>

            <tr>
                <td>
                    <label>
                        <span style="font-family:'', '', '应用字体';">备注</span>
                    </label>
                </td>
                <td>
                    <input class="easyui-textbox" name="remark" id="remark"style="width: 100%;height: 80px;"  data-options="
                multiline:true,
                validType:'maxLength[550]'
                ">

                </td>

            </tr>


        </table>
    </form>
    <div data-options="region:'center',border:0">
        <div id="tb">
            <a id="btn_add" onclick="save()" class="easyui-linkbutton" style="float:right">保存</a>
        </div>

    </div>

</div>

</body>
</html>
