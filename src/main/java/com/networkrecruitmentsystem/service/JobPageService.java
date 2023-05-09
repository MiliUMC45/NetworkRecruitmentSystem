package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.JobPageBean;
import com.networkrecruitmentsystem.dao.JobDao;

public class JobPageService {
    public static void prepareJobData(JobPageBean jobData) {
        //准备职位数据方法
        //调用Dao层获取职位数据
        JobDao.selectJobForJobPage(jobData);
    }
}
