package com.shine.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 获得与时间相关的类
 *
 */
public class TimeUtil {
    /**
     * 一秒
     **/
    public static final int SECOND = 1000;
    /**
     * 一分钟
     **/
    public static final int MINUTE = 60 * SECOND;
    /**
     * 一小时
     **/
    public static final int HOUR = 60 * MINUTE;
    /**
     * 一天
     **/
    public static final long DAY = 24L * HOUR;
    /**
     * 一个星期
     **/
    public static final long WEEK = 7L * DAY;

    /**
     * 时间戳
     **/
    public static final String TIME_STAMP = "yyyyMMddHHmmssss";

    public static final String TIME_STAMP2 = "yyyyMMddHHmmssSSSS";

    public static final String TIME_STAMP3 = "yyyyMMddHHmmss";

    public static final String TIME_STAMP4 = "yyyy-MM-dd HH:mm:ss:SSS";

    public static final String TIME_STAMP_SLASH = "yyyy/MM/dd HH:mm:ss";

    public static final String TIME_SAMPLE = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_DATE = "yyyy-MM-dd";

    public static final String TIME_STAMP5= "yyyy-MM-dd HH:mm";

    /**
     * 获得今天的日期
     *
     * @return
     */
    public static String getNowDateString(String format) {
        return getTimeByFormat(format);
    }

    /**
     * 获得今天的日期
     *
     * @return
     */
    public static Date getNowDate() {
        return stringToDate(getNowDateString(TIME_DATE), TIME_DATE);
    }
    /**
     * 获得今天的日期小时分钟
     *
     * @return
     */
    public static Date getNowTimeDate() {
        return stringToDate(getNowDateString(TIME_STAMP5), TIME_STAMP5);
    }
    /**
     * 时间加减
     *
     * @param date         时间
     * @param num          数量
     * @param calenderType 单位
     * @return
     */
    public static String getCalculateTime(Date date, int num, int calenderType) {
        SimpleDateFormat df = new SimpleDateFormat(TIME_SAMPLE);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calenderType, num);
        return df.format(c.getTime());
    }

    public static String getCalculateTime2(Date date, int num, int calenderType) {
        SimpleDateFormat df = new SimpleDateFormat(TIME_DATE);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calenderType, num);
        return df.format(c.getTime());
    }

    /**
     * 比较两个日期
     *
     * @param date1 Date 类型  或者 String（yyyy-MM-dd HH:mm:ss） 类型
     * @param date2 同上
     * @return -1  date1 比 date2 早  <br>
     * 1  date1 比 date2 晚
     * 0  日期相等
     * @throws ParseException     String  格式不对
     * @throws ClassCastException String 数据类型不对
     */
    public static int compareDate(Object date1, Object date2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1;
            Date dt2;
            if (date1 instanceof String) {
                dt1 = df.parse((String) date1);
            } else {
                dt1 = (Date) date1;
            }
            if (date2 instanceof String) {
                dt2 = df.parse((String) date2);
            } else {
                dt2 = (Date) date2;
            }


            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得yyyyMMddHHmmss格式的当前时间
     *
     * @return
     */
    public static String getTimeSimple() {
        return getTimeByFormat(TIME_STAMP3);
    }

    /**
     * 获得yyyy-MM-dd HH:mm:ss格式的当前时间
     *
     * @return
     */
    public static String getTimeAll() {
        return getTimeByFormat(TIME_SAMPLE);
    }

    /**
     * SSS  毫秒
     * @return
     */
    public static String getTimeAllSSS() {
        return getTimeByFormat(TIME_STAMP4);
    }

    /**
     * 获得yyyy-MM-dd HH:mm:ss:SSS格式的当前时间
     *
     * @return
     */
    public static String getTimeAll2() {
        return getTimeByFormat(TIME_STAMP4);
    }

    /**
     * 根据时间格式获得当前时间
     *
     * @param format 格式，如yyyyMMddHHmmss
     * @return
     */
    public static String getTimeByFormat(String format) {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(nowDate);
        return nowtime;
    }

    /**
     * 将字符串时间改为Date类型的时间
     *
     *
     * @param next
     * @param s yyyy/MM/dd HH:mm:ss
     * @return
     */
    public static Date StringToDate1(String next, String s) {
        return stringToDate(s, "yyyy/MM/dd HH:mm:ss");
    }

    /**
     * 将字符串时间改为Date类型的时间
     *
     * @param s yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate2(String s) {
        return stringToDate(s, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串时间转化为Date类型
     *
     * @param s      时间字符串
     * @param format s的时间格式
     * @return
     */
    public static Date stringToDate(String s, String format) {
        try {
            Date time;
            SimpleDateFormat sd = new SimpleDateFormat(format);
            time = sd.parse(s);
            return time;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * 将long类型转化成String  "yyyy-MM-dd HH:mm:ss"
     *
     * @param time
     * @return
     */
    public static String long2String(Long time) {
        if (time == null)
            return null;
        else
            return long2String(time, TIME_SAMPLE);
    }

    /**
     * 将long类型转化成String
     *
     * @param time
     * @param format
     * @return
     */
    public static String long2String(Long time, String format) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String data2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 修改时间
     *
     * @param date   时间
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     * @return
     */
    public static Date setHMS(Date date, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }


    /**
     * 计算距离现在的天数
     *
     * @return 天数   错误时返回-1
     * @paramdate 计算日期(XXXX-XX-XX)
     */
    public static long getDayOffsetToNow(String date) {
        Calendar calender = Calendar.getInstance();
        String nowDate = String.valueOf(calender.get(Calendar.YEAR)) + "-"
                + String.valueOf(calender.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calender.get(Calendar.DAY_OF_MONTH));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(date + " 00:00:00");
            Date d2 = df.parse(nowDate + " 00:00:00");
            long diff = d2.getTime() - d1.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 计算距离现在分钟数
     *
     * @param date 计算日期 (XXXX-XX-XX hh:mm:ss)
     * @return 分钟(只有差距在不满一分钟不算)
     */
    public static long getMinuteOffsetToNow(String date) throws ParseException {
        String nowDate = getNowOfdate2();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = df.parse(date);
        Date d2 = df.parse(nowDate);
        long diff = d2.getTime() - d1.getTime();
        long minutes = diff / (1000 * 60);
        return minutes;
    }

    /**
     * 获得当前日期
     *
     * @return 格式 XXXX-XX-XX
     */
    public static String getNowOfdate1() {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        // 获取即时时间
        String nowDate = String.valueOf(calender.get(Calendar.YEAR)) + "-"
                + String.format("%02d", calender.get(Calendar.MONTH) + 1) + "-"
                + String.format("%02d", calender.get(Calendar.DAY_OF_MONTH));
        return nowDate;

    }

    /**
     * 获得当前日期
     *
     * @return 格式 XXXX-XX-XX hh:mm:ss
     */
    public static String getNowOfdate2() {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        // 获取即时时间
        String nowDate = String.valueOf(calender.get(Calendar.YEAR)) + "-"
                + String.format("%02d", calender.get(Calendar.MONTH) + 1) + "-"
                + String.format("%02d", calender.get(Calendar.DAY_OF_MONTH)) + " "
                + String.format("%02d", calender.get(Calendar.HOUR_OF_DAY)) + ":"
                + String.format("%02d", calender.get(Calendar.MINUTE)) + ":"
                + String.format("%02d", calender.get(Calendar.SECOND));

        return nowDate;

    }


    /**
     * 获得当前时间+制定偏移天数日期
     *
     * @return 格式 XXXX-XX-XX hh:mm:ss
     */
    public static String getOffsetDaysdate(int days) {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        int all = 0, evoffset = 0, sign = 1;
        if (days < 0) {
            sign = -1;
            days *= -1;
        }
        //分多次偏移
        for (; days != 0; days -= evoffset) {

            if (days != 0 && days % 360 == 0) {
                evoffset = 360;
            } else {
                evoffset = days % 360;
            }
            calender.add(Calendar.DAY_OF_YEAR, evoffset * sign);
        }

        // 获取即时时间
        String nowDate = String.valueOf(calender.get(Calendar.YEAR)) + "-"
                + String.format("%02d", calender.get(Calendar.MONTH) + 1) + "-"
                + String.format("%02d", calender.get(Calendar.DAY_OF_MONTH)) + " "
                + String.format("%02d", calender.get(Calendar.HOUR_OF_DAY)) + ":"
                + String.format("%02d", calender.get(Calendar.MINUTE)) + ":"
                + String.format("%02d", calender.get(Calendar.SECOND));

        return nowDate;

    }


    /**
     * 获得当前时间+制定偏移天数日期
     *
     * @return 格式 XXXX-XX-XX
     */
    public static String getOffsetDaysdate2(int days) {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        int all = 0, evoffset = 0, sign = 1;
        if (days < 0) {
            sign = -1;
            days *= -1;
        }
        //分多次偏移
        for (; days != 0; days -= evoffset) {

            if (days != 0 && days % 360 == 0) {
                evoffset = 360;
            } else {
                evoffset = days % 360;
            }
            calender.add(Calendar.DAY_OF_YEAR, evoffset * sign);
        }

        // 获取即时时间
        String nowDate = String.valueOf(calender.get(Calendar.YEAR)) + "-"
                + String.format("%02d", calender.get(Calendar.MONTH) + 1) + "-"
                + String.format("%02d", calender.get(Calendar.DAY_OF_MONTH));

        return nowDate;

    }


    /**
     * 得到月份与星期
     *
     * @return [例如：9月2日 周三]
     */
    public static String getMonthAndWeekday() {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        // 获取即时日期
        String nowDate = (calender.get(Calendar.MONTH) + 1) + "月" + calender.get(Calendar.DAY_OF_MONTH) + "日 周";
        switch (calender.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                nowDate += "一";
                break;
            case Calendar.THURSDAY:
                nowDate += "二";
                break;
            case Calendar.WEDNESDAY:
                nowDate += "三";
                break;
            case Calendar.TUESDAY:
                nowDate += "四";
                break;
            case Calendar.FRIDAY:
                nowDate += "五";
                break;
            case Calendar.SATURDAY:
                nowDate += "六";
                break;
            case Calendar.SUNDAY:
                nowDate += "日";
                break;
        }
        return nowDate;
    }

    /**
     * 得到日期次序 自2015年1月1日起为1(天作为计算对象) 注意计算日期不得早于2015年,否则返回-1
     *
     * @param date 日期字符串(为YYYY-MM-DD或者YYYY-MM-DD HH:mm：ss)
     * @return [例如：2016年1月1日为 366]
     */
    public static int getDayIndex(String date) {
        int dayIndex = 0;
        Calendar calender = Calendar.getInstance(); // 获得日历对象
        int year = Integer.parseInt(date.substring(0, 4));
        if (year < 2015) {
            return -1;
        }
        int month = Integer.valueOf(date.substring(5, 7)) - 1;
        int day = Integer.valueOf(date.substring(8, 10));

        // 从2015年1月1日起计算

        for (int i = 2015; i <= year; i++) {
            if (i == year) {
                calender.set(year, month, day);
            }
            // 如果不是本年则从-12-31获得该年天数
            else {
                calender.set(i, 11, 31);
            }
            dayIndex += calender.get(Calendar.DAY_OF_YEAR);
        }

        return dayIndex;
    }

    /**
     * 获取一个月的天
     *
     * @param year
     * @param month
     * @param isNow 是否是现在时间，是 前面的参数无效
     * @return list对应的每七个数据一组, 这七个分别对应 日——>六
     */
    public static List<Integer> getMonthDays(int year, int month, boolean isNow) {

        if (isNow) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
        }

        //新建列表
        List<Integer> days = new ArrayList<>();

        int index = 1;

        for (int i = 1; i <= 42; i++) {
            days.add(null);
        }

        // 获得日历对象
        Calendar calender = Calendar.getInstance();

        //先查出这个月的第一天是星期几
        calender.set(year, month - 1, 1);

        //前面的几个星期应排上上一个月的
        if (calender.get(Calendar.DAY_OF_WEEK) > 1) {
            while (true) {
                //  System.out.println(calender.get(Calendar.DAY_OF_WEEK));

                if (1 == calender.get(Calendar.DAY_OF_WEEK)) {
                    break;
                }

                //减一天
                calender.add(Calendar.DATE, -1);

                days.set(calender.get(Calendar.DAY_OF_WEEK) - 1, calender.get(Calendar.DAY_OF_MONTH));
                index++;
            }
        }

        //开始这个月的分析或者延伸到下一个月前几天
        calender.set(year, month - 1, 1);
        for (int i = calender.get(Calendar.DAY_OF_WEEK); index <= 42; i++) {

            days.set(i - 1, calender.get(Calendar.DAY_OF_MONTH));
            index++;

            //加一天
            calender.add(Calendar.DATE, 1);
        }
        return days;
    }


    /**
     * 获得距离现在时间前后的时间戳
     *
     * @param offset 偏移 大于0表示往后推 小于0表示往前移(单位：s)
     * @return
     */
    public static long getOffsetTimeStamp(int offset) {

        Calendar calendar = Calendar.getInstance();

        //设置偏移
        calendar.add(Calendar.SECOND, offset);

        return calendar.getTimeInMillis();
    }

    /**
     * 增减天数
     *
     * @param date 指定的时间
     * @param num  要变化的天数，可以为负数
     * @return
     */
    public static Date addDay(Date date, int num) {
        try {
            Calendar startDT = Calendar.getInstance();
            startDT.setTime(date);
            startDT.add(Calendar.DAY_OF_MONTH, num);
            return startDT.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 增减分钟
     *
     * @param date 指定的时间
     * @param num  要变化的分钟，可以为负数
     * @return
     */
    public static Date addMinute(Date date, int num) {
        try {
            Calendar startDT = Calendar.getInstance();
            startDT.setTime(date);
            startDT.add(Calendar.MINUTE, num);
            return startDT.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前日期+时间
     *
     * @return XXXX-XX-XX hh:mm:ss
     */
    public static String getNowDateTime() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_SAMPLE);
        return sdf.format(nowDate);
    }

    public static void main(String[] strings) {
        Date nowDate = TimeUtil.getNowDate();

        for (int i = 0; i < 5; i++) {
            String dayDateStr = TimeUtil.data2String(TimeUtil.addDay(nowDate, -i), TimeUtil.TIME_DATE);
            System.out.println(i + "=" + dayDateStr);
        }
    }

    /**
     * 将 yyyy-MM-dd HH:mm 转为时间戳
     * @param string
     * @return
     */
    public static Long getTimeStamp(String string) {
        Date date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(TIME_STAMP5);
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
