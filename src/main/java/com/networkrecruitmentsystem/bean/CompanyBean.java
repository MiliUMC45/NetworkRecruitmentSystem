package com.networkrecruitmentsystem.bean;

public class CompanyBean {


    private int CompanyId;  //公司ID
    private String CompanyName; //公司名
    private String kind; //公司类型
    private String introduction;    //公司描述
    private String icon;    //职位所属公司图标地址





    public CompanyBean() {
    }

    public CompanyBean(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public CompanyBean(int CompanyId, String CompanyName, String kind, String introduction,String icon) {
        this.CompanyId = CompanyId;
        this.CompanyName = CompanyName;
        this.kind = kind;
        this.introduction = introduction;
        this.icon = icon;
    }

    //各变量getter和setter方法
    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
