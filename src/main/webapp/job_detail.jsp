<%--
  Created by IntelliJ IDEA.
  User: Loucey
  Date: 2023/5/10
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/job_page_style.css">
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
            <li><a class="header-option" href="company_page.jsp">公司</a></li>
        </ul>
        <ul id="header-ul2">
            <li><a class="header-option" href="login.jsp">登录</a></li>
            <li><a class="header-option" href="register.jsp">注册</a></li>
        </ul>
    </nav>
</div>
<div id="main">
    <div id="main-page">
        <h1>${jobData.getJobName()}</h1>
        <h2>${jobData.getPay()}</h2>
        <p>${jobData.getIntroduction()}</p>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>

