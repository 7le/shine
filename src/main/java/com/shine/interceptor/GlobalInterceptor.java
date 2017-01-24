package com.shine.interceptor;

import com.shine.util.HttpUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置全局变量
 * @author hq
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (null == modelAndView) {
			return;
		}
		// 系统配置参数
		String basePath = HttpUtil.getBasePath(request,false);
		modelAndView.addObject("BASE_PATH", basePath);
		MDC.put("ip", HttpUtil.getIpAddr(request));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
