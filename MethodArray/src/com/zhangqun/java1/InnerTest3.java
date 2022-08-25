package com.zhangqun.java1;

/**  被static修饰的内部类
 * @author zhangqun
 * @create 2021-10-04 16:53
 */

class Outer3{
    static class Inner3{
        public void show(){
            System.out.println("内部方法");
        }
        static public void show2(){
            System.out.println("内部静态方法");
        }

    }
}

public class InnerTest3 {
//    public static void main(String[] args) {
//        //被static修饰的内部类对象的创建的
//        Outer3.Inner3 oi = new Outer3.Inner3();
//        oi.show();
//
//        new Outer3.Inner3().show();
//        Outer3.Inner3.show2();
//    }

    public static void main(String[] args) {
        Outer3.Inner3 inner3 = new Outer3.Inner3();
        inner3.show();

        new Outer3.Inner3().show();

        Outer3.Inner3.show2();
    }
}