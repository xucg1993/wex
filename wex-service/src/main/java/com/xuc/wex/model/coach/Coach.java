package com.xuc.wex.model.coach;

import java.text.SimpleDateFormat;

/**
 * Created by XCG on 2016/11/26.
 */
public class Coach {
  private int cid;
  private String coachname;//'教练姓名',
  private int age;
  private int sex;
  private long entrytime;// '0',
  private String fine;// '等级  1：金牌教练  2：银牌教练 3：铜牌教练',
  private String mobile;//
  private String weixin;//
  private String remark;//
  private int free;//'1:不加班   2：可加班',

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
    public String getFormatEntrytime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entrytime);
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
