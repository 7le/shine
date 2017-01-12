package com.shine.init;


import com.shine.server.Dict;
import com.shine.server.ServerModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContextEvent;

/**
 * 监视ServletContext以做相应的初始化和销毁工作
 *
 */
public class ServletContextListener implements
		javax.servlet.ServletContextListener {
	protected final Log logger = LogFactory.getLog(getClass());

	public void contextInitialized(ServletContextEvent event) {
		WebUtils.setWebAppRootSystemProperty(event.getServletContext());
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

		logger.info("————————————————初始化字典开始——————————————");
		ServerModule dict = Dict.getInstance();
		dict.initialize(context);
		event.getServletContext().setAttribute("dict", dict);

		logger.info("————————————————初始化字典结束——————————————");
	}

	public void contextDestroyed(ServletContextEvent event) {
		WebUtils.removeWebAppRootSystemProperty(event.getServletContext());
	}
}
