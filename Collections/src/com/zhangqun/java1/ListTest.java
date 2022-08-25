package com.zhangqun.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**   1.List接口框架
 *    /-----Collection接口：单列集合，用来存储一个一个对象
 *         /----List接口：存储有序的、可重复的数据   --> “动态”数组，替换原有的数组
 *                /----ArrayList：作为List接口的主要实现类；线程不安全的，执行效率高；底层使用Object[] elementData存储
 *                /----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList效率高；底层使用双向链表存储
 *                /----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 *    2.ArrayList的源码分析：
 *    2.1 jdk 7 情况下
 *       ArrayList list = new ArrayList();//底层创建了长度为10的Object[]数组elementData
 *       arr.add(123);//elementData[0] = new Integer(123);
 *       ...
 *       list.add(456);//如果此次的添加导致底层elementData数组容量不够，则扩容
 *       默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中
 *
 *       结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *    2.2 jdk 8 中ArrayList的变化
 *      ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *      list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数组123添加到elementData[0]
 *      ...
 *      后续的添加扩容操作与 jdk 7无异
 *
 *    2.3结论：jdk 7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk 8 中的对象的创建
 *      类似于单例的懒汉式，延迟了数组的创建，节省了内存。
 *
 *    3.LinkedList的源码分析
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first 和 last 属性，默认值为null
 *      list.add(123);//将123封装到 Node中，创建了Node对象。
 *
 *      其中，Node定义为：体现了LinkedList双向链表的性质
 *       private static class Node<E> {
 *          E item;
 *          Node<E> next;
 *          Node<E> prev;
 *
 *          Node(Node<E> prev, E element, Node<E> next) {
 *              this.item = element;
 *              this.next = next;
 *              this.prev = prev;
 *          }
 *      }
 *
 *     4.Vector的源码分析：jdk 7 和 jdk 8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *          在扩容方面，默认扩容为原来数组长度的2倍
 *
 *
 *     5.List接口中的常用方法
 *
 *
 *    面试题：ArrayList、LinkedList、Vector三者的异同？
 *    同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *    不同：见上
 *
 *
 * @author zhangqun
 * @create 2021-08-17 16:41
 */
public class ListTest {
    @Test
    public void test2(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String ("Tom"));
        list.add(new Person("zhangqun",22));
        list.add(123);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，则返回-1
        System.out.println(list.indexOf("Tom"));

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(123));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = list.remove(4);
        System.out.println(remove);

        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(0,"goushi");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合（左闭右开）
        System.out.println(list.subList(0, 2));


    }
    /*
     void add(int index, Object ele):在index位置插入ele元素
     boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
     Object get(int index):获取指定index位置的元素
     int indexOf(Object obj):返回obj在集合中首次出现的位置
     int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     Object remove(int index):移除指定index位置的元素，并返回此元素
     Object set(int index, Object ele):设置指定index位置的元素为ele
     List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合


     总结：常用方法
     增：add( Object ele)
     删：remove(int index)/remove(Object obj)
     改：set(int index, Object ele)
     查：get(int index)
     插： add(int index, Object ele)
     长度：size()
     遍历：①Iterator迭代器
           ②增强for循环
           ③普通for循环


     */

    @Test
    public void test3(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String ("Tom"));
        list.add(new Person("zhangqun",22));


// 将list输出，三种方式，但是目前来说经常用的就是迭代器iterator
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }

        for(Object o : list){
            System.out.println(o);
        }
    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(new String ("Tom"));
        list.add(new Person("zhangqun",22));

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List integers = Arrays.asList(1, 23, 4);
        list.addAll(integers);
        System.out.println(list.size());

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));
    }
}
