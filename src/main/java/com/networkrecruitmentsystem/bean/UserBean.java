package com.networkrecruitmentsystem.bean;

public class UserBean { //普通用户数据封装类
/*    [user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nchar](20) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[sex] [nchar](1) NULL,
    [email] [nchar](30) NULL,
    [telephone] [nchar](11) NULL*/
    private int userId; //用户ID
    private String username;    //用户名
    private String password;    //用户密码
    private String sex; //用户性别
    private String email;   //用户电子邮件地址
    private String telephone;   //用户电话

    //构造方法
    public UserBean() {
    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserBean(int userId, String username, String password, String sex, String email, String telephone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
    }

    //各变量getter和setter方法
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
