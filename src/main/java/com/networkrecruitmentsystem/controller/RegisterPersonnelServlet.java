package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.dao.IuserDao;
import com.networkrecruitmentsystem.dao.registerDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "RegisterPersonnelServlet", value = "/RegisterPersonnelServlet")
public class RegisterPersonnelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String userpwd1 = req.getParameter("userpwd1");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String CH = "";
        int CompanyID = Integer.parseInt(req.getParameter("CompanyID"));
        IuserDao registerDao = new registerDao();
        UserBean user = new UserBean();
        HotCompanyBean Company = new HotCompanyBean();
        user.setUsername(username);
        Company.setComId(CompanyID);
        user.setPassword(userpwd);
        user.setTelephone(tel);
        user.setEmail(email);
        user.setSex(sex);
        resp.setContentType("text/html");   //设置响应的内容类型，这个一定要设置否则，页面中文现实乱码！！！
        resp.setCharacterEncoding("utf-8"); //设置响应的编码方式，告诉浏览器我发送的内容编码类型为utf-8;
        if(user.getUsername()==""){
            resp.getWriter().println("用户名不能为空值！");
            resp.setHeader("refresh", "3;register_normal.jsp");
            return;
        }
        else if(user.getPassword()==""){
            resp.getWriter().println("密码不能为空值！");
            resp.setHeader("refresh", "3;register_normal.jsp");
            return;
        }
        else if(registerDao.isExistPersonnel(username)){
            resp.getWriter().println("该用户名已注册！");
            resp.setHeader("refresh", "3;register_normal.jsp");
            return;
        }
        registerDao.savePersonnels(user,Company);
        try {
            resp.sendRedirect("login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}