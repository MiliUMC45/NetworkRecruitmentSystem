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
        String sql = null;
        //判断关键词是否为空
        if (jobData.getKeyword() == null) {
            /*
            SELECT *：选择从“job”表中检索出来的所有列。
            FROM(SELECT ROW_NUMBER() OVER ( ORDER BY job_id ASC ) AS line, COUNT(job_id) OVER () AS total, * FROM job) job：这是一个SQL的子查询结构，用于为查找结果生成行号 LINE 和计算总行数 TOTAL。
            在内部的子查询中，对“job”表执行ROW_NUMBER() 函数，按照“job_id”列的升序进行排序，将结果作为一个名为“job”的表返回，并将其作为外部查询的输入。
            WHERE line>? AND line<=?：这个WHERE子句用于返回行号在一个给定范围内的记录。其中“line”是通过ROW_NUMBER()函数为结果集中的每一行所分配的序列号，因此子查询中计算出的行号将被用于筛选结果并返回指定的行。
            综上所述，这个SQL查询使用ROW_NUMBER() 和COUNT()函数来分配序列号和计算总行数，并使用WHERE子句返回仅包含指定行号(序列号)范围内的记录的结果集。
            */
            sql = "SELECT * FROM(SELECT ROW_NUMBER() OVER ( ORDER BY job_id ASC ) AS line, "
                    + "COUNT(job_id) OVER () AS total, * FROM job) job "
                    + "WHERE line>? AND line<=?";
        } else {
            /*
            SELECT COUNT(*) OVER () AS total 这个子句用于计算符合条件的总记录数，并且将计算结果保存在名为"total"的列中。
            COUNT()函数会返回符合WHERE子句条件的总记录数，而OVER()子句则用于计算整个结果集的总记录数，这就是为什么我们需要用OVER()函数而不是简单的COUNT()函数。这个计算结果将会被添加到查询结果的每一行记录中。
            SELECT ROW_NUMBER() OVER (ORDER BY job_id ASC) AS line, job.* FROM job WHERE job_name LIKE ? 这个子句用于查询名为"job"的表中，job_name列中包含指定字符串的记录，并且使用job_id列升序排序。
            查询结果中使用ROW_NUMBER()函数为每一行分配行号，并将行号作为"line"列返回。
            SELECT ... WHERE t.line > ? AND t.line <= ? ORDER BY t.job_id ASC 这个子句用于筛选出行号在指定范围内的记录，并且使用job_id列升序排序。
            "t.line > ? AND t.line <= ?"用于指定筛选行号的范围，这些参数需要在实际查询中替换为实际值。
            ORDER BY子句用于按照job_id列升序排列结果集
            */
            sql = "SELECT COUNT(*) OVER () AS total, "
                    + "t.* FROM (SELECT ROW_NUMBER() OVER (ORDER BY job_id ASC) AS line, "
                    + "job.* FROM job WHERE job_name LIKE ? ) t WHERE t.line > ? AND t.line <= ? "
                    + "ORDER BY t.job_id ASC;";
        }
        //定义数据模型数组
        ArrayList<JobPageItemBean> arrayList = new ArrayList<>();
        try {
            //预编译SQL语句
            ps = conn.prepareStatement(sql);
            //判断关键词是否为空
            if (jobData.getKeyword() == null) {
                ps.setInt(1, (jobData.getCurPage() - 1) * jobData.getJobsAPage());
                ps.setInt(2, jobData.getCurPage() * jobData.getJobsAPage());
            } else {
                ps.setString(1, "%" + jobData.getKeyword() + "%");
                ps.setInt(2, (jobData.getCurPage() - 1) * jobData.getJobsAPage());
                ps.setInt(3, jobData.getCurPage() * jobData.getJobsAPage());
            }
            //执行并获取执行结果
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取所有记录数
                if (jobData.getTotalJobs() == 0) {
                    int total = rs.getInt("total");
                    jobData.setTotalJobs(total);
                }
                //获取数据
                int jobId = rs.getInt("job_id");
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                int companyId = rs.getInt("company_id");
                //封装数据
                JobPageItemBean job = new JobPageItemBean(jobId, jobName, pay, companyId);
                //调用CompanyDao的方法获取公司信息
                CompanyDao.selectCompanyByCompanyId(job);
                //数据加入数组
                arrayList.add(job);
            }
            //封装数据
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
