package com.shine.interceptor;

import com.shine.util.HttpUtil;
import com.shine.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererInterceptor extends BaseInterceptor {

    public static final String[] HOST = new String[]{"localhost", "127.0.0.1",};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String whereString = request.getHeader("Referer");
        boolean ok = false;
        if (StringUtil.isNotEmpty(whereString)) {
            for (String host : HOST) {
                if (whereString.indexOf(host) != -1) {
                    ok = true;
                    break;
                }
            }
        }
        if (ok) {
            return true;
        } else {
            String url = HttpUtil.getBasePath(request, false) + "/member/login";
            response.sendRedirect(url);
            return false;
        }

    }
}
