/**
 * Created by abner on 2016/5/19.
 */
/*弹出iframe*/
function loadPage(url, titleName) {
    $(".panel-title").html("<b>" + titleName + "</b>");
    $("#mainFrame").attr("src", url);
};

/*退出登录*/
function logout() {
        window.location = "logout";
};

/*弹出修改密码窗口*/
function openUpdatePassword() {
    $("#form").form("clear");
    $('#updatePassword').dialog({
        title: "修改密码",
        closed: false
    });
};

/*校验两次密码是否重复*/
$.extend($.fn.validatebox.defaults.rules, {

    checkPassWord : {
        validator : function (value, param) {
            if(value == $("#newPassWord").val())
            return true;
        },
        message: "两次输入密码不匹配！"
    },
    checkType: {
        validator: function (value, param) {
            if ($("input[name='paperType']").val() != "") {
                return true
            }
        },
        message: '请选择证件类型!'
    },
    maxLen: {
        validator: function (value, param) {
            return value.length <= param[0];
        },
        message: '最大只能输入 {0} 字符'
    },
    codeSpace: {
        validator: function (value, param) {
            var reg = /\s/;
            if (!reg.test(value)) {
                return true;
            }
        },
        message: '不允许有空格!'
    },
    safepass: {
        validator: function (value, param) {
            return !(!(/^(?![^0-9]+$)(?![^a-zA-Z]+$).+$/.test(value)) || !(/^[A-Za-z0-9]+$/.test(value)) || (/^(.{0,5})$/.test(value)));
        },
        message: '密码由字母和数字组成，至少6位'
    },
    mpNumber: {
        validator: function (value, param) {
            //return /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[6|8|9])\d{8}$)/.test(value);
            // return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(1\d{10})/.test(value);
            return /(^\d{3,4}\-\d{7,8}$)|(^1\d{10}$)/g.test(value);
        },
        message: '请输入正确的电话号码,如：0591-6487256，15005059587'
    },
    nameSpace: {
        validator: function (value, param) {
            var reg = /^[\s]|[\s*]+$/;
            if (!reg.test(value)) {
                return true;
            }
        },
        message: '前后不允许有空格!'
    },
    idCard: {
        validator: function (value, param) {
            var flag = isCardID(value);
            return flag == true ? true : false;
        },
        message: '不是有效的身份证号码！'
    },
    phoneVal: {
        validator: function (value, param) {
            //return /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[6|8|9])\d{8}$)/.test(value);
            // return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(1\d{10})/.test(value);
            return /(^1\d{10}$)/g.test(value);
        },
        message: '请输入正确的电话号码,如:15005059587'
    }

});

/*初始化*/
$(function () {

    openPersonal();
    initDialog();
    menuInit();
    initPersonDialog();
    $(".datebox :text").attr("readonly", "readonly");
});

/*openPersonal 弹出层定位*/
function openPersonal(){
    $('#openPersonal').tooltip({
        position: 'bottom',
        content: $("#personal"),
        showEvent: 'mouseenter',
        onShow: function () {
            var t = $(this);
            t.tooltip('tip').unbind().bind('mouseenter', function () {
                t.tooltip('show');
            }).bind('mouseleave', function () {
                t.tooltip('hide');
            });
        }
    });
};

/**
 * 初始化对话框
 */
function initDialog() {
    $('#updatePassword').dialog({
        width: 320,
        height: 180,
        closed: true,
        resizable: true,
        cache: false,
        border: 'thin',
        modal: true,
        buttons: [{
            text: '保存',
            handler: function () {
                updatePassword();
            }
        }, {
            text: '取消',
            handler: function () {
                $('#updatePassword').dialog('close');
            }
        }],
        onClose: function () {
            $("#form").form("clear");
        }
    });
};

/*form提交 修改密码*/
function updatePassword(){
    $('#form').form("submit", {
        url: basePath + "/account/updatePassWord",
        onSubmit: function () {
            $.messager.progress({title: "处理中，请稍后...."});
            //校验表单
            var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            }
            return isValid;
        },
        success: function (result) {
            result = $.parseJSON(result);
            $.messager.progress("close");
            if (result.success) {
                noty({text: result.message, timeout: 3000});
                $('#updatePassword').dialog('close');
            } else {
                $.messager.alert("错误", result.message, "error");
            }
        }
    });
};
/*初始化菜单事件*/
function menuInit(){
    $('.first-ul a').click(function (event) {
        if($(this).next('ul').css("display") == 'none'){
            $('.cur').children("span").children("img").attr("src",basePath+"/images/left.png");
            $('.cur').next('ul').css("display", "none");
            $('.cur').parent("li").css("height", 41);
            $('.two-ul').parent("li").css("height", 41);
            $(this).next('ul').css("display","block");
            var hei = $(this).next('ul').height() + 41;
            $(this).parent("li").css("height", hei);
            $(this).children("span").children("img").attr("src",basePath+"/images/down.png");
            $('.cur').removeClass('cur');
            $(this).addClass('cur');
        }else if ($(this).next('ul').css("display") == 'block') {
            $(this).next('ul').css("display", "none");
            $(this).parent("li").css("height", 41);
            $(this).children("span").children("img").attr("src",basePath+"/images/left.png");
        }else {
            if($(this).parents('.two-ul').css("display") != 'block'){
                $('.cur').children("span").children("img").attr("src",basePath+"/images/left.png");
                $('.cur').next('ul').css("display", "none");
                $('.cur').parent("li").css("height", 41);
                $('.two-ul').parent("li").css("height", 41);
                $('.two-ul').css("display", "none");
            }
        };
    });
};

/**
 * 打开个人资料框
 */
function openPersonDialog() {

    var $form = $("#personData");
    $('#loginName').textbox('disable');
    $('#organId').combotree('disable');
    $('#post').combobox('disable');
    $('#role').combobox('disable');
    var url = basePath + "/userController/getUserById";
    $.post(url, {id: id}, function (res) {
        $form.form("disableValidation");

        if (res.success) {
            $('#personDilog').dialog({
                title: "个人资料维护",
                closed: false
            })
            region.initProvince("province", "city", "area", res.data.province, res.data.city, res.data.area);
            $form.form("load", res.data);

        } else {
            $.messager.alert("错误", res.message, "error");
        }
        $form.form("enableValidation");
    }, "json");
}
/**
 * 个人资料维护
 */
function initPersonDialog() {
    $('#personDilog').dialog({
        title: '个人资料维护',
        width: 700,
        height: 550,
        closed: true,
        cache: false,
        resizable: true,
        modal: true,
        buttons: [{
            text: '修改',
            handler: function () {
                updatePersonData();
            }
        }, {
            text: '取消',
            handler: function () {
                cancel();
            }
        }],
        onClose: function () {
            $("#personData").form("clear");
        }
    });
}
/**
 * 修改个人资料
 */
function updatePersonData(){
    $('#personData').form('submit', {
        url: basePath + '/userController/updatePerson',
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
            //校验表单
            var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            } else {
                $.messager.progress("close");
            }
            return isValid;
        },
        success: function (result) {
            var data = eval('(' + result + ')');
            if (data.success) {
                $('#personData').form('clear');
                $('#personDilog').dialog('close');
                noty({text: data.message, timeout: 2000});
            } else {
                $.messager.alert("错误", data.message, "error");
            }
        }
    });
}
/**
 * 取消
 */
function cancel(){
    $('#personData').form('clear');
    $('#personDilog').dialog('close');
}

function breadcrumb(name){
    var html = $(".panel-title").find("b").html()+">"+name;
    $(".panel-title").find("b").html(html);
}

/**
 * 校验身份证
 * @param sId
 */
function isCardID(idCard) {
    var iSum = 0;
    var info = "";
    var aCity = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    }
    if (!/^\d{17}(\d|x)$/i.test(idCard)) {
        return "你输入的身份证长度或格式错误";
    }
    idCard = idCard.replace(/x$/i, "a");
    if (aCity[parseInt(idCard.substr(0, 2))] == null) {
        return "你的身份证地区非法";
    }
    sBirthday = idCard.substr(6, 4) + "-" + Number(idCard.substr(10, 2)) + "-" + Number(idCard.substr(12, 2));
    var d = new Date(sBirthday.replace(/-/g, "/"));
    if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) {
        return "身份证上的出生日期非法";
    }
    for (var i = 17; i >= 0; i--) {
        iSum += (Math.pow(2, i) % 11) * parseInt(idCard.charAt(17 - i), 11);
    }
    if (iSum % 11 != 1) {
        return "你输入的身份证号非法";
    }
    return true;
    //aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女")
}