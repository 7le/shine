package com.shine.controller.backend;

import com.shine.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台控制器
 * Created by hq on 2016/12/5.
 */
public class BackendController extends BaseController implements HandlerInterceptor {

    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后，也就是在Controller的方法调用之后执行，
     * 但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        /*
		 * 方法调用后调用该方法，返回数据给请求页
		 */
        if (isLegalView(modelAndView)) {
        //    modelAndView.addObject("currentUser", userService.selectById(getCurrentUserId()));
            modelAndView.addObject("menuList", adminPermissionService.selectMenuByUserId(19L));
        }
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * 判断是否为合法的视图地址
     * <p>
     *
     * @param modelAndView
     *            spring 视图对象
     * @return boolean
     */
    protected boolean isLegalView(ModelAndView modelAndView) {
        boolean legal = false;
        if (modelAndView != null) {
            String viewUrl = modelAndView.getViewName();
            if (viewUrl != null && viewUrl.contains("redirect:")) {
                legal = false;
            } else {
                legal = true;
            }
        }
        return legal;
    }
}
