package com.zhangqun.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zhangqun
 * @create 2021-08-22 20:57
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序（实现Comparable接口）和 定制排序（Comparator）

    3.自然排序中，比较两个是否相同的标准compareTo()返回0，不再是equals()。
    4.定制排序中，比较两个是否相同的标准compare()返回0，不再是equals()。


     */

    //自然排序
    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();

        //失败：不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add(new User("Tom",22));

        //举例一：
//        treeSet.add(23);
//        treeSet.add(75);
//        treeSet.add(908);
//        treeSet.add(-432);
//        treeSet.add(12);

        //举例二：
        treeSet.add(new User("Tom",22));
        treeSet.add(new User("Folk",43));
        treeSet.add(new User("Jerry",21));
        treeSet.add(new User("Alice",65));
        treeSet.add(new User("Bob",13));
        treeSet.add(new User("Bob",43));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o1;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("输入的类型不匹配");
                }
            }
        };

        TreeSet treeSet = new TreeSet(com);

        treeSet.add(new User("Folk",43));
        treeSet.add(new User("Jerry",21));
        treeSet.add(new User("Alice",65));
        treeSet.add(new User("Bob",13));
        treeSet.add(new User("Bob",43));

        Iterator iterator = treeSet.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
