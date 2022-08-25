package com.zhangqun.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/** 一、说明：java中的对象，正常情况下，只能进行： == 或 !=。不能使用 > 或 < 的
 *           但是在开发场景中，我们需要对多个对象排序，言外之意，就需要比较对象的大小。
 *           如何实现？就需要实现两个接口中的任何一个：Comparable 或 Comparator
 *
 *  二、Comparable接口与Comparator的使用对比：
 *      Comparable接口的方式一但一定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *      Comparator接口属于临时性的比较。
 *
 *
 * @author zhangqun
 * @create 2021-08-07 22:12
 */
public class CompareTest {
    /*
    Comparable接口使用的举例：自然排序
    1.像String、包装类等实现了Comparable接口、重写了compareTo(obj),给出了比较两个对象大小方式
    2.像String、包装类重写了compareTo(obj)以后，进行从小到达的排列
    3.重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数；
        如果当前对象this小于形参对象obj，则返回负整数；
        如果当前对象this等于形参对象obj，则返回零。
    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写CompareTo(obj)
        在CompareTo(obj)中指明如何排序
     */
    @Test
    public void test1(){
        String[] str = new String[]{"AA","CC","MM","GG","JJ","DD","KK"};

        Arrays.sort(str);

        System.out.println(Arrays.toString(str));

    }
    @Test
    public void test2(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("LenovoMouse",38);
        goods[1] = new Goods("DELLMouse",60);
        goods[2] = new Goods("hpMouse",40);
        goods[3] = new Goods("xiaomiMouse",24);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));


    }
    /*
    Comparator接口的使用：定制排序
    1.背景：当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
           或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
           么可以考虑使用 Comparator 的对象来排序
    2.重写CompareTo(Object o1,Object o2),比较o1，o2的大小：
        如果返回正整数，则表示o1大于o2；
        如果返回零，则表示相等；
        如果返回负整数，则表示o1小于o2。
    3.
    4.
     */
    @Test
    public void test3() {
        String[] str1 = new String[]{"AA", "BB", "GG", "OO", "PP", "VV"};

        Arrays.sort(str1, new Comparator(){
            //按照大到小的方式排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }

                throw new RuntimeException("输入类型不一致！");
            }
        });
        System.out.println(Arrays.toString(str1));
    }
    @Test
    public void test4(){
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("LenovoMouse",38);
        goods[1] = new Goods("LenovoMouse",50);
        goods[3] = new Goods("DELLMouse",60);
        goods[2] = new Goods("hpMouse",40);
        goods[4] = new Goods("xiaomiMouse",24);

        Arrays.sort(goods, new Comparator() {
            //指明商品比较大小的方式，按照产品名称从低到高排列，再按照价格由高到低排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入类型不一致！！");
            }

        });
        System.out.println(Arrays.toString(goods));
    }
}