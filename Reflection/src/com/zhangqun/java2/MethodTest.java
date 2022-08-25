package com.zhangqun.java2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zhangqun.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**  获取运行时类的方法结构
 * @author zhangqun
 * @create 2022-08-10 14:01
 */
public class MethodTest {
    @Test
    public void test(){
        Class classz = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为pubic权限的方法
        Method[] methods = classz.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println("************");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不含父类中声明的方法）
        Method[] declaredMethods = classz.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method);
        }
    }

    @Test
    public void test2(){
        Class classz = Person.class;
        Method[] declaredMethods = classz.getDeclaredMethods();
        for(Method method : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for(Annotation a : annotations){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(method.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(method.getName() + "\t");

            //5.形参列表
            Class[] parameterTypes = method.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0)){
                for(int i = 0; i < parameterTypes.length; i ++){
                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_ " + i);
                    }
                    System.out.print(parameterTypes[i].getName() + " args_ " + i + " ,");
                }
            }

            System.out.println();
        }

    }
}
