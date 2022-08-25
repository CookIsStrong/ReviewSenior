package com.zhangqun.java;

import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;

/**
 * @author zhangqun
 * @create 2022-07-08 21:39
 */
public class ReflectionTest {

    //通过反射
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class classz = Person.class;
        Constructor constructor = classz.getConstructor(String.class, int.class);
        Object object = constructor.newInstance("tom", 12);
        Person person1 = (Person) object;
        System.out.println(object.toString());

        //通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = classz.getDeclaredField("age");
        System.out.println(age);
        age.set(person1, 10);
        System.out.println(person1.toString());

        //调用方法
        Method show = classz.getDeclaredMethod("show");
        System.out.println(show);
        show.invoke(person1);//执行show()方法

        System.out.println("*********************************");

        //通过反射，可以调用Person类的私有结构
        Constructor constructor1 = classz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person2 = (Person) constructor1.newInstance("zhangsan");
        System.out.println(person2.toString());
        //调用私有属性
        Field name = classz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person2, "lisi");
        System.out.println(person2.toString());

        //调用私有方法
        Method showNation = classz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object nation = showNation.invoke(person1, "中国");
        System.out.println(nation);

        //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
        //建议：直接new方式
        //什么时候会使用：反射的方式。反射的特征：动态性
        //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
        //不矛盾。


    }
      /*
        关于java.lang.CLass类的理解
        1.类的加载过程

        程序经过java.exe命令以后，会生成一个或多个字符码文件（.class结尾），接着我们使用
        java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
        此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class
        的一个实例。

        2.换句话说，Class的实例就对应着一个运行时类

        3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们通过不同的方式来获取此
         运行时类。
      */


    //常用方式获取Class类对象实例化
    @Test
    public void test2() throws ClassNotFoundException {

        //1、方式一
        Date date = new Date();
        Class classz1= date.getClass();
        System.out.println(classz1.getName());

        //2、方式二
        Class classz2 = Date.class;
        System.out.println(classz2.getName());

        //3、方式三
        Class classz3 = Class.forName("java.util.Date");
        System.out.println(classz3.getName());
    }

    //创建一个指定类的对象
    //ClassPath:指定类对象
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class classz = Class.forName(classPath);
        classz.forName(classPath);
        return classz.newInstance();
    }

    //体会反射的动态性
    @Test
    public void test3(){

        int num = new Random().nextInt(3);
        String classPath = "";
        switch(num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.zhangqun.java.Person";
                break;
        }

        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
