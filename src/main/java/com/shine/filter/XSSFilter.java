package com.shine.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XSSFilter implements Filter {
    /**
     * 需要排除的页面
     */
    private String excludedPages;

    private String[] excludedPageArray;

    @SuppressWarnings("unused")
    private FilterConfig filterConfig;

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        boolean isExcludedPage = false;

        HttpServletRequest request2 = (HttpServletRequest) request;
        String ctx_path = request2.getContextPath();
        String request_uri = request2.getRequestURI();
        String action = request_uri.substring(ctx_path.length());

        //判断是否在过滤url之外
        for (String page : excludedPageArray) {
            if (page.equals(action)) {
                isExcludedPage = true;
                break;
            }
        }

        if (isExcludedPage) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(new XSSRequestWrapper(request2), response);
        }

    }

    /**
     * 自定义过滤规则
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        excludedPages = filterConfig.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.replaceAll("[\\s]", "").split(",");
        }
    }
}