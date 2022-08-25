package com.zhangqun.java;

/**  常见代码块
 *   1.普通代码块   类中方法的方法体
 *   2.构造代码块   构造快会在创建对象时被调用，每次创建时都会被调用，优先于类构造函数执行
 *   3.静态代码块   用static{}包裹起来的代码片段，只会执行一次。静态代码块优先于构造代码块
 *   4.同步代码块   使用synchronized(){}包裹起来的代码块，在多线程的环境下，对共享数据的读写操作是需要互斥进行的，否则
 *                 会导致数据的不一致性。同步代码块需要写在方法中。
 *
 * @author zhangqun
 * @create 2021-10-04 0:54
 */
public class BlockTest {

    /*
    1.静态代码块不能存在于任何方法体内
    2.静态代码块不能直接访问实例变量和实例方法，需要通过类的实例对象来访问
     */

    public static String STATIC_FIELD = "静态属性";

    //静态代码块1
    //类加载时就执行，在对象创建之前
    //仅仅执行一次
    static{
        System.out.println(STATIC_FIELD);
        System.out.println("静态代码块1");
    }

    public String field = "非静态属性";

    //非静态代码块
    //每new一个对象就会执行一次
    {
        System.out.println(field);
        System.out.println("非静态代码块2");
    }

    public BlockTest(){
        System.out.println("无参构造函数");
    }

    public static void main(String[] args) {
        BlockTest blockTest = new BlockTest();

//        BlockTest blockTest1 = new BlockTest();
    }

    {
        System.out.println(field);
        System.out.println("非静态代码块1");
    }

    //静态代码块2
    //无论放置在后面还是最前面，都是最开始执行的
    static{
        System.out.println(STATIC_FIELD);
        System.out.println("静态代码块2");
    }
}
