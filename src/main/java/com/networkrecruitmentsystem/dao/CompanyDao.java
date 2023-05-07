package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDao {
    public static void selectHotJobByCompanyId(int companyId, HotJobBean hotJob) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company WHERE company_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company_name");
                hotJob.setCompanyName(companyName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
