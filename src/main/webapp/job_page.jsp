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
        <div id="search-box">
            <form action="JobPageServlet" method="get">
                <div id="job-search-from">
                    <label>
                        <input id="job-search-input" type="text" name="keyword" placeholder="搜索职位">
                    </label>
                    <input id="job-search-submit" type="submit" name="submit" onclick="" value="搜索">
                </div>
            </form>
        </div>
        <div class="job-frame">
            <c:forEach var="jobItem" items="${jobData.jobList}">
                <div class="job-item">
                    <a href="JobDetailServlet?jobId=${jobItem.getJobId()}" class="job-info">
                        <div class="job-name">${jobItem.getJobName()}</div>
                        <div class="job-pay">${jobItem.getPay()}</div>
                    </a>
                    <div class="company">
                        <img alt="" src="${jobItem.getIcon()}" class="company-icon">
                        <div class="company-info">
                            <div class="company-name">${jobItem.getCompanyName()}</div>
                            <div class="company-kind">${jobItem.getCompanyKind()}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="curPage">
            <a href="JobPageServlet?curPage=${jobData.firstPageForNavigation}">«</a>
            <c:forEach var="i" begin="${jobData.firstPageForNavigation}" end="${jobData.lastPageForNavigation}">
                <a id="page${i}" href="JobPageServlet?curPage=${i}">${i}</a>
            </c:forEach>
            <a href="JobPageServlet?curPage=${jobData.lastPageForNavigation}">»</a>
        </div>
    </div>
</div>
<div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
</body>
</html>
