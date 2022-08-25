package com.zhangqun.java1;

import org.junit.Test;

import java.util.*;

/**
 *  泛型的使用:
 *  1.jdk 5.0 之后新增的特性
 *
 *  2.在集合中使用泛型
 *  总结：
 *  ①集合接口或集合类在jdk 5.0时都修改为带泛型的结构
 *  ②在实例化集合类时，可以指明具体的泛型类
 *  ③指明完以后，在集合类或接口中凡是定义类或是接口时，内部结构(方法、属性、构造器等)使用到类的泛型的位置，都指定为实例化时泛型的类型。
 *  比如：add(E e) --->实例化以后：add(Integer e)
 *  ④注意的点：泛型的类必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
 *  ⑤如果实例化时，没有指明泛型的类型。默认类型为：java.lang.Object类型
 *
 *  3.如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *
 *
 *
 * @author zhangqun
 * @create 2021-08-26 14:36
 */

public class GenericTest {

    //在集合中使用的泛型之前的情况
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();

        //需求：存放学生成绩
        arrayList.add(80);
        arrayList.add(78);
        arrayList.add(68);
        arrayList.add(85);

        //问题一：类型不安全
        arrayList.add("Tom");

        for (Object o : arrayList){
            //问题二：强转时，可能会出现 ClassCastException
//            int stuScore = (int) o;
//            System.out.println(stuScore);
        }
    }
    //在集合中使用的泛型的情况:以ArrayList
    @Test
    public void test2(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        //编译时，就会进行类型检查，保证数据的安全
        arrayList.add(80);
        arrayList.add(78);
        arrayList.add(68);
        arrayList.add(85);

        //方式一：
        for (Integer score : arrayList){
            //避免了强转操作
            int stuscore = score;
            System.out.println(stuscore);
        }

        //方式二：
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            int stuscore = iterator.next();
            System.out.println(stuscore);
        }
    }

    //在集合中使用的泛型的情况:以ArrayList
    @Test
    public void test3(){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("AA",96);
        hashMap.put("BB",89);
        hashMap.put("CC",90);
        System.out.println(hashMap);

        //输出所有的key
        Set<String> strings = hashMap.keySet();
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //输出所有的value
        Collection<Integer> values = hashMap.values();
        System.out.println(values);

        //方式一：
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = entries.iterator();
        while(iterator2.hasNext()){
            Map.Entry<String, Integer> next = iterator2.next();
            String key = next.getKey();
            int value = next.getValue();
            System.out.println(key+"==============>"+value);

        }
    }
}




