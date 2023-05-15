package com.networkrecruitmentsystem.service;

import com.networkrecruitmentsystem.bean.PersonnelBean;
import com.networkrecruitmentsystem.bean.UserBean;
import com.networkrecruitmentsystem.dao.UserDao;

public class LoginService {
    public static void login(UserBean user) {
        //登录实现方法
        //调用Dao层检查登录数据
        UserDao.selectForLogin(user);
    }
    public static void login(PersonnelBean personnel) {
        //登录实现方法
        //调用Dao层检查登录数据
        UserDao.selectForLogin(personnel);
    }
}
