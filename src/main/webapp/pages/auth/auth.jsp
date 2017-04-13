<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>功能权限管理</title>
    <%@ include file="../resources.jsp"%>
    <link href="${CP}/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${CP}/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="${CP}/js/page/auth/auth.js"></script>
    <script type="text/javascript">
        var basePath="${CP}";
        var moduleTreeData = ${u:getModuleZtreeData('1')};
        var modulePhoneTreeData = ${u:getModuleZtreeData('4')};
    </script>
</head>
<body style="width: 100%;margin: 0 auto">
<div class="easyui-layout" data-options="fit:true,border:0">
    <!--左侧-->
    <div data-options="region:'west',split:true,checkbox:true,onClickRow:show,onSelect:show" style="width:20%;">
        <div id="dataList"  ></div>
    </div>
    <div data-options="region:'center'" >
        <div id="tt" class="easyui-layout">
            <div id="tb" style="padding:5px;height:auto">
                <div style="margin-bottom:5px">
                    <a href="#" class="easyui-linkbutton"  onclick="saveData()">保存</a>
                </div>
            </div>
            <ul id="tree" class="ztree" style="width:300px; overflow:auto;"></ul>
            <ul id="phoneTree" class="ztree" style="width:300px; overflow:auto;"></ul>
        </div>
    </div>
</div>
</body>
</html>