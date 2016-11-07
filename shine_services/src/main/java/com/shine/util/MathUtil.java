package com.shine.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class MathUtil {

    public static double addAll(double[] arr){
        double all = 0 ;
        for(double d : arr)
            all += d;
        return all;
    }

    /**
     * 获取6位随机数
     *
     * @return
     */
    public static String getRandomNum() {
        return getRandomNum(6);
    }

    /**
     * 获取指定位数随机数
     *
     * @param digit 指定位数
     * @return
     */
    public static String getRandomNum(int digit) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            result.append(random.nextInt(9));
        }
        return result.toString();
    }

    /**
     * 获取指定位数随机数
     *
     * @param digit 指定位数
     * @return
     */
    public static String getRandomNumStr(int digit) {
        String str = "012456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            result.append(str.charAt(random.nextInt(str.length())));
        }
        return result.toString();
    }

    /**
	 * 判断字符串是否是浮点数
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNumber(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	/**
	 * 格式化精度，四舍五入
	 * @param num
	 * @param precision 几位小数
	 * @return
	 */
	public static String format(Double num,int precision){
        return String.format("%."+String.valueOf(precision)+"f", num);
	}

	/**
	 * 格式化精度，不四舍五入
	 * @param num
	 * @param precision
	 * @return
	 */
	public static Double format2(Double num,int precision){
		DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(precision);
        formater.setGroupingSize(0);
        //不四舍五入
        formater.setRoundingMode(RoundingMode.FLOOR);
        return Double.valueOf(formater.format(num));
	}

    /**
     * 格式化精度, 四舍五入
     * */
    public static Double format3(Double num, int precision) {

        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(precision);
        formater.setGroupingSize(0);
        //四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);
        return Double.valueOf(formater.format(num));
    }


    /**
     * 随机六位数
     * @return
     */
    public static String getSixRandomNum(){
        Random random = new Random();
        return String.valueOf(random.nextInt(899999)+100000);
    }

    public static Double string2Double(String str){
        if (StringUtil.isNotEmpty(str)){
            return Double.parseDouble(str);
        }
        return 0.00;
    }

    public static int string2Int(String str){
        if (StringUtil.isNotEmpty(str)){
            return Integer.parseInt(str);
        }
        return 0;
    }

    /**
     * 比较大小
     *
     * @param obj1
     * @param obj2
     * @return obj1 > obj2 true <br/> obj1 < obj2 false
     */
    public static boolean compareDouble(String obj1, String obj2) {
        Double d1 = Double.parseDouble(obj1);
        Double d2 = Double.parseDouble(obj2);
        return d1 > d2 ? true : false;
    }

    /**
     * 保留两位小数
     * @param f
     * @return
     */
    public static double Reserved2DecomalPlaces(double f) {
        BigDecimal b = new BigDecimal(f);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * double转int 四舍五入
     * @param douNum
     * @return
     */
    public static int double2Int(Double douNum){
        int intNum = (int)(douNum + 0.5) ;
        return intNum;
    }



	
}
