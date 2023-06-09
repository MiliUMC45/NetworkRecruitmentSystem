<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
        <link rel="stylesheet" type="text/css" href="css/register_style.css">
    </head>
    <body>
        <div id="header-frame">
            <nav id="header-nav">
                <a id="logo" href="#">
                    <img src="image/logo.png" alt="logo" id="logoIMG">
                </a>
                <ul id="header-ul1">
                    <li><a class="header-option" href="MainPageServlet">首页</a></li>
                    <li><a class="header-option" href="job_page.jsp">求职</a></li>
                    <li><a class="header-option" href="company_page.jsp">公司</a></li>
                </ul>
                <ul id="header-ul2"></ul>
            </nav>
        </div>
        <div id="main">
            <div class="register-frame">
                <div class="register-header">注册</div>
                <form class="register-form" id = "form" action="RegisterUserServlet">
                    用户名：<input class="register-input" type="text" name="username" id="username" placeholder="用户名"><br/>
                    邮箱：<input class="register-input" type="email" name="email" id="email" placeholder="邮箱"><br/>
                    性别：<select class="register-input">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select><br/>
                    密码：<input class="register-input" type="password" name="userpwd" id="userpwd" placeholder="密码"><br/>
                    确认密码：<input class="register-input" type="password" name="userpwd2" id="userpwd2" placeholder="确认密码"><br/>
                    电话：<input class="register-input" type="text" name="tel" id="tel" placeholder="电话">
                    <button class="register-button" type="submit" onclick="checkform">提交</button>
                </form>

            </div>
        </div>
        <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
    </body>
</html>
