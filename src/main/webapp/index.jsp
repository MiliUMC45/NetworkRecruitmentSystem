<%--
  Created by IntelliJ IDEA.
  User: 洛佑希
  Date: 2023/4/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>网络招聘系统</title>
    <link rel="stylesheet" type="text/css" href="css/mainPageStyle.css">
    <script type="javascript" src="js/vue.js"></script>
  </head>
  <body>
    <div id="header-frame">
      <nav id="header-nav">
        <a id="logo" href="#">
          <img src="image/logo.png" alt="logo" id="logoIMG">
        </a>
        <ul id="header-ul1">
          <li><a class="header-option" href="#">首页</a></li>
          <li><a class="header-option" href="#">求职</a></li>
          <li><a class="header-option" href="#">公司</a></li>
        </ul>
        <ul id="header-ul2">
          <li><button class="lg-button" type="button" value="login" onclick="">登录</button></li>
          <li><button class="lg-button" type="button" value="register" onclick="">注册</button></li>
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
        </div>
        <div id="hot-company">
          <h1>热门公司</h1>
        </div>
      </div>
    </div>
    <div id="footer">测试文字</div>
  </body>
</html>
