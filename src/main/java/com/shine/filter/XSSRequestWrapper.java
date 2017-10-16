package com.shine.filter;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    private static Pattern[] patterns = new Pattern[]{
            // Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            // src='...'
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // lonely script tags
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // eval(...)
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // expression(...)
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // javascript:...
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // vbscript:...
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };

    public XSSRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }

        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
//        if("callback".equals(parameter)){
//            return  "'%22/%3E%3C/body%3E%3Cbody+onload=prompt()%3E";
//        }
        return stripXSS(value);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }


    static private String stripXSS(String value) {
//        return XssClean.xssClean(value);
        if (value != null) {
            return XssClean.xssClean(value);
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
//             value = ESAPI.encoder().canonicalize(value);

            // Avoid null characters
//            value = value.replaceAll("\0", "");
//
//            // Remove all sections that match a pattern
//            for (Pattern scriptPattern : patterns){
//                value = scriptPattern.matcher(value).replaceAll("");
//            }
        }
        return value;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String value = "abc";
        value= "'%22/%3E%3C/body%3E%3Cbody+onload=prompt()%3E";
        System.out.println(URLDecoder.decode(value));
        System.out.println(cleanStr( value));
//        value="<body>alert(1);</body>";
//        value = "123";
        value = "\"/></body><body+onload=prompt()>";
        value=">=";
        String abc = stripXSS(value);
        System.out.println("before:"+value);
        System.out.println("after:"+abc);

        String url = "123+456";
        System.out.println(URLDecoder.decode(url,"utf-8"));
//        System.out.println(UrlEncoderUtils.hasUrlEncoded(url));




//        escapeutils();
    }

    private static String cleanStr(String value){
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }

    public static void escapeutils() {
        String sql="1' or '1'='1";
        System.out.println("防SQL注入:"+ StringEscapeUtils.escapeSql(sql)); //防SQL注入

        System.out.println("转义HTML,注意汉字:"+ StringEscapeUtils.escapeHtml("<font>chen磊  xing</font>"));    //转义HTML,注意汉字
        System.out.println("反转义HTML:"+ StringEscapeUtils.unescapeHtml("<font>chen磊  xing</font>"));  //反转义HTML

        System.out.println("转成Unicode编码："+ StringEscapeUtils.escapeJava("陈磊兴"));     //转义成Unicode编码

        System.out.println("转义XML："+ StringEscapeUtils.escapeXml("<name>陈磊兴</name>"));   //转义xml
        System.out.println("反转义XML："+ StringEscapeUtils.unescapeXml("<name>陈磊兴</name>"));    //转义xml
    }
}