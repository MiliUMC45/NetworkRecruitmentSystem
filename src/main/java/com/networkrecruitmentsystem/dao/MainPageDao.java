package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.bean.MainPageBean;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainPageDao {
    public static void selectHotJob(MainPageBean mainData) {
        ArrayList<HotJobBean> arrayList = new ArrayList<>();
        for (int i = 1; i <= 6 ;i++) {
            HotJobBean hotJob = new HotJobBean();
            JobDao.selectHotJobByJobId(ThreadLocalRandom.current().nextInt(1, 19), hotJob);
            arrayList.add(hotJob);
        }
        mainData.setHotJobList(arrayList);
    }

    public static void selectHotCompany(MainPageBean mainData) {
        ArrayList<HotCompanyBean> arrayList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            HotCompanyBean hotCompany = new HotCompanyBean();
            CompanyDao.selectHotCompanyByCompanyId(i, hotCompany);
            JobDao.selectJobByCompanyId(hotCompany.getComId(), hotCompany);
            arrayList.add(hotCompany);
        }
        mainData.setHotCompanyList(arrayList);
    }
}
