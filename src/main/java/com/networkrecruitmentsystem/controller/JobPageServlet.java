package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.JobPageBean;
import com.networkrecruitmentsystem.service.JobPageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JobPageServlet", value = "/JobPageServlet")
public class JobPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = null;
        int curPage = 1;

        String keywordOrigin = request.getParameter("keyword");
        if (keywordOrigin != null)
            keyword = keywordOrigin;
        String curPageOrigin = request.getParameter("curPage");
        if (curPageOrigin != null)
            curPage = Integer.parseInt(curPageOrigin);

        JobPageBean jobData = new JobPageBean(keyword, curPage);
        JobPageService.prepareJobData(jobData);

        request.setAttribute("jobData", jobData);
        request.getRequestDispatcher("job_page.jsp").forward(request, response);
    }
}
