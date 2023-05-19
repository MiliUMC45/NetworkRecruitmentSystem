<%--
  Created by IntelliJ IDEA.
  User: Loucey
  Date: 2023/5/15
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/user_center_style.css">
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
            <c:if test="${user.kind == 'N'}">
                <li>
                    <a class="" href="#">已申请的职位</a>
                </li>
            </c:if>
            <c:if test="${user.kind == 'P'}">
                <li>
                    <a class="" href="PostedJobServlet?comId=${user.comId}">已发布的职位</a>
                </li>
                <hr/>
                <li>
                    <a class="" href="#">已收到的申请</a>
                </li>
            </c:if>
        </ul>
        <div class="line"></div>
        <div class="job-posted">
            <div class="job-action">
                <a type="button" href="job_cu.jsp" class="job-action-button">发布新职位</a>
            </div>
            <ul class="job-list">
                <c:forEach var="jobDate" items="${jobDate}">
                    <li>
                        <div class="job-name">${jobDate.jobName}</div>
                        <div class="job-pay">${jobDate.pay}</div>
                        <div class="job-introduce">${jobDate.introduction}</div>
                        <div class="job-button-list">
                            <a type="button" href="JobCUServlet?jobId=${jobDate.jobId}&action=Query">修改职位</a>
                            <a type="button" href="JobCUServlet?jobId=${jobDate.jobId}&action=Delete">删除职位</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>
