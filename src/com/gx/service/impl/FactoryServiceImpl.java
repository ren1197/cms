package com.gx.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.gx.dao.XxFactoryMapper;
import com.gx.po.XxFactory;
import com.gx.po.XxFactoryExample;
import com.gx.po.XxFactoryExample.Criteria;
import com.gx.service.FactoryService;
import com.gx.utils.PageBean;

@Service
public class FactoryServiceImpl implements FactoryService {
	@Autowired
	XxFactoryMapper factoryMapper;

	@Override
	public List<XxFactory> findByPage(int pageNo, int pageSize) {
		// 设置分页信息
		PageHelper.startPage(pageNo, pageSize);
		// 执行查询
		XxFactoryExample example = new XxFactoryExample();
		List<XxFactory> factoryList = factoryMapper.selectByExample(example);
		return factoryList;
	}

	// 按条件查询，没有条件则查询所有
	@Override
	public List<XxFactory> find(Map paraMap) {
		XxFactoryExample example = new XxFactoryExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		// criteria.andIdEqualTo(id);
		// 执行查询
		List<XxFactory> list = factoryMapper.selectByExample(example);
		return list;
	}

	// 按id查找一条记录
	@Override
	public XxFactory get(int id) {
		return factoryMapper.selectByPrimaryKey(id);
	}

	// 添加一条记录
	@Override
	public void insert(XxFactory entity) {
		entity.setState(1); // 0停用1启用
		factoryMapper.insert(entity);
	}

	// 更新记录
	@Override
	public void update(XxFactory entity) {
		entity.setCreateTime(new Date());
		factoryMapper.updateByPrimaryKey(entity);
	}

	// 按id删除记录
	@Override
	public void deleteById(int id) {
		factoryMapper.deleteByPrimaryKey(id);
	}

	// 批量删除记录
	@Override
	public void delete(int[] ids) {
		factoryMapper.deleteAll(ids);
	}

	// 启用一个或多个
	@Override
	public void start(int[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1); // 1启用
		map.put("ids", ids);
		factoryMapper.updateState(map);
	}

	// 停用一个或多个
	@Override
	public void stop(int[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 0); // 1停用
		map.put("ids", ids);
		factoryMapper.updateState(map);
	}

	@Override
	public int getTotalSize() {
		XxFactoryExample example = new XxFactoryExample();
		int count=factoryMapper.countByExample(example);
		return count;
	}

}
