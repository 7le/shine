package net.shine.mongodb.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间类
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
    public static final int DAY = 24 * HOUR;
    /**
     * 一个星期
     **/
    public static final int WEEK = 7 * DAY;

    /**
     * 时间戳
     **/
    public static final String TIME_STAMP = "yyyyMMddHHmmssSSS";

    /**
     * 精确时间格式
     */
    public static final String TIME_SAMPLE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式
     */
    public static final String TIME_DATE = "yyyy-MM-dd";

    /**
     * 日期格式：最简单
     */
    public static final String TIME_DATE_SAMLE = "yyyyMMdd";


    /**
     * 格式化时间
     *
     * @param time
     * @param format
     * @return
     */
    public static String format(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(StringToDate2(time));
    }


    /**
     * 获得yyyyMMddHHmmss格式的当前时间
     *
     * @return
     */
    public static String getTimeSimple() {
        return getTimeByFormat("yyyyMMddHHmmss");
    }

    /**
     * 获得yyyy-MM-dd HH:mm:ss格式的当前时间
     *
     * @return
     */
    public static String getTimeAll() {
        return getTimeByFormat("yyyy-MM-dd HH:mm:ss");
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
     * @param s yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date StringToDate2(String s) {
        return StringToDate(s, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串时间转化为Date类型
     *
     * @param s      时间字符串
     * @param format s的时间格式
     * @return
     */
    public static Date StringToDate(String s, String format) {
        try {
            Date time = new Date();
            SimpleDateFormat sd = new SimpleDateFormat(format);
            time = sd.parse(s);
            return time;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 增加月数
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addMonth(Date date, int num) {
        try {
            Calendar startDT = Calendar.getInstance();
            startDT.setTime(date);
            startDT.add(Calendar.MONTH, num);
            return startDT.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
     * 增加分钟
     *
     * @param date
     * @param num
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
     * 增加月数
     *
     * @param date
     * @param num
     * @return
     */
    public static String addMonth(String date, int num) {
        return addMonth(date, num, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 增加月数
     *
     * @param date
     * @param num
     * @return
     */
    public static String addMonth(String date, int num, String format) {
        try {
            String newDate = dateToString(addMonth(StringToDate(date, format), num), format);
            return newDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串时间更改时间
     *
     * @param date
     * @param num
     * @return
     */
    public static String addDay(String date, int num) {
        return addDayWithFormat(date, num, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串时间更改时间
     *
     * @param date
     * @param num
     * @return
     */
    public static String addDayWithFormat(String date, int num, String format) {
        try {
            String newDate = dateToString(addDay(StringToDate(date, format), num), format);
            return newDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串增加分钟
     *
     * @param date
     * @param num
     * @return
     */
    public static String addMinute(String date, int num) {
        try {
            String newDate = dateToString(addMinute(StringToDate(date, "yyyy-MM-dd HH:mm:ss"), num), "yyyy-MM-dd HH:mm:ss");
            return newDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * data 转string
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(date);
        return nowtime;
    }


    /**
     * 比较两个时间的大小
     *
     * @param time1
     * @param time2
     * @return time1 比time 2 大，则返回true
     */
    public static boolean compareTime(String time1, String time2) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            long diff = d1.getTime() - d2.getTime();
            return diff >= 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 比较两个时间的大小，带格式
     *
     * @param time1
     * @param time2
     * @return time1 比time 2 大，则返回true
     */
    public static boolean compareTimeWithFormat(String time1, String time2, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format);
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            long diff = d1.getTime() - d2.getTime();
            return diff >= 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 获得当天日期
     *
     * @return
     */
    public static String getDate() {
        return getTimeByFormat("yyyy-MM-dd");
    }


    /**
     * 转化格式化
     *
     * @param time
     * @return
     */
    public static String changeFormat(String time, String format1, String format2) {
        try {
            return dateToString(StringToDate(time, format1), format2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获得当前月的第一天
     *
     * @return
     */
    public static String getFirstDayOfCurrentMonth() {
        return getFirstDayOfMonth(getTimeByFormat("yyyy-MM-dd"));
    }


    /**
     * 获得当前月的最后一天
     *
     * @return
     */
    public static String getLastDayOfCurrentMonth() {
        return getLastDayOfMonth(getTimeByFormat("yyyy-MM-dd"));
    }


    /**
     * 获得指定日期所在月的第一天
     *
     * @param time
     * @return
     */
    public static String getFirstDayOfMonth(String time) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }


    /**
     * 根据指定日期获取所在月的最后一天
     *
     * @param time
     * @return
     */
    public static String getLastDayOfMonth(String time) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 获得下个交易日
     */
    public static Date getNextWorksday(Date date) {
        try {
            return StringToDate(addDayWork(dateToString(date, TIME_SAMPLE), 1), TIME_SAMPLE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 设置小时数及分
     */
    public static Date setHoursAndMinutes(Date date, int hours, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        return cal.getTime();
    }


    /**
     * 获得相差天数
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long getDimDays(String time1, String time2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long to = 0;
        try {
            to = df.parse(time1).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long from = 0;
        try {
            from = df.parse(time2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long days = (from - to) / (1000 * 60 * 60 * 24);
        return days;
    }


    /**
     * 增加天数，去除周末和节假日
     *
     * @param time
     * @param count
     * @return
     */
    public static String addDayWork(String time, int count) {
        Date date = StringToDate(time, TIME_SAMPLE);
        for (int i = 1; i <= count; i++) {
            date = addDay(date, 1);
            date = getWorkDate(date);
        }
        return dateToString(date, TIME_SAMPLE);
    }


    /**
     * 获得工作时间，去除周末和节假日
     *
     * @param date 任意日期
     * @return the income date
     * @throws NullPointerException if null == date
     */
    public static Date getWorkDate(Date date) {
        if (null == date) {
            return null;
        }
        //对日期的操作,我们需要使用 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Date workDate = calendar.getTime();

        if (isWeekend(calendar) || isHoliday(calendar)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            workDate = calendar.getTime();
            //递归
            return getWorkDate(workDate);
        }
        return workDate;
    }

    /**
     * 判断一个日历是不是周末.
     *
     * @param calendar the calendar
     * @return true, if checks if is weekend
     */
    public static boolean isWeekend(Calendar calendar) {
        //判断是星期几
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == 1 || dayOfWeek == 7) {
            return true;
        }
        return false;
    }

    /**
     * 一个日历是不是节假日.
     *
     * @param calendar the calendar
     * @return true, if checks if is holiday
     */
    public static boolean isHoliday(Calendar calendar) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(calendar.getTime());
//        String holidays = WebConst.holidays;
        String holidays = "2015-01-01,2015-01-02,2015-01-03,2015-04-04,2015-04-05,2015-04-06,2015-05-01,2015-05-02,2015-05-03,2015-06-20,2015-06-21,2015-06-22,2015-09-26,2015-09-27,2015-10-01,2015-10-02,2015-10-03,2015-10-04,2015-10-05,2015-10-06,2015-10-07";
        //为空，则没设置节假日
        if (StringUtil.isEmpty(holidays)) {
            return false;
        }
        String[] holidayArray = holidays.split(",");
        boolean isHoliday = false;// org.apache.commons.lang.ArrayUtils.contains(holidayArray, dateString);
        return isHoliday;
    }

    public static final int YEAR_RETURN = 0;

    public static final int MONTH_RETURN = 1;

    public static final int DAY_RETURN = 2;

    public static final int HOUR_RETURN = 3;

    public static final int MINUTE_RETURN = 4;

    public static final int SECOND_RETURN = 5;


    public static final String YYYY = "yyyy";

    public static final String YYYYMM = "yyyy-MM";

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String YYYYMMDDHH = "yyyy-MM-dd HH";

    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获得两个时间的相隔月份
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static long getBetweenByMonth(String beginTime, String endTime) {
        return getBetween(beginTime, endTime, YYYYMM, MONTH_RETURN);
    }

    /**
     * 获得两个时间的时间差或日期差
     *
     * @param beginTime
     * @param endTime
     * @param formatPattern
     * @param returnPattern
     * @return
     * @throws ParseException
     */
    public static long getBetween(String beginTime, String endTime, String formatPattern, int returnPattern) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatPattern);
            Date beginDate = simpleDateFormat.parse(beginTime);
            Date endDate = simpleDateFormat.parse(endTime);

            Calendar beginCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            beginCalendar.setTime(beginDate);
            endCalendar.setTime(endDate);
            switch (returnPattern) {
                case YEAR_RETURN:
                    return getByField(beginCalendar, endCalendar, Calendar.YEAR);
                case MONTH_RETURN:
                    return getByField(beginCalendar, endCalendar, Calendar.YEAR) * 12 + getByField(beginCalendar, endCalendar, Calendar.MONTH);
                case DAY_RETURN:
                    return getTime(beginDate, endDate) / (24 * 60 * 60 * 1000);
                case HOUR_RETURN:
                    return getTime(beginDate, endDate) / (60 * 60 * 1000);
                case MINUTE_RETURN:
                    return getTime(beginDate, endDate) / (60 * 1000);
                case SECOND_RETURN:
                    return getTime(beginDate, endDate) / 1000;
                default:
                    return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得系统距离1970年1月1日零时的毫秒数
     *
     * @return
     */
    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获得系统距离1970年1月1日零时的毫秒数字符串
     *
     * @return
     */
    public static String getSystemTimeString() {
        return String.valueOf(getSystemTime());
    }


    private static long getByField(Calendar beginCalendar, Calendar endCalendar, int calendarField) {
        return endCalendar.get(calendarField) - beginCalendar.get(calendarField);
    }

    private static long getTime(Date beginDate, Date endDate) {
        return endDate.getTime() - beginDate.getTime();
    }

    public static void main(String[] args) {

        Date date = new Date(2040694098l);
        System.out.println(dateToString(date, TIME_SAMPLE));

//        System.out.println(1453953219128l -1453951810855l );

    }

}
