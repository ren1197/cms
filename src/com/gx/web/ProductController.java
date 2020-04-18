package com.gx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.po.XxProduct;
import com.gx.result.GridResult;
import com.gx.service.ProductService;

/**
 * 商品管理Controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/findProductById")
	@ResponseBody
	// 测试
	// http://localhost:8080/ssmgrogshop/product/findProductById.do?id=1
	private XxProduct getItemById(Long id) {
		System.out.println(id);
		XxProduct xxProduct = productService.getProductById(id);
		System.out.println(xxProduct.getName());
		return null;
	}

//	 @RequestMapping("/list")
//	 @ResponseBody
//	 // http://localhost:8080/ssmgrogshop/product/list.do?page=1&rows=5
//	 public GridResult getItemList(Integer page, Integer rows) {
//	 // 调用服务查询商品列表
//	 GridResult result = productService.getXxProductList(page, rows);
//	 System.out.println(result.getRows().size());
//	 return result;
//	 }

		// 客户列表
		@RequestMapping(value = "/list")
		public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, Model model) {
			GridResult result = productService.getXxProductList(page, rows);
			model.addAttribute("result", result);
			return "product/list";
		}
}
