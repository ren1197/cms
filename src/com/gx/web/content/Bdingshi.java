package com.gx.web.content;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gx.dao.BArticleMapper;
import com.gx.dao.BDingshirenwuMapper;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.po.BDingshirenwu;
import com.gx.utils.DateUtil;
import com.gx.web.content.SendArticle;

@Controller
@RequestMapping("/Bdingshi")
public class Bdingshi {
	 public static String JOB_NAME = "动态任务调度";  
	    public static String TRIGGER_NAME = "动态任务触发器";  
	    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
	    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP"; 

	  @Autowired
	 private BDingshirenwuMapper bd;
	  @Autowired
		private  BArticleMapper ba;
	@RequestMapping("/content/tolist.action")
	public String tolist(Model model){
		/*List<BDingshirenwu> bding= bd.selectAllInfo();
		model.addAttribute("bding",bding);*/
		BArticle example=new BArticle();	
		List<BArticle> barticle=ba.selectAllInfo(example);
		model.addAttribute("article",barticle);		
		return "/content/dingshi/dingshilist";
	}
	@RequestMapping("/content/toadd.action")
	public String toadd(Model model){
		BArticle example=new BArticle();	
		List<BArticle> barticle=ba.selectAllInfo(example);
		model.addAttribute("article",barticle);	
		return "/content/dingshi/dingshiadd";
	}
	//转向定时发送页面
	@RequestMapping("/content/toaddsend.action")
	public String toaddsend(Model model, Integer id){
		BArticle b = ba.selectById(id);
		model.addAttribute("list", b);
		return "/content/dingshi/dingshisendupdate";
	}
	//转向定时下线页面
	@RequestMapping("/content/toaddxiaxian.action")
	public String toaddxiaxian(Model model, Integer id){
		BArticle b = ba.selectById(id);
		model.addAttribute("list", b);
		return "/content/dingshi/dingshixiaxianupdate";
	}
	@RequestMapping("/content/add.action")
	public String add(BDingshirenwu  record,Integer aid,Date stoptime ){
		System.out.println("aid"+record.getAid());
		System.out.println("stoptime"+record.getStoptime());
		Date time=record.getStoptime();		
		String cron=DateUtil.getCron(stoptime);  
		System.out.println(cron);		
		QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, SendArticle.class, cron,aid);    
		bd.insert(record);	
		return "redirect:/Bdingshi/content/tolist.action";
	}
	
	
	    // 启用一个
		@RequestMapping("/content/start.action")
		public String start(Integer id,Date sendtime) {				
			String cron=DateUtil.getCron(sendtime);  
			System.out.println(cron);		
			QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, SendArticle.class, cron,id);    
			return "redirect:/Bdingshi/content/tolist.action";
		}
		
		// 下线一个
		@RequestMapping("/content/xiaxian.action")
		public String xiaxian(Integer id,Date sendtime) {
			String cron=DateUtil.getCron(sendtime);  
			System.out.println(cron);		
			QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, XiaxianArticle.class, cron,id);    
			return "redirect:/Bdingshi/content/tolist.action";
		}
}
