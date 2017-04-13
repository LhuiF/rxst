$(function(){
    initDatalist();
    initTree();
})
function initDatalist(){
    $("#dataList").datalist({
        url: basePath+'/auth/getAllRole',
        method:'get',
        checkbox: true,
        lines: true,
        valueField:'id',
        textField:'name',
        border:0,
        fit:true,
        onSelect:show
    });
}
var roleId="";
function show(index, row){
    roleId=row.id
    var url = basePath+"/auth/getListByRoleId.do";
    //获取当前角色有权限的功能模块id
    $.post(url,{"roleId":roleId},function(moduleIdList) {
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        var nodes = treeObj.getNodes();
        //客服手机后台
        var treeObjPhone = $.fn.zTree.getZTreeObj("phoneTree");
        var phonenodes = treeObjPhone.getNodes();
        treeObjPhone.checkAllNodes(false);
        //全部设置为不选中
        treeObj.checkAllNodes(false);
        //根据权限判断选中
        for(var m=0;m<moduleIdList.length;m++) {
            var mi =moduleIdList[m].code;
            //根据节点id找到节点
            var node = treeObj.getNodeByParam("id",mi,null);
            if(node == null) {
                continue;
            }
            if(node.isParent) {
                continue;
            }
            if(null != node){
                //设置节点选中
                treeObj.checkNode(node, true, true);
            }
        }
        //根据客服手机后台权限判断选中
        for(var m=0;m<moduleIdList.length;m++) {
            var mi =moduleIdList[m].code;
            //根据节点id找到节点
            var phonenode = treeObjPhone.getNodeByParam("id",mi,null);
            if(phonenode == null){
                continue;
            }
            if(phonenode.isParent){
                continue;
            }
            if(null != phonenode){
                //设置节点选中
                treeObjPhone.checkNode(phonenode, true, true);
            }
        }
    },"json");
}
var ztree=null ;
var phoneTree=null;
function initTree(id){
    var setting ={
        check: {
            enable: true,
            chkStyle: "checkbox",
            chkboxType: { "Y": "ps", "N": "ps" }
        },
        callback : {
            beforeCheck: zTreeOnClick,
            onCheck:zTreeCheck
        }
    };
    ztree = $.fn.zTree.init($("#tree"), setting, moduleTreeData);
    phoneTree = $.fn.zTree.init($("#phoneTree"), setting, modulePhoneTreeData);

}
function zTreeOnClick( treeId, treeNode){
    return true;
}
function zTreeCheck(event, treeId, treeNode){

}
function saveData(){
    if(roleId ==""){
        noty({text:"请选择角色！",timeout:3000});
        return;
    }
    //获取所有选中节点
    var selectnodes = ztree.getCheckedNodes();
    //获取所有手机后台选中节点
    var selectphonenodes = phoneTree.getCheckedNodes();
    //console.log(selectnodes);
    //console.log(selectphonenodes);
    var html="";
    for(var i=0;i<selectnodes.length;i++){
        html += (selectnodes[i].id+",");
    }
    console.log(html);
    var htmlphone = "";
    for(var i=0;i<selectphonenodes.length;i++){
        htmlphone += (selectphonenodes[i].id+",");
    }
    console.log(htmlphone);
    html = html + htmlphone;
    $.ajax({
        url:basePath+"/auth/save.do",
        type:"post",
        data:"data="+html+"&roleId="+roleId,
        dataType:"json",
        success:function(data){
            noty({text:data.message,timeout:3000});
        },
        error:function(e){
            noty({text:'保存数据失败!',timeout:3000});
        }
    })
}