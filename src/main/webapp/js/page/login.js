//初始化
$(function(){
    $("#ck_rmbUser").attr("checked", $.cookie("ck_rmbUser"));
    $("#loginName").val($.cookie("loginName"));
    $("#openEditDialog").hide();
    $("#forgetPasswordDialog").hide();
    clearTimeout(t);
    document.getElementById("verification").removeAttribute("disabled");
    document.getElementById("verification").value = "获取验证码";
    //document.getElementById("verification").setAttribute("disabled", "disabled");
});

//记住用户名密码
function rememberUser() {
    if ($("#ck_rmbUser").is(':checked')) {
        var username = $("#loginName").val();
        $.cookie("loginName", username, {expires: 365});
        $.cookie("ck_rmbUser", true, {expires: 365});
    }else{
        $.removeCookie("loginName");
        $.removeCookie("ck_rmbUser");
    }
}

/**
 *  登录
 *  @author abner
 */
function login() {
    rememberUser();
    if ($("#loginName").val() == "" || $("#password").val() == "") {
        $(".error").html("请输入您的用户名和密码!");
        $(".error").css("visibility", "visible");
        return false;
    }
    var params = {"username": $("#loginName").val(), "password": $("#password").val()};
    $.ajax({
        type: 'POST',
        dataType: "JSON",
        data: params,
        url: CP + '/login',
        success: function (data) {
            if(data.message == "STORE_NO_PASS"){
                storeNoPass($("#loginName").val());
            }else if (data.success) {
                window.location.href = "index";
            }else{
                $(".error").html(data.message);
                $(".error").css("visibility", "visible");
                $("#password").val("");
            }
        },
        error: function (data) {
            $(".error").html("好像出现了问题，请与管理员联系!");
            $(".error").css("visibility", "visible");
            $("#password").val("");
        }
    });
};
var storeId;
/**
 * 店家审核不通过
 * @param loginName
 */
function storeNoPass(loginName){
    $.ajax({
        type: 'POST',
        dataType: "JSON",
        data: {"loginName": loginName},
        url: CP + '/storeInfo/storeNoPass',
        success: function (data) {
            console.log(data.data);
            storeId = data.data.id;
            if(data.data.isHost == 1){
                $("#skip").show();
            }else {
                $("#skip").hide();
            }
            $("#storeLoginName").html(loginName);
            $("#checkContent").html("未通过原因："+ data.data.checkContent);
        }
    });
    $("#openEditDialog").show();
};
/**
 * 关闭店家审核不通过对话框
 */
function closeStoreNoPass(){
    $("#openEditDialog").hide();
};
/**
 *跳转店家审核
 */
function skip(){
    window.location.href= CP+"/storeInfo/storeRegister?storeId="+storeId;
};
/**
 *  监听回车事件
 *  @author abner
 */
document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 13) { // enter 键
        login();
    }
};
/**
 *根据帐号查询手机号发送验证码
 */
function pushCode(){
    $("#loginNameNo").html("");
    $("#codeNo").html("");
    $("#verificationNo").html("");
    $("#forgetPasswordNo").html("");
    $("#forgetPasswordsNo").html("");
    if($("#forgetLoginName").val() == '' || $("#forgetLoginName").val() == null){
        $("#loginNameNo").html("请输入帐号");
        return;
    }
    $.ajax({
        type: 'POST',
        dataType: "JSON",
        data: {"loginName": $("#forgetLoginName").val(),"kefuorstore":$("#kefuorstore").val()},
        url: CP + '/account/getPhonenumberAndVerifycodeByAccount',
        success: function (data) {
            if(data.success){
                if (data.data.phone != null && data.data.phone != "") {
                    $("#verificationNo").html("验证码将发送到您" + data.data.phone.substr(0,3)+"****"+ data.data.phone.substr(7) + "的手机上。");
                    settime();
                }
            }else {
                $("#loginNameNo").html("帐号不存在");
            }
        }
    });
};
/**
 * 按钮倒计时
 * @param obj
 */
var countdown = 60;
var t;
function settime() {
    if (countdown == 0) {
        document.getElementById("verification").removeAttribute("disabled");
        document.getElementById("verification").value = "获取验证码";
        countdown = 60;
        return;
    } else {
        document.getElementById("verification").setAttribute("disabled", "disabled");
        document.getElementById("verification").value = "重新发送(" + countdown + ")";
        countdown--;
    }
    t = setTimeout(function () {settime()}, 1000);
};
function openForgetPassword(){
    $("#forgetPasswordDialog").show();
    $("#forgetLoginName").val("");
    $("#code").val("");
    $("#forgetPassword").val("");
    $("#forgetPasswords").val("");
    $("#loginNameNo").html("");
    $("#verificationNo").html("");
    $("#forgetPasswordNo").html("");
    $("#forgetPasswordsNo").html("");
    $("#codeNo").html("");
};
function closeForgetPassword() {
    $("#forgetPasswordDialog").hide();
    clearTimeout(t);
    document.getElementById("verification").removeAttribute("disabled");
    document.getElementById("verification").value = "获取验证码";
};

function forgetPassword(){
    $("#loginNameNo").html("");
    $("#codeNo").html("");
    $("#forgetPasswordNo").html("");
    $("#forgetPasswordsNo").html("");
    if ($("#forgetLoginName").val() == '' || $("#forgetLoginName").val() == null) {
        $("#loginNameNo").html("请输入帐号");
        return;
    }
    if ($("#code").val() == '' || $("#code").val() == null) {
        $("#codeNo").html("请输入验证码");
        return;
    }
    if ($("#forgetPassword").val() == '' || $("#forgetPassword").val() == null) {
        $("#forgetPasswordNo").html("请输入密码");
        return;
    }
    if ($("#forgetPassword").val() != $("#forgetPasswords").val()) {
        $("#forgetPasswordsNo").html("两次密码输入不一致,请重新输入");
        return;
    }
    if(!(/^(?![^0-9]+$)(?![^a-zA-Z]+$).+$/.test($("#forgetPassword").val())) || !(/^[A-Za-z0-9]+$/.test($("#forgetPassword").val())) || (/^(.{0,5})$/.test($("#forgetPassword").val()))){
        $("#forgetPasswordNo").html("密码由字母和数字组成，至少6位");
        return;
    }
    $.ajax({
        type: 'POST',
        dataType: "JSON",
        data: {"loginName": $("#forgetLoginName").val(), "password": $("#forgetPassword").val(),"code":$("#code").val()},
        url: CP + '/account/forgetPassword',
        success: function (data) {
            if (data.success) {
                closeForgetPassword();
            }else{
                $("#codeNo").html("验证码错误或已失效");
            }
        }
    });
}