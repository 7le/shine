package com.shine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hq on 2016/11/9.
 */
public class RexTest {

    public static void main(String[] args) {

 /*       ([\u4E00-\u9FA5]|[\uFE30-\uFFA0])+  */
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5\\（\\）\\《\\》\\——\\；\\，\\。\\“\\”\\<\\>]");
        System.out.println(p.matcher("hello你好吗,我很好thank you").find());

        String str = "hello你好吗,我很好 thank you……a…a,a.";
        String reg="[\\u4e00-\\u9fa5\\（\\）\\《\\》\\——\\；\\，\\。\\“\\”\\<\\>\\…\\……\\,\\.]";
  //      String reg = "[\u2E80-\u9FFF]";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        String repickStr = mat.replaceAll("");
        System.out.println("过滤中文后: "+repickStr);


        //验证是否为邮箱地址
        String str1="ceponline@yahoo.com.cn";

        Pattern pattern =Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());

        //去除html标记

        Pattern pattern1 = Pattern.compile("<.+?>",Pattern.DOTALL);

        Matcher matcher1 = pattern1.matcher("<a href=\"index.html\">主页<br><br/></a>");

        String string = matcher1.replaceAll("");

        System.out.println(string);
           //去除html标记

           Pattern pattern2 = Pattern.compile("[\\[\\]\\【\\】\\&nbsp;\\ \\\n\\　]");

           Matcher matcher2 = pattern2.matcher("[][dasd] asda sds【dsadas】d as　d　&nb　sp;&nbsp;&nbsp;231\n\n\ndd");

           String string2 = matcher2.replaceAll("");

           System.out.println(string2);

    }

}

