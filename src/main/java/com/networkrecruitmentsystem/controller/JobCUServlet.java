package com.networkrecruitmentsystem.controller;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.service.JobCUService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JobCUServlet", value = "/JobCUServlet")
public class JobCUServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //尝试从请求获取变量并赋值
        int jobId;
        String action = req.getParameter("action");
        //根据action值进行不同操作
        if ("Query".equals(action)) {
            //获取职位ID
            jobId = Integer.parseInt(req.getParameter("jobId"));
            //封装数据
            JobBean jobDate = new JobBean(jobId);
            //调用Service方法获取已有职位信息
            JobCUService.prepareJobDateForCU(jobDate);
            //将已有职位信息发送到前端以供修改
            req.setAttribute("jobDate", jobDate);
            req.getRequestDispatcher("job_cu.jsp").forward(req, resp);
        } else if ("Delete".equals(action)) {
            //获取职位ID
            jobId = Integer.parseInt(req.getParameter("jobId"));
            //调用Service方法根据职位ID删除已有职位信息
            JobCUService.deleteJobDate(jobId);
            //重定向到已发布职位页面
            resp.sendRedirect("PostedJobServlet");
        }else {
            //调用Post方法
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //尝试从请求获取变量并赋值
        int jobId;
        String jobName;
        String pay;
        int companyId;
        String introduction;
        String action = req.getParameter("action");
        jobName = req.getParameter("jobName");
        pay = req.getParameter("pay");
        introduction = req.getParameter("introduction");
        //根据action值进行不同操作
        if ("Update".equals(action)) {
            //获取职位ID
            jobId = Integer.parseInt(req.getParameter("jobId"));
            //封装数据
            JobBean jobDate = new JobBean(jobId, jobName, pay, introduction);
            //调用Service层更新已有职位数据
            JobCUService.updateJobDate(jobDate);
        } else if ("Create".equals(action)) {
            //获取公司ID
            companyId = Integer.parseInt(req.getParameter("companyId"));
            //封装数据
            JobBean jobDate = new JobBean(jobName, pay, companyId, introduction);
            //调用Service层创建新职位数据
            JobCUService.insertDateIntoJob(jobDate);
        }
        //重定向至已发布职位页面
        resp.sendRedirect("PostedJobServlet?comId=" + req.getParameter("companyId"));
    }
}
