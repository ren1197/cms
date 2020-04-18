package com.gx.web.refund;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.gx.po.XxFactory;
import com.gx.po.ZfRefunds;
import com.gx.service.RefundMonenyService;
import com.gx.utils.Page;
import com.gx.utils.PageBean;

@Controller
@RequestMapping("/Refund")
public class RefundMoneny {
	@Autowired
	private RefundMonenyService rf;
	@RequestMapping("/RefundMoneny/list.action")
	public String list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, Model model,String account) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");	
		map.put("account", account);		
		map.put("start", (page-1)*size);
		map.put("size", size);
		List<ZfRefunds> ZfRefundsList = rf.query(map);
		int total=rf.getTotalSize(map);		
		//设置分页参数 
		Page<ZfRefunds> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(ZfRefundsList);
		pageBean.setTotal(total);
		model.addAttribute("page", pageBean);
		return "/refund/refundMoneny/refundlist";
	}

	// 转向修改页面
	@RequestMapping("/factory/toupdate.action")
	public String toupdate(int id, Model model) {
	
		


		return "/basicinfo/factory/jFactoryUpdate";
	}

	// 修改保存
	@RequestMapping("/factory/update.action")
	public String update(XxFactory factory) {
		

		return "redirect:/basicinfo/factory/list.action";
	}

	// 删除一条
	@RequestMapping("/factory/deleteById.action")
	public String deleteById(int id) {
	

		return "redirect:/basicinfo/factory/list.action";
	}

	// 批量删除
	@RequestMapping("/emp/delete.action")
	public String delete(@RequestParam("id") int[] ids) {
	

		return "redirect:/basicinfo/factory/list.action";
	}

	// 查看
	@RequestMapping("/factory/toview.action")
	public String toview(int id, Model model) {
		

		return "/basicinfo/factory/jFactoryView";
	}

	// 启用
	@RequestMapping("/factory/start.action")
	public String start(@RequestParam("id") int[] ids) {
		

		return "redirect:/basicinfo/factory/list.action";
	}

	// 停用
	@RequestMapping("/factory/stop.action")
	public String stop(@RequestParam("id") int[] ids) {
		

		return "redirect:/basicinfo/factory/list.action";
	}
}
