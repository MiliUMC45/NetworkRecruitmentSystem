package com.networkrecruitmentsystem.bean;

public class HotJobBean {
    private int jobId;
    private String jobName;
    private String companyName;
    private String companyKind;
    private String pay;

    public HotJobBean() {
    }

    public HotJobBean(int jobId, String jobName, String companyName, String companyKind, String pay) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.companyName = companyName;
        this.companyKind = companyKind;
        this.pay = pay;
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
