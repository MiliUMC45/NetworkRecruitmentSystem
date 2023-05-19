<%--
  Created by IntelliJ IDEA.
  User: Loucey
  Date: 2023/5/17
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络招聘系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/user_center_style.css">
    <link rel="stylesheet" type="text/css" href="css/job_cu.css">
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
            <li><a class="header-option" href="user_center.jsp">个人中心</a></li>
            <li><a class="header-option" href="LoginServlet?logout=1">退出</a></li>
        </ul>
    </nav>
</div>
<div id="main">
    <div id="main-page">
        <ul class="user-nav">
            <li>
                <a class="" href="user_center.jsp">个人信息</a>
            </li>
            <hr/>
            <li>
                <a class="" href="PostedJobServlet?comId=${user.comId}">已发布的职位</a>
            </li>
            <hr/>
            <li>
                <a class="" href="#">已收到的申请</a>
            </li>
        </ul>
        <div class="line"></div>
        <div class="job-info-frame">
            <c:if test="${!empty jobDate}">
                <form action="JobCUServlet" method="post">
                    <div class="tip-text">职位名称：</div>
                    <input type="text" name="jobName" value="${jobDate.jobName}" class="NP-input">
                    <div class="tip-text">职位薪酬：</div>
                    <input type="text" name="pay" value="${jobDate.pay}" class="NP-input">
                    <div class="tip-text">职位描述：</div>
                    <textarea name="introduction" class="intro-input"> ${jobDate.introduction}</textarea>
                    <input type="text" name="jobId" value="${jobDate.jobId}" style="display: none">
                    <input type="text" name="companyId" value="${jobDate.companyId}" style="display: none">
                    <input type="text" name="action" value="Update" style="display: none">
                    <button type="submit" class="submit-button">提交</button>
                </form>
            </c:if>
            <c:if test="${empty jobDate}">
                <form action="JobCUServlet">
                    <div class="tip-text">职位名称：</div>
                    <input type="text" name="jobName" class="NP-input">
                    <div class="tip-text">职位薪酬：</div>
                    <input type="text" name="pay" class="NP-input">
                    <div class="tip-text">职位描述：</div>
                    <textarea name="introduction" class="intro-input"></textarea>
                    <input type="text" name="companyId" value="${user.comId}" style="display: none">
                    <input type="text" name="action" value="Create" style="display: none">
                    <button type="submit" class="submit-button">提交</button>
                </form>
            </c:if>
        </div>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>

