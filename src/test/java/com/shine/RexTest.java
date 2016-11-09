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

        String str = "hello你好吗,我很好 thank you";
        String reg="[\\u4e00-\\u9fa5\\（\\）\\《\\》\\——\\；\\，\\。\\“\\”\\<\\>]";
  //      String reg = "[\u2E80-\u9FFF]";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        String repickStr = mat.replaceAll("");
        System.out.println("过滤中文后: "+repickStr);


    }

}

