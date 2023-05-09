package com.networkrecruitmentsystem.bean;

public class JobPageItemBean {  //职位页面单个职位数据封装类
    private int jobId;  //职位ID
    private String jobName; //职位名
    private String pay; //职位薪酬
    private int companyId;  //职位所属公司ID
    private String companyName; //职位所属公司名
    private String companyKind; //职位所属公司类别
    private String icon;    //职位所属公司图标地址

    //构造方法
    public JobPageItemBean() {
    }

    public JobPageItemBean(int jobId, String jobName, String pay, int companyId) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.pay = pay;
        this.companyId = companyId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyKind() {
        return companyKind;
    }

    public void setCompanyKind(String companyKind) {
        this.companyKind = companyKind;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "JobPageItemBean{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", pay='" + pay + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyKind='" + companyKind + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
