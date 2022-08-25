package com.zhangqun.java3;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *
 *
 *
 * @author zhangqun
 * @create 2021-08-27 13:43
 */
public class GenericTest {
    /*
    1.泛型在继承方面的体现

      类A是类B的父类，G<A>和G<B>二者不具备子父类关系，二者是并列关系。

      补充：类A 是类B 的父类，A<G> B<G>

     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] obj1 = null;
        String[] str1 = null;
        obj1=str1;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2不具备子父类关系
        //编译不通过
//        list1 = list2;


    }
    public void show1(List<String> list){

    }
    public void show2(List<Object> list){

    }
    @Test
    public void test2(){
        AbstractList<String> list = null;
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

    }
    /*
    2.通配符的使用
      通配符：？

     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list3 = null;

        list3 = list1;
        list3 = list2;

        //编译通过的
//        print(list1);
//        print(list2);

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("AA");
        list4.add("BB");
        list4.add("CC");
        list3 = list4;
        //添加（写入）：对于List<?>就不能向其内部添加数据，除了null
//        list3.add("Tom");
        list3.add(null);
        //获取（读取）：是允许读取数据的，其类型为Object
        Object o = list3.get(0);
        System.out.println(o);

    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
    }

    /*
    3.有限制条件的通配符的使用

        ? extends A:
                 G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类

        ? super A:
                G<? super A>可以作为G<A>和G<B>的父类，其中B是A的父类

     */
     @Test
    public void test4(){
         List<Person> list1 = null;
         List<Person> list2 = null;

         List<Person> list3 = new ArrayList<>();
         List<Person> list4 = new ArrayList<>();
         List<Person> list5 = new ArrayList<>();

         list1 = list3;
         list1 = list4;
         //编译不通过
//         list1 = list5;

         //编译不通过
//         list2 = list3;
         list2 = list4;
         list2 = list5;

         //读取数据
         list1 = list3;
//         Person person = list1.get(0);
         //编译不通过
//         Student s = list1.get(0);

         list2 = list4;
         Object o = list2.get(0);
         //编译不通过
//         Person person1 = list2.get(2);

         //写入数据:
         //编译不通过
//         list1.add(new Student());

         //编译通过
         list2.add(new Student());
         list2.add(new Person());

     }
}
