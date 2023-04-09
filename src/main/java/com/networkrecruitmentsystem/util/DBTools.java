package com.networkrecruitmentsystem.util;

import java.sql.*;

public class DBTools {
    public static Connection getConn() {
        String DBurl = "jdbc:sqlserver://localhost:1433;DatabaseName=supermarket;encrypt=false;";
        String DBUser = "admin";
        String DBPwd = "987654321";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBurl, DBUser, DBPwd);
        } catch (Exception e) {
            System.out.println("数据库连接失败，请检查配置");
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeDBResource(ResultSet rs, Statement stm, Connection con) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stm != null) {
                stm.close();
                stm = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("查询失败");
            e.printStackTrace();
        }
    }
}
