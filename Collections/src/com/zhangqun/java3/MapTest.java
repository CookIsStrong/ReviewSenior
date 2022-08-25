package com.zhangqun.java3;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map结构的框架
 * /----Map：双列数据，存储key-value对的数据
 *      /----HashMap:作为Map的主要实现类；线程不安全的，效率高；可以存储 null的key和value
 *           /----LinkedHashMap:保证在遍历 Map元素时，可以按照添加的元素遍历。
 *                      原因：在原有HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap
 *      /----TreeMap：保证按照添加的key-value对进行排序，实现循环遍历。此时考虑底层自然排序或者定制排序
 *                    底层使用红黑树
 *      /----Hashtable:作为古老的实现类；线程安全的，效率低；不可以存储 null的key和value
 *           /----Properties:常用来处理配置文件。key 和 value 都是String类型
 *
 *
 *      HashMap底层结构：数组 + 链表 （jdk 7）
 *                      数组 + 链表 + 红黑树 （jdk 8）
 *
 *
 *  面试题：
 *  1.HashMap 的底层实现原理？
 *  2.HashMap 和Hashtable 的异同？
 *  3.CurrentHashMap 与Hashtable 的异同？
 *
 *
 *
 *
 *  二、Map结构的理解
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key --->key所在的类要重写equals()和 hashCode() （以HashMap为例）
 *      Map中的value：无序的、不可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象。
 *      Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *
 *  三、HashMap 的底层实现原理？以jdk 7为例说明：
 *      HashMap map = new HashMap();
 *      在实例化以后，底层创建了一个长度为16的一维数组 Entry[] table;
 *      。。。可能已经执行多次put。。。
 *      map.put(key1,value1);
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值通过某种算法计算以后，得到在Entry数组中存放的位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。---->情况1
 *      如果此位置上的数组不为空，（意味着存在一个或者多个数据（以链表形式存在）），比较key1和已经存在的一个或者多个数据
 *      的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。---->情况2
 *          如果key1的哈希值和已经存在的某一个数据的哈希值相同，继续比较：调用key1所在类的key1.equals(key2)
 *                如果equals()返回false：此时key1-value1添加成功；---->情况3
 *                如果equals()返回true：使用value1替换value2。
 *
 *          补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的形式存储。
 *
 *          在不断添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的两倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *      1.new HashMap():底层没有创建一个长度为16的数组；
 *      2.jdk 8底层的数组是 Node[],而非是 Entry[]
 *      3.首次调用put()时，底层创建长度为16的数组
 *      4.jdk7底层结构只有：数组 + 链表。jdk 8中底层结构：数组 + 链表 + 红黑树。
 *      当数组的某一个索引位置上的元素以链表的形式存在的数据个数 > 8 且当前数组的长度 > 64时
 *      此时此索引位置上的所有的数据改为使用红黑树存储。
 *
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值，=容量*填充因子：16 X 0.75 = 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量：64
 *
 *   四、LinkedHashMap的底层实现原理？
 *
 *   五、Map中定义的方法：
 *    添加、删除、修改操作：
 *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *      void putAll(Map m):将m中的所有key-value对存放到当前map中
 *      Object remove(Object key)：移除指定key的key-value对，并返回value
 *      void clear()：清空当前map中的所有数据
 *    元素查询的操作：
 *      Object get(Object key)：获取指定key对应的value
 *      boolean containsKey(Object key)：是否包含指定的key
 *      boolean containsValue(Object value)：是否包含指定的value
 *      int size()：返回map中key-value对的个数
 *      boolean isEmpty()：判断当前map是否为空
 *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *   元视图操作的方法：
 *      Set keySet()：返回所有key构成的Set集合
 *      Collection values()：返回所有value构成的Collection集合
 *      Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 *   总结：常用方法：
 *   增加：put(Object key , Object value)
 *   删除：remove(Object key )
 *   修改：put(Object key , Object value)
 *   查询：get(Object key)
 *   长度：size()
 *   遍历：keySet() / values() / entrySet()
 *
 *
 *
 * @author zhangqun
 * @create 2021-08-22 22:07
 */
public class MapTest {

    /*
     元视图操作的方法：
       Set keySet()：返回所有key构成的Set集合
       Collection values()：返回所有value构成的Collection集合
       Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5(){
        HashMap hashMap = new HashMap();

        hashMap.put("sgd",1423);
        hashMap.put("agfds",1432);
        hashMap.put("afsdhf",15234);
        hashMap.put("aa",14321);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = hashMap.values();
        for (Object object : values){
            System.out.println(object);
        }

        //遍历所有的key-value
        //方式一：entrySet()
        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object next = iterator1.next();
            Map.Entry next1 = (Map.Entry) next;
            System.out.println(next1.getKey()+"--------->"+next1.getValue());
        }
        //方式二：
        Set set2 = hashMap.keySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()){
            Object next = iterator2.next();//得到的是所有的key
            Object o = hashMap.get(next);//得到的是key所对应的value
            System.out.println(next+"==========="+o);
        }
    }

    /*
    元素查询的操作：
       Object get(Object key)：获取指定key对应的value
       boolean containsKey(Object key)：是否包含指定的key
       boolean containsValue(Object value)：是否包含指定的value
       int size()：返回map中key-value对的个数
       boolean isEmpty()：判断当前map是否为空
       boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        HashMap hashMap = new HashMap();
        HashMap hashMap1 = new HashMap();

        hashMap.put("sgd",1423);
        hashMap.put("agfds",1432);
        hashMap.put("afsdhf",15234);
        hashMap.put("aa",14321);
        System.out.println(hashMap);

        //get(Object key)
        System.out.println(hashMap.get("aa"));

        //containsKey(Object key)
        System.out.println(hashMap.containsKey("sgd"));

        //containsValue(Object value)
        System.out.println(hashMap.containsValue(1432));

        //size()
        System.out.println(hashMap.size());

        //isEmpty()
//        hashMap.clear();
//        System.out.println(hashMap.isEmpty());

        //equals(Object obj)
        System.out.println(hashMap.equals(hashMap1));

    }


    /*
    添加、删除、修改操作：
      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
      void putAll(Map m):将m中的所有key-value对存放到当前map中
      Object remove(Object key)：移除指定key的key-value对，并返回value
     */
    @Test
    public void test3(){
        HashMap hashMap = new HashMap();

        //添加
        hashMap.put("sgd",1423);
        hashMap.put("agfds",1432);
        hashMap.put("afsdhf",15234);
        hashMap.put("aa",14321);
        //修改
        hashMap.put("aa",1234);
        System.out.println(hashMap);

        HashMap map1 = new HashMap();
        map1.put("afasd",14);
        map1.put("hsg",142);
        hashMap.putAll(map1);
        System.out.println(hashMap);


        //remove(Object key)
        Object hsg = hashMap.remove("hsg");
        System.out.println(hsg);
        System.out.println(hashMap);

        //clear()
        hashMap.clear();//与map = null不同
        System.out.println(hashMap.size());
        System.out.println(hashMap);

    }

    @Test
    public void test2(){
        HashMap map = new HashMap();
        map.put(132,"asdfs");
        map.put(423,"sfas");
        map.put(635,"ewtr");
        System.out.println(map);
    }

    @Test
    public void test1(){
        HashMap hashMap = new HashMap();

        hashMap.put(null,null);


    }
}
