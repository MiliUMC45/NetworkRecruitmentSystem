package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.JobPageBean;
import com.networkrecruitmentsystem.dao.JobDao;

public class JobPageService {
    public static void prepareJobData(JobPageBean jobData) {
        if (jobData.getKeyword() != null) {
            JobDao.selectJobForJobPage(jobData);
        }
    }
}
