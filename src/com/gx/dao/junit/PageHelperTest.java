package com.gx.dao.junit;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.dao.XxProductMapper;
import com.gx.po.XxProduct;
import com.gx.po.XxProductExample;

public class PageHelperTest {
	 
	public static void main(String args[]){
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		//从容器中获得Mapper代理对象
		XxProductMapper xxProductMapper = applicationContext.getBean(XxProductMapper.class);
		//执行sql语句之前设置分页信息使用PageHelper的startPage方法。
       //获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(1, 10);
		//执行查询
		XxProductExample example = new XxProductExample();
		List<XxProduct> list = xxProductMapper.selectByExample(example);
		//取分页信息，PageInfo。1、总记录数2、总页数 。当前页码
		PageInfo<XxProduct> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(list.size());
	}
	 
	
}

