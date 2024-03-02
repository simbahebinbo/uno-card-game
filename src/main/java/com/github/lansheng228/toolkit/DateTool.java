package com.github.lansheng228.toolkit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期Util类
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTool {
    private static final Clock clock = Clock.systemDefaultZone();

    public static String convert(String strDate) {
        String dt = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        boolean isBlank = StringUtils.isEmpty(strDate);

        if (!isBlank) {
            try {
                dt = df.format(df.parse(strDate));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return dt;
    }

    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);

            return dt1.compareTo(dt2);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    //获得后一天日期
    public static String getNextDay(String currentDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = df.parse(currentDate);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String nextDate = df.format(c.getTime());
        return nextDate;
    }

    //获得前一天日期
    public static String getPrevDay(String currentDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        Date date = null;

        try {
            date = df.parse(currentDate);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String prevDate = df.format(c.getTime());
        return prevDate;
    }

    //得到今天日期
    public static String getToday() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(new Date());
    }

    // 获得昨天日期
    public static String getYesterday() {
        return getPrevDay(getToday());
    }


    // 获得明天日期
    public static String getTomorrow() {
        return getNextDay(getToday());
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     */
    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToStrLong(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern)
            throws ParseException {
        return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
                pattern).parse(strDate);
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     */
    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }


    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);
    }


    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static String parseString(String strDate, String pattern)
            throws ParseException {
        Date dt = StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
                pattern).parse(strDate);
        return format(dt, pattern);
    }

    public static String dateToString(Date time) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        String ctime = formatter.format(time);

        return ctime;
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return strToDate(dateString);
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getNow() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取间隔N个月的时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getIntervalMonth(int n) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.MONTH, n);
        String dateString = formatter.format(c.getTime());

        return dateString;
    }

    /**
     * 获取间隔前N个周的时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getIntervalWeek(int n) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DATE, 7 * n);
        String dateString = formatter.format(c.getTime());

        return dateString;
    }

    public static String timeString(LocalDateTime now) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        return FORMATTER.format(now);
    }

    public static long currentTimeMillis() {

        return clock.millis();
    }

    // 当前时间(纳秒)
    public static long currentTimeNanos() {

        return System.nanoTime();
    }

    // 将纳秒转成毫秒 保留精度
    public static double convertNanosToMillis(long nanos) {
        double millis = nanos / 1000 / 1000D;

        return millis;
    }

    /**
     * 获取现在时间
     */
    public static Date getCurrentDate() {
        Date currentTime = new Date();
        return currentTime;
    }
}

