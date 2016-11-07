package com.shine.interceptor;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基础拦截器
 *
 * @author hq 2016/11/4
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    /**
     * 执行json响应
     *
     * @param response 当前http会话响应对象
     * @param result   结果对象
     */
    public static void doResponse(HttpServletResponse response, Object result) throws IOException {

        // 设置响应的类型格式为JSON格式
        response.setContentType("application/json;charset=UTF-8");
        //禁止缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.getWriter().append(JSONObject.fromObject(result).toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
