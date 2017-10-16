package com.shine.filter;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.owasp.validator.html.*;

import java.io.InputStream;


/**
 * XSS清洁工
 * 用于过滤XSS
 */
public class XssClean {


    private static final Logger logger = Logger.getLogger(XssClean.class);
    private static Policy policy = null;

    public static Policy getPolicy() throws PolicyException {
        if (policy == null) {
            InputStream policyFile = XssClean.class.getResourceAsStream("/xss/antisamy-ebay.xml");
            policy = Policy.getInstance(policyFile);
        }
        return policy;
    }

    public static String xssClean(String value) {
        if (StringUtils.isNotEmpty(value)) {
            AntiSamy antiSamy = new AntiSamy();
            try {
                final CleanResults cr = antiSamy.scan(value, getPolicy());
                //安全的HTML输出
                value = cr.getCleanHTML();
            } catch (ScanException e) {
                logger.error("过滤XSS异常");
                //e.printStackTrace();
            } catch (PolicyException e) {
                logger.error("加载XSS规则文件异常: " + e.getMessage());
                //e.printStackTrace();
            }
        }
        return value;
    }
}
