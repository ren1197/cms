package com.gx.service.junit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gx.result.GridResult;
import com.gx.service.ProductService;

public class ProductServiceTest extends BaseTest{
	@Autowired
	private ProductService productService;

	@Test
	public void testProductfindByName(){
		// 执行查询
		GridResult result = productService.getXxProductList(1, 2);
		System.out.println(result);
		 
	}
}
