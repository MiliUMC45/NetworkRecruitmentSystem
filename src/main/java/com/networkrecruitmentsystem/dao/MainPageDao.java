package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.HotJobBean;
import com.networkrecruitmentsystem.bean.MainPageBean;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainPageDao {
    public static void selectHotJob(MainPageBean mainData) {
        //获取热门职位方法
        //声明热门职位数据集
        ArrayList<HotJobBean> arrayList = new ArrayList<>();
        //获取热门职位数据，主页仅展示6个
        for (int i = 1; i <= 6 ;i++) {
            //声明热门职位数据对象
            HotJobBean hotJob = new HotJobBean();
            //通过随机数生成职位ID查询热门职位数据
            JobDao.selectHotJobByJobId(ThreadLocalRandom.current().nextInt(1, 19), hotJob);
            //将查询到的数据加入数组
            arrayList.add(hotJob);
        }
        //将查询到的热门职位数据集封装
        mainData.setHotJobList(arrayList);
    }

    public static void selectHotCompany(MainPageBean mainData) {
        //获取热门公司方法
        //声明热门公司数据集
        ArrayList<HotCompanyBean> arrayList = new ArrayList<>();
        //获取热门公司数据，主页仅展示6个
        for (int i = 1; i <= 6; i++) {
            //声明热门公司数据对象
            HotCompanyBean hotCompany = new HotCompanyBean();
            //通过公司ID查询热门公司数据
            CompanyDao.selectHotCompanyByCompanyId(i, hotCompany);
            //通过公司ID查询相应公司职位数据
            JobDao.selectJobByHotCompanyId(hotCompany.getComId(), hotCompany);
            //将查询到的数据加入数组
            arrayList.add(hotCompany);
        }
        //将查询到的热门公司数据集封装
        mainData.setHotCompanyList(arrayList);
    }
}
