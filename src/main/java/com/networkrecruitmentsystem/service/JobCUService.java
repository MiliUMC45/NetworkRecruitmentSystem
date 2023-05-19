package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.dao.JobDao;

public class JobCUService {
    //获取修改职位数据方法
    public static void prepareJobDateForCU(JobBean jobDate) {
        JobDao.selectJobByJobId(jobDate);
    }

    //修改职位数据方法
    public static void updateJobDate(JobBean jobDate) {
        JobDao.updateJobByJobId(jobDate);
    }

    //新增职位数据方法
    public static void insertDateIntoJob(JobBean jobDate) {
        JobDao.insertJobDate(jobDate);
    }

    //删除职位数据方法
    public static void deleteJobDate(int jobId) {
        JobDao.deleteJobDateByJobId(jobId);
    }
}
