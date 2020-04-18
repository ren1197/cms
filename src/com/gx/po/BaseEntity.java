package com.gx.po;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseEntity {
    protected Integer id;
    protected Integer createBy;
    protected Date createTime;
    protected Integer updateBy;
    protected Date updateTime;
    protected Map<String, Object> query;
    protected UserPo createUser;
    protected UserPo updateUser;
    protected Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }

    public BaseEntity setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }

    public UserPo getCreateUser() {
        return createUser;
    }

    public BaseEntity setCreateUser(UserPo createUser) {
        this.createUser = createUser;
        return this;
    }

    public UserPo getUpdateUser() {
        return updateUser;
    }

    public BaseEntity setUpdateUser(UserPo updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public Map<String, Object> getQuery() {
        return query == null ? new HashMap<String, Object>() : query;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }

    public BaseEntity setAdd(UserPo user) {
        if (user != null)
            this.createBy = user.getId();
        return setAdd();
    }

    public BaseEntity setAdd() {
        setCreateTime(new Date());
        return this;
    }

    public BaseEntity setUpdate(UserPo user) {
        if (user != null)
            this.updateBy = user.getId();
        return setUpdate();
    }

    public BaseEntity setUpdate() {
        setUpdateTime(new Date());
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
