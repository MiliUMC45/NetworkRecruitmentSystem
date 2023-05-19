package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.service.PostedJobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostedJobServlet", value = "/PostedJobServlet")
public class PostedJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //尝试从请求获取变量并赋值
        int comId = 0;
        if (req.getParameter("comId") != null) {
            comId = Integer.parseInt(req.getParameter("comId"));
        }
        //声明职位数据列表
        ArrayList<JobBean> jobDate = new ArrayList<>();
        //调用Service层获取已发布职位列表
        PostedJobService.prepareJobDate(comId, jobDate);
        //设置职位数据列表，转发到已发布职位页面处理
        req.setAttribute("jobDate", jobDate);
        req.getRequestDispatcher("posted_job.jsp").forward(req, resp);
    }
}
