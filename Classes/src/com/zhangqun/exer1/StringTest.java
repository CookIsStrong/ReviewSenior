package com.zhangqun.exer1;

/**
 * 体现了String的不可变性
 * @author zhangqun
 * @create 2021-07-31 13:48
 */
public class StringTest {
    Person person = new Person();
    String str = "good";
    int i = 1;
    char[] ch = {'t', 'e', 's', 't'};

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        int age = 18;
        ex.person.setAge(age);
        ex.change(age, ex.ch);
        System.out.println(age);
        System.out.println(ex.ch);//best
    }

    public void change(int age, char ch[]) {
        age = 20;
        ch[0] = 'b';
    }
}
class Person{
    private String name;
    private int age;
    private String sex;

    public Person(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
