package com.zhangqun.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**  如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 *
 *  1.关于自定义泛型类、泛型接口：
 *
 * @author zhangqun
 * @create 2021-08-26 20:20
 */
public class GenericTest1 {
    //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
    //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
    @Test
    public void test1(){
        Order order = new Order();
        order.setOrderId(1342);
        order.setOrderId("Tom");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("Tom",13,"Bob");
        order1.setOrderId("zhangqun");
        System.out.println(order1.getOrderT());
    }
    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderId(2342);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderId("Bob");
    }
    @Test
    public void test3(){


        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
//        list2 = list1;

        Person person1 = null;
        Person person2 = null;
        person1 = person2;

    }
    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] integer = new Integer[]{1,2,34,4,5};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(integer);

        System.out.println(list);
    }
}
