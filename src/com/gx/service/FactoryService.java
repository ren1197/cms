package com.gx.service;

import java.util.List;
import java.util.Map;

import com.gx.po.XxFactory;
import com.gx.utils.PageBean;


public interface FactoryService {
	public List<XxFactory> findByPage(int pageNo, int pageSize);		//分页查询
	public List<XxFactory> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public XxFactory get(int id);			//只查询一个，常用于修改
	public void insert(XxFactory entity);				//插入，用实体作为参数
	public void update(XxFactory entity);				//修改，用实体作为参数
	public void deleteById(int id);		//按id删除，删除一条；支持整数型和字符串类型ID
	
	public void delete(int[] ids);			//批量删除；支持整数型和字符串类型ID
	public void start(int[] ids);		//启用
	public void stop(int[] ids);			//停用
	
	 //分页查询数据
	public int getTotalSize();
}
