<%--
  Created by IntelliJ IDEA.
  User: Loucey
  Date: 2023/4/22
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
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
                    <li><a class="header-option" href="JobPageServlet">求职</a></li>
                    <li><a class="header-option" href="CompanyPageServlet">公司</a></li>
                </ul>
                <ul id="header-ul2"></ul>
            </nav>
        </div>
        <div id="main">
            <div class="register-frame">
                <div class="register-header">注册</div>
                <div class="choose-frame">
                    <a class="choose" href="register_normal.jsp">我是求职者</a>
                    <a class="choose" href="register_personnel.jsp">我是招聘者</a>
                </div>
            </div>
        </div>
        <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
    </body>
</html>
