package com.zhangqun.java1;

/**  内部类相关知识
 * @author zhangqun
 * @create 2021-10-04 16:34
 */
public class InnerTest {
    public static void main(String[] args) {
        //内部类对象的创建
        Outer.Inner oi = new Outer().new Inner();
        oi.delete();
        System.out.println(oi.sum);//10

        //通过外部类对内部类执行相关操作
        new Outer().find();
    }
}

//1.创建外部类
class Outer{
    String name;
    private int age;
    public void find(){
        System.out.println("Outer...find()");
        Inner in = new Inner();
        System.out.println(in.sum);
        in.delete();
    }

    //2.创建内部类
    class Inner{
        int sum = 10;

        public void delete(){
            System.out.println("Inner...delete()");
            System.out.println(name);//null
            System.out.println(age);//0
        }
    }
}