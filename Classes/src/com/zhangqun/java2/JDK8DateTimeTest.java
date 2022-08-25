package com.zhangqun.java2;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK 8 当中的日期时间API的测试
 *
 * @author zhangqun
 * @create 2021-08-06 16:48
 */
public class JDK8DateTimeTest {
    @Test
    public void test(){
        Date date = new Date(2021-1900,8-1,6);
        System.out.println(date);

    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime使用频率要高
        2.类似于Calendar

     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、时间+日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //Of()：设置指定的年、月、日、时、分、秒 没有偏移量
        LocalDateTime of1 = LocalDateTime.of(2021,8,7,15,33);
        System.out.println(of1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getDayOfYear());

        //体现不可变性
        LocalDate localdate1 = localDate.withDayOfMonth(10);
        System.out.println(localdate1);
        LocalDateTime localDateTime1 = localDateTime.withDayOfYear(180);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusMonths(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusMonths(5);
        System.out.println(localDateTime3);

    }
    /*
    Instant的使用
    类似于java.sql.Date类

     */
    @Test
    public void test2(){
        //now():获取的是本初子午线对应的标准时间
        Instant instance1 = Instant.now();
        System.out.println(instance1);//2021-08-07T08:59:26.184Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instance1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-08-07T16:59:26.184+08:00

        //toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数 -->类似于Date类中的getTime()
        long toEpochMilli = instance1.toEpochMilli();
        System.out.println(toEpochMilli);

        //ofEpochMilli(long time)；通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant = Instant.ofEpochMilli(3436234124123L);
        System.out.println(instant);

    }
    /*DateTimeFormatter:格式化或解析日期或时间
     类似于SimpleDateFormat

     */
    @Test
    public void test3(){
        //方式一： 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter datetimeformatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 --> 字符串
        LocalDateTime now = LocalDateTime.now();
        String format = datetimeformatter.format(now);
        System.out.println(now);
        System.out.println(format);

        //解析：字符串 --> 日期
        String str = "2021-08-07T21:09:15.182";
        TemporalAccessor parse = datetimeformatter.parse(str);
        System.out.println(parse);

        // 方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime()
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);//2021年8月7日 下午09时16分13秒  / 2021-8-7 21:16:39  /  21-8-7 下午9:17

        //本地相关的格式。如ofLocalizedDate()
        //FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDate
        LocalDate localdate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String format2 = dateTimeFormatter1.format(localdate);
        System.out.println(format2);//2021年8月7日 星期六  / 2021年8月7日  / 2021-8-7 / 21-8-7

        //重点 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format3 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format3);// 2021-08-07 09:42:57

        //解析
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2021-08-07 09:42:57");
        System.out.println(parse1);
    }
}
