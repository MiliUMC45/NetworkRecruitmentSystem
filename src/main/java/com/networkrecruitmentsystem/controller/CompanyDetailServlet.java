package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.CompanyBean;
import com.networkrecruitmentsystem.service.CompanyDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyDetailServlet", value = "/CompanyDetailServlet")
public class CompanyDetailServlet extends HttpServlet {
    public void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int CompanyId;
        CompanyId =Integer.parseInt(request.getParameter("CompanyId"));
        CompanyBean Company = new CompanyBean(CompanyId);
        CompanyDetailService.prepareCompanyDetail(Company);
        request.setAttribute("CompanyData", Company);
        request.getRequestDispatcher("company_detail.jsp").forward(request, response);

    }
}