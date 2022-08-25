package com.zhangqun.java2;

import com.zhangqun.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 调用运行时类中指定的结构：属性、方法、构造器
 * @author zhangqun
 * @create 2022-08-10 16:14
 */
public class ReflectionTest {

    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class classz =  Person.class;

        //创建运行时类的对象
        Person p = (Person) classz.newInstance();

        //获取指定的属性:要求运行时类中属性声明为 public
        Field id = classz.getField("id");

        //设置当前属性的值
        //set():参数一：指明设置哪个对象的属性   参数二：将此属性值设置为多少
        id.set(p, 1001);

        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    //如何设置

    @Test
    public void testField1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class classz = Person.class;

        //创建运行时类的对象
        Person person =(Person) classz.newInstance();

        //getDeclaredField(String name):获取运行时类中指定变量名的属性
        Field name = classz.getDeclaredField("name");

        //保证当前属性是访问的
        name.setAccessible(true);
        //获取、设置指定对象的此属性值
        name.set(person, "Tom");

        System.out.println(name.get(person));
    }

    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class classz = Person.class;

        Person person = (Person) classz.newInstance();

        Method show = classz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);

        Object chn = show.invoke(person, "CHN");
        System.out.println(chn);

        System.out.println("************如何调用静态方法***********");

        //获取静态方法
        //private static void showDesc()
        Method showDesc = classz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);//没有返回值，则为null
        System.out.println(returnVal);
    }

    //如何调用运行时类中的指定的构造器
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Class classz = Person.class;

        //private Person(String name)
        //1.获取指定的构造器

        Constructor declaredConstructor = classz.getDeclaredConstructor(String.class);

        //2.保证构造器是可访问的
        declaredConstructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person per =(Person) declaredConstructor.newInstance("Tom");
        System.out.println(per);
    }

}
