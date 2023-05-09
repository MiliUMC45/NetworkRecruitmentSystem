package com.networkrecruitmentsystem.bean;

public class JobPageItemBean {
    private int jobId;
    private String jobName;
    private String pay;
    private int companyId;
    private String companyName;
    private String companyKind;
    private String icon;

    public JobPageItemBean() {
    }

    public JobPageItemBean(int jobId, String jobName, String pay, int companyId) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.pay = pay;
        this.companyId = companyId;
    }

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
