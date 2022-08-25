package com.zhangqun.java2;

import com.zhangqun.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhangqun
 * @create 2022-08-10 14:55
 */
public class OtherTest {

    //1.获取构造器结构
    @Test
    public void test1(){
        Class classz = Person.class;
        //getConstructors(): 获取当前运行时类中声明为public的构造器
        Constructor[] constructors = classz.getConstructors();

        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println("**************");
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = classz.getDeclaredConstructors();
        for(Constructor c :declaredConstructors){
            System.out.println(c);
        }
    }

    //2.获取运行时类的父类
    @Test
    public void test2(){

        Class classz = Person.class;
        Class superclass = classz.getSuperclass();
        System.out.println(superclass);

    }

    //3.获取运行时类的带泛型的父类的泛型
    @Test
    public void test3(){
        Class classz = Person.class;

        Type genericSuperclass = classz.getGenericSuperclass();

        ParameterizedType generic = (ParameterizedType) genericSuperclass;
        //获取泛型参数
        Type[] actualTypeArguments = generic.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    //获取运行时类实现的接口
    @Test
    public void test4(){
        Class classz = Person.class;
        Class[] interfaces = classz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }
        System.out.println();

        Class[] interfaces1 = classz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }

    //获取运行时类所在的包
    @Test
    public void test5(){
        Class classz = Person.class;
        Package aPackage = classz.getPackage();
        System.out.println(aPackage);
    }
}
