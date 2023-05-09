package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.MainPageBean;
import com.networkrecruitmentsystem.service.MainPageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", value = "/MainPageServlet")
public class MainPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //封装数据
        MainPageBean mainPage = new MainPageBean();
        //调用service逻辑处理
        MainPageService.prepareMainData(mainPage);
        //向请求中添加变量并转发请求到主页
        request.setAttribute("mainPageData", mainPage);
        request.getRequestDispatcher("main_page.jsp").forward(request, response);
    }
}
