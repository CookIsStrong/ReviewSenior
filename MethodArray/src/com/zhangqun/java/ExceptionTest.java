package com.zhangqun.java;

/**
 * @author zhangqun
 * @create 2021-10-08 9:23
 */
public class ExceptionTest {
    //问题一：
//    public static void main(String[] args){
//        doSome();
//    }
//    public static void doSome() throws ClassNotFoundException{
//        System.out.println("doSome!!");
//    }

//    //解决方式一：上报给方法调用者
//    public static void main(String[] args)  throws ClassNotFoundException{
//        doSome();
//    }
//
//    public static void doSome() throws ClassNotFoundException{
//        System.out.println("doSome!!");
//    }

    //解决方式二：try catch 捕捉，处理
//    public static void main(String[] args) {
//        try {
//            doSome();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//    public static void doSome() throws ClassNotFoundException{
//        System.out.println("doSome!!");
//    }


    //问题二：
//    public static void main(String[] args) {
//        int result = m();
//        System.out.println(result);
//    }
//
//    public static int m(){
//        int i = 100;
//        try{
//            return i;
//        }finally {
//            i ++;
//            return i;
//        }
//    }

    //问题三：
//    public static void main(String[] args) {
//        int i1 = 100;
//        int i2 = 0;
//
//        try{
//            int i3 = i1 / i2;
//            System.out.println(i3);
//        }catch(ArithmeticException e){
//            e.printStackTrace();
//        }
//    }
}
