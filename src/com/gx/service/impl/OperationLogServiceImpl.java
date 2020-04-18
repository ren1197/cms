package com.gx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.dao.OperationLogMapper;
import com.gx.po.OperationLog;
import com.gx.po.UserPo;
import com.gx.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class OperationLogServiceImpl implements OperationLogService {
	@Autowired
	OperationLogMapper operationLogMapper;
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		operationLogMapper.delete(id);
	}

	@Override
	public void logicDelete(Integer id) {
		operationLogMapper.logicDelete(id);
	}

	@Override
	public void deleteAll(Integer[] id) {
		operationLogMapper.deleteAll(id);
	}

	@Override
	public void logicDeleteAll(Integer[] id) {
		operationLogMapper.logicDeleteAll(id);
	}

	@Override
	public void insert(OperationLog record) {
		// TODO Auto-generated method stub
		operationLogMapper.insert(record);
	}

	@Override
	public OperationLog getOne(OperationLog t) {
		// TODO Auto-generated method stub
		return operationLogMapper.getOne(t);
	}

	@Override
	public OperationLog get(Integer id) {
		// TODO Auto-generated method stub
		return operationLogMapper.get(id);
	}

	@Override
	public void update(OperationLog record) {
		// TODO Auto-generated method stub
		operationLogMapper.update(record);
	}

	@Override
	public List<OperationLog> getList(OperationLog t) {
		// TODO Auto-generated method stub
		return operationLogMapper.getList(t);
	}


	@Override
	public PageInfo<OperationLog> getPage(OperationLog t, Integer pageNo, Integer pageSize) {
		Map<String, Object> map = t.getQuery();
		PageHelper.startPage(pageNo, pageSize);
		if (map.containsKey("order")) {
			PageHelper.orderBy((String) map.get("order"));
			map.remove("order");
			t.setQuery(map);
		}
		return new PageInfo<>(operationLogMapper.getList(t));
	}

	@Override
	public void createLog(UserPo login, String params, String operation,String operationType) {
		OperationLog log=new OperationLog();
		log.setParams(params).setOperation(operation).setTimestamp(new Date()).setOperationType(operationType);
		if (login!=null){
			log.setUserId(login.getId());
			log.setUserName(login.getUserName());
		}
		operationLogMapper.insert(log);
	}


}
