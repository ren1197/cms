package com.gx.web.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.gx.po.XxFactory;
import com.gx.service.FactoryService;
import com.gx.utils.PageBean;

@Controller
@RequestMapping("/basicinfo")
public class FactoryController {
	@Autowired
	private FactoryService factoryService;

	// 分页查询
	// @RequestMapping("/factory/list.action")
	// public String list(@RequestParam(defaultValue = "1") Integer page,
	// @RequestParam(defaultValue = "10") Integer rows,
	// Model model) {
	// List<XxFactory> dataList = factoryService.findByPage(page, rows);
	// model.addAttribute("dataList", dataList);
	// return "/basicinfo/factory/jFactoryList";
	// }

	@RequestMapping("/factory/list.action")
	public String list(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, Model model) {
		PageBean<XxFactory> pageBean = new PageBean<XxFactory>();
		pageBean.setCurrentPage(pageNo); //赋当前页
		
		int totalCount=factoryService.getTotalSize(); //获取总记录数
		pageBean.setTotalCount(totalCount);
		List<XxFactory> factoryList = factoryService.findByPage(pageNo, pageSize); //获取分页数据
		model.addAttribute("factoryList", factoryList);
		return "/basicinfo/factory/jFactoryList";
	}

	// 转向新增页面
	@RequestMapping("/factory/tocreate.action")
	public String tocreate() {
		return "/basicinfo/factory/jFactoryCreate";
	}

	// 新增保存
	@RequestMapping("/factory/insert.action")
	public String insert(XxFactory factory) {
		factoryService.insert(factory);

		return "redirect:/basicinfo/factory/list.action";
	}

	// 转向修改页面
	@RequestMapping("/factory/toupdate.action")
	public String toupdate(int id, Model model) {
		XxFactory obj = factoryService.get(id);
		
		model.addAttribute("obj", obj);

		return "/basicinfo/factory/jFactoryUpdate";
	}

	// 修改保存
	@RequestMapping("/factory/update.action")
	public String update(XxFactory factory) {
		factoryService.update(factory);

		return "redirect:/basicinfo/factory/list.action";
	}

	// 删除一条
	@RequestMapping("/factory/deleteById.action")
	public String deleteById(int id) {
		factoryService.deleteById(id);

		return "redirect:/basicinfo/factory/list.action";
	}

	// 批量删除
	@RequestMapping("/emp/delete.action")
	public String delete(@RequestParam("id") int[] ids) {
		factoryService.delete(ids);

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
		factoryService.start(ids);

		return "redirect:/basicinfo/factory/list.action";
	}

	// 停用
	@RequestMapping("/factory/stop.action")
	public String stop(@RequestParam("id") int[] ids) {
		factoryService.stop(ids);

		return "redirect:/basicinfo/factory/list.action";
	}
}
