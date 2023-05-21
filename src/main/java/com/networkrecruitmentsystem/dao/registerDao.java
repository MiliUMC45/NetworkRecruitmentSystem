package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registerDao implements IuserDao{
    @Override
    public void saveUser(UserBean user) {
        Connection connection = DBTools.getConn();
        String sql = "insert into users values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getTelephone());
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBTools.closeDBResource(null,ps,connection);
        }
    }
    @Override
    public void savePersonnels(UserBean personnels, HotCompanyBean pes) {
        Connection connection = DBTools.getConn();
        String sql = "insert into personnels values (?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, personnels.getUsername());
            ps.setInt(2, pes.getComId());
            ps.setString(3, personnels.getPassword());
            ps.setString(4, personnels.getTelephone());
            ps.setString(5, personnels.getEmail());
            ps.setString(6, personnels.getSex());
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBTools.closeDBResource(null,ps,connection);
        }
    }
    @Override
    public boolean isExistUser(String username){
        boolean flag = false;
        Connection connection = DBTools.getConn();
        String sql = "select * from users where username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBTools.closeDBResource(null,ps,connection);
        }
        return flag;
    }
    @Override
    public boolean isExistPersonnel(String username){
        boolean flag = false;
        Connection connection = DBTools.getConn();
        String sql = "select * from personnels where username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBTools.closeDBResource(null,ps,connection);
        }
        return flag;
    }
}
