package com.zhangqun.java2;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 * 1. System类中的currentTimeMillis()
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. calendar
 *
 * @author zhangqun
 * @create 2021-08-05 21:16
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期 Date类的格式化和解析

    1.两个操作：
      1.1格式化：日期 --> 字符串
      1.2解析：格式化的逆过程  字符串 --> 日期

    2.simpleDateFormat的实例化

     */
    @Test
    public void test() throws ParseException {
        //1.实例化SimpleDateFormat
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        //2.格式化： 日期 -->字符串
        Date date1 = new Date();
        System.out.println(date1);

//        String format1 = sdf1.format(date1);
        String format1 = sdf1.format(date1);
        System.out.println(format1);

        //3.解析：格式化的逆过程 字符串 --> 逆过程
        String str = "21-08-15 上午11:34";
        Date parse1 = sdf1.parse(str);
        Date parse2 = sdf1.parse(str);
        System.out.println(parse1);
        System.out.println(parse2);

        //************按照指定的方式格式化和解析：调用带参的构造器****************
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh.mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = sdf2.format(date1);
        System.out.println(format2);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现），否则，抛异常
        Date date2 = sdf2.parse("2021-08-05 10:17:16");
        System.out.println(date2);
    }
    /*
    Calendar日历类（抽象类）的使用
     */
    @Test
    public void test3(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）对象
        //方式二：调用其静态方法getInstance()
        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.getClass());

        //2.常用方法

        //get()
        int days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));

        //set()
        instance.set(Calendar.DAY_OF_MONTH,22);
        days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        instance.add(Calendar.DAY_OF_MONTH,2);
        days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 --> Date
        Date date = instance.getTime();
        System.out.println(date);

        //setTime():Date --> 日历类
        Date date1 = new Date();
        instance.setTime(date1);
        days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
    /*
    练习一：字符串"2020-09-08"转换成java.sql.Date

     */
    @Test
    public void test1() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
//        System.out.println(date);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

    /*

    练习二："三天打鱼，两天晒网" 1990-01-01 xxxx-xx-xx 打鱼？晒网？
    举例：2020-09-08 ？总天数
    总天数 % 5 = 1，2，3 ：打鱼
    总天数 % 5 =0，4 ：晒网

    总天数的计算？
    方式一：利用毫秒数
    方式二：

     */
    @Test
    public void test2() {

    }
}