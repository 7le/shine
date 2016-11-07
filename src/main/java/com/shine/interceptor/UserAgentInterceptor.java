package com.shine.interceptor;

import com.shine.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hq 2016/11/4
 */
public class UserAgentInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userAgent = request.getHeader("user-agent");
        boolean ok = false;
        if (StringUtil.isNotEmpty(userAgent)) {
            ok = true;
        }

        if (ok) {
            return true;
        } else {
            response.sendRedirect("/user/login/loginView");
            return false;
        }

    }
}
