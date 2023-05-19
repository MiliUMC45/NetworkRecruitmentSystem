package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.JobBean;
import com.networkrecruitmentsystem.dao.JobDao;

import java.util.ArrayList;

public class PostedJobService {
    public static void prepareJobDate(int comId, ArrayList<JobBean> jobDate) {
        //调用Dao层获取已发布职位列表
        JobDao.selectJobWhichPosted(comId, jobDate);
    }
}
