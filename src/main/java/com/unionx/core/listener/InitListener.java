package com.unionx.core.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;

public class InitListener implements ServletContextListener {

	private DictService dictService;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); 
		  if(springContext != null){ 
			  System.out.println("初始化系统服务!"); 
			 dictService = (DictService)springContext.getBean("dictService"); 
			 event.getServletContext().setAttribute("dict",  dictService.findAllBygroup());
		  }else{ 
		   System.out.println("获取应用程序上下文失败!"); 
		   return; 
		  } 
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
