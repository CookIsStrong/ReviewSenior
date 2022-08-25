package com.zhangqun.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqun
 * @create 2021-08-26 20:06
 */
public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用泛型
    T orderT;
    public Order(){

    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    public T getOrderT(){
        return orderT;
    }
    public void setOrderId(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" + "orderName='" + orderName + '\'' + ", orderId=" + orderId + ", orderT=" + orderT + '}';
    }

    //静态方法中不能使用泛型
//    public static void show(){
//        System.out.println(orderT);
//    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非实在实例化时确定。DAO
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }

}
