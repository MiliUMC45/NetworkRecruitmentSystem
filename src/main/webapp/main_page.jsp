<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/main_page_style.css">
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
        <div id="hot-job">
          <h1>热招岗位</h1>
          <ul class="cur1">
            <c:forEach var="hotJob" items="${mainPageData.hotJobList}">
              <li>
                <a href="JobDetailServlet?jobId=${hotJob.getJobId()}" class="hot-job-top">
                  <div class="h-job-name">${hotJob.getJobName()}</div>
                  <div class="h-job-pay">${hotJob.getPay()}</div>
                </a>
                <a href="#" class="hot-job-bottom">
                  <div class="h-j-company-name">${hotJob.getCompanyName()}</div>
                  <div class="h-j-company-kind">${hotJob.getCompanyKind()}</div>
                </a>
              </li>
            </c:forEach>
          </ul>
          <a class="more-info" href="JobPageServlet">查看更多</a>
        </div>
        <div id="hot-company">
          <h1>热门公司</h1>
          <ul class="cur2">
            <c:forEach var="hotCompany" items="${mainPageData.hotCompanyList}">
              <li>
                <a href="#" class="hot-com-top">
                  <img alt="" src="${hotCompany.getComIcon()}" class="hot-com-icon">
                  <div class="hot-com-info">
                    <div class="hot-com-name">${hotCompany.getComName()}</div>
                    <div class="hot-com-kind">${hotCompany.getComKind()}</div>
                  </div>
                </a>
                <hr/>
                <div class="hot-com-list">
                  <c:forEach var="hotCompanyJob" items="${hotCompany.jobList}">
                    <a href="JobDetailServlet?jobId=${hotCompanyJob.getJobId()}" class="hot-com-job">
                      <div class="hot-c-j-name">${hotCompanyJob.getJobName()}</div>
                      <div class="hot-c-j-pay">${hotCompanyJob.getPay()}</div>
                    </a>
                  </c:forEach>
                </div>
              </li>
            </c:forEach>
          </ul>
          <a class="more-info" href="company_page.jsp">查看更多</a>
        </div>
      </div>
    </div>
    <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
  </body>
</html>