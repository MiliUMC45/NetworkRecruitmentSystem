<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/login_style.css">
</head>
<body>
<div id="header-frame">
    <nav id="header-nav">
        <a id="logo" href="MainPageServlet">
            <img src="image/logo.png" alt="logo" id="logoIMG">
        </a>
        <ul id="header-ul1">
            <li><a class="header-option" href="MainPageServlet">首页</a></li>
            <li><a class="header-option" href="JobPageServlet">求职</a></li>
            <li><a class="header-option" href="company_page.jsp">公司</a></li>
        </ul>
        <ul id="header-ul2"></ul>
    </nav>
</div>
<div id="main">
    <div class="login-frame">
        <div class="login-header">登录</div>
        <form>
            <label>
                <input class="login-input" type="text" id="username" placeholder="请输入用户名">
            </label>
            <label>
                <input class="login-input" type="password" id="password" placeholder="请输入密码">
            </label>
        </form>
        <div class="button-frame">
            <button class="login-button" type="submit" name="login" onclick="login('N')">普通用户登录</button>
            <button class="login-button" type="submit" name="login" onclick="login('P')">人事用户登录</button>
            <button class="login-button" type="button" name="register" onclick="register()">注册</button>
            <script>
                function login(type) {
                    var name = document.getElementById("username").value;
                    var pwd = document.getElementById("password").value;
                    window.location.href="LoginServlet?username=" + name + "&password=" + pwd + "&kind=" + type;
                }
                function register() {
                    window.location.href="./register.jsp";
                }
            </script>
        </div>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>
