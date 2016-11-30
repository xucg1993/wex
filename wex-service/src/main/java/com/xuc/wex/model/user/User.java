package com.xuc.wex.model.user;

import java.text.SimpleDateFormat;

public class User {
    public static final int SUBJECT_STATUS_EXIST = 2;
    public static final int SUBJECT_STATUS_NOT_EXIST = 1;


    public static final int  STATUS_EXIST = 2;
    public static final int  STATUS_NOT_EXIST = 1;

    private int uid;
    private String idcardno;//身份证号码
    private String password;
    private String username;
    private String mobile;//手机号
    private String weixin;//微信号
    private int sex;//性别
    private int age;//年龄
    private int status;// 1：未报名  2：报名
    private int subject1; //1;不通过  2:通过
    private int subject2; //1;不通过  2:通过
    private int subject3; //1;不通过  2:通过
    private int subject4; //1;不通过  2:通过
    private long entrydate;
    private long enddate;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
    }

    public int getSubject4() {
        return subject4;
    }

    public void setSubject4(int subject4) {
        this.subject4 = subject4;
    }

    public long getEntrydate() {
        return entrydate;
    }

    public String getFormatEntrydate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(entrydate);
    }

    public void setEntrydate(long entrydate) {
        this.entrydate = entrydate;
    }

    public long getEnddate() {
        return enddate;
    }

    public String getFormatEnddate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(enddate);
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }
}
