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
        ArrayList<HotJobBean> arrayList = new ArrayList<HotJobBean>();
        for (int i = 1; i <= 6 ;i++) {
            HotJobBean hotJob = new HotJobBean();
            JobDao.selectHotJobById(i, hotJob);
            arrayList.add(hotJob);
        }
        mainData.setHotJobList(arrayList);
    }

    public static void selectHotCompany(MainPageBean mainData) {
        Connection conn = DBTools.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM company";
        try {
            ps = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBTools.closeDBResource(rs, ps, conn);
        }
    }
}
