package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.PersonnelBean;
import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public static void selectForLogin(UserBean user) {
        //登录功能数据库对比方法
        //建立数据库连接
        Connection conn = DBTools.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from users where username=? and password=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            //当查询到对应数据时循环进行
            while (rs.next()) {
                //获取用户数据
                int id = rs.getInt("user_id");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                //封装数据
                user.setUserId(id);
                user.setSex(sex);
                user.setEmail(email);
                user.setTelephone(telephone);
            }
        } catch (Exception e) {
            //输出错误信息，并将用户ID赋值为-1以供检查
            e.printStackTrace();
            user.setUserId(-1);
        } finally {
            //释放数据库链接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
    public static void selectForLogin(PersonnelBean personnel) {
        //登录功能数据库对比方法
        //建立数据库连接
        Connection conn = DBTools.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from personnels where username=? and password=?";
        try {
            //预编译SQL语句，执行并获取数据集
            ps = conn.prepareStatement(sql);
            ps.setString(1, personnel.getPerName());
            ps.setString(2, personnel.getPerPwd());
            rs = ps.executeQuery();
            //当查询到对应数据时循环进行
            while (rs.next()) {
                //获取用户数据
                int perId = rs.getInt("personnel_id");
                String perName = rs.getString("username");
                int comId = rs.getInt("company_id");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                //封装数据
                personnel.setPerId(perId);
                personnel.setPerName(perName);
                personnel.setComId(comId);
                personnel.setPerTel(telephone);
                personnel.setPerEmail(email);
                personnel.setPerSex(sex);
            }
        } catch (Exception e) {
            //输出错误信息，并将用户ID赋值为-1以供检查
            e.printStackTrace();
            personnel.setPerId(-1);
        } finally {
            //释放数据库链接资源
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
