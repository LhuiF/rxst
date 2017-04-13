<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<title id="ajaxtiaozhuangdengl">人事管理系统</title>
<head>
<link rel="stylesheet" type="text/css" href="${CP}/css/login.css"/>
<script type="text/javascript" src="${CP}/lib/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${CP}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${CP}/js/page/login.js"></script>
  <script type="text/javascript">
    if (window.top != window) {
      window.top.location = window.location;
    }
    var CP  = '${CP}';
  </script>
</head>
<body>
    <div class="login_box">
        <h2>欢迎登录人事管理系统</h2>
        <div class="login_content">
            <form class="login_form" method="">
                <h3>人事管理系统登录</h3>
                <ul>
                    <li><label>账 &nbsp;号：</label><input id="loginName" name="loginName" type="text"/></li>
                    <li><label>密 &nbsp;码：</label><input id="password" name="password" type="password"/></li>
                    <li style="font-size: 12px !important;float: right">
                        <input id="ck_rmbUser" type="checkbox" style="width: 20px;vertical-align: top;display: table-cell;"/><label style="width: auto;">记住帐号!</label>
                    </li>
                    <span class="error">错误!</span>
                    <li><a id="loginButton" class="button" onclick="login();">登 录</a></li>
                </ul>
            </form>
        </div>
        <div class="login_copy">
            <p>Copyright &copy; 2016-2017(XXXX) XXX </p>
            <p>All Rights Reserved.</p>
            <p> 京ICP备16005704号 </p>
        </div>
    </div>
    <!--忘记密码-->
    <div id="forgetPasswordDialog" class="wrap">
        <input id="kefuorstore" type="hidden" value="1">
        <div class="md-form">
            <ul>
                <h2>忘记密码</h2>
                <li>
                    <label>账号</label>
                    <input id="forgetLoginName" type="text" placeholder="请输入账号"/>
                    <strong id="loginNameNo"></strong>
                </li>
                <li class="location">
                    <label>验证码：</label>
                    <input id="code" type="text" style="width:32%;" placeholder="请输入验证码"/>
                    <input onclick="pushCode();" id="verification" type="button" style="width:16%;margin-left:10px;" value="获取验证码" class="verification"/>
                    <span id="verificationNo" class="verification-yn" style="color:#000;"></span>
                    <strong id="codeNo"></strong>
                </li>
                <li class="lumar">
                    <label>设置新密码：</label>
                    <input id="forgetPassword" type="password" placeholder="请输入密码（6位以上的数字和字母组合）"/>
                    <strong id="forgetPasswordNo"></strong>
                </li>
                <li>
                    <label>确认密码：</label>
                    <input id="forgetPasswords" type="password" placeholder="请输入密码（6位以上的数字和字母组合）"/>
                    <strong id="forgetPasswordsNo"></strong>
                </li>
                <li>
                    <label></label>
                    <button onclick="forgetPassword();">确定</button>
                    <button onclick="closeForgetPassword();">取消</button>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>