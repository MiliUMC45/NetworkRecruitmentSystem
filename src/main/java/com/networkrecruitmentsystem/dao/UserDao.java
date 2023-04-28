package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public static void selectForLogin(UserBean user) {
        //
        Connection conn = DBTools.getConn();
        String sql = "select * from users where username=? and password=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");

                user.setUserId(id);
                user.setSex(sex);
                user.setEmail(email);
                user.setTelephone(telephone);
            }
            System.out.println(user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            user.setUserId(-1);
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
