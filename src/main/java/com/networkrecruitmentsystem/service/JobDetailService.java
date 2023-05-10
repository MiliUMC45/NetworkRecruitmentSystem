package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.dao.JobDao;

public class JobDetailService {
    public static void prepareJobDetail(JobBean job) {
        JobDao.selectJobByJobId(job);
    }
}
