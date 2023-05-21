package com.networkrecruitmentsystem.dao;

import com.networkrecruitmentsystem.bean.HotCompanyBean;
import com.networkrecruitmentsystem.bean.UserBean;

public interface IuserDao {

    void saveUser(UserBean user);
    //UserBean finduserName(String uname);
    boolean isExistUser(String user);
    void savePersonnels(UserBean personnels, HotCompanyBean pes);

    boolean isExistPersonnel(String username);
}
