package com.zhangqun.java1;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @author zhangqun
 * @create 2021-08-02 23:19
 */
public class StringBufferBuilderTest {
    /*
    对比String、StringBuffer、StringBuilder三者的效率 的测试
     */
    @Test
    public void test3(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
    /*
    StringBuffer的常用方法：
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end)：删除指定位置的内容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把当前字符序列逆转

    public int indexOf(String str)
    public String substring(int start,int end)
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char ch)

    总结：
    增：append(xxx)
    删：delete(int start,int end)
    改：setCharAt(int n,char ch) /replace(int start, int end, String str)
    查：charAt(int n)
    插：insert(int offset, xxx)
    长度：length()
    遍历：for() + charAt() / toString()

     */
    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append("1");
        System.out.println(sb1);
//        sb1.delete(2,3);
//        sb1.replace(2,3,"goushi");
//        sb1.insert(2,"false");
        sb1.reverse();
        System.out.println(sb1);



    }

    /*
    String、StringBuilder、StringBuffer有何异同？
    String：不可变的字符序列；底层使用char[]存储
    StringBuffer：可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder：可变的字符序列；JDK5.0 新增的，线程不安全的，效率高；底层使用char[]存储


    源码分析：
    String str1 = new String();//char[] value = new char[0]
    String str1 = new String("abc");//char value = new char[]{'a','b','c'}

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
    System.out.println(sb2.length());//0
    sb1.append('a');//value[0]= 'a';
    sb1.append('b');//value[1]= 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];

    问题一：System.out.println(sb2.length());//3
    问题二：扩容问题：如果要添加的数据底层数组乘不下了，那就需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍 + 2,同时将原有数组的元素复制到新的数组中。

            开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity);
     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length());
    }
}
