package com.gx.web.content;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gx.dao.BFriendLinkMapper;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.po.BFriendLink;
import com.gx.utils.Page;


@Controller
@RequestMapping("/BFriendLink")

public class Bfrinedlink {
	@Autowired
	private BFriendLinkMapper  fl;
	@RequestMapping("/content/tolist.action")
	public String tolist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="3")Integer size,
			Model model,Integer state,String name){		
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("搜索");
		System.out.println(state);
		System.out.println(name);
		map.put("state", state);
		map.put("name", name);
		map.put("start", (page-1)*size);
		map.put("size", size);
		List<BFriendLink> friendList = fl.query(map);
		int total=fl.getTotalSize(map);		
		//设置分页参数 
		Page<BFriendLink> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(friendList);
		pageBean.setTotal(total);
		model.addAttribute("page", pageBean);
	

		return "/content/Bfriendlink/linklist";
	}
	
	
	
	@RequestMapping("/content/toadd.action")
	public String toadd(Model model){
		System.out.println("toadd");		
		return "/content/Bfriendlink/linkadd";
	}
	@RequestMapping("/content/toupdate.action")
	public String toupdate(Model model,Integer id){
		System.out.println("toupdate");	
		BFriendLink bf=	fl.selectById(id);
		model.addAttribute("list",bf);
		return "/content/Bfriendlink/linkupdate";
	}
	@RequestMapping("/content/add.action")
	public String add(BFriendLink record,MultipartFile pictureFile, Model model,HttpServletRequest request) throws Exception{
		        System.out.println("友情链接add");	
		          // 1. 获取图片完整名称
				String fileStr = pictureFile.getOriginalFilename();
				if(fileStr.isEmpty()==false){				
				// 3. 将图片保存到硬盘
				// 项目路径
				String realPath =request.getSession().getServletContext().getRealPath("/image");
				System.out.println(realPath);
				// 保存文件的路径
				String filePath = realPath + File.separator +fileStr;// 上传路径要指定全路径
				pictureFile.transferTo(new File(filePath));
				record.setLogoimg(fileStr);
				}
				record.setCreatetime(new Date());
				record.setModifytime(new Date());
		        fl.insert(record);
		        return "redirect:/BFriendLink/content/tolist.action";
	}
	@RequestMapping("/content/update.action")
	public String update(BFriendLink record,MultipartFile pictureFile, Model model,HttpServletRequest request) throws Exception{
		System.out.println("update");	
		 System.out.println("友情链接update");	
         // 1. 获取图片完整名称
		 String fileStr = pictureFile.getOriginalFilename();
		 if(fileStr.isEmpty()==false){		
		// 3. 将图片保存到硬盘
		// 项目路径
		String realPath =request.getSession().getServletContext().getRealPath("/image");
		System.out.println(realPath);
		// 保存文件的路径
		String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
		pictureFile.transferTo(new File(filePath));

		record.setLogoimg(fileStr);
		 }
		record.setModifytime(new Date());
		fl.updateById(record);
		return "redirect:/BFriendLink/content/tolist.action";
	}
	@RequestMapping("/content/delete.action")
	public String delete(Integer id){
		System.out.println("删除");	
		 fl.deleteById(id);
		return "redirect:/BFriendLink/content/tolist.action";
	}
	      // 批量删除
			@RequestMapping("/content/deletem.action")
			public String delete(@RequestParam("id") int[] ids) {
				System.out.println("批量删除");	
				fl.deleteByIds(ids);
				return "redirect:/BFriendLink/content/tolist.action";
			}
			// 启用一个或多个
			@RequestMapping("/content/start.action")
				public String start(@RequestParam("id")int[] ids) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("state", 1); // 1启用
					map.put("ids", ids);
					fl.updateState(map);
					return "redirect:/BFriendLink/content/tolist.action";
				}
			// 停用一个或多个
			@RequestMapping("/content/stop.action")
				public String stop(@RequestParam("id") int[] ids) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("state", 0); // 0停用
					map.put("ids", ids);
					fl.updateState(map);
					return "redirect:/BFriendLink/content/tolist.action";
				}
}
