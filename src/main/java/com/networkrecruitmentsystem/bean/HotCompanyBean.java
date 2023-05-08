package com.networkrecruitmentsystem.bean;

import java.util.ArrayList;

public class HotCompanyBean {
    private int comId;
    private String comName;
    private String comKind;
    private String comIcon;
    private ArrayList<JobBean> jobList;

    public HotCompanyBean() {
    }

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
