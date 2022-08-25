package com.zhangqun.java2;

import org.junit.Test;

/**
 * @author zhangqun
 * @create 2021-08-04 10:28
 */
public class IDEADebug {
    @Test
    public void test1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//

        System.out.println(sb);//

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//

    }
}
