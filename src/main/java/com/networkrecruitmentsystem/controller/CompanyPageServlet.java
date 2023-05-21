package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.CompanypageBean;
import com.networkrecruitmentsystem.service.CompanyPageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyPageServlet", value = "/CompanyPageServlet")
public class CompanyPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String keyword = null;
        int curPage = 1;
        //尝试从请求获取变量并赋值
        String keywordOrigin = request.getParameter("keyword");
        if (keywordOrigin != null)
            keyword = keywordOrigin;
        String curPageOrigin = request.getParameter("curPage");
        if (curPageOrigin != null)
            curPage = Integer.parseInt(curPageOrigin);
        //封装数据
        CompanypageBean CompanyData = new CompanypageBean(keyword, curPage);
        //调用service逻辑处理
        CompanyPageService.prepareCompanyPage(CompanyData);
        //向请求中添加变量并转发请求到职位页面
        request.setAttribute("CompanyData", CompanyData);
        request.getRequestDispatcher("company_page.jsp").forward(request, response);
    }
}
