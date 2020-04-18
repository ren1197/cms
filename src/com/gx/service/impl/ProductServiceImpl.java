package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.dao.XxProductMapper;
import com.gx.po.XxProduct;
import com.gx.po.XxProductExample;
import com.gx.po.XxProductExample.Criteria;
import com.gx.result.GridResult;
import com.gx.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private XxProductMapper ProductMapper; // 注入dao层

	@Override
	public XxProduct getProductById(long id) {
		// 根据主键查询
		XxProductExample example = new XxProductExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(id);
		// 执行查询
		List<XxProduct> list = ProductMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public GridResult getXxProductList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		XxProductExample example = new XxProductExample();
		List<XxProduct> list = ProductMapper.selectByExample(example);
		// 创建一个返回值对象
		GridResult result = new GridResult();
		result.setRows(list);
		// 取分页结果
		PageInfo<XxProduct> pageInfo = new PageInfo<>(list);
		// 取总记录数
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;

	}

}
