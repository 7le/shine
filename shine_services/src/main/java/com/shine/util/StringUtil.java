package com.shine.util;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {


    public static boolean arrayContainString(String[] array,String str){
        for(String s : array)
            if(str.contains(s))
                return true;
        return false;
    }


    public static String[] splitAndTrim(String value,String regularExpression){
        try {
            String[] values = value.split(regularExpression);
            int num=0;
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


    public static String[] List2Array(List<String> list){
        try {
            String[] strings = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strings[i]  = list.get(i);
                ;			}
            return strings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> Array2List(String[] strings){
        try {
            List<String> stringList = new ArrayList<>();
            for (int i=0;i<strings.length;i++){
                stringList.add(strings[i]);
            }
            return stringList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * �жϸ����ַ����Ƿ�հ״���
     * �հ״���ָ�ɿո��Ʊ�����س��������з���ɵ��ַ���
     * �������ַ���Ϊnull����ַ���������true
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input){
        if (input == null || input.trim().equals("")){
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
     * �жϸ����ַ����Ƿ�հ״���
     * @param input
     * @return
     */
    public static boolean isNotEmpty(String input){
        return !isEmpty(input);
    }

    /**
     * ��ĸ����ĸ��д
     * @param str
     * @return
     */
    public static String toLowerCaseTheFristChar(String str) {
        byte[] items = str.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * ����ַ��������ǲ��Ƿǿ�
     * @param strings
     * @return
     */
    public static boolean arrayIsEmpty(String[] strings){
        boolean ok = false;
        for (int i = 0; i < strings.length; i++) {
            if (isNotEmpty(strings[i])) {
                break;
            }
            if (i==strings.length-1) {
                ok = true;
            }
        }
        return ok;
    }


    /**
     * ��������*****511@163.com�����
     * @param str
     * @return
     */
    public static String getWebEmail(String str) {
        String rs="error";
        if (isNotEmpty(str)) {
            try {
                if ( isEmail(str) ) {
                    String[] strS = str.split("[@]");
                    if (strS[0].length()>4) {
                        rs = strS[0].substring(0, strS[0].length()-4)+"****@"+strS[1];
                    }else{
                        rs = strS[0].substring(0,strS[0].length()-2)+"**@"+strS[1];
                    }
                    //rs=str.substring(0,str.length() - (str.substring(3)).length()) +"****"+str.substring(7);
                }
            } catch (Exception e) {
                rs="error";
            }
        }
        return rs;
    }


    /**
     * ��֤�Ƿ�Ϊ�����
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }



    /**
     * ���ֻ����滻��182****351��ʽ
     * @param str
     * @return
     */
    public static String getWebPhone(String str) {
        String rs="error";
        if (isNotEmpty(str)) {
            try {
                if (isMobileNO(str)) {
                    rs=str.substring(0,str.length() - (str.substring(3)).length()) +"****"+str.substring(7);
                }
            } catch (Exception e) {
                rs="error";
            }
        }
        return rs;
    }

    /**
     * �����Ƿ����ֻ���
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        if (StringUtil.isEmpty(mobiles)){
            return false;
        }
        Pattern p = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // ��֤�ֻ���
        Matcher m= p.matcher(mobiles);
        return m.matches();
    }


    /**
     * �ж��ַ����ǲ�������
     * @param string
     * @return
     */
    public static boolean isNumber(String string){
        return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    /**
     * ��ȡ330**************4��ʽ�����֤��
     * @param idcard
     * @return
     */
    public static String getWebIdcard(String idcard){
        String str = "error";
        if(isNotEmpty(idcard)){
            try {
                str = idcard.substring(0, 3) + "**************" + idcard.substring(idcard.length() - 1);
            } catch (Exception e){
                str = "error";
            }
        }
        return str;
    }





    /**��֤�����ַ����Ƿ���YYYY-MM-DD��ʽ
     * @param str
     * @return
     */
    public static boolean isDataFormat(String str){
        boolean flag=false;
        //String regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
        String regxStr="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Pattern pattern1=Pattern.compile(regxStr);
        Matcher isNo=pattern1.matcher(str);
        if(isNo.matches()){
            flag=true;
        }
        return flag;
    }

    /**
     * ����html��ǩ���������
     * @param content
     * @param length
     * @return
     */
    public static String filterHtml(String content, int length) {
        if (isEmpty(content)) {
            return "";
        }
        // ȥ������htmlԪ��,
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
     * �����ַ���
     * @param str
     * @return
     */
    public static String reverseString(String str){
        if (StringUtil.isNotEmpty(str)){
            return new StringBuffer(str).reverse().toString();
        }
        return "";
    }

    /**
     * �������Ƿ���ָ��ֵ
     * @param array
     * @param value
     * @return
     */
    public static boolean arrayContainsValue(Object[] array, Object value){
        for(Object object : array){
            if(object.equals(value)) return true;
        }
        return false;
    }


    public static void main(String[] arg){
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

    public static String join(Object[] arr, String split){
        StringBuilder sb = new StringBuilder();
        int offset = arr.length - 1;
        for( int i = 0; i < offset; i++ )
        {
            sb.append(arr[i]).append(split);
        }
        sb.append(arr[offset]);

        return sb.toString();
    }

}
