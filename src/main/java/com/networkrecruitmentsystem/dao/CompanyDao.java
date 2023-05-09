package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.bean.JobPageItemBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDao {
    public static void selectHotJobCompanyByCompanyId(int companyId, HotJobBean hotJob) {
        //通过公司ID获取热门职位的公司信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company WHERE company_id=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取数据
                String companyName = rs.getString("company_name");
                String companyKind = rs.getString("kind");
                //封装数据
                hotJob.setCompanyName(companyName);
                hotJob.setCompanyKind(companyKind);
            }
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectHotCompanyByCompanyId(int companyId, HotCompanyBean hotCompany){
        //通过公司ID获取热门公司信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company WHERE company_id=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取数据
                String companyName = rs.getString("company_name");
                String companyKind = rs.getString("kind");
                String companyIcon = rs.getString("icon");
                //封装数据
                hotCompany.setComId(companyId);
                hotCompany.setComName(companyName);
                hotCompany.setComKind(companyKind);
                hotCompany.setComIcon(companyIcon);
            }
        } catch (Exception e) {
            //输出报错信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectCompanyByCompanyId(JobPageItemBean jobData) {
        //通过公司ID获取职位公司信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company WHERE company_id=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setInt(1, jobData.getCompanyId());
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取数据
                String companyName = rs.getString("company_name");
                String companyKind = rs.getString("kind");
                String companyIcon = rs.getString("icon");
                //封装数据
                jobData.setCompanyName(companyName);
                jobData.setCompanyKind(companyKind);
                jobData.setIcon(companyIcon);
            }
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
