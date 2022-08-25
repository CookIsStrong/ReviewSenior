package com.zhangqun.java;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhangqun
 * @create 2022-08-04 22:31
 */
public class test {

    @Test
    public void test0(){
        Person person = new Person("tom", 15);

        person.age = 20;
        System.out.println(person.toString());
        person.show();

        //在Person类的外部，不可以通过person类的对象调用其内部私有结构
        //比如：name、showNation()以及私有构造器
    }
    
    @Test
    public void test(){
        ClassLoader classLoader = test.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    @Test
    public void test1() throws IOException {

        Properties property = new Properties();
        //此时的文件默认在当前的 module下
        //读取配置文件的方式一：
//        FileInputStream fileInputStream = new FileInputStream("src/file.properties");
//        property.load(fileInputStream);


        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader test = test.class.getClassLoader();
        InputStream resourceAsStream = test.getResourceAsStream("file.properties");
        property.load(resourceAsStream);


        String user = property.getProperty("user");
        String password = property.getProperty("password");
        System.out.println("user :" + user + ", password :" + password);

    }
}
