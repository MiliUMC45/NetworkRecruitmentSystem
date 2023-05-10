package com.networkrecruitmentsystem.bean;

public class JobBean {  //职位数据封装类
    private int jobId;  //职位ID
    private String jobName; //职位名
    private String pay; //职位薪酬
    private int companyId;  //职位所属公司ID
    private String introduction;    //职位描述

    //构造方法
    public JobBean() {
    }

    public JobBean(int jobId) {
        this.jobId = jobId;
    }

    //各变量getter和setter方法
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
