package com.zhangqun.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author zhangqun
 * @create 2022-08-16 10:09
 */
public class LambdaTest {


    @Test
    public void test1(){
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门！");
            }
        };

        run1.run();

        System.out.println("*******************");

        Runnable run2 = () -> {
            System.out.println("我爱安庆！！");
        };

        run2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i1, i2);
            }
        };

        int compare1 = com1.compare(51, 41);
        System.out.println(compare1);

        System.out.println("****************");
        //lambda表达式
        Comparator<Integer> com2 = (i1, i2) -> {
            return Integer.compare(i1, i2);
        };


        int compare2 = com2.compare(51, 41);
        System.out.println(compare2);

        System.out.println("***************");

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com3.compare(32, 54);
        System.out.println(compare3);
    }

}
