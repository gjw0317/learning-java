package com.practice.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by junwuguo on 2017/2/14 0014.
 */
public class DateTime {

    private static final String demoTitle = "==========================";
    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 时间转时间戳
     * @param date 时间或日期
     * @param sdf 时间格式
     * @return 时间戳
     * @throws ParseException
     */
    public static String dateToStamp(String date, SimpleDateFormat sdf) throws ParseException {
        Date time = sdf.parse(date);
        long stamp = time.getTime();
        String result = String.valueOf(stamp);
        return result;
    }

    /**
     * 时间戳转时间
     * @param stamp 时间戳
     * @param sdf 时间格式
     * @return 时间或日期
     */
    public static String stampToDate(String stamp, SimpleDateFormat sdf) {
        Long ts = Long.valueOf(stamp);
        Date time = new Date(ts);
        String result = sdf.format(time);
        return result;
    }

    /**
     * 演示时间戳与时间（日期）的互相转化
     * @throws ParseException
     */
    public static void dateAndStampDemo() throws ParseException {
        System.out.println("\n" + demoTitle + Thread.currentThread().getStackTrace()[1].getMethodName() + demoTitle);

        System.out.println("Datetime To Datetime's Stamp:\t" + dateToStamp("2016-11-01 13:51:44", DATETIME_FORMAT));
        System.out.println("Date To Date's Stamp:\t\t\t" + dateToStamp("2016-11-01", DATE_FORMAT));
        System.out.println("Datetime To Date's Stamp:\t\t" + dateToStamp("2016-11-01 13:51:44", DATE_FORMAT));

        System.out.println("Stamp To Datetime:\t" + stampToDate("1477979504511", DATETIME_FORMAT));
        System.out.println("Stamp To Date:\t\t" + stampToDate("1477979504511", DATE_FORMAT));
    }

    /**
     * 演示日历的相关操作
     */
    public static void calendarDemo() {
        System.out.println("\n" + demoTitle + Thread.currentThread().getStackTrace()[1].getMethodName() + demoTitle);

        //声明、创建当前时间的Calendar对象
        Calendar current = Calendar.getInstance();
        System.out.println("Calendar Date Before Set:\t\t\t" + current.getTime());
        //设置时间为当前时间 往前7天 的 零时零分零秒零毫秒 的 时间
        current.set(Calendar.DATE, current.get(Calendar.DATE) - 7);
/*
        HOUR_OF_DAY与HOUR不同，前者是24小时，后者是12小时
        举例：
            1、（HOUR, 0）表示12点，（HOUR, 6）表示18点，（HOUR, -6）表示6点
            2、（HOUR_OF_DAY, 6）表示6点，（HOUR_OF_DAY, 18）表示18点
        current.set(Calendar.HOUR, 0);
*/
        current.set(Calendar.HOUR_OF_DAY, 0);
        current.set(Calendar.MINUTE, 0);
        current.set(Calendar.SECOND, 0);
        current.set(Calendar.MILLISECOND, 0);
        System.out.println("Calendar Date After Set:\t\t\t" + current.getTime());
        //增加7天时间
        current.add(Calendar.DATE, 7);
        System.out.println("Calendar Date After Add 7 Days:\t\t" + current.getTime());
        //减少7天的时间
        current.add(Calendar.DATE, -7);
        System.out.println("Calendar Date After Add -7 Days:\t" + current.getTime());
        System.out.println(current.getTime().getTime());
        System.out.println(current.getTimeInMillis());
    }

    public static long dateToLong(Date date) {
        long result = date.getTime();
        return result;
    }

    public static Date longToDate(long date) {
        Date result = new Date(date);
        return result;
    }

    private static long getRecentTime(int days) {
        Calendar current = Calendar.getInstance();
        current.set(Calendar.DATE, current.get(Calendar.DATE) - days);
        current.set(Calendar.HOUR_OF_DAY, 0);
        current.set(Calendar.MINUTE, 0);
        current.set(Calendar.SECOND, 0);
        current.set(Calendar.MILLISECOND, 0);
        return current.getTimeInMillis();
    }

    public static void main(String[] args) throws ParseException {
        Calendar current = Calendar.getInstance();
        long a = current.getTimeInMillis();
        System.out.println(a);
        current.set(Calendar.DATE, current.get(Calendar.DATE) - 6);
        long b = current.getTimeInMillis();
        System.out.println(b);
        System.out.println(a-b);

        System.out.println(getRecentTime(4));
        System.out.println(new Date(getRecentTime(4)));

//        dateAndStampDemo();
//        calendarDemo();
//
//        System.out.println(DATETIME_FORMAT.format(longToDate(1477972867089L)));
//        System.out.println(dateToLong(DATE_FORMAT.parse("2017-02-15")));
//        System.out.println(dateToLong(DATE_FORMAT.parse("2017-02-16")));
//
//        for (int i = -1; i < 7; i++) {
//            System.out.print(DATETIME_FORMAT.format(longToDate(getRecentTime(i))));
//            System.out.print("\t");
//            System.out.println(getRecentTime(i));
//        }

//        System.out.println(new Date());
//        System.out.println("Date:\t" + new Date().getTime());
//
//        long timeNow = System.currentTimeMillis();
//        System.out.println("Current:\t" + timeNow);
//
//        System.out.println("Timestamp:\t" + new Timestamp(timeNow).getTime());
//        System.out.println(new Timestamp(timeNow));
    }
}
