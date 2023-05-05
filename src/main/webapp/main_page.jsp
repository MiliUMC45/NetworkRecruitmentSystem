<%--
  Created by IntelliJ IDEA.
  User: 洛佑希
  Date: 2023/4/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/main_page_style.css">
    <script type="javascript" src="js/vue.js"></script>
  </head>
  <body>
    <div id="header-frame">
      <nav id="header-nav">
        <a id="logo" href="#">
          <img src="image/logo.png" alt="logo" id="logoIMG">
        </a>
        <ul id="header-ul1">
          <li><a class="header-option" href="main_page.jsp">首页</a></li>
          <li><a class="header-option" href="job_page.jsp">求职</a></li>
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
          <form action="" method="get">
            <div id="job-search-from">
              <label>
                <input id="job-search-input" type="text" name="job-search" placeholder="搜索职位">
              </label>
              <input id="job-search-submit" type="submit" name="submit" onclick="" value="搜索">
            </div>
          </form>
        </div>
        <div id="hot-job">
          <h1>热招岗位</h1>
          <ul class="cur1">
            <c:forEach var="i" begin="1" end="6" step="1">
              <li>
                <a href="#" class="hot-job-top">
                  <div class="h-job-name">123</div>
                  <div class="h-job-pay">123</div>
                </a>
                <a href="#" class="hot-job-bottom">
                  <div class="h-j-company-name">123</div>
                  <div class="h-j-company-kind">123</div>
                </a>
              </li>
            </c:forEach>
          </ul>
          <a class="more-info" href="#">查看更多</a>
        </div>
        <div id="hot-company">
          <h1>热门公司</h1>
          <ul class="cur2">
            <c:forEach var="i" begin="1" end="6" step="1">
              <li>
                <a>

                </a>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>
    <div id="footer">作者：2120332卓刘毅 2120348吴诚豪</div>
  </body>
</html>
