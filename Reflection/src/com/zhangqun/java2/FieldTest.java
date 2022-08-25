package com.zhangqun.java2;

import com.zhangqun.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/** 获取当前运行时类的属性结构
 * @author zhangqun
 * @create 2022-08-10 11:29
 */
public class FieldTest {

    @Test
    public void test(){
        Class cla = Person.class;

        //获取属性结构
        //getFields(): 获取当前运行时类及其父类中声明为 public访问权限的属性
        Field[] fields = cla.getFields();
        for(Field fl : fields){
            System.out.println(fl);
        }
        //getDeclaredFields():获取当前运行时类中声明的所有属性结构（不包含父类中声明的属性）
        Field[] declaredFields = cla.getDeclaredFields();
        for(Field fl : declaredFields){
            System.out.println(fl);
        }
    }

    //权限修饰符  数据类型  变量名
    @Test
    public void test2(){
        Class classz = Person.class;
        Field[] declaredFields = classz.getDeclaredFields();
        for(Field fl : declaredFields){

            //1.修饰权限符
            int modifies = fl.getModifiers();
//            System.out.println(Modifier.toString(modifies));
            System.out.println(modifies);

            //2.数据类型
            Class type = fl.getType();
            System.out.println(type);

            //3.变量名
            String name = fl.getName();
            System.out.println(name);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
