package com.jdc.assigment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManager implements ServletContextListener {
	
	public static final String SPRING_CONTEXT = "spring.context";
	
	private GenericXmlApplicationContext springContext;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initialize IoC Container");
		
		springContext = new GenericXmlApplicationContext("classpath:/application.xml");
		
		sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Close IoC Container");
		
		if (springContext != null) {
			springContext.close();
		}
	}

}
