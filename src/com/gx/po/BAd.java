package com.gx.po;

import java.util.Date;

public class BAd {
    private Integer id;

    private String title;

    private Date creatdate;

    private Date modifydate;

    private Date begindate;

    private Date enddate;

    private String url;

    private Integer adpositionid;

    private Integer isdel;

    private String path;

    private Integer type;

    private String path2;

    private String path3;

    private String path5;

    private String path4;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getAdpositionid() {
        return adpositionid;
    }

    public void setAdpositionid(Integer adpositionid) {
        this.adpositionid = adpositionid;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2 == null ? null : path2.trim();
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3 == null ? null : path3.trim();
    }

    public String getPath5() {
        return path5;
    }

    public void setPath5(String path5) {
        this.path5 = path5 == null ? null : path5.trim();
    }

    public String getPath4() {
        return path4;
    }

    public void setPath4(String path4) {
        this.path4 = path4 == null ? null : path4.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}