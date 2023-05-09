package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.service.LoginService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //尝试从请求获取变量并赋值
        String username = null;
        String pwd = null;
        username = request.getParameter("username");
        pwd = request.getParameter("password");
        //封装数据
        UserBean user = new UserBean(username, pwd);
        //调用service逻辑处理
        LoginService.login(user);
        //根据数据状态响应请求
        response.setContentType("text/html");   //设置响应的内容类型，这个一定要设置否则页面中文出现乱码！！！
        response.setCharacterEncoding("utf-8"); //设置响应的编码方式，告诉浏览器我发送的内容编码类型为utf-8;
        if (user.getUserId() < 0) { //用户ID小于0表示数据库出错或数据不合法
            response.getWriter().println("数据库出错");
            response.setHeader("refresh", "3;main_page.jsp");
        } else if (user.getUserId() == 0) { //用户ID等于0表示未在数据库中查询到响应数据，可能为用户名或密码错误
            response.getWriter().println("用户名或密码错误");
            response.setHeader("refresh", "3;login.jsp");
        } else {    //用户ID大于0表示成功查询到相应数据，将用户数据添加到session中并跳回主页
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("MainPageServlet");
        }
    }
}