package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class MainPageBean { //主页数据封装类
    private ArrayList<HotJobBean> hotJobList;   //热门职位数据列表
    private ArrayList<HotCompanyBean> hotCompanyList;   //热门公司数据列表

    //构造方法
    public MainPageBean() {
    }

    public MainPageBean(ArrayList<HotJobBean> hotJobList, ArrayList<HotCompanyBean> hotCompanyList) {
        this.hotJobList = hotJobList;
        this.hotCompanyList = hotCompanyList;
    }

    //各变量getter和setter方法
    public ArrayList<HotJobBean> getHotJobList() {
        return hotJobList;
    }

    public void setHotJobList(ArrayList<HotJobBean> hotJobList) {
        this.hotJobList = hotJobList;
    }

    public ArrayList<HotCompanyBean> getHotCompanyList() {
        return hotCompanyList;
    }

    public void setHotCompanyList(ArrayList<HotCompanyBean> hotCompanyList) {
        this.hotCompanyList = hotCompanyList;
    }
}
