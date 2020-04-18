package com.gx.service;

import com.gx.po.XxProduct;
import com.gx.result.GridResult;

public interface ProductService {
	//根据id查询商品
	public XxProduct getProductById(long id) ;
	
	public GridResult getXxProductList(int page, int rows) ;
}
