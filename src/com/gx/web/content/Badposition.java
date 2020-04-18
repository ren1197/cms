package com.gx.web.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gx.dao.BAdPositionMapper;
import com.gx.po.BAd;
import com.gx.po.BAdPosition;
import com.gx.utils.Page;



@Controller
@RequestMapping("/Badposition")
public class Badposition {
	 @Autowired
	private BAdPositionMapper ad;
	@RequestMapping("/content/tolist.action")
	public String tolist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
			Model model,String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");		
		System.out.println(name);		
		map.put("name", name);
		map.put("start", (page-1)*size);
		map.put("size", size);
		
		List<BAdPosition> adList = ad.query(map);
		int total=ad.getTotalSize(map);
		 //设置分页参数 
		Page<BAdPosition> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(adList);
		pageBean.setTotal(total);
		model.addAttribute("page", pageBean);		
		return "/content/Badposition/adplist";
	}
	@RequestMapping("/content/toadd.action")
	public String toadd(Model model){
		System.out.println("ad toadd");
		
		return "/content/Badposition/adpadd";
	}
	@RequestMapping("/content/toupdate.action")
	public String toupdate(Model model,Integer id){
		System.out.println("ad toupdate");
		BAdPosition ba=ad.selectById(id);
		model.addAttribute("list",ba);
		return "/content/Badposition/adpupdate";
	}
	@RequestMapping("/content/add.action")
	public String add(BAdPosition record){
		System.out.println("ad add");
		ad.insert(record);
		return "redirect:/Badposition/content/tolist.action";

	}
	@RequestMapping("/content/update.action")
	public String update(BAdPosition record){
		System.out.println("广告位修改");
		ad.updateById(record);
		return "redirect:/Badposition/content/tolist.action";

	}
	@RequestMapping("/content/delete.action")
	public String delete(Integer id){
		System.out.println("广告位删除");
		ad.deleteById(id);
		return "redirect:/Badposition/content/tolist.action";

	}
	// 启用一个或多个
				@RequestMapping("/content/start.action")
					public String start(@RequestParam("id")int[] ids) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("state", 1); // 1启用
						map.put("ids", ids);
						ad.updateState(map);
						return "redirect:/Badposition/content/tolist.action";
					}
				// 停用一个或多个
				@RequestMapping("/content/stop.action")
					public String stop(@RequestParam("id") int[] ids) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("state", 0); // 0停用
						map.put("ids", ids);
						ad.updateState(map);
						return "redirect:/Badposition/content/tolist.action";
					}
				 // 批量删除
				@RequestMapping("/content/deletem.action")
				public String delete(@RequestParam("id") int[] ids) {
					System.out.println("批量删除");	
					ad.deleteByIds(ids);
					return "redirect:/Badposition/content/tolist.action";
				}
}
