package com.zhangqun.java1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String和其他结构之间的转换
 *
 * @author zhangqun
 * @create 2021-08-02 20:19
 */
public class StringTest1 {
    /*
    String、StringBuffer、StringBuilder之间的转换
    String --> StringBuffer、StringBuilder:调用StringBuffer、StringBuilder的构造器
    StringBuffer、StringBuilder --> String:①调用String的构造器；
                                           ②使用StringBuffer、StringBuilder的toString()

     */
    @Test
    public void test4(){
        String s1 = "abc";

        //调用StringBuffer、StringBuilder的构造器
        StringBuffer sb1 = new StringBuffer(s1);
        System.out.println(sb1);
        StringBuilder sb2 = new StringBuilder(s1);
        System.out.println(sb2);


        //调用String的toString()
        StringBuffer sb3 = new StringBuffer("abcdef");
        String sb4 = sb3.toString();
        System.out.println(sb4);
        StringBuilder sb5 = new StringBuilder("goushi");
        String sb6 = sb5.toString();
        System.out.println(sb6);


        //调用String的构造器
        String sb7 = new String(sb3);
        System.out.println(sb7);
        String sb8 = new String(sb5);
        System.out.println(sb8);

    }

    /*
    String 与 byte[]之间的转换
    编码：String --> byte[]:调用String的getBytes()
    解码：byte[] --> String:调用String的构造器


    编码：字符串 --> 字节（看得懂 --> 看不懂的二进制数据）
    解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 --> 看得懂）

    说明：解码时，要求解码使用的字符集应该和编码时使用的字符集一致，否则会出现乱码

     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc12345我爱你";
        System.out.println(s1);
        byte[] bytes =s1.getBytes();
        System.out.println(Arrays.toString(bytes));//使用默认的字符集，进行转换

        byte[] gbks = s1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("***********************");
        String string1 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(string1);

        String string2 = new String(gbks);
        System.out.println(string2);//出现乱码。原因：编码集和字符集字符集不一致

        String string3 = new String(gbks, "gbk");
        System.out.println(string3);//没有出现乱码。原因：编码集和字符集字符集一致

    }

    /*
    String 与 char[]之间的转换

    String --> char[]:调用String的toCharArray()
    char[] --> String:调用String的构造器

     */
    @Test
    public void test2() {
        String s1 = "abc123"; //题目：a21cb3
        char arr[] = s1.toCharArray();

        //增强for循环
        for(Object o: arr){
            System.out.println(o);
        }

        //普通for循环
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        char[] arr1 = new char[]{'a', 'b', 'c'};
        String s2 = new String(arr1);
        System.out.println(s2);

    }

    /*
    复习：
    String 与基本数据结构、包装类之间的转换。

    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)

     */
    @Test
    public void test1() {
        String str1 = "123";
//        int num = (int) str1;错误的

        float v = Float.parseFloat(str1);
        System.out.println(v);

        int num = Integer.parseInt(str1);
        System.out.println(num);

        String str2 = String.valueOf(num);
        System.out.println(str2);

        boolean b = true;
        String s = String.valueOf(b);
        System.out.println(s);
    }
}
