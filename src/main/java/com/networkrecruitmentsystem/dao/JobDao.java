package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobDao {
    public static void selectHotJobById(int jobId, HotJobBean hotJob) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM job WHERE job_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, jobId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String jobName = rs.getString("job_name");
                String pay = rs.getString("pay");
                int company_id = rs.getInt("company_id");

                hotJob.setJobId(jobId);
                hotJob.setJobName(jobName);
                hotJob.setPay(pay);
                hotJob.setCompanyId(company_id);

                CompanyDao.selectHotJobByCompanyId(company_id, hotJob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
