package com.gx.web.content;

import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.gx.dao.BArticleMapper;
import com.gx.service.SpringContextUtils;
//定时发送文章
@Service
public class SendArticle implements Job{
	@Autowired
	private BArticleMapper ba;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("获取id"+arg0.getTrigger().getJobDataMap().get("id"));		
		System.out.println("启动定时成功");	
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    	ba=SpringContextUtils.getBean(BArticleMapper.class);   
    	Integer id= (Integer) arg0.getTrigger().getJobDataMap().get("id");
    
    	ba.updateByDingshiId(id);
	}
	 
}
