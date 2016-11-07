package net.sedion.mongodb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串工具类
 *
 */
public class StringUtil {

    /**
     * 字符切割
     *
     * @param value             字符串值
     * @param regularExpression 切割符
     * @return 字符串数组
     */
    public static String[] splitAndTrim(String value, String regularExpression) {
        try {
            String[] values = value.split(regularExpression);
            int num = 0;
            for (int i = 0; i < values.length; i++) {
                if (!values[i].trim().equals("")) {
                    num++;
                }
            }
            String[] resultValues = new String[num];
            for (int i = 0; i < resultValues.length; i++) {
                resultValues[i] = values[i];
            }
            return resultValues;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 将String的list集合转化为字符串数组
     *
     * @param list
     * @return
     */
    public static String[] List2Array(List<String> list) {
        try {
            String[] strings = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strings[i] = list.get(i);
                ;
            }
            return strings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> Array2List(String[] strings) {
        try {
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                stringList.add(strings[i]);
            }
            return stringList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断给定字符串是否空白串。
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串
     * 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || input.trim().equals("")) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断给定字符串是否空白串。
     *
     * @param input
     * @return
     */
    public static boolean isNotEmpty(String input) {
        return !isEmpty(input);
    }

    /**
     * 字母首字母大写
     *
     * @param str
     * @return
     */
    public static String toLowerCaseTheFristChar(String str) {
        byte[] items = str.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * 检查字符串数组是不是非空
     *
     * @param strings
     * @return
     */
    public static boolean arrayIsEmpty(String[] strings) {
        boolean ok = false;
        for (int i = 0; i < strings.length; i++) {
            if (isNotEmpty(strings[i])) {
                break;
            }
            if (i == strings.length - 1) {
                ok = true;
            }
        }
        return ok;
    }


    /**
     * 生成类似*****511@163.com邮箱号
     *
     * @param str
     * @return
     */
    public static String getWebEmail(String str) {
        String rs = "error";
        if (isNotEmpty(str)) {
            try {
                if (isEmail(str)) {
                    String[] strS = str.split("[@]");
                    if (strS[0].length() > 4) {
                        rs = strS[0].substring(0, strS[0].length() - 4) + "****@" + strS[1];
                    } else {
                        rs = strS[0].substring(0, strS[0].length() - 2) + "**@" + strS[1];
                    }
                    //rs=str.substring(0,str.length() - (str.substring(3)).length()) +"****"+str.substring(7);
                }
            } catch (Exception e) {
                rs = "error";
            }
        }
        return rs;
    }


    /**
     * 验证是否为邮箱号
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    /**
     * 将手机号替换成182****351形式
     *
     * @param str
     * @return
     */
    public static String getWebPhone(String str) {
        String rs = "error";
        if (isNotEmpty(str)) {
            try {
                if (isMobileNO(str)) {
                    rs = str.substring(0, str.length() - (str.substring(3)).length()) + "****" + str.substring(7);
                }
            } catch (Exception e) {
                rs = "error";
            }
        }
        return rs;
    }

    /**
     * 检验是否是手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (StringUtil.isEmpty(mobiles)) {
            return false;
        }
        Pattern p = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    /**
     * 判断字符串是不是数字
     *
     * @param string
     * @return
     */
    public static boolean isNumber(String string) {
        return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }


    /**
     * 功能：身份证的有效验证
     *
     * @param IDStr 身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws ParseException
     */
    @SuppressWarnings("rawtypes")
    public static String IDCardValidate(String IDStr) {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = {"1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2"};
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDataFormat(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围。";
                return errorInfo;
            }
        } catch (Exception e) {
            errorInfo = "身份证生日不在有效范围。";
            return errorInfo;
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        return "";
    }

    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 验证日期字符串是否是YYYY-MM-DD格式
     *
     * @param str
     * @return
     */
    public static boolean isDataFormat(String str) {
        boolean flag = false;
        //String regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
        String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Pattern pattern1 = Pattern.compile(regxStr);
        Matcher isNo = pattern1.matcher(str);
        if (isNo.matches()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 过滤html标签，获得内容
     *
     * @param content
     * @param length
     * @return
     */
    public static String filterHtml(String content, int length) {
        if (isEmpty(content)) {
            return "";
        }
        // 去掉所有html元素,
        String str = content.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
                "<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        int len = str.length();
        if (len <= length) {
            return str;
        } else {
            str = str.substring(0, length);
        }
        return str;
    }


    /**
     * 倒序字符串
     *
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if (StringUtil.isNotEmpty(str)) {
            return new StringBuffer(str).reverse().toString();
        }
        return "";
    }


    public static void main(String[] arg) {
//        String num  = "510322197406283968";
//        System.out.println(IDCardValidate(num));


//    	String str="182111@qq.com";

    	/*Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
    	System.out.println(matcher.matches());*/
//    	System.out.println(getWebEmail(str));
//        String body = "<img title=\"110524225582718e00acae1ef7.jpg\" src=\"/upload/web/images/20140830202300349757.jpg\" width =\"100\" height = \"100\">";
//        body = body.replaceAll(
//                "(<img[^>]*?)\\s+width\\s*=\\s*\\S+", "$1");
//        body = body.replaceAll(
//                "(<img[^>]*?)\\s+height\\s*=\\s*\\S+", "$1");
//        System.out.println(body);

//        String s = "1ivc2ivc3";
//        String[] strings = s.split("ivc");
//        System.out.println(strings.length);
//        for (int i = 0 ;i<strings.length;i++){
//            System.out.println(strings[i]);
//        }
//        System.out.println(isNumber("0.01"));

//        Object ok = true;
//        if (ok instanceof Boolean){
//            System.out.println("xx");
//        }else {
//            System.out.println("ssss");
//        }
//        System.out.println(new StringBuffer("y125746").reverse().toString());


    }

}
