package com.gx.dao.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gx.dao.XxProductMapper;
import com.gx.po.XxProduct;
import com.gx.po.XxProductExample;
import com.gx.po.XxProductExample.Criteria;

public class ProductDaoTest extends BaseTest{
	@Autowired
	private XxProductMapper xxProductMapper;
	
	
	@Test
	public void testProductfindById(){
		// 初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		// 从容器中获得Mapper代理对象
		XxProductMapper xxProductMapper = applicationContext.getBean(XxProductMapper.class);
		// 根据主键查询
		XxProductExample example = new XxProductExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(1L);
		// 执行查询
		List<XxProduct> list = xxProductMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0));
		}

	}
	

	@Test
	public void testProductfindByName(){
		// 初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		// 从容器中获得Mapper代理对象
		XxProductMapper xxProductMapper = applicationContext.getBean(XxProductMapper.class);
	
		// 执行查询
		List<XxProduct> list = xxProductMapper.findProductByName("尚都");
		System.out.println(list.size());
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getName());
		}

	}
	

	@Test
	public void testProductfindByName2(){
		// 执行查询
		List<XxProduct> list = xxProductMapper.findProductByName("尚都");
		System.out.println(list.size());
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getName());
		}

	}
}
