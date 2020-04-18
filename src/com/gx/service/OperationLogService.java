package com.gx.service;

import com.github.pagehelper.PageInfo;
import com.gx.po.OperationLog;
import com.gx.po.UserPo;

import java.util.List;

public interface OperationLogService {
	void delete(Integer id);
	void logicDelete(Integer id);

	void deleteAll(Integer[] id);
	void logicDeleteAll(Integer[] id);

    void insert(OperationLog record);

    OperationLog getOne(OperationLog record);
    
    OperationLog get(Integer id);

    void update(OperationLog record);

    List<OperationLog> getList(OperationLog record);

    PageInfo<OperationLog> getPage(OperationLog record, Integer pageNo, Integer pageSize);

    void createLog(UserPo login,String params,String operation,String operationType);
}
