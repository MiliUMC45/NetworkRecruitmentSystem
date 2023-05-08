package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobDao {
    public static void selectHotJobByJobId(int jobId, HotJobBean hotJob) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM job WHERE job_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, jobId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                int company_id = rs.getInt("company_id");

                hotJob.setJobId(jobId);
                hotJob.setJobName(jobName);
                hotJob.setPay(pay);
                hotJob.setCompanyId(company_id);

                CompanyDao.selectHotJobCompanyByCompanyId(company_id, hotJob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectJobByCompanyId(int companyId, HotCompanyBean hotCompany) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM job WHERE company_id=?";
        ArrayList<JobBean> jobList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
            rs = ps.executeQuery();
            for (int i = 1; i <= 3 && rs.next(); i++) {
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                JobBean job = new JobBean();
                job.setJobName(jobName);
                job.setPay(pay);
                jobList.add(job);
            }
            hotCompany.setJobList(jobList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
