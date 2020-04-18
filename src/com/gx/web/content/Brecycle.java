package com.gx.web.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gx.dao.BAdMapper;
import com.gx.dao.BAdPositionMapper;
import com.gx.dao.BArticleCategoryMapper;
import com.gx.dao.BArticleMapper;
import com.gx.dao.BFriendLinkMapper;
import com.gx.po.BAd;
import com.gx.po.BAdPosition;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.utils.Page;

@Controller
@RequestMapping("/recycle")
public class Brecycle {
	 @Autowired
	private  BArticleMapper ba;
	 @Autowired
	 private  BArticleCategoryMapper ac;
	 @Autowired
		private BAdMapper ad;
	     @Autowired
	 	private BAdPositionMapper adp;
	     @Autowired
	 	private BFriendLinkMapper  fl;
	     
	 @RequestMapping("/content/articleList.action")
		public String articleList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
				Model model,Integer state,String title){	
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");
		System.out.println(state);
		System.out.println(title);
		map.put("state", state);
		map.put("title", title);
		map.put("start", (page-1)*size);
		map.put("size", size);
		List<BArticle> articleList = ba.selectAllDel(map);
		int total=ba.getTotalDelSize(map);		
		BArticleCategory example2 = new BArticleCategory();
		List<BArticleCategory> type = ac.selectAllCategory(example2);		
		//设置分页参数 
		Page<BArticle> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(articleList);
		pageBean.setTotal(total);
		model.addAttribute("page", pageBean);
		model.addAttribute("type", type);
		return "/content/Article/recyclearticle";
		}
	 
	 @RequestMapping("/content/adList.action")
		public String adList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
				Model model,String title){	
		 HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println("搜索");			
			System.out.println(title);			
			map.put("title", title);
			map.put("start", (page-1)*size);
			map.put("size", size);
			List<BAd> adList = ad.selectAllDel(map);
			int total=ad.getTotalDelSize(map);			
			 BAdPosition example2=new BAdPosition();
			 List<BAdPosition> type=adp.selectAllInfo(example2);
			    //设置分页参数 
				Page<BAd> pageBean = new Page<>();
				pageBean.setPage(page);
				pageBean.setSize(size);
				pageBean.setRows(adList);
				pageBean.setTotal(total);
				model.addAttribute("page", pageBean);
				model.addAttribute("type", type);
		         return "/content/Bad/recyclead";
		}
	 
	 @RequestMapping("/content/categorylist.action")
		public String categorylist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
				Model model,String name){
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println("搜索");
			map.put("name", name);
			map.put("start", (page-1)*size);
			map.put("size", size);
			List<BArticleCategory> categoryList = ac.selectAllDel(map);
			int total=ac.getTotalDelSize(map);
			//设置分页参数 
					Page<BArticleCategory> pageBean = new Page<>();
					pageBean.setPage(page);
					pageBean.setSize(size);
					pageBean.setRows(categoryList);
					pageBean.setTotal(total);
					model.addAttribute("page", pageBean);
			BArticleCategory example2=new BArticleCategory();
			  List<BArticleCategory> type=ac.selectAllCategory(example2);
			  model.addAttribute("type",type);			
			return "/content/ArticleCategory/recyclecategory";
		}
	     // 批量删除广告
				@RequestMapping("/content/deleteadm.action")
				public String deleteadm(@RequestParam("id") int[] ids) {
					
					ad.deleteAllByIds(ids);

					return "redirect:/recycle/content/adList.action";
				}
	     // 批量删除文章
			@RequestMapping("/content/deletem.action")
			public String deletem(@RequestParam("id") int[] ids) {
				System.out.println("pilshanchu");
				System.out.println(ids.length);
				ba.deleteAllByIds(ids);
				return "redirect:/recycle/content/articleList.action";
			}
			 // 批量删除文章分类
			@RequestMapping("/content/deletemcategory.action")
			public String deletecategory(@RequestParam("id") int[] ids) {
				System.out.println("pilshanchu");
				System.out.println(ids.length);
				ac.deleteAllByIds(ids);
				return "redirect:/recycle/content/categoryList.action";
			}
			 
			 // 批量恢复文章
			@RequestMapping("/content/recover.action")
			public String recover(@RequestParam("id") int[] ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("state", 1); // 1启用
				map.put("ids", ids);
				ba.updateDelState(map);
				return "redirect:/recycle/content/articleList.action";
			}
			 // 批量恢复广告
			@RequestMapping("/content/recoverad.action")
			public String recoverad(@RequestParam("id") int[] ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("state", 1); // 1启用
				map.put("ids", ids);
				ad.updateDelState(map);
				return "redirect:/recycle/content/adList.action";
			}
}
