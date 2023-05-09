package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class HotCompanyBean {   //热门公司数据封装类
    private int comId;  //公司ID
    private String comName; //公司名
    private String comKind; //公司类别
    private String comIcon; //公司图标地址
    private ArrayList<JobBean> jobList; //公司职位列表

    //构造方法
    public HotCompanyBean() {
    }

    //各变量的getter和setter方法
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComKind() {
        return comKind;
    }

    public void setComKind(String comKind) {
        this.comKind = comKind;
    }

    public String getComIcon() {
        return comIcon;
    }

    public void setComIcon(String comIcon) {
        this.comIcon = comIcon;
    }

    public ArrayList<JobBean> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<JobBean> jobList) {
        this.jobList = jobList;
    }
}
