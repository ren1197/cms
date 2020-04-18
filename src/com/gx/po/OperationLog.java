package com.gx.po;

import java.util.Date;

public class OperationLog extends BaseEntity{
    public static final String INSERT="添加操作";
    public static final String UPDATE="修改操作";
    public static final String DELETE="彻底删除操作";
    public static final String LOGIC_DELETE="逻辑删除操作";


    private Integer userId;

    private String userName;

    private Date timestamp;

    private String operation;

    private String params;

    private String operationType;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getUserId() {
        return userId;
    }

    public OperationLog setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public OperationLog setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public OperationLog setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public OperationLog setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public String getParams() {
        return params;
    }

    public OperationLog setParams(String params) {
        this.params = params;
        return this;
    }
}