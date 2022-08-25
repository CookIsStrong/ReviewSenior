package com.zhangqun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**  java内置的四大核心函数式接口
 *
 *   消费式接口 Consume<T>      void accept(T t)
 *   供给型接口 Supplier<T>     T get()
 *   函数型接口 Function<T, R>  R apply(T t)
 *   断定型接口 Predicate<T>    boolean test(T t)
 * @author zhangqun
 * @create 2022-08-16 14:47
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，花了：" + aDouble);
            }
        });

        System.out.println("******************");


        happyTime(500, money -> System.out.println("学习太累了，去天上人间买了瓶矿泉水，花了：" + money));
    }


    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list =Arrays.asList("合肥","芜湖","安庆","蚌埠","淮南");
        List<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("庆");
            }
        });

        System.out.println(filterStr);

        System.out.println("*********************");

        System.out.println(filterString(list, s -> s.contains("庆")));

    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String>  filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
