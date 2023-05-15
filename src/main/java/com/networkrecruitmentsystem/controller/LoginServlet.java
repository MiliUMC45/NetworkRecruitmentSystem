package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.PersonnelBean;
import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //尝试从请求获取变量并赋值
        String username;
        String pwd;
        String kind;
        String logout;
        int id = 0;
        username = request.getParameter("username");
        pwd = request.getParameter("password");
        kind = request.getParameter("kind");
        logout = request.getParameter("logout");
        if (logout != null) {
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");
        } else {
            UserBean user = new UserBean();
            PersonnelBean personnel = new PersonnelBean();
            if ("N".equals(kind)) {
                //封装数据
                user.setUsername(username);
                user.setPassword(pwd);
                user.setKind(kind);
                //调用service逻辑处理
                LoginService.login(user);
                id = user.getUserId();
            } else if ("P".equals(kind)) {
                //封装数据
                personnel.setPerName(username);
                personnel.setPerPwd(pwd);
                personnel.setKind(kind);
                //调用service逻辑处理
                LoginService.login(personnel);
                id = personnel.getPerId();
            }
            //根据数据状态响应请求
            response.setContentType("text/html");   //设置响应的内容类型，这个一定要设置否则页面中文出现乱码！！！
            response.setCharacterEncoding("utf-8"); //设置响应的编码方式，告诉浏览器我发送的内容编码类型为utf-8;
            if (id < 0) { //用户ID小于0表示数据库出错或数据不合法
                response.getWriter().println("数据库出错");
                response.setHeader("refresh", "3;main_page.jsp");
            } else if (id == 0) { //用户ID等于0表示未在数据库中查询到响应数据，可能为用户名或密码错误
                response.getWriter().println("用户名或密码错误");
                response.setHeader("refresh", "3;login.jsp");
            } else {    //用户ID大于0表示成功查询到相应数据，将用户数据添加到session中并跳回主页
                HttpSession session = request.getSession();
                if ("N".equals(kind)) {
                    session.setAttribute("user", user);
                } else if ("P".equals(kind)) {
                    session.setAttribute("user", personnel);
                }
                response.sendRedirect("MainPageServlet");
            }
        }
    }
}