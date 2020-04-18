package com.gx.web.content;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.gx.dao.BArticleMapper;
import com.gx.service.SpringContextUtils;

public class XiaxianArticle implements Job {
	@Autowired
	private BArticleMapper ba;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("获取id"+arg0.getTrigger().getJobDataMap().get("id"));		
		System.out.println("启动下线定时成功");	
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    	ba=SpringContextUtils.getBean(BArticleMapper.class);   
    	Integer id= (Integer) arg0.getTrigger().getJobDataMap().get("id");
    
    	ba.updateByXiaxianDingshiId(id);
	}

}
