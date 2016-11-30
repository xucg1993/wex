package com.xuc.wex.model.team;

/**
 * Created by XCG on 2016/11/26.
 */
public class Team {
    private int tid;//
    private String teamname;//
    private String remark;// '备注',
    private String price;//价格',

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
