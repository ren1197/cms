package com.gx.web.content;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gx.dao.BAdMapper;
import com.gx.dao.BAdPositionMapper;
import com.gx.po.BAd;
import com.gx.po.BAdPosition;
import com.gx.po.BArticle;
import com.gx.utils.Page;



@Controller
@RequestMapping("/Bad")
public class Bad {
	     @Autowired
		private BAdMapper ad;
	     @Autowired
	 	private BAdPositionMapper adp;
		@RequestMapping("/content/tolist.action")
		public String tolist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer size,
				Model model,String title){		
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println("搜索");
			
			System.out.println(title);
			
			map.put("title", title);
			map.put("start", (page-1)*size);
			map.put("size", size);
			List<BAd> adList = ad.query(map);
			int total=ad.getTotalSize(map);
			
			
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

			return "/content/Bad/adlist";
		}
		@RequestMapping("/content/toadd.action")
		public String toadd(Model model){
			System.out.println("ad toadd");
			BAdPosition example=new BAdPosition();
			 List<BAdPosition> list=adp.selectAllInfo(example);
			 model.addAttribute("list",list);
			return "/content/Bad/adadd";
		}
		@RequestMapping("/content/toupdate.action")
		public String toupdate(Model model,Integer id){
			System.out.println("ad toupdate");
			BAd ba=ad.selectById(id);
			model.addAttribute("list",ba);
			BAdPosition example2=new BAdPosition();
			 List<BAdPosition> type=adp.selectAllInfo(example2);
			 model.addAttribute("type",type);
			return "/content/Bad/adupdate";
		}
		//广告发布
		@RequestMapping("/content/add.action")
		public String add(BAd record,@RequestParam(value="pictureFile") MultipartFile[] pictureFile, Model model,HttpServletRequest request) throws Exception{
			int count=1;
			for(MultipartFile img:pictureFile){
				if(!img.isEmpty()){
					
				// 1. 获取图片完整名称
				String fileStr = img.getOriginalFilename();
			
				
				// 3. 将图片保存到硬盘
				// 项目路径
				String realPath =request.getSession().getServletContext().getRealPath("/image");
				System.out.println(realPath);
				// 保存文件的路径
				String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
				img.transferTo(new File(filePath));
				if(count==1){
				record.setPath(fileStr);
				}else if(count==2){
				record.setPath2(fileStr);
				}else if(count==3){
				record.setPath3(fileStr);
				}else if(count==4){
				record.setPath4(fileStr);
				}else if(count==5){
				record.setPath5(fileStr);
				}				
			}
				
			count++;
		}
		
			record.setType(1);//设置状态
			ad.insert(record);
			return "redirect:/Bad/content/tolist.action";

		}
		
		//广告未发布
		@RequestMapping("/content/add2.action")
		public String add2(BAd record,@RequestParam(value="pictureFile") MultipartFile[] pictureFile, Model model,HttpServletRequest request) throws Exception{
			int count=1;
			for(MultipartFile img:pictureFile){
				if(!img.isEmpty()){
					
				//  获取图片完整名称
				String fileStr = img.getOriginalFilename();
				
				//  将图片保存到硬盘
				// 项目路径
				String realPath =request.getSession().getServletContext().getRealPath("/image");
				System.out.println(realPath);
				// 保存文件的路径
				String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
				img.transferTo(new File(filePath));
				if(count==1){
				record.setPath(fileStr);
				}else if(count==2){
				record.setPath2(fileStr);
				}else if(count==3){
				record.setPath3(fileStr);
				}else if(count==4){
				record.setPath4(fileStr);
				}else if(count==5){
				record.setPath5(fileStr);
				}				
			}
			count++;
		}
		    record.setType(0);
			ad.insert(record);
			return "redirect:/Bad/content/tolist.action";

		}
		//未发布
		@RequestMapping("/content/update2.action")
		public String update2(BAd record,@RequestParam(value="pictureFile") MultipartFile[] pictureFile, Model model,HttpServletRequest request) throws Exception{
			int count=1;
			for(MultipartFile img:pictureFile){
				if(!img.isEmpty()){
					
				// 获取图片完整名称
				String fileStr = img.getOriginalFilename();
				
				// 将图片保存到硬盘
				// 项目路径
				String realPath =request.getSession().getServletContext().getRealPath("/image");
				System.out.println(realPath);
				// 保存文件的路径
				String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
				img.transferTo(new File(filePath));
				if(count==1){
				record.setPath(fileStr);
				}else if(count==2){
				record.setPath2(fileStr);
				}else if(count==3){
				record.setPath3(fileStr);
				}else if(count==4){
				record.setPath4(fileStr);
				}else if(count==5){
				record.setPath5(fileStr);
				}				
			}
			count++;
		}
		System.out.println("广告修改");
		record.setType(0);
		ad.updateById(record);
		return "redirect:/Bad/content/tolist.action";

		}
		@RequestMapping("/content/update.action")
		public String update(BAd record,@RequestParam(value="pictureFile") MultipartFile[] pictureFile, Model model,HttpServletRequest request) throws Exception{
			int count=1;
			for(MultipartFile img:pictureFile){
				if(!img.isEmpty()){
					
				// 1. 获取图片完整名称
				String fileStr = img.getOriginalFilename();
				
				// 3. 将图片保存到硬盘
				// 项目路径
				String realPath =request.getSession().getServletContext().getRealPath("/image");
				System.out.println(realPath);
				// 保存文件的路径
				String filePath = realPath + File.separator + fileStr;// 上传路径要指定全路径
				img.transferTo(new File(filePath));
				if(count==1){
				record.setPath(fileStr);
				}else if(count==2){
				record.setPath2(fileStr);
				}else if(count==3){
				record.setPath3(fileStr);
				}else if(count==4){
				record.setPath4(fileStr);
				}else if(count==5){
				record.setPath5(fileStr);
				}				
			}
			count++;
		}
		System.out.println("广告修改");
		record.setType(1);
		ad.updateById(record);
		return "redirect:/Bad/content/tolist.action";

		}
		
		
		@RequestMapping("/content/delete.action")
		public String delete(Integer id){
			System.out.println("广告删除");
			ad.deleteById(id);
			return "redirect:/Bad/content/tolist.action";

		}
		// 批量删除
				@RequestMapping("/content/deletem.action")
				public String delete(@RequestParam("id") int[] ids) {
					ad.deleteByIds(ids);

					return "redirect:/Bad/content/tolist.action";
				}
		// 启用一个或多个
		@RequestMapping("/content/start.action")
			public String start(@RequestParam("id")int[] ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", 1); // 1启用
				map.put("ids", ids);
				ad.updateState(map);
				return "redirect:/Bad/content/tolist.action";
			}

			// 停用一个或多个
		@RequestMapping("/content/stop.action")
			public String stop(@RequestParam("id") int[] ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", 0); // 0停用
				map.put("ids", ids);
				ad.updateState(map);
				return "redirect:/Bad/content/tolist.action";
			}
		// 下线一个或多个
		@RequestMapping("/content/xiaxian.action")
			public String xiaxian(@RequestParam("id") int[] ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", 2); // 2下线
				map.put("ids", ids);
				ad.updateState(map);
				return "redirect:/Bad/content/tolist.action";
			}
		// 查看
				@RequestMapping("/content/toview.action")
				public String toview(@RequestParam(value="id" ,required =true )Integer id, Model model) {
					BAd  bad=ad.selectById(id);
					model.addAttribute("list", bad);

					return "/content/Bad/adview";
				}
}
