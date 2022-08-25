package com.zhangqun.java1;


/**
 * @author zhangqun
 * @create 2022-08-09 22:43
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){

    }
    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException{
        return interests + age;
    }


    private static void showDesc(){
        System.out.println("还好！！");
    }

    @Override
    public int compareTo(String s) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人！！");
    }
}
