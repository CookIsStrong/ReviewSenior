package com.zhangqun.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *  Collection接口中生命的方法的测试
 *
 *  结论：
 *  向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 *
 * @author zhangqun
 * @create 2021-08-15 9:56
 */
public class CollectionTest {

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);

        Person p = new Person("zhangsan",12);
        arrayList.add(p);

        arrayList.add(new String("Zhangqun"));
        arrayList.add(new Person("lisi",18));
        arrayList.add(false);

        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们判断时会调用obj对象所在类的equals()
        boolean contains = arrayList.contains(123);
        System.out.println(contains);
        System.out.println(arrayList.contains(new String("Zhangqun")));
//        System.out.println(arrayList.contains(p));
        System.out.println(arrayList.contains(new Person("zhangsan",12)));


        //2.containsAll(Collection coll1):判断形参coll1中的所有元素都是否存在于当前集合中。
        Collection list = Arrays.asList(123, 456);
        System.out.println(arrayList.containsAll(list));
    }
    @Test
    public void test2(){
        Collection arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(new String("Tom"));
        arrayList.add(new Person("zhangqun",35));
        arrayList.add(false);


        //3.remove(Object obj):当前集合中移除obj元素。
        arrayList.remove(1234);
        System.out.println(arrayList);
        boolean zhangqun = arrayList.remove(new Person("zhangqun", 35));
        System.out.println(zhangqun);

        System.out.println(arrayList);

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有元素。
        Collection coll1 = Arrays.asList(123, 456);
        arrayList.removeAll(coll1);
        System.out.println(arrayList);
    }
    @Test
    public void test3(){
        Collection arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(new String("Tom"));
        arrayList.add(new Person("zhangqun",35));
        arrayList.add(false);

//        //5.retainAll():交集：获取当前集合和coll1集合的交集，并返回当前集合。
//        Collection coll1 = Arrays.asList(123, 456,789);
//        boolean b = arrayList.retainAll(coll1);
//        System.out.println(b);
//        System.out.println(arrayList);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll1 = new ArrayList();

        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(new Person("zhangqun",35));
        coll1.add(false);

        System.out.println(arrayList.equals(coll1));
    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("zhangqun",35));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值。
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组： toArray():
        Object[] objects = coll.toArray();
        for (int i = 0; i< objects.length; i++){
            System.out.println(objects[i]);
        }

        //拓展：数组 ---> 集合 ：调用Array类的静态方法asList()
        List<String> objects1 = Arrays.asList(new String[]{"aa","bb","cc"});
        System.out.println(objects1);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());
        System.out.println(arr1);

        List arr2 = Arrays.asList(new Integer[]{123,45});
        System.out.println(arr2.size());
        System.out.println(arr2);

        //iterator():返回的是Iterator接口的实例，用于遍历集合元素。
    }
}
