package com.gx.dao;

import java.util.List;

import com.gx.po.OperationLog;

public interface OperationLogMapper{
	int delete(Integer id);

    int deleteAll(Integer[] ids);

    int logicDelete(Integer id);

    int logicDeleteAll(Integer[] ids);

    int update(OperationLog t);

    int insert(OperationLog t);

    OperationLog get(Integer id);

    OperationLog getOne(OperationLog t);

    List<OperationLog> getList(OperationLog t);
}