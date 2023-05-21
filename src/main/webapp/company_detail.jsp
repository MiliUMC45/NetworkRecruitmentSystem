<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/job_detail_style.css">
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
            <li><a class="header-option" href="CompanyPageServlet">公司</a></li>
        </ul>
        <ul id="header-ul2">
            <c:if test="${empty user}">
                <li><a class="header-option" href="login.jsp">登录</a></li>
                <li><a class="header-option" href="register.jsp">注册</a></li>
            </c:if>
            <c:if test="${!empty user}">
                <li><a class="header-option" href="user_center.jsp">个人中心</a></li>
                <li><a class="header-option" href="LoginServlet?logout=1">退出</a></li>
            </c:if>
        </ul>
    </nav>
</div>
<div id="main">
    <div id="main-page">
        <div class="brief-introduction">
            <div class="job-name">${CompanyData.getCompanyName()}</div>
        </div>
        <div class="job-introduce">${CompanyData.getIntroduction()}</div>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>
