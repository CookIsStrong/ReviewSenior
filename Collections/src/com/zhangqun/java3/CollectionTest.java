package com.zhangqun.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  Collections：操作Collection、Map工具类
 *
 *  面试题：Collection 和 Collections的区别？
 *
 * @author zhangqun
 * @create 2021-08-25 21:55
 */
public class CollectionTest {
    /*
    排序操作：（均为static方法）
        reverse(List)：反转 List 中元素的顺序
        shuffle(List)：对 List 集合元素进行随机排序
        sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
    查找、替换
        Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        Object min(Collection)
        Object min(Collection，Comparator)
        int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        void copy(List dest,List src)：将src中的内容复制到dest中
        boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值

     */
    @Test
    public void test2(){
        List arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add(0);
        arrayList.add(132);
        arrayList.add(-123);

        //错误的，会报异常
//        Collections.copy(desc,arrayList);
        //正确的：
        List desc =Arrays.asList(new Object[arrayList.size()]);
        System.out.println(desc.size());
        Collections.copy(desc,arrayList);
        System.out.println(desc);


        /*
        Collections类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合
        包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
        */
        List list = Collections.synchronizedList(arrayList);
        System.out.println(list);

    }

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add(0);
        arrayList.add(132);
        arrayList.add(-123);

        System.out.println(arrayList);

        //reverse(List):
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //shuffle(List)  使用默认随机源对列表进行置换，所有置换发生的可能性都是大致相等的。
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //sort(List)
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //swap(List，int， int)
        Collections.swap(arrayList,1,2);
        System.out.println(arrayList);
        //frequency(Collection，Object)
        int frequency = Collections.frequency(arrayList, 132);
        System.out.println(frequency);


    }
}
