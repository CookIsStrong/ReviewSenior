package com.zhangqun.java;

import sun.rmi.runtime.NewThreadAction;

/**  单例模式
 * @author zhangqun
 * @create 2021-10-04 21:10
 */
public class Singleton {
    //关键：属性及其获取实例的方法设置为private

    //第一种方式
    //线程不安全的，不推荐
    private Singleton(){

    }
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }


    //第二种方式
    //线程安全的，推荐
    private static Singleton instance1 = null;

    public static synchronized Singleton getInstance1(){
        if (instance1 == null)
            instance1 = new Singleton();
        return instance1;
    }
}
