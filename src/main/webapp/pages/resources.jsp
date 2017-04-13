<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://www.unionx.cn" %>

<!-- easyui CSS -->
<link rel="stylesheet" type="text/css" href="${CP}/lib/easyui/themes/metro/easyui.css"/>

<link rel="stylesheet" type="text/css" href="${CP}/css/style.css"/>

<!-- jquery -->
<script type="text/javascript" src="${CP}/lib/easyui/jquery.min.js"></script>

<!-- easyui js -->
<script type="text/javascript" src="${CP}/lib/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${CP}/lib/easyui/locale/easyui-lang-zh_CN.js"></script>

<!-- artTemplate -->
<script type="text/javascript" src="${CP}/lib/template.js"></script>

<!-- noty插件 -->
<script type="text/javascript" src="${CP}/lib/noty/jquery.noty.packaged.min.js"></script>


<script type="text/javascript">
    var basePath = '${CP}';
    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        complete: function (xhr, textStatus) {
            if (undefined != xhr.responseText && xhr.responseText.indexOf("ajaxtiaozhuangdengl") > 0) {
                window.location.href = basePath + "/login";
            }
        }
    });


    /**
     * 将表单数据转成json对象
     * 使用方法：$("#formId").serializeJson()
     * 转换完的格式为:{age: "b",name: "a"}
     * 如果有多选框转换格式为：{age: "aa",interest: ["interest2", "interest4"],name: "dd",vehicle:["Bike","Car"]}
     */
    (function ($) {
        $.fn.serializeJson = function () {
            var serializeObj = {};
            var array = this.serializeArray();
            var str = this.serialize();
            $(array).each(function () {
                if (serializeObj[this.name]) {
                    if ($.isArray(serializeObj[this.name])) {
                        serializeObj[this.name].push(this.value);
                    } else {
                        serializeObj[this.name] = [serializeObj[this.name], this.value];
                    }
                } else {
                    serializeObj[this.name] = this.value;
                }
            });
            return serializeObj;
        };
    })(jQuery);

    /************************************校验扩展************************************/
    /*@author Zhangcy
     * 需要传递两个参数的唯一性验证(比如修改时的唯一性验证)
     * @param value是验证所在的value
     * @unique[信息名称,url,name,第二个参数]
     第二个参数为动态执行的json脚本
     * */
    $.extend($.fn.validatebox.defaults.rules, {
//        unique: {
//            validator: function (value, param) {
//                var json = {};
//                var name = param[2];
//                json[name] = value;
//                var json2 = eval("(" + param[3] + ")");
//                $.extend(json, json2);
//                var resp = $.ajax({
//                    url: encodeURI(param[1]),
//                    data: json,
//                    async: false,//必写
//                    cache: false,
//                    type: "post"
//                }).responseText;
//                return resp == "true";
//            },
//            message: "{0}已存在"
//        },
//        //最小长度
//        minLength: {
//            validator: function (value, param) {
//                return value.length >= param[0];
//            },
//            message: '请至少输入{0}个字符.'
//        },
        maxLength: {
            validator: function (value, param) {
                return value.length <= param[0];
            },
            message: '最大只能输入{0}个字'
        },
//        //固定长度
//        fixLength: {
//            validator: function (value, param) {
//                return value.length == param[0];
//            },
//            message: '请输入{0}个字符.'
//        },
//        alpha: {
//            validator: function (value, param) {
//                if (value) {
//                    return /^[a-zA-Z\u00A1-\uFFFF]*$/.test(value);
//                } else {
//                    return true;
//                }
//            },
//            message: '只能输入字母.'
//        },
//        alphanum: {
//            validator: function (value, param) {
//                if (value) {
//                    return /^([a-zA-Z\u00A1-\uFFFF0-9])*$/.test(value);
//                } else {
//                    return true;
//                }
//            },
//            message: '只能输入字母和数字.'
//        },
        positiveInt: {
           validator: function (value, param) {
               if (value) {
                    return /^[0-9]*[1-9][0-9]*$/.test(value);
                } else {
                    return true;
               }
            },
           message: '只能输入正整数.'
      },
//        chsNoSymbol: {
//            validator: function (value, param) {
//                return /^[\u4E00-\u9FA5]+$/.test(value);
//            },
//            message: '只能输入中文'
//        },
        chs: {
            validator: function (value, param) {
                return /^[\u0391-\uFFE5]+$/.test(value);
            },
            message: '请输入汉字'
        },
       zip: {
           validator: function (value, param) {
                return /^[1-9]\d{5}$/.test(value);
           },
           message: '邮政编码不存在'
       },
//        qq: {
//            validator: function (value, param) {
//                return /^[1-9]\d{4,10}$/.test(value);
//            },
//            message: 'QQ号码不正确'
//        },
//        mobile: {
//            validator: function (value, param) {
//                return /^[1][358][0-9]{9}$/.test(value);
//            },
//            message: '手机号码不正确'
//        },
//        checkPhone: {
//            validator: function (value, param) {
//                var ev = value;
//                var regu = /^(\d{7,13}|\d{3,5}-\d{7,8})(\-\d{1,4})?$/;
//                var re = new RegExp(regu);
//                if (!re.test(ev)) {
//                    return false;
//                }
//                return true;
//            },
//            message: "电话格式不正确"
//        },
//        checkDate: {
//            validator: function (value, param) {
//                var ev = value;
//                var regu = /^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
//                var re = new RegExp(regu);
//                if (!re.test(ev)) {
//                    return false;
//                }
//                return true;
//            },
//            message: "时间格式不正确"
//        },
//        commonChar: {
//            validator: function (value, param) {
//                return /^[\u0391-\uFFE5\w]+$/.test(value);
//            },
//            message: '只允许汉字、英文字母、数字及下划线。'
//        },
//        loginName: {
//            validator: function (value, param) {
//                return /^[\u0391-\uFFE5\w]+$/.test(value);
//            },
//            message: '登录名称只允许汉字、英文字母、数字及下划线。'
//        },
        loginname: {
            validator: function (value, param) {
                return /^[a-zA-Z0-9]*$/.test(value);
            },
            message: '账号只允许输入英文字母、数字！'
        },
        safepass: {
            validator: function (value, param) {
                return !(!(/^(?![^0-9]+$)(?![^a-zA-Z]+$).+$/.test(value)) || !(/^[A-Za-z0-9]+$/.test(value)) || (/^(.{0,5})$/.test(value)));
            },
            message: '密码由字母和数字组成，至少6位'
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
        codeSpace: {
            validator: function (value, param) {
                var reg = /\s/;
                if (!reg.test(value)) {
                    return true;
                }
            },
            message: '不允许有空格!'
        },
        specialChart: {
            validator: function (value, param) {
                if(/((?=[\x21-\x7e]+)[^A-Za-z0-9])/.test(value)){
                    return false;
                }else{
                    return true;
                }
            },
            message: '不能含有特殊字符!'
        },
        mobilePhone: {
            validator: function (value, param) {
                var regx = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                if(regx.test(value)){
                    return true;
                }else{
                    return false;
                }
            },
            message: '手机号码不正确!'
        },
//        equalTo: {
//            validator: function (value, param) {
//                return value == $(param[0]).val();
//            },
//            message: '两次输入的字符不一至'
//        },
        number: {
            validator: function (value, param) {
                return /^\d+$/.test(value);
           },
           message: '请输入数字'
        },
//        idcard: {
//            validator: function (value, param) {
//                return idCard(value);
//            },
//            message: '请输入正确的身份证号码'
//        },
        email: {
            validator: function (value, param) {
               if ((value.length > 128) || (value.length < 6)) {
                  return false;
               }
               var format = /^[A-Za-z0-9+]+[A-Za-z0-9\.\_\-+]*@([A-Za-z0-9\-]+\.)+[A-Za-z0-9]+$/;
               if (!value.match(format)) {
                    return false;
              }
                return true;
           },
           message: '请输入正确的邮件地址'
        }
    });


//    $.extend($.fn.validatebox.defaults.rules, {
//        radio: {
//            validator: function (value, param) {
//                var input = param[0], ok = false;
//                $('input[name="' + input + '"]').each(function () {
//                    if (this.checked) {
//                        ok = true;
//                        return false;
//                    }
//                });
//                return ok
//            },
//            message: '请选择一项'
//        },
//        checkbox: {
//            validator: function (value, param) {
//                var input = param[0];
//                var checkNum = 0;
//                $('input[name="' + input + '"]').each(function () {
//                    if (this.checked) checkNum++;
//                });
//                return checkNum >= param[1] && checkNum <= param[2];
//            },
//            message: '请选择{1}-{2}项'
//        }
//    });


    /* 密码由字母和数字组成，至少6位 */
    var safePassword = function (value) {
        return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
    };
</script>
