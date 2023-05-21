package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.CompanyBean;
import com.networkrecruitmentsystem.dao.CompanyDao;
public class CompanyDetailService {
    public static void prepareCompanyDetail(CompanyBean Company) {
        CompanyDao.selectCompanyDetail(Company);
    }
}
