<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录</title>
        <link rel="stylesheet" type="text/css" href="css/login_style.css">
        <script type="javascript" src="js/vue.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
    </head>
    <body>
        <div id="header-frame">
            <nav id="header-nav">
                <a id="logo" href="#">
                    <img src="image/logo.png" alt="logo" id="logoIMG">
                </a>
                <ul id="header-ul1">
                    <li><a class="header-option" href="main_page.jsp">首页</a></li>
                    <li><a class="header-option" href="#">求职</a></li>
                    <li><a class="header-option" href="#">公司</a></li>
                </ul>
                <ul id="header-ul2"></ul>
            </nav>
        </div>
        <div id="main">
            <div class="login-frame">
                <div class="login-header">登录</div>
                <form>
                    <input class="login-input" type="text" id="username" placeholder="请输入用户名">
                    <input class="login-input" type="password" id="password" placeholder="请输入密码">
                </form>
                <div class="button-frame">
                    <button class="login-button" type="submit" name="login" onclick="login()">登录</button>
                    <button class="login-button" type="button" name="register" onclick="register()">注册</button>
                </div>
            </div>
        </div>
        <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
    </body>
</html>
