package com.zhangqun.java1;

/**
 * @author zhangqun
 * @create 2021-10-04 17:00
 */
public class InnerTest5 {
    public static void main(String[] args) {
        new Inter1(){
            @Override
            public void save() {
                System.out.println("save()...");
                get();
            }
            @Override
            public void get() {
                System.out.println("get()...");
            }
        }.save();

        new Inter2(){
            @Override
            public void drink() {
                System.out.println("一个人饮酒醉");
            }
        }.drink();

        new Inter3().powerUp();
        new Inter3().powerUp();

        Inter3 in = new Inter3();
        in.study();
        in.study();
        in.study();
        in.study();
        in.study();

    }
}

//接口中的方法必须被重写
interface Inter1{
    void save();
    void get();
}

abstract class Inter2{//抽象类

   public void play(){
       System.out.println("Inner2...play()");
   }

   abstract public void drink();//抽象方法，必须重写
}

 class Inter3{

    public void study(){
        System.out.println("什么都阻挡不了我想学习赚钱的决心");
    }

    public void powerUp(){
        System.out.println("我们会越来越强的！");
    }
 }

