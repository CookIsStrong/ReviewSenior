package com.zhangqun.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhangqun
 * @create 2021-08-17 14:20
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("zhangqun",35));
        coll.add(false);

        //for( 集合元素的类型   局部变量 : 集合对象 )
        for (Object obj : coll ){
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        for (int i : arr){
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
        String[] arr = new String[]{"aa","bb","cc"};

        //方式一：普通for赋值
//        for(int i = 0 ; i < arr.length ; i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for (String s : arr){
            s = "gg"; //改变不了原有list
        }

        for(int i = 0 ; i< arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
