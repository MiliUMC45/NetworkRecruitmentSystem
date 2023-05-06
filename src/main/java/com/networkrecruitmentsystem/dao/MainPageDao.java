package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.bean.MainPageBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MainPageDao {
    public static void selectHotJob(MainPageBean mainData) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM hot_job";
        ArrayList<HotJobBean> arrayList = new ArrayList<HotJobBean>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("job_id");
                String jobName = rs.getString("job_name");
                String companyName = rs.getString("company_name");
                String companyKind = rs.getString("company_kind");
                String pay = rs.getString("pay");

                HotJobBean hotJob = new HotJobBean(id, jobName, companyName, companyKind, pay);
                arrayList.add(hotJob);
            }
            mainData.setHotJobList(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
