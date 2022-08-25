package com.zhangqun.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  集合元素的遍历操作，使用迭代器 Iterator 接口
 *
 *   1.内部方法：hasNext() 和 next()
 *   2.集合对象每次调用iterator()都会得到一个全新的迭代器对象，默认游标都在第一个元素之前。
 *   3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 * @author zhangqun
 * @create 2021-08-15 17:17
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("zhangqun",35));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //方式二：不推荐
//        for (int i = 0 ; i < coll.size() ; i++){
//            System.out.println(iterator.next());
//        }
        //方式三：推荐
        //hasNext():判断是否还有下一个元素
        while(iterator.hasNext()){
            //next():①指针下移；②将下移以后集合上的元素返回
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("zhangqun",35));
        coll.add(false);


        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while(iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()都会得到一个全新的迭代器对象，默认游标都在第一个元素之前。
//        while(coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }

    }
    //测试Iterator中的remove()
    @Test
    public void test3(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("zhangqun",35));
        coll.add(false);

        //删除集合中的“Tom”
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            if ("Tom".equals(o)){
                iterator.remove();
            }
        }


        //遍历集合
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
