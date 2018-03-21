package com.iterror.prediction.common.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    private static final String DEFAULT_DATE_FORMAT     = "yyyy/MM/dd/";

    // yyyy-MM-dd HH:mm:ss
    public static final String  DEFAULT_DATE_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";
    
    //HH:mm:ss
    public static final String DEFAULT_DATE_FORMAT_HH_MM_SS = "HHmmss";
    
    public static final String  YYYY_MM_DD_ALL = "yyyyMMdd";

    public static final String  YYYYMM = "yyyyMM";
    // yyyy-MM-dd HH:mm
    public static final String  DEFAULT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    
    //HHmm
    public static final String  DEFAULT_DATE_FORMAT_HHMM = "HHmm";

    // yyyy-MM-dd
    public static final String  DEFAULT_DATE_FORMAT_MIN = "yyyy-MM-dd";
    public static final String  DEFAULT_YYYY_MM_DD_HH = "yyyy-MM-dd-HH";
    
    // yyyyMM
    public static final String  DEFAULT_DATE_YEAR_MONTH = "yyyyMM";
    public static final String  DEFAULT_DATE_Y_M_ = "yyyy年MM月";
    public static final String  DEFAULT_DATE_YEAR = "yyyy";
    
    public static final int MONTH_DAY  = 30;//一个月30

    private static int          SEC_EVERYDAY            = 86400;
    private static long             cacheNow      = System.currentTimeMillis();
    public static void freshCacheNow() {
        cacheNow = System.currentTimeMillis();
    }

    public static long getCacheNow() {
        return cacheNow;
    }

    
    /**
     * 返回 20110605 类似的整数
     * 
     * @param date
     * @return
     */
    public static int getDayInt(Date date) {
        if(date==null){
            date = new Date();
        }
        String s = toLocaleString(date, "yyyyMMdd");
        return Integer.parseInt(s);
    }
    
    /**
     * 返回 20110605 类似的整数
     * 
     * @param date
     * @return
     */
    public static long getDayMinuteInt(Date date) {
        if(date == null){
            date = new Date();
        }
        String s = toLocaleString(date, "yyyyMMddHHmm");
        return Long.parseLong(s);
    }
    /**
     * 返回 2011060502 类似的整数
     *
     * @param date
     * @return
     */
    public static long getDayHourInt(Date date) {
        if(date == null){
            date = new Date();
        }
        String s = toLocaleString(date, "yyyyMMddHH");
        return Long.parseLong(s);
    }
    /**
     * 返回 201106 类似的整数
     * 
     * @param date
     * @return
     */
    public static int getMonthInt(Date date) {
        if(date==null){
            date = new Date();
        }
        String s = toLocaleString(date, "yyyyMM");
        return Integer.parseInt(s);
    }

    /**
     * 读取当月的第多少天
     * @param date
     * @return
     */
    public static int getMonthDay(Date date){
        if(date==null){
            date = new Date();
        }
        String s = toLocaleString(date, "dd");
        return Integer.parseInt(s);
    }

    /**
     * 读取当月的第多少天
     * @param date
     * @return
     */
    public static int getMonthMaxDay(Date date){
        if(date==null){
            date = new Date();
        }
        date = getMonthLastDayTime(date);
        String s = toLocaleString(date, "dd");
        return Integer.parseInt(s);
    }
    
    /**
     * 把日期型转换成字符串形式。
     * 
     * @param date 日期
     * @param dateFormat 日期格式，例如"yyyy/MM/dd"、"yyyy年MM月dd"
     * @return 日期字符串
     */
    public static String toLocaleString(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }

        if (StringUtils.isBlank(dateFormat)) {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
        }

        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 把日期型转换成"yyyy/MM/dd/"字符串形式。
     * 
     * @param date
     * @return 日期字符串
     */
    public static String toLocaleString(Date date) {
        return toLocaleString(date, null);
    }

    /**
     * 获得sysdate+hours后的时间
     * 
     * @param hours 提前或者推后的时间
     * @return sysdate+hours后的时间
     */
    public static Date getSysDate(int hours) {
        Calendar time = Calendar.getInstance();

        time.add(Calendar.HOUR, hours);

        return time.getTime();
    }

    public static int getDateHour() {
        Calendar time = Calendar.getInstance();
        return time.get(Calendar.HOUR_OF_DAY);
    }

    public static int getDateHour(Date date) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.HOUR_OF_DAY);
    }
    
    /**
     * 返回分钟
     * @return
     */
    public static int getMinute() {
        Calendar time = Calendar.getInstance();
        return time.get(Calendar.MINUTE);
    }
    /**
     * 返回分钟
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.MINUTE);
    }

    /**
     * 方法说明:天数差
     * 
     * @param firstDate
     * @param lastDate
     */
    public static int getTimeIntervalDays(Date firstDate, Date lastDate) {
        if(null == firstDate || null == lastDate){
            return 0;
        }
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long daysd = intervals / (24 * 60 * 60 * 1000);

            return new Long(daysd).intValue();
        }

        return 0;
    }
    /**
     * 方法说明:秒钟差
     * 
     * @param firstDate
     * @param lastDate
     */
    public static int getTimeIntervalSeconds(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);
        if (intervals > 0) {
            return (int)intervals/1000;
        }
        return 0;
    }
    /**
     * 读取当前时间的开始时间
     * 
     * @param time
     * @return
     */
    public static Date getDateStartTime(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 读取当前时间的结束时间
     * 
     * @param time
     * @return
     */
    public static Date getDateEndTime(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 方法说明:小时差
     * 
     * @param firstDate
     * @param lastDate
     */
    public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long longHours = (intervals / (60 * 60 * 1000)) % 24;

            return new Long(longHours).intValue();
        }

        return 0;
    }

    /**
     * 方法说明:分钟差
     * 
     * @param firstDate
     * @param lastDate
     */
    public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long longMins = intervals / (60 * 1000);

            return new Long(longMins).intValue();
        }

        return 0;
    }

    /**
     * 秒数差
     * 
     * @param startDate
     * @return
     */
    public static int calLastedTime(Date startDate) {
        long b = new Date().getTime();
        long a = startDate.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }

    /**
     * 方法说明:parse date
     * 
     * @param date
     * @param dateformat
     */
    public static Date parseDate(String date, String dateformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);

        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    
    public static int getYear(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        return year1;
    }
    
    public static int getMonth(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int month = c1.get(Calendar.MONTH);
        return month;
    }
    
    public static int getYear(Date start, Date end) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(start);
        c2.setTime(end);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        return year2 - year1;
    }

    /**
     * 比较日期是否大于当前日期
     */
    public static boolean afterNow(Date date) {
        if (date == null) {
            return false;
        }

        Calendar nowCar = Calendar.getInstance();
        Calendar car = Calendar.getInstance();

        car.setTime(date);

        return car.after(nowCar);
    }

    /*
     * 查看是否早几天
     */
    public static boolean afterDays(Date date, int day) {
        if (date == null) {
            return false;
        }

        Calendar levelDay = Calendar.getInstance();
        Calendar createDay = Calendar.getInstance();

        createDay.setTime(date);
        createDay.add(Calendar.DATE, day);

        if (createDay.after(levelDay)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 查看是否早几小时
     */
    public static boolean afterHours(Date date, int hours) {
        if (date == null) {
            return false;
        }

        Calendar levelDay = Calendar.getInstance();
        Calendar createDay = Calendar.getInstance();

        createDay.setTime(date);
        createDay.add(Calendar.HOUR, hours);

        if (createDay.after(levelDay)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取得系统当前日期
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * 返回多少时间的前的时间, seconds 可以是负的
     * 
     * @param when
     * @param seconds
     */
    public static Date addTime(Date when, int seconds) {
        Calendar c = Calendar.getInstance();

        c.setTime(when);
        c.add(Calendar.SECOND, seconds);

        return c.getTime();
    }

    /**
     * @param date
     * @param pattern "yyyy-MM-dd HH:mm:ss.SSS"
     * @return
     */
    public static String dateToStr(Date date, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        DateFormat ymdhmsFormat = new SimpleDateFormat(pattern);

        return ymdhmsFormat.format(date);
    }

    /**
     * @param str
     * @param pattern "yyyy-MM-dd HH:mm:ss.SSS"
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        DateFormat ymdhmsFormat = new SimpleDateFormat(pattern);
        try {
            return ymdhmsFormat.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getFilterLoveDate() {
        return DateUtil.strToDate("2014-09-13 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getFilterUserInfoDate() {
        return DateUtil.strToDate("2014-12-15 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获得当天日期
     * 
     * @date 2009-2-20
     */
    public static Date getToday() {
        Calendar ca = Calendar.getInstance();
        return ca.getTime();
    }

    /**
     * 获得当天最后的时间
     * 
     * @date 2009-2-20
     */
    public static Date getTodayEndTime() {
        Calendar ca = Calendar.getInstance();
        String todayStr = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
        todayStr = todayStr + " 23:59:59";
        return strToDate(todayStr, "yyyy-MM-dd hh:mm:ss");
    }

    /**
     * 获得当天最后的时间
     * 
     * @date 2009-2-20
     */
    public static Date getTodayStartTime() {
        Calendar ca = Calendar.getInstance();
        String todayStr = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
        todayStr = todayStr + " 00:00:00";
        return strToDate(todayStr, "yyyy-MM-dd hh:mm:ss");
    }

    /**
     * 获得当天零点的时间
     */
    public static Date getTodayZero() {
        Calendar ca = Calendar.getInstance();
        Calendar todayDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE), 0, 0, 0);
        return todayDate.getTime();
    }

    public static int get24Hour() {
        int hour = 0;
        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * @date 2009-2-20
     */
    public static Date mkDate(int year, int month, int date) {
        Calendar ca = Calendar.getInstance();
        ca.set(year, month - 1, date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.format(ca.getTime());
        return ca.getTime();
    }

    /**
     * 获取18年前的日期
     * 
     * @return
     */
    public static Date getEighthYearsAgo() {
        Calendar ca = Calendar.getInstance();
        Calendar agoDate = new GregorianCalendar(ca.get(Calendar.YEAR) - 18, ca.get(Calendar.MONTH), ca.get(Calendar.DATE), 0, 0, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.format(agoDate.getTime());
        return agoDate.getTime();
    }

    /**
     * 获取180天后的日期
     * 
     * @return
     */
    public static Date getHalfYearLater() {
        Calendar ca = Calendar.getInstance();
        Calendar agoDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) + 180, 0, 0, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.format(agoDate.getTime());
        return agoDate.getTime();
    }

    /**
     * 获取365天后的日期
     * 
     * @return
     */
    public static Date getAYearLater() {
        Calendar ca = Calendar.getInstance();
        Calendar agoDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) + 365, 18, 0, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.format(agoDate.getTime());
        return agoDate.getTime();
    }

    /**
     * <li></li>
     * 
     * @param date1
     * @param date2 <li></li>
     */
    public static boolean compareTwoDate(Date date1, Date date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm");
        return simpleDateFormat.format(date1).equals(simpleDateFormat.format(date2));
    }
    public static boolean compareTwoDateSecond(Date date1, Date date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return simpleDateFormat.format(date1).equals(simpleDateFormat.format(date2));
    }

    /**
     * <li></li>
     * 
     * @param date1
     * @param date2 <li></li>
     */
    public static boolean compareTwoDateDay(Date date1, Date date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date1).equals(simpleDateFormat.format(date2));
    }

    public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }
    
    public static Date addHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }
    
    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 判断是否在今天
     * 
     * @param a
     * @return
     */
    public static boolean isToday(Date a) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE));
        Date today = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today).equals(format.format(a));
    }

    /**
     * 当前时间是否在区间时间内
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isDateIn(Date nowTime, Date startTime, Date endTime) {
        boolean inDate = false;
        long now = nowTime.getTime();
        if (now >= startTime.getTime() && now < endTime.getTime()) {
            inDate = true;
        }
        return inDate;
    }

    public static Date getTomorrowZero() {
        Calendar ca = Calendar.getInstance();
        Calendar todayDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) + 1, 0, 0, 0);
        return todayDate.getTime();
    }

    public static Date getTomorrowEighteen() {
        Calendar ca = Calendar.getInstance();
        Calendar tDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) + 1, 18, 0, 0);
        return tDate.getTime();
    }

    public static Date getYestodayZero() {
        Calendar ca = Calendar.getInstance();
        Calendar todayDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) - 1, 0, 0, 0);
        return todayDate.getTime();
    }

    public static Date getTwoDaysBeforeZero() {
        Calendar ca = Calendar.getInstance();
        Calendar todayDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) - 2, 0, 0, 0);
        return todayDate.getTime();
    }

    // 获取N天前的0点时间
    public static Date getDaysBeforeZero(int day) {
        Calendar ca = Calendar.getInstance();
        Calendar todayDate = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE) - day, 0, 0, 0);
        return todayDate.getTime();
    }

    public static boolean isYestoday(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        Date today = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today).equals(format.format(date));
    }

    /**
     * 当天剩余的秒数
     * 
     * @return
     */
    public static int getSecondRestOfToday() {
        Calendar c = Calendar.getInstance();
        return SEC_EVERYDAY - c.get(Calendar.HOUR_OF_DAY) * 60 * 60 - c.get(Calendar.MINUTE) * 60 - c.get(Calendar.SECOND);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getFormatTime((long) (1000 * 60 * 61 + 1000 * 38 + 1000 * 60 * 60 * 3)));

        System.out.println(DateUtil.dateToStr(new Date(), "HH:mm"));

        System.out.println(DateUtil.dateToStr(new Date(), "HH:mm"));

        Date start = DateUtil.getDateStartTime(new Date());
        Date end = DateUtil.getDateStartTime(new Date());

        compareTwoDateDay(new Date(), DateUtil.addHour(new Date(), 1));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date lastTime = getLastMonthTime();
        System.out.println(sdf.format(lastTime));
        
        Date startTime = getMonthFistDayTime(lastTime);
        System.out.println(sdf.format(startTime));
        Date endTime =getMonthLastDayTime(lastTime);
        System.out.println(sdf.format(endTime));
        Date preDate = getPreviousFistMonthDay();
        System.out.println(sdf.format(preDate));

        getWeek(new Date());

        getNextWeekday(new Date());
    }

    /**
     * 返回 yyyyMMddHHmmss 格式的long类型
     * 
     * @param date
     * @return
     */
    public static long getDaySecondLong(Date date) {
        String s = toLocaleString(date, "yyyyMMddHHmmss");
        return Long.parseLong(s);
    }
    
    /**
     * 取当前周的周一时间
     * @return
     */
    public static Date getFistWeekDay() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeek == -1) {
            dayOfWeek = 6;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, -1 * dayOfWeek);
        Date sundayDay = currentDate.getTime();
        return sundayDay;
    }
    
    /**
     * 取当某個時間的的周一时间
     * @return
     */
    public static Date getFistWeekDay(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeek == -1) {
            dayOfWeek = 6;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.add(GregorianCalendar.DATE, -1 * dayOfWeek);
        return currentDate.getTime();
    }

    
    /**
     * 取上周的周一时间
     * @return
     */
    public static Date getPreviousWeekday() {
        Date date = addDay(new Date(), -7);
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeek == -1) {
            dayOfWeek = 6;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.add(GregorianCalendar.DATE, -1 * dayOfWeek);
        return currentDate.getTime();
    }
    /**
     * 取某个日期的上周的周一时间
     * @return
     */
    public static Date getPreviousWeekday(Date d) {
        Date date = addDay(d, -7);
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeek == -1) {
            dayOfWeek = 6;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.add(GregorianCalendar.DATE, -1 * dayOfWeek);
        return currentDate.getTime();
    }
    /**
     * 取某个日期的下周的周一时间
     * @return
     */
    public static Date getNextWeekday(Date d) {
        Date date = addDay(d, 7);
        return getFirstDayOfWeek(date);
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 计算两个日期之间相差的小时数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int hourBetween(Date smdate, Date bdate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600);
        return Integer.parseInt(String.valueOf(between_days));
    }
    
    /**
     * 计算两个日期之间相差的分钟数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int minuteBetween(Date smdate, Date bdate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 60);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 取当上月的一号时间
     * @return
     */
    public static Date getPreviousFistMonthDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date day = cal.getTime();
        return day;
    }
    
    /**
     * 获取当前时间月份的第一天开始时间
     * @param date
     * @return
     */
    public static Date getMonthFistDayTime(Date date) {
        if(date==null){
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
    /**
     * 获取当前时间月份的最后一天结束时间
     * @param date
     * @return
     */
    public static Date getMonthLastDayTime(Date date) {
        if(date==null){
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 读取下个月的时间
     * @return
     */
    public static Date getNextMonthTime() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }
    
    /**
     * 读取上个月的时间
     * @return
     */
    public static Date getLastMonthTime() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 将 yyyy-MM String 类型的字符串转换成 yyyyMM的整形
     * @param month
     * @return
     */
    public static Integer strToIntMonth(String month) {
        if(StringUtils.isEmpty(month)) {
            return null;
        }
        String[] strings = month.split("-");
        String s = strings[0] + strings[1];
        return Integer.parseInt(s);
    }


    /**
     * 获取某个日期所在周的周一日期:  yyyyMMdd
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            c.add(Calendar.DATE, -1);
        }
        Calendar cf = Calendar.getInstance();
        cf.setTime(c.getTime());
        cf.set(Calendar.DAY_OF_WEEK, cf.getFirstDayOfWeek());
        cf.add(Calendar.DATE, 1);
        Date d = cf.getTime();
        return new Date(d.getYear(), d.getMonth(), d.getDate());
    }

    /**
     *  获取某个日期所在周的周日日期:  yyyyMMdd
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            c.add(Calendar.DATE, -1);
        }
        Calendar cf = Calendar.getInstance();
        cf.setTime(c.getTime());
        cf.set(Calendar.DAY_OF_WEEK, cf.getFirstDayOfWeek());
        cf.add(Calendar.DATE, 1);
        Calendar ce = Calendar.getInstance();
        ce.setTime(c.getTime());
        ce.set(Calendar.DAY_OF_WEEK, cf.getFirstDayOfWeek()+6);
        ce.add(Calendar.DATE, 1);
        Date d = ce.getTime();
        return new Date(d.getYear(), d.getMonth(), d.getDate());
    }

    /**
     * 获取当前日期的星期
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static String getTimeString(int value) {
        String sec = "";
        if (value <= 0) { // 1分钟
            sec = "1分钟";
        } else if (value > 0 && value < 60) { // 约X分钟
            sec = value + "分钟";
        } else if (value >= 60) {// X小时X分钟
            int hour = value / 60;
            if ((value % 60) == 0) {
                sec = hour + "小时";
            } else {
                sec = hour + "小时" + (value % 60) + "分钟";
            }
        }
        return sec;
    }


    /**
     * 将 Long 型的毫秒数转换成 HH:MM::SS形式的String
     */
    public static String getFormatTime(Long time){
        if (time == null || time < 1000) {
            return "00:00:00";
        }
        long seconds = time / 1000;
        long h = seconds / 3600;
        long m = (seconds % 3600) / 60;
        long s = (seconds % 3600) % 60;
        return String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    /**
     * 获取n天的秒数
     * @param days 天数
     * @return 秒数
     */
    public static int getDaysSeconds(int days) {
        return days * 24 * 60 * 60;
    }
}
