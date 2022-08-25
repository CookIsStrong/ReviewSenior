package com.zhangqun.java1;

import org.junit.Test;

/**
 * String 的使用
 *
 * @author zhangqun
 * @create 2021-07-30 21:53
 */
public class StringTest {
    /*
    结论：
    1.常量与常量的拼接在常量池中，且常量池不会存在相同内容的常量
    2.只要其中有一个是变量，结果就在堆中。
    3.如果拼接的结果调用intern()方法，返回值就在常量池中

     */

    @Test
    public void test4(){
        String s1 ="javaeehadoop";
        String s2 ="javaee";
        String s3 =s2+"hadoop";
        System.out.println(s1==s3);//false

        // s4其实是:常量
        final String s4="javaee";

        String s5 =s4+"hadoop";
        System.out.println(s1==s5);//true
    }

    @Test
    public void test3() {
        String s1 = "JavaEE";
        String s2 = "Hadoop";

        String s3 = "JavaEEHadoop";
        String s4 = "JavaEE" + "Hadoop";
        String s5 = s1 + "Hadoop";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s5.intern();//手动入池操作
        String s9 = s6.intern();
        System.out.println(s8 == s9);//true
        System.out.println(s3 == s8);//true
    }

    /*
    String的实例化的方式：
    方式一：通过 字面量定义 的方式
    方式二：通过 new + 构造器 的方式

    面试题：String s=new String("abc");的方式在内存中创建了几个对象？
            真正的是两个：一个是堆空间中new的结构，另一个是char[]对应的常量池中的数据："abc"

     */
    @Test
    public void test2() {
        //通过字面量定义的方式：此时的s1和s2的数据JavaEE生命在方法区的字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";

        //通过new + 构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");
        System.out.println(s3.equals(s4));

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
        System.out.println("******************");
        Person person1 = new Person("Tom", 12);
        Person person2 = new Person("Tom", 12);
        System.out.println(person1.name.equals(person2.name));
        System.out.println(person1.name == person2.name);
        person1.name = "Jerry";
        System.out.println(person1.name);
        System.out.println(person2.name);


    }


    /*
     String：字符串，是用一对""引起来表示
     1.String声明为final的，不可被继承
     2.String实现了Serializable接口：表示字符串是支持序列化的
             实现了Comparable接口：表示String可以比较大小
     3.String：内部定义了final char[] value用于存储字符串数据
     4.String：代表了不可变的字符序列。简称：不可变性。
         体现：1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用的原有的value进行赋值。
              2.当对现有的字符串进行连接操作时，也需要重新指定内存区域，不能使用原有的value进行赋值
              3.当调用String的replace()修改指定的字符或字符串时，也需要重新指定内存区域赋值
     5.通过 字面量的方式（区别于new）给一个字符串赋值，此时的字符串声明在字符串常量池中。
     6.字符串常量池是不会存储相同内容的字符串的。
      */


    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("********************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println("********************");
        String s4 = "abc";
        String s5 = s4.replace("a", "m");
        System.out.println(s4);
        System.out.println(s5);
    }
}
