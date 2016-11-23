package net.shine.mongodb.utils;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 数学工具类
 *
 */
public class MathUtil {

    /**
     * 格式化精度，四舍五入
     *
     * @param num
     * @param precision 几位小数
     * @return
     */
    public static String format(Double num, int precision) {
        return String.format("%." + String.valueOf(precision) + "f", num.doubleValue());
    }

    /**
     * 格式化精度，不四舍五入
     *
     * @param num
     * @param precision
     * @return
     */
    public static Double format2(Double num, int precision) {
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(precision);
        formater.setGroupingSize(0);
        //不四舍五入
        formater.setRoundingMode(RoundingMode.FLOOR);
        return Double.valueOf(formater.format(num));
    }

    /**
     * 格式化精度, 四舍五入
     */
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
     *
     * @return
     */
    public static String getSixRandomNum() {
        Random random = new Random();
        return String.valueOf(random.nextInt(899999) + 100000);
    }

    public static Double string2Double(String str) {
        if (StringUtil.isNotEmpty(str)) {
            return Double.parseDouble(str);
        }
        return 0.00;
    }

    public static int string2Int(String str) {
        if (StringUtil.isNotEmpty(str)) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    /**
     * double转int 四舍五入
     *
     * @param douNum
     * @return
     */
    public static int double2Int(Double douNum) {
        int intNum = (int) (douNum + 0.5);
        return intNum;
    }


    public static void main(String[] args) {
//        System.out.println(format(10000.011,0));
//        System.out.println(getSixRandomNum());
//        System.out.println(getSixRandomNum());
        double outcome = -986.56878;
        System.out.println(MathUtil.format(-outcome, 2));
    }


}
