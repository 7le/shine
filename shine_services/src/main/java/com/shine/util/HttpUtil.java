package com.shine.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by hq on 2016/11/04.
 */
public class HttpUtil {

    /**
     * �û�����*
     */
    protected static final String USER_AGENT = "User-Agent";

    public static Boolean isPost(HttpServletRequest request){
        return "post".equalsIgnoreCase(request.getMethod());
    }

    /**
     *
     *
     * @param type
     * @param request
     * @return
     */
    public static String getSessionName(String type, HttpServletRequest request) {
        String ip = getIpAddr(request);
        String userAgrent = request.getHeader(USER_AGENT).toUpperCase();
        String sessonId = request.getSession().getId();
        String sessionName = MD5Util.MD5(type + ip + userAgrent + sessonId);
        return sessionName;
    }

    /**
     * 获得session name
     * 添加一个value
     *
     * @param type
     * @param value
     * @param request
     * @return
     */
    public static String getSessionName(String type, String value, HttpServletRequest request){
        String ip = getIpAddr(request);
        String userAgrent = request.getHeader(USER_AGENT).toUpperCase();
        String sessonId = request.getSession().getId();
        String sessionName = MD5Util.MD5(type + value + ip + userAgrent + sessonId);
        return sessionName;
    }

    /**
     * ��ȡip��ַ
     *
     * @param request the current request
     * @return IP to application
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) return "";
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtil.isNotEmpty(ip)){
            String[] ips = ip.split(",");
            for (int i=0;i<ips.length;i++){
                String realIp  = ips[i];
                if (StringUtil.isNotEmpty(realIp)&&!realIp.trim().equalsIgnoreCase("unknown")){
                    ip = realIp;
                    break;
                }
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }



    /**
     * 获得项目的绝对地址，不以'/'结尾
     */
    public static String getBasePath(HttpServletRequest request, boolean isHttps) {
        String path = request.getContextPath();
        int serverPost = request.getServerPort();
        String basePath;
        if (isHttps) {
            basePath = "https://";
        } else {
            basePath = "http://";
        }
        if (serverPost == 80 || serverPost == 443) {
            basePath += request.getServerName() + path;
        } else {
            basePath += request.getServerName() + ":"
                    + request.getServerPort() + path;
        }
        return basePath;
    }

    public static boolean isIE(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return request.getHeader("User-Agent").toUpperCase().indexOf("MSIE")>0;
    }

    /**
     * 判断是不是手机
     * @param request
     * @return
     */
    static String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
            "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
            "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
            "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
            "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
            "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
            "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
            "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
            "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
            "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
            "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
            "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
            "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
            "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
            "Googlebot-Mobile" };
    public static boolean judgeIsMobile(HttpServletRequest request) {
        boolean isMobile = false;
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
                    isMobile = true;
                    break;
                }
            }
        }
        return isMobile;
    }


    /**
     * 获取上传文件表
     * @param request
     * @return
     */
    public static Map<String, MultipartFile> getUploadFiles(HttpServletRequest request){

        //文件表
        Map<String, MultipartFile> fileMap= null;
        try {

         fileMap = ((MultipartRequest) request).getFileMap();
        }catch (Exception e){
            return null;
        }

        if(fileMap==null||fileMap.size()==0){
            return null;
        }

        return fileMap;

    }
}
