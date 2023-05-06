package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class MainPageBean {
    private ArrayList<HotJobBean> hotJobList;
    private ArrayList hotCompanyList;

    public MainPageBean() {
    }

    public MainPageBean(ArrayList<HotJobBean> hotJobList, ArrayList hotCompanyList) {
        this.hotJobList = hotJobList;
        this.hotCompanyList = hotCompanyList;
    }

    public ArrayList<HotJobBean> getHotJobList() {
        return hotJobList;
    }

    public void setHotJobList(ArrayList<HotJobBean> hotJobList) {
        this.hotJobList = hotJobList;
    }

    public ArrayList getHotCompanyList() {
        return hotCompanyList;
    }

    public void setHotCompanyList(ArrayList hotCompanyList) {
        this.hotCompanyList = hotCompanyList;
    }
}
