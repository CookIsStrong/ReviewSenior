package com.zhangqun.java1;


import org.junit.Test;

import java.util.Date;

/**
 * JDK8 之前时间和日期API的测试
 * @author zhangqun
 * @create 2021-08-03 15:24
 */
public class DateTimeTest {
    /*
    /----java.util.Date类
           |----java.sql.Date类

    1.两个构造器的使用
        >构造器一：Date():创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象

    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前date对象对应的毫秒数（时间戳）

    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转化为java.sql.Date对象


     */
    @Test
    public void test2(){
        //构造器一：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();//util中的Date()
        System.out.println("data1:"+date1);//同System.out.println(date1.toString)一致
        System.out.println("data1:"+date1.getTime());//得到的是毫秒数
        System.out.println("************************");

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1627980479735L);
        System.out.println("data2:"+date2.toString());
        System.out.println("data2:"+date2.getTime());
        System.out.println("********************");

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(334233432412L);
        System.out.println("data3:"+date3.toString());
        System.out.println("********************");

        //如何将java.util.Date对象转化为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(334233432412L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);
    }

    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        long start = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差，称为时间戳。
        for (int i =0; i < 1000; i++){
            System.out.println(i*i*i+ " ");
        }
        System.out.println("***********************");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    @Test
    public void test3(){
        int[] ints = new int[4];
        System.out.println(ints);

        String[] strings = {"a", "b", "c", "d"};
        System.out.println(strings);

        //对于char型数组,使用的sout下相比于其他不一样
        char[] chars = {'a', 'b', 'c', 'd'};
        System.out.println(chars);
    }

}
