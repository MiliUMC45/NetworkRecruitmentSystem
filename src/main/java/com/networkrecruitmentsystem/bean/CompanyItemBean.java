package com.networkrecruitmentsystem.bean;

public class CompanyItemBean {
    private int CompanyId;  //公司ID
    private String CompanyName; //公司名
    private String kind; //公司种类
    private String CompanyIcon;    //职位所属公司图标地址
    public  CompanyItemBean(){
    }
    public CompanyItemBean(int CompanyId,String CompanyName,String kind,String CompanyIcon){
        this.CompanyId = CompanyId;
        this.CompanyName = CompanyName;
        this.kind = kind;
        this.CompanyIcon = CompanyIcon;
    }
    public int getCompanyId() {
        return CompanyId;
    }
    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }
    public String getCompanyName() {
        return CompanyName;
    }
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getIcon() {
        return CompanyIcon;
    }
    public void setIcon(String icon) {
        this.CompanyIcon = icon;
    }

}
