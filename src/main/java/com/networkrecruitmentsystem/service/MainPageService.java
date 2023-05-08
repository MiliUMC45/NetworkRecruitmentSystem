package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.MainPageBean;
import com.networkrecruitmentsystem.dao.MainPageDao;

public class MainPageService {
    public static void prepareMainData(MainPageBean mainPage) {
        MainPageDao.selectHotJob(mainPage);
        MainPageDao.selectHotCompany(mainPage);
    }
}
