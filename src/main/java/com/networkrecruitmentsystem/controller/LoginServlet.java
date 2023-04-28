package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.service.LoginService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println(username + "\t" + pwd);

        UserBean user = new UserBean(username, pwd);
        LoginService.login(user);

        response.setContentType("text/html");   //设置响应的内容类型，这个一定要设置否则，页面中文现实乱码！！！
        response.setCharacterEncoding("utf-8"); //设置响应的编码方式，告诉浏览器我发送的内容编码类型为utf-8;
        if (user.getUserId() < 0) {
            response.getWriter().println("数据库出错");
            response.setHeader("refresh", "3;main_page.jsp");
        } else if (user.getUserId() == 0) {
            response.getWriter().println("用户名或密码错误");
            response.setHeader("refresh", "3;login.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("main_page.jsp");
        }
    }
}