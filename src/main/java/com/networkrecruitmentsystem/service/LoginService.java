package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.dao.UserDao;

public class LoginService {
    public static void login(UserBean user) {
        UserDao.selectForLogin(user);
    }
}
