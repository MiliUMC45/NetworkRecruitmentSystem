package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.*;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobDao {
    public static void selectHotJobByJobId(int jobId, HotJobBean hotJob) {
        //通过职位ID获取热门职位信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM job WHERE job_id=?";
        try {
            //预编译SQL语句，执行并获取结果
            ps = conn.prepareStatement(sql);
            ps.setInt(1, jobId);
            rs = ps.executeQuery();
            if (rs.next()) {
                //获取数据
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                int company_id = rs.getInt("company_id");
                //数据封装
                hotJob.setJobId(jobId);
                hotJob.setJobName(jobName);
                hotJob.setPay(pay);
                hotJob.setCompanyId(company_id);
                //调用方法获取公司信息
                CompanyDao.selectHotJobCompanyByCompanyId(company_id, hotJob);
            }
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库链接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectJobByCompanyId(int companyId, HotCompanyBean hotCompany) {
        //通过公司ID获取热门公司职位信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM job WHERE company_id=?";
        //定义数据模型数组
        ArrayList<JobBean> jobList = new ArrayList<>();
        try {
            //预编译SQL语句，执行并获取结果
            ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
            rs = ps.executeQuery();
            //最多获取3个职位信息
            for (int i = 1; i <= 3 && rs.next(); i++) {
                //获取数据
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                //封装数据
                JobBean job = new JobBean();
                job.setJobName(jobName);
                job.setPay(pay);
                //将数据模型加入数组
                jobList.add(job);
            }
            //封装数组
            hotCompany.setJobList(jobList);
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectJobForJobPage(JobPageBean jobData) {
        //为职位页面获取所有职位信息
        //建立数据库链接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
        这条SQL语句从数据库表"job"中选择特定的行。以下是更详细的解释：
        SELECT *：选择从“job”表中检索出来的所有列。
        FROM(SELECT ROW_NUMBER() OVER ( ORDER BY job_id ASC ) AS line, COUNT(job_id) OVER () AS total, * FROM job) job：这是一个SQL的子查询结构，用于为查找结果生成行号 LINE 和计算总行数 TOTAL。
        在内部的子查询中，对“job”表执行ROW_NUMBER() 函数，按照“job_id”列的升序进行排序，将结果作为一个名为“job”的表返回，并将其作为外部查询的输入。
        WHERE line>? AND line<=?：这个WHERE子句用于返回行号在一个给定范围内的记录。其中“line”是通过ROW_NUMBER()函数为结果集中的每一行所分配的序列号，因此子查询中计算出的行号将被用于筛选结果并返回指定的行。
        综上所述，这个SQL查询使用ROW_NUMBER() 和COUNT()函数来分配序列号和计算总行数，并使用WHERE子句返回仅包含指定行号(序列号)范围内的记录的结果集。
        */
        String sql = "SELECT * FROM(SELECT ROW_NUMBER() OVER ( ORDER BY job_id ASC ) AS line, COUNT(job_id) OVER () AS total, * FROM job) job "
                + "WHERE line>? AND line<=?";
        //定义数据模型数组
        ArrayList<JobPageItemBean> arrayList = new ArrayList<>();
        //定义计数变量i
        int i = 0;
        try {
            //预编译SQL语句，执行并获取执行结果
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (jobData.getCurPage() - 1) * jobData.getJobsAPage());
            ps.setInt(2, jobData.getCurPage() * jobData.getJobsAPage());
            rs = ps.executeQuery();
            while (rs.next()) {
                //计数+1
                i++;
                //获取数据
                int jobId = rs.getInt("job_id");
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                int companyId = rs.getInt("company_id");
                //封装数据
                JobPageItemBean job = new JobPageItemBean(jobId, jobName, pay, companyId);
                System.out.println(job);
                //调用CompanyDao的方法获取公司信息
                CompanyDao.selectCompanyByCompanyId(job);
                //数据加入数组
                arrayList.add(job);
            }
            //封装数据
            jobData.setTotalJobs(i);
            jobData.setJobList(arrayList);
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
