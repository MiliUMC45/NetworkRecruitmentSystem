<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/normal_frame_style.css">
    <link rel="stylesheet" type="text/css" href="css/company_page_style.css">

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
              <ul id="header-ul2">
                <li><a class="header-option" href="login.jsp">登录</a></li>
                <li><a class="header-option" href="register.jsp">注册</a></li>
            </ul>
          </nav>
    </div>
        <div id="main">
            <div id="main-page">
                <div id="search-box">
                    <form action="CompanyPageServlet" method="get">
                        <div id="company-search-from">
                <label>
                    <input id="company-search-input" type="text" name="keyword" placeholder="搜索公司">
                </label>
                    <input id="company-search-submit" type="submit" name="submit" onclick="" value="搜索">
                        </div>
                    </form>
                </div>


      <div class="company-frame">
        <c:forEach var="Companyitem" items="${CompanyData.getCompanyList()}">
          <div class="company-item">
            <a href="CompanyDetailServlet?CompanyId=${Companyitem.getCompanyId()}" class="job-info">
            </a>
                <div class="company">
                    <img alt="" src="${Companyitem.getIcon()}" class="company-icon">
                  <div class="company-info">
                  <div class="company-name">${Companyitem.getCompanyName()}</div>
                  <div class="company-kind">${Companyitem.getKind()}</div>
                  </div>
                </div>
          </div>
        </c:forEach>
      </div>
          <div class="curPage">
              <a href="CompanyPageServlet?curPage=${CompanyData.firstPageForNavigation}">«</a>
              <c:forEach var="i" begin="${CompanyData.firstPageForNavigation}" end="${CompanyData.lastPageForNavigation}">
                  <a id="page${i}" href="CompanyPageServlet?curPage=${i}">${i}</a>
              </c:forEach>
              <a href="CompanyPageServlet?curPage=${CompanyData.lastPageForNavigation}">»</a>
            </div>
          </div>
    </div>
    <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
  </body>
</html>
