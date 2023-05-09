package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.MainPageBean;
import com.networkrecruitmentsystem.dao.MainPageDao;

public class MainPageService {
    public static void prepareMainData(MainPageBean mainPage) {
        //准备主页数据方法
        //调用Dao层方法获取热门职位数据
        MainPageDao.selectHotJob(mainPage);
        //调用Dao层方法获取热门公司数据
        MainPageDao.selectHotCompany(mainPage);
    }
}
