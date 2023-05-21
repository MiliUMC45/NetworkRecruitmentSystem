package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.CompanypageBean;
import com.networkrecruitmentsystem.dao.CompanyDao;


public class CompanyPageService {
    public static void prepareCompanyPage(CompanypageBean CompanyData) {
        CompanyDao.selectCompanyForCompanyPage(CompanyData);
    }
}
