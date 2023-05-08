package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class MainPageBean {
    private ArrayList<HotJobBean> hotJobList;
    private ArrayList<HotCompanyBean> hotCompanyList;

    public MainPageBean() {
    }

    public MainPageBean(ArrayList<HotJobBean> hotJobList, ArrayList<HotCompanyBean> hotCompanyList) {
        this.hotJobList = hotJobList;
        this.hotCompanyList = hotCompanyList;
    }

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
