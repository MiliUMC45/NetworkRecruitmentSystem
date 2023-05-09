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
        //初始化变量
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
        JobPageBean jobData = new JobPageBean(keyword, curPage);
        //调用service逻辑处理
        JobPageService.prepareJobData(jobData);
        //向请求中添加变量并转发请求到职位页面
        request.setAttribute("jobData", jobData);
        request.getRequestDispatcher("job_page.jsp").forward(request, response);
    }
}
