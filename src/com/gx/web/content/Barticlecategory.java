package com.gx.web.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.dao.BArticleCategoryMapper;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.utils.Page;




@Controller
@RequestMapping("/Barticlecategory")
public class Barticlecategory {
	 @Autowired
    private  BArticleCategoryMapper ac;
	@RequestMapping("/content/tolist.action")
	public String tolist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
			Model model,String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");		
		map.put("name", name);
		map.put("start", (page-1)*size);
		map.put("size", size);
		List<BArticleCategory> categoryList = ac.query(map);
		int total=ac.getTotalSize(map);
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
		
		return "/content/ArticleCategory/list";
	}
  @RequestMapping("/content/toadd.action")
	public String toadd(Model model){
		System.out.println("toadd");
		BArticleCategory example=new BArticleCategory();
	  List<BArticleCategory> list=ac.selectAllCategory(example);
	  model.addAttribute("list", list);
		return "/content/ArticleCategory/add";
	}
  @RequestMapping("/content/toupdate.action")
	public String toupdate(Model model,Integer id){
		System.out.println("toupdate");
		BArticleCategory ba=ac.selectById(id);
		model.addAttribute("list",ba);
		BArticleCategory example2=new BArticleCategory();
		  List<BArticleCategory> type=ac.selectAllCategory(example2);
		  model.addAttribute("type",type);
		return "/content/ArticleCategory/update";
	}
 
  @RequestMapping("/content/add.action")
 	public String add(BArticleCategory record){
 		System.out.println("add");
 		record.setCreattime(new Date());
 		record.setModifytime(new Date());
 		ac.insert(record);
 		return "redirect:/Barticlecategory/content/tolist.action";
 	}
  @RequestMapping("/content/update.action")
	public String update(BArticleCategory record){
		System.out.println("update");	
		record.setModifytime(new Date());
		ac.updateById(record);
		return "redirect:/Barticlecategory/content/tolist.action";
	}
  @RequestMapping("/content/delete.action")
	public String delete(Integer id){
		System.out.println("delete");	
		ac.deleteById(id);
		return "redirect:/Barticlecategory/content/tolist.action";
	}
  @RequestMapping("/content/deletem.action")
	public String deletem(@RequestParam("id") int[] ids){
		System.out.println("delete");	
		ac.deleteByIds(ids);
		return "redirect:/Barticlecategory/content/tolist.action";
	}
  
  @RequestMapping("/content/tree.action")
  public String tree() {
	  System.out.println("请求树状");
      return "/content/ArticleCategory/left";
  }
  @RequestMapping("/content/getTree.action")
  @ResponseBody
  public Map<String, Object> getTree() {
	  System.out.println("获取树状列表");
      Map<String, Object> tree = new HashMap<>();
      List<BArticleCategory> articleTypeList = ac.getList();
      List<Map<String, Object>> data = new ArrayList<>();
      for (BArticleCategory type : articleTypeList) {
          Map<String, Object> temp = new HashMap<>();
          temp.put("id", type.getId());
          temp.put("title", type.getName());

          if (type.getPid() == null)
              temp.put("parentId", 0);
          else
              temp.put("parentId", type.getPid());

          data.add(temp);
      }
      Map<String ,Object> status=new HashMap<>();
      status.put("code", 200);
      status.put("msg", "操作成功！");
      tree.put("data", data);
      tree.put("status", status);
      return tree;
  }
}
