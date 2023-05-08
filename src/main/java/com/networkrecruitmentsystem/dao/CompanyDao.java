package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDao {
    public static void selectHotJobCompanyByCompanyId(int companyId, HotJobBean hotJob) {
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
                String companyKind = rs.getString("kind");
                hotJob.setCompanyName(companyName);
                hotJob.setCompanyKind(companyKind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectHotCompanyByCompanyId(int companyId, HotCompanyBean hotCompany){
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
                String companyKind = rs.getString("kind");
                String companyIcon = rs.getString("icon");
                hotCompany.setComId(companyId);
                hotCompany.setComName(companyName);
                hotCompany.setComKind(companyKind);
                hotCompany.setComIcon(companyIcon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
