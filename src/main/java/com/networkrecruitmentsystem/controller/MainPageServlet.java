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
        MainPageBean mainPage = new MainPageBean();
        MainPageService.prepareMainData(mainPage);

        request.setAttribute("mainPageData", mainPage);
        request.getRequestDispatcher("main_page.jsp").forward(request, response);
    }
}
