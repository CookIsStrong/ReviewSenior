package com.zhangqun.java1;

import org.junit.Test;

import java.util.Locale;


/**
 * @author zhangqun
 * @create 2021-07-31 19:36
 */
public class StringMethodTest {
    /*
    String replace(char oldChar, char newChar)：返回一个新的字符串，它是
        通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
    String replace(CharSequence target, CharSequence replacement)：使
        用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
    String replaceAll(String regex, String replacement) ： 使 用 给 定 的
        replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
    String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
        replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

    boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。

    String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
    String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
        字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

     */
    @Test
    public void test4(){
        String s1="helloworld";
        System.out.println(s1.replace('d','l'));
        System.out.println(s1);
        System.out.println(s1.replace("hello","gun"));
        System.out.println(s1);

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        String str1 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str1.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        String str2 = "hello|world|java";
        String[] strs = str2.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str3 = "hello.world.java";
        String[] strs2 = str3.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

    }

    /*
    boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
    boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
    boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串
         是否以指定前缀开始

    boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
        时，返回 true
    int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
        现处的索引，从指定的索引开始
    int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
    int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
        一次出现处的索引，从指定的索引开始反向搜索
    注：indexOf和lastIndexOf方法如果未找到都是返回-1

    什么情况下，indexOf(String str)和lastIndexOf(String str)返回值一样？
    答：情况一：存在唯一的一个str；情况二：不存在

     */
    @Test
    public void test3(){
        String s1="helloworld";
        System.out.println(s1.startsWith("he"));
        System.out.println(s1.endsWith("fjg"));
        System.out.println(s1.startsWith("ll",2));
        System.out.println("***************");

        String s2="wo";
        System.out.println(s1.contains(s2));
        System.out.println(s1.indexOf("he"));
        System.out.println(s1.indexOf("rl",8));
        System.out.println(s1.lastIndexOf("he"));
        System.out.println(s1.lastIndexOf("ll",5));

    }

    @Test
    public void test2(){
        String s1="helloworld";
        String s2="HelloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3="abc";
        System.out.println(s3.concat("def"));

        String s5="abc";
        String s6 =new String("gdh");
        System.out.println(s5.compareTo(s6));//表明 s5 小

        String s7 ="张群永远的神";
        System.out.println(s7.substring(5));
        System.out.println(s7.substring(2,4));//包括前面的，但是不包括后面的
    }

    /*
    int length()：返回字符串的长度： return value.length
    char charAt(int index)： 返回某索引处的字符return value[index]
    boolean isEmpty()：判断是否是空字符串：return value.length == 0
    String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
    String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
    String trim()：返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj)：比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
    int compareTo(String anotherString)：比较两个字符串的大小
    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的
          从beginIndex开始截取到最后的一个子字符串。
    String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串
          从beginIndex开始截取到endIndex(不包含)的一个子字符串。

     */
    @Test
    public void test1(){
        String s1="HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(1));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
//        s1=" ";
        System.out.println(s1.isEmpty());
        System.out.println("***********************");
        String s2 = s1.toLowerCase(Locale.ROOT);
        System.out.println(s1);
        System.out.println(s2);
        String s3 = s2.toUpperCase(Locale.ROOT);
        System.out.println(s2);
        System.out.println(s3);

        String s4="   he  llo world    ";
        String trim1 = s4.trim();
        System.out.println(trim1);
    }
}
