package com.networkrecruitmentsystem.util;

import java.sql.*;

public class DBTools {
    public static Connection getConn() {
        //数据库连接方法
        //数据库链接URL
        String DBurl = "jdbc:sqlserver://localhost:1433;DatabaseName=RecruitmentSystem;encrypt=false;";
        //数据库登录名和密码
        String DBUser = "sa";
        String DBPwd = "abc5048398";
        //声明数据库链接对象
        Connection connection = null;
        try {
            //尝试获取连接
            connection = DriverManager.getConnection(DBurl, DBUser, DBPwd);
        } catch (Exception e) {
            //连接失败，输出错误信息
            System.out.println("数据库连接失败，请检查配置");
            e.printStackTrace();
        }
        //返回数据库链接对象
        return connection;
    }

    public static void checkDBIdent(String tableName) {
        //检查表自增键及标识符，防止增添数据时发生错误
        Connection connection = getConn();
        Statement stmt = null;
        String sql1 = "DBCC CHECKIDENT ( " + tableName + ", NORESEED)";
        String sql2 = "DBCC CHECKIDENT ( " + tableName + ", RESEED)";
        try {
            //编译SQL语句并执行
            stmt = connection.createStatement();
            stmt.executeUpdate(sql1);
            stmt = connection.createStatement();
            stmt.executeUpdate(sql2);
        } catch (Exception e) {
            //输出错误信息
            e.printStackTrace();
        } finally {
            //释放数据库连接资源
            closeDBResource(null, stmt, connection);
        }
    }

    public static void closeDBResource(ResultSet rs, Statement stm, Connection con) {
        //释放数据库连接资源方法
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
            //输出错误信息
            System.out.println("查询失败");
            e.printStackTrace();
        }
    }
}
