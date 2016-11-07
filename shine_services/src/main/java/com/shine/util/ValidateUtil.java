package com.shine.util;

import com.google.common.base.Throwables;

/**
 * 信息检验
 */
public class ValidateUtil {

    /**
     * 邮箱验证
     *
     * @param validateString
     * @return 验证成功为 true 否则为 false
     */
    public static boolean isEmail(String validateString) {
        if (validateString == null || validateString.length() == 0) {
            return false;
        } else if (!validateString
                .matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
            return false;
        }
        return true;
    }


    /**
     * 邮箱验证(无原因版)
     *
     * @param validateString
     * @return 成功返回原字符串失败抛出异常
     * @throws Throwable 异常message为验证失败信息
     */
    public static String email(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("邮箱为空");
        } else if (!validateString
                .matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
            throw new Throwable("邮箱格式不正确");
        }
        return validateString;
    }


    /**
     * 电话号码验证
     *
     * @param validateString 验证字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String phoneNum(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("手机号不能为空");
        } else if (!validateString.matches("1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}")) {
            throw new Throwable("手机号码格式不正确");
        } else if (validateString.length() != 11) {
            throw new Throwable("手机号码格式不正确");
        }
        return validateString;
    }


    /**
     * 电话号码验证(无原因版)
     *
     * @param validateString 验证字符串
     * @return 验证成功为 true 否则为 false
     */
    public static boolean isPhoneNum(String validateString) {
        if (validateString == null || validateString.length() == 0) {
            return false;
        } else if (!validateString.matches("1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}")) {
            return false;
        } else if (validateString.length() != 11) {
            return false;
        }
        return true;
    }


    /**
     * 将""字符装换为null;
     *
     * @param validateString
     * @return 不为""将反回原字符串,""返回null;
     */
    public static String noLengthStr(String validateString) {
        if (validateString != null && validateString.length() == 0) {
            return null;
        } else {
            return validateString;
        }
    }


    /**
     * 非法字符验证1 只能包含数字、字母、下划线
     *
     * @param validateString 验证字段名
     * @param validateString 验证字符串
     * @param minLength      最短长度
     * @param maxLength      最大长度
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String ofenChar(String fielName, String validateString, int minLength, int maxLength)
            throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable(fielName + "不能为空");
        } else if (!validateString.matches("[A-Za-z0-9_]+")) {
            throw new Throwable(fielName + "含有意外字符(只能包含字母,数字,下划线,且不可有空格)");
        } else if (validateString.length() < minLength || validateString.length() > maxLength) {
            throw new Throwable(fielName + "长度不符合要求(只能在" + minLength + "-" + maxLength + "之间)");
        }
        return validateString;
    }

    /**
     * 字符串装换为整数(有范围检查)
     *
     * @param fielName      验证字符串
     * @param convertString 待转换字符串
     * @param min           最小值
     * @param max           最大值
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static int parseIntoWithSize(String fielName, String convertString, int min, int max) throws Throwable {
        try {
            int p = Integer.valueOf(convertString);
            if (p < min || p > max) {
                throw new Throwable("字段[" + fielName + "]范围不符要求(必须在" + min + "-" + max + "之间)");
            }
            return p;
        } catch (NumberFormatException e) {
            throw new Throwable("字段[" + fielName + "]不符合数字特征");
        }
    }

    /**
     * 字符串装换为整数
     *
     * @param fielName      验证字符串
     * @param convertString 待转换字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static int praseInt(String fielName, String convertString) throws Throwable {
        try {
            int p = Integer.valueOf(convertString);
            return p;
        } catch (Exception e) {
            throw new Throwable("字段[" + fielName + "]无法装换为整型");
        }
    }


    /**
     * 字符串装换为浮点数
     *
     * @param fielName      验证字符串
     * @param convertString 待转换字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static double praseDouble(String fielName, String convertString) throws Throwable {
        try {
            double p = Double.valueOf(convertString);
            return p;
        } catch (Exception e) {
            throw new Throwable("字段[" + fielName + "]无法装换为整型");
        }
    }

    /**
     * 字符串装换为布尔型
     *
     * @param fielName      验证字符串
     * @param convertString 待转换字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static boolean praseBool(String fielName, String convertString) throws Throwable {
        try {
            boolean p = Boolean.valueOf(convertString);
            return p;
        } catch (Exception e) {
            throw new Throwable("字段[" + fielName + "]无法装换为布尔型");
        }
    }

    /**
     * 日期验证1 形式为 YYYY-MM-DD
     *
     * @param fielName       字段名，字段名
     * @param validateString 验证字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String date(String fielName, String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable(fielName + "不能为空");
        } else if (!validateString.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            throw new Throwable(fielName + "格式不正确");
        }
        return validateString;
    }

    /**
     * 日期验证1 形式为 YYYY-MM-DD HH:mm:ss
     *
     * @param fielName       字段名，字段名
     * @param validateString 验证字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String dateTime(String fielName, String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable(fielName + "不能为空");
        } else if (!validateString.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            throw new Throwable(fielName + "格式不正确");
        }
        return validateString;
    }

    /**
     * IP地址验证
     *
     * @param validateString 验证字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String ip(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("IP地址为空");
        } else if (!validateString.matches(
                "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){2}\\..*")) {
            throw new Throwable("IP格式不正确");
        }
        return validateString;
    }

    /**
     * 匹配1*
     * @param validateString
     * @return
     * @throws Throwable
     */
    public static String ip1(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("IP地址为空");
        } else if (!validateString.matches(
                "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d|\\*)")) {
            throw new Throwable("IP格式不正确");
        }
        return validateString;
    }

    /**
     * 匹配2*
     * @param validateString
     * @return
     * @throws Throwable
     */
    public static String ip2(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("IP地址为空");
        } else if (!validateString.matches(
                "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d|\\*)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d|\\*)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d|\\*)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d|\\*)")) {
            throw new Throwable("IP格式不正确");
        }
        return validateString;
    }

    /**
     * 性别验证 * @param fielName 字段名，字段名
     *
     * @param validateString 验证字符串
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static char sex(String validateString) throws Throwable {
        if (validateString == null || validateString.length() == 0) {
            throw new Throwable("性别不能为空");
        } else if (!(validateString.equals("男") || validateString.equals("女"))) {
            throw new Throwable("性别格式不正确");
        }
        return validateString.charAt(0);
    }

    /**
     * 全为空格验证
     *
     * @param validateString 验证字符串
     * @param minLength      最短长度
     * @param maxLength      最大长度
     * @return 验证成功为原字符串
     * @throws Throwable 异常message为验证失败信息
     */
    public static String blankSpace(String fielName, String validateString, int minLength, int maxLength)
            throws Throwable {
        if (validateString == null || validateString.length() == 0) {
        } else if (validateString.replaceAll(" ", "").length() == 0) {
            throw new Throwable(fielName + "不能全为空格");
        } else if (validateString.length() < minLength || validateString.length() > maxLength) {
            throw new Throwable(fielName + "长度不符要求(必须在" + minLength + "-" + maxLength + "之间)");
        }
        return validateString;
    }

    /**
     * 将包含”请选择“的关键字装换为null
     *
     * @param validateString
     * @return
     */
    public static String keyWord(String validateString) {
        if (validateString != null && validateString.contains("请选择")) {
            return null;
        } else {
            return validateString;
        }
    }


    /**
     * 账号验证
     *
     * @param str
     * @throws Throwable 验证失败抛出异常 getMessage获得原因
     */
    public static void account(String str) throws Throwable {
        if (str == null || str.length() == 0) {
            throw new Throwable("账号不能为空");
        }

        if (str.indexOf(" ") != -1) {
            throw new Throwable("账号不能含有空格");
        }

        if (!str.matches("^[0-9A-Za-z_]+$")) {
            throw new Throwable("账号不能含有除字母、数字、下划线之外的字符");
        }
    }


    /**
     * md5码验证
     *
     * @param str
     * @throws Throwable 验证失败抛出异常 getMessage获得原因
     */
    public static void md5Code(String filedName, String str) throws Throwable {
        if (str == null || str.length() == 0) {
            throw new Throwable(filedName + "不能为空");
        }

        if (!str.matches("^[0-9A-Za-z]{32}$")) {
            throw new Throwable(filedName + "格式错误");
        }
    }


    /**
     * 空格或者全为空格检测
     *
     * @return
     */
    public static boolean blackSpaceCheck(String str) {
        if (str == null) {
            return false;
        }

        if (str.length() == 0) {
            return true;
        }

        if (str.replaceAll(" ", "").length() == 0) {
            return true;
        }

        return false;
    }


    /**
     * 微信号检测
     *
     * @param str
     * @return
     */
    public static void weiXin(String str) throws Throwable {
        if (str == null || str.length() == 0) {
            throw new Throwable("微信号不能为空");
        }
        if (!str.matches("^[1-9a-zA-Zd_]{5,30}+$")) {
            throw new Throwable("微信号格式错误");
        }


    }


    /**
     * QQ号检测
     *
     * @param str
     * @return
     */
    public static void qq(String str) throws Throwable {
        if (str == null || str.length() == 0) {
            throw new Throwable("QQ号不能为空");
        }
        if (!str.matches("^[1-9][0-9]{4,15}+$")) {
            throw new Throwable("QQ号格式错误");
        }
    }

}
