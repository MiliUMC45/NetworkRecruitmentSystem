package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.dao.UserDao;

public class LoginService {
    public static void login(UserBean user) {
        //登录实现方法
        //调用Dao层检查登录数据
        UserDao.selectForLogin(user);
    }
}
