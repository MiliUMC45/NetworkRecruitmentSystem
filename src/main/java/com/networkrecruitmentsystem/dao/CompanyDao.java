package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.*;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public static void selectCompanyDetail(CompanyBean CompanyData) {
        //通过公司ID获取职位公司信息
        //建立数据库连接
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company WHERE company_id=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setInt(1, CompanyData.getCompanyId());
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取数据
                String companyName = rs.getString("company_name");
                String Kind = rs.getString("kind");
                String instruction = rs.getString("introduction");
                //封装数据
                CompanyData.setCompanyName(companyName);
                CompanyData.setKind(Kind);
                CompanyData.setIntroduction(instruction);
            }
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }

    public static void selectCompanyForCompanyPage(CompanypageBean CompanyData) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        if (CompanyData.getKeyword() == null) {
            sql = "SELECT * FROM(SELECT ROW_NUMBER() OVER ( ORDER BY company_id ASC ) AS line, "
                    + "COUNT(company_id) OVER () AS total, * FROM company) company "
                    + "WHERE line>? AND line<=?";
        } else {
            sql = "SELECT COUNT(*) OVER () AS total, "
                    + "t.* FROM (SELECT ROW_NUMBER() OVER (ORDER BY company_id ASC) AS line, "
                    + "company.* FROM company WHERE company_name LIKE ? ) t WHERE t.line > ? AND t.line <= ? "
                    + "ORDER BY t.company_id ASC;";
        }
        ArrayList<CompanyItemBean> arrayList = new ArrayList<>();
        try{
            ps = conn.prepareStatement(sql);
            if (CompanyData.getKeyword() == null) {
                ps.setInt(1, (CompanyData.getCurPage() - 1) * CompanyData.getCompaniesAPage());
                ps.setInt(2, CompanyData.getCurPage() * CompanyData.getCompaniesAPage());
            } else {
                ps.setString(1, "%" + CompanyData.getKeyword() + "%");
                ps.setInt(2, (CompanyData.getCurPage() - 1) * CompanyData.getCompaniesAPage());
                ps.setInt(3, CompanyData.getCurPage() * CompanyData.getCompaniesAPage());
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                //获取所有记录数
                if (CompanyData.getTotalCompanies() == 0) {
                    int total = rs.getInt("total");
                    CompanyData.setTotalCompanies(total);
                }   //获取数据
                int CompanyId = rs.getInt("company_id");
                String CompanyName = rs.getString("company_name");
                String kind = rs.getString("kind");
                String CompanyIcon = rs.getString("icon");
                //封装数据
                CompanyItemBean Company = new CompanyItemBean(CompanyId, CompanyName, kind, CompanyIcon);
                //数据加入数组
                arrayList.add(Company);
            }

            CompanyData.setCompanyList(arrayList);
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
