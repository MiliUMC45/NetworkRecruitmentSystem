package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.service.JobDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JobDetailServlet", value = "/JobDetailServlet")
public class JobDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId;
        jobId =Integer.parseInt(request.getParameter("jobId"));
        JobBean job = new JobBean(jobId);
        JobDetailService.prepareJobDetail(job);
        request.setAttribute("jobData", job);
        request.getRequestDispatcher("job_detail.jsp").forward(request, response);
    }
}
