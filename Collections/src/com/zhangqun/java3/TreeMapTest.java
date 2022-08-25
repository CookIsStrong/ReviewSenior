package com.zhangqun.java3;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangqun
 * @create 2021-08-25 20:33
 */
public class TreeMapTest {
    /*
    向TreeMap中添加key-value,要求key必须是由同一类创建的对象
    因为要按照key进行排序：自然排序、定制排序
     */
    //自然排序
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        User user = new User("Tom", 23);
        User user1 = new User("Jerry", 23);
        User user2 = new User("Zhangqun", 22);
        User user3 = new User("Bob", 23);
        User user4 = new User("Rose", 28);

        treeMap.put(user,14);
        treeMap.put(user1,12);
        treeMap.put(user2,17);
        treeMap.put(user3,24);
        treeMap.put(user4,23);

        //方式一：
//        Set set = treeMap.keySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            Object key = iterator.next();
//            Object value = treeMap.get(key);
//            System.out.println(key+"=========="+value);
//        }
        //方式二：
        Set entrySet = treeMap.entrySet();
        System.out.println(entrySet);
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-------->" + entry.getValue());
//            Map.Entry entry = (Map.Entry) obj;
//            System.out.println(entry.getKey()+"------>"+entry.getValue());
        }

    }
    //定制排序
    @Test
    public void test2(){
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }
                throw new RuntimeException("输入的类型不一致！");
            }
        });
        User user = new User("Tom", 23);
        User user1 = new User("Jerry", 23);
        User user2 = new User("Zhangqun", 22);
        User user3 = new User("Bob", 23);
        User user4 = new User("Rose", 28);

        treeMap.put(user,14);
        treeMap.put(user1,12);
        treeMap.put(user2,17);
        treeMap.put(user3,24);
        treeMap.put(user4,23);

        Set entrySet = treeMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"------>"+entry.getValue());
        }
    }
}
