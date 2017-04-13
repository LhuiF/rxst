/**
 * @author zhaihonghong
 */
/**
 * 弹框对象
  * @type {string}
 */
var dialog = "";
$(document).ready(function () {
    //查询列表的函数
    loadKefuRoleData();

    //点击新增按钮的操作
    $("#addBtn").click(function(){
        dialog =  layer.open({
            type : 1,
            area : ['700px','400px'],
            title :'客服角色新增页面',
            fix: false,
            maxmin: true,
            shade:[0.4,'#000'],
            content : $("#addDiv"),
            end:function(){ //无论是确认还是取消，只要层被销毁了，end都会执行.
                $("#saveForm input[type='text'],textarea").val("");
            }

        });
    });
    //验证角色名称不能为空和是否可用
    $("#saveBtn").bind("click",function(){
        demo.check();
        if(demo.check() == true){
            //保存记录
            var data = $("#saveForm").serialize();
            $.ajax({
                async:false,
                url:basePath+"/kefuRoleCtr/saveKefuRole",
                data:data,
                dataType:"json",
                success:function(data){
                    var status = data.status;
                    if (status == 0){
                        $("#saveForm input[type='text'],textarea").val("");
                        layer.msg(data.message,{icon:1});
                        layer.close(dialog);
                        selectData();
                    }else {
                        layer.msg(data.message,{icon:2});
                    }
                },
                error:function(){
                    layer.msg("保存失败!",{icon:2});
                }
            });
        }else{
            return false;
        }
    });
    var demo = $("#saveForm").Validform({
        tiptype:function(msg,o,cssctl){
            if(!o.obj.is("form")){
                var objtip=o.obj.siblings(".Validform_checktip");
                cssctl(objtip,o.type);
                objtip.text(msg);
            }
        },
        callback:function(){
            //这里可以写 ajax提交后台处理数据
            return false;
        }
    });
});
function loadKefuRoleData(){
    var t =$('#table_id').dataTable({
        "ajax" : {
            "url" : "/kefuRoleCtr/findList",
            "type" : "post",
           // "data" :serialize($("#selectForm").serialize()), //dataTables向后台传data格式只能为json格式
            "dataType" : "json",
        },
        "aoColumns": [
            { "title" : "角色名称" , "data" : "name"},
            { "title" : "角色描述" , "data" : "remark" },
            { "title" : "是否启用" ,"data": "enable","render": function(data){
                if(data==1){
                    return "启用";
                }else if (data==0){
                    return "停用";
                }
            }},//sDefaultContent 为null时替换成Edit
            { "title" : "是否删除" , "data" : "isDelete","render":function(data){
                if (data==1){
                    return "正常";
                }else if (data==0){
                    return "删除";
                }
            }},
            {
                "title" : "操作",
                "render":function (data,type,row) {//行回调
                    return "<a href='javascript:openEditDialog(\""+row.id+"\")' class='operateA'><i class='Hui-iconfont'>&#xe692;</i></a>" +
                        "<a href='javascript:deleteKefuRoleById(\""+row.id+"\")' class='operateA'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
                 }
            },
        ]
    });
}
/**
 *弹出编辑框
 * @param id
 */
function openEditDialog(id){
    dialog = layer.open({
        type : 1,
        area : ['700px','400px'],
        title :'客服角色新增页面',
        fix: false,
        maxmin: true,
        shade:[0.4,'#000'],
        content : $("#updateDiv")
    });
    getKefuRoleById(id);
}
/**
 * 序列化参数  dataTable传递参数需要转换格式
 * @param dataString
 * @returns {*}
 */
function serialize(dataString){
    var JsonData="";
    var o=dataString.split("&");
    for(var i = 0;i < o.length; i++) {
        var ob=o[i].split("=");
        JsonData = JsonData + '\"'+ob[0]+'\":'+'\"'+ob[1]+'\",';
    }
    return $.parseJSON("{"+JsonData.substring(0,JsonData.length-1)+"}");
}
//删除函数 修改isDelete属性的值
function deleteKefuRoleById(id){
    $.ajax({
        async:false,
        url:basePath+"/kefuRoleCtr/updateById",
        data:{
            "id":id,
            "isDelete":"0"
        },
        dataType:"json",
        success:function(data){
            var status = data.status;
            if (status == 0){
                layer.msg(data.message,{icon:1});
                loadKefuRoleData();
            }else {
                layer.msg(data.message,{icon:2});
            }
        },
        error:function(){
            layer.msg("修改失败!",{icon:2});
        }
    });
}
//根据id获取客服角色
function getKefuRoleById(id){
    $.ajax({
        async:false,
        url:basePath+"/kefuRoleCtr/getKefuRoleById",
        data:{
            "id":id
        },
        dataType:"json",
        success:function(data){
            var kefuRole = data.kefuRole;
            $("#updateForm input[name='id']").val(kefuRole.id);
            $("#updateForm input[name='name']").val(kefuRole.name).prop("disabled",true);
            $("#updateForm input[name='code']").val(kefuRole.code).prop("disabled",true);
            $("#updateForm textarea[name='remark']").val(kefuRole.remark);
            var enable = kefuRole.enable;
            $("#updateForm input[name='enable'][value="+enable+"]").attr("checked",true);
            var isDelete = kefuRole.isDelete;
            $("#updateForm input[name='isDelete'][value="+isDelete+"]").attr("checked",true);
        }
    });
}
//修改客服角色信息
function updateKefuRole(){
    var data = $("#updateForm").serialize();
    $.ajax({
        async:false,
        url:basePath+"/kefuRoleCtr/updateById",
        data:data,
        dataType:"json",
        success:function(data){
            var status = data.status;
            if (status == 0){
                layer.msg(data.message,{icon:1});
                layer.close(dialog);
                loadKefuRoleData();
            }else {
                layer.msg(data.message,{icon:2});
            }
        },
        error:function(){
            layer.msg("修改失败!",{icon:2});
        }
    });
}