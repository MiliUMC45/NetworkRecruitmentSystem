package com.networkrecruitmentsystem.bean;

public class PersonnelBean {
/*    [personnel_id] [int] IDENTITY(1,1) NOT NULL,
	[company_id] [int] NOT NULL,
	[company_name] [nvarchar](30) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[telephone] [nchar](11) NULL,
    [email] [nchar](30) NULL,
    [sex] [nchar](1) NULL,*/
    private int perId;
    private int comId;
    private String comName;
    private String perPwd;
    private String perTel;
    private String perEmail;
    private String perSex;

    public PersonnelBean() {
    }

    public PersonnelBean(String comName, String perPwd) {
        this.comName = comName;
        this.perPwd = perPwd;
    }

    public PersonnelBean(int comId, String comName, String perPwd, String perTel, String perEmail, String perSex) {
        this.comId = comId;
        this.comName = comName;
        this.perPwd = perPwd;
        this.perTel = perTel;
        this.perEmail = perEmail;
        this.perSex = perSex;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
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

    public String getPerPwd() {
        return perPwd;
    }

    public void setPerPwd(String perPwd) {
        this.perPwd = perPwd;
    }

    public String getPerTel() {
        return perTel;
    }

    public void setPerTel(String perTel) {
        this.perTel = perTel;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerSex() {
        return perSex;
    }

    public void setPerSex(String perSex) {
        this.perSex = perSex;
    }
}
