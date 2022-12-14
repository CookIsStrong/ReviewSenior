package com.zhangqun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *  一、集合框架的概述
 *
 *  1、集合、数组都是对多个数据进行存储操作的结构，简称java容器。
 *    说明：此时的存储，主要是指内存层面的存储，不涉及持久化的存储（.txt,.jpg,数据库中）
 *
 *  2.1 数组在存储多个数据方面的特点：
 *      >一但初始化以后，其长度就确定了。
 *      >数据一但定义好，其元素的类型也就确定了。比如String[] str,char[] ch
 *  2.2 数组在存储多个数据方面的缺点：
 *      >一但初始化以后，其长度就不可修改
 *      >数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 *      >获取数组中实际元素的个数要求，数组没有现成的属性或方法可用
 *      >数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 *  二、集合框架
 *        /-----Collection接口：单列集合，用来存储一个一个对象
 *            /----List接口：存储有序的、可重复的数据   --> “动态”数组
 *               /----ArrayList、LinkedList、Vector
 *            /----Set接口：存储无序的、不可重复的数据  --> “必修一集合”
 *               /----HashSet、LinkedHashSet、TreeSet
 *
 *       /-----Map接口：双列集合，用来存储一对（key - value）一对的数据    -->高中函数：y=f(x)
 *            /----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *  三、Collection接口中方法的使用：
 *
 *
 * @author zhangqun
 * @create 2021-08-09 22:00
 */
public class CollectionTest {
    @Test
    public void test() throws Exception {
        Collection coll = new ArrayList();

        //add(Object e)
        coll.add("aa");
        coll.add("bb");
        coll.add(13241);
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add("fdasas");
        coll1.add(5453);
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        System.out.println(coll);

        //isEmpty():判断当前对象是否为空
        System.out.println(coll.isEmpty());
    }

}
