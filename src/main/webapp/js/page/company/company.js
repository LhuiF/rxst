
function save() {
    $('#myForm').form('submit', {
        url: basePath + '/companyController/save',
        method: "post",
        onSubmit: function () {
            $.messager.progress({
                title: "处理中,请稍候...."
            });
            //校验表单
            var isValid = $(this).form("validate");
            if (!isValid) {//校验不通过关提示信息
                $.messager.progress("close");
            }
            return isValid;
        },
        success: function (result) {
            $.messager.progress("close");
            var data = eval('(' + result + ')');
            if (data.success) {
                noty({text: data.message, timeout: 2000});
            } else {
                $.messager.alert("错误", data.message, "error");
            }
        }
    });

}


$.extend($.fn.validatebox.defaults.rules, {
    nameCheck:{
        validator: function (value, param) {
            var json = {"name":value};
            var resp = $.ajax({
                type:"POST",
                url:basePath+"/companyController/validate",
                data:json,
                async : false,
                cache : false,
                dataType:"json"
            }).responseText;
            return resp == "true";
        },
        message: '【该公司名称已存在，请重新输入】'
    },
    mpNumber: {
        validator: function (value, param) {
            return /(^\d{3,4}\-\d{7,8}$)|(^1\d{10}$)/g.test(value);
        },
        message: '请输入正确的电话号码,如：0591-6487256，15005059587'
    },

        qqCheck: {
        validator: function (value, param) {
            return /(^[1-9][0-9]{4,9}$)/g.test(value);
        },
        message: 'qq格式不正确'
    },

    emailCheck: {
        validator: function (value, param) {
            return /(^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$)/g.test(value);
        },
        message: '邮箱格式不正确'
    },

    phoneCheck:{
        validator: function (value, param) {
            return /(^1[34578]\d{9}$)/g.test(value);
        },
        message: '手机格式不正确'
    }


})



