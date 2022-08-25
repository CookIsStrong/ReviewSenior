package com.zhangqun.java2;

import java.util.Objects;

/**
 * @author zhangqun
 * @create 2021-08-18 17:17
 */

//实现了Comparable接口，为了TreeSetTest做准备
public class User implements Comparable{
    private String name;
    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //按照姓名从小到大的顺序排列，年龄从小到大的排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o;
//            return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if (compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
