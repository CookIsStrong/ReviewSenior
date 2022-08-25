package com.zhangqun.exer2;

/**
 * @author zhangqun
 * @create 2021-08-04 10:13
 */
public class StringDemo {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

     */
    public char[] reverse(String str){
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length / 2; i ++){
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return chars;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int N = str.length();
        StringDemo stringDemo = new StringDemo();
        char[] reverse = stringDemo.reverse(str);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < reverse.length; i ++){
            sb.append(reverse[i]);
        }
        System.out.println(sb.toString());
    }


}
