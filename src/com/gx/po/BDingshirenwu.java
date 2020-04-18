package com.gx.po;

import java.util.Date;

public class BDingshirenwu {
    private Integer id;

    private Integer aid;

    private Date pubtime;

    private Date stoptime;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}