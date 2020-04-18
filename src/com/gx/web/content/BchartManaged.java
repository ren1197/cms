package com.gx.web.content;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gx.dao.BAdMapper;
import com.gx.dao.BAdPositionMapper;
import com.gx.dao.BArticleMapper;
import com.gx.po.BAdPosition;
import com.gx.po.BArticle;
@Controller
@RequestMapping("/chart")
public class BchartManaged {
	 @Autowired
		private  BArticleMapper ba;
	 @Autowired
	private BAdPositionMapper ad;
	 
	 @RequestMapping(value ="/test.action")
	    public String into(){
	        return "/content/echarts/articleview";
	    }
	 
	    @RequestMapping(value ="/getTrainInforStatic.action",method = {RequestMethod.GET, RequestMethod.POST})
	    @ResponseBody
	    public List<Map<String, Object>> getTrainInforStatic(HttpSession session) {
		 System.out.println("bchart调用");		
		 List<Map<String, Object>> chart= ba.getTrainTypeNuminfo();
		return chart;
		
	 }
	    @RequestMapping(value ="/test2.action")
	    public String into2(){
	        return "/content/echarts/adchart";
	    }
	    
	    @RequestMapping(value ="/getadposition.action",method = {RequestMethod.GET, RequestMethod.POST})
	    @ResponseBody
	    public List<BAdPosition> getadposition(HttpSession session) {
		 System.out.println("广告位统计");
		
		 List<BAdPosition> chart= ad.getTrainTypeNuminfo();
		return chart;
		
	 }
}
