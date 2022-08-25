package com.zhangqun.java1;

/**
 * @author zhangqun
 * @create 2021-10-04 16:58
 */
public class InnerTest4 {

    public static void main(String[] args) {
        new Outer4().show();
    }

}

class Outer4{
    public void show(){
        class Inner4{
            String name;
            int age;

            public void eat(){
                System.out.println("我是Inner4的eat()");
            }
        }

        //方法内部内部类对象的创建
        Inner4 in = new Inner4();
        in.eat();
        System.out.println(in.name);
        System.out.println(in.age);
    }
}
