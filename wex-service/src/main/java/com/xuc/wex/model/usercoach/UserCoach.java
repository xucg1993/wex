package com.xuc.wex.model.usercoach;

/**
 * Created by XCG on 2016/11/26.
 */
public class UserCoach {
    private int uid;
    private int cid;
    private String username;
    private String coachname;
    private long entrytime;// '0',
    private String fine;// '等级  1：金牌教练  2：银牌教练 3：铜牌教练',

    private String comobile;//手机号
    private String usmobile;//手机号
    private String coweixin;//微信号
    private String usweixin;//微信号
    private int cosex;//性别
    private int ussex;//性别
    private int coage;//年龄
    private int usage;//年龄
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        this.coachname = coachname;
    }

    public long getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(long entrytime) {
        this.entrytime = entrytime;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getComobile() {
        return comobile;
    }

    public void setComobile(String comobile) {
        this.comobile = comobile;
    }

    public String getUsmobile() {
        return usmobile;
    }

    public void setUsmobile(String usmobile) {
        this.usmobile = usmobile;
    }

    public String getCoweixin() {
        return coweixin;
    }

    public void setCoweixin(String coweixin) {
        this.coweixin = coweixin;
    }

    public String getUsweixin() {
        return usweixin;
    }

    public void setUsweixin(String usweixin) {
        this.usweixin = usweixin;
    }

    public int getCosex() {
        return cosex;
    }

    public void setCosex(int cosex) {
        this.cosex = cosex;
    }

    public int getUssex() {
        return ussex;
    }

    public void setUssex(int ussex) {
        this.ussex = ussex;
    }

    public int getCoage() {
        return coage;
    }

    public void setCoage(int coage) {
        this.coage = coage;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
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

    public void setEntrydate(long entrydate) {
        this.entrydate = entrydate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }
}
